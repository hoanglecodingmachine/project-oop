import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QLHD extends MainQLBH {
    private static Scanner sc = new Scanner(System.in);

    public void capNhatGiaTriChiTiet() {
        ChiTietHoaDon[] arrCT = dscthd.getChiTietHoaDon();
        DienThoai[] arrSP = dssp.getSP();
        int soCT = dscthd.getSoLuongChiTietHoaDon();
        int soSP = dssp.getNum();

        for (int i = 0; i < soCT; i++) {
            if (arrCT[i] == null) continue;
            for (int j = 0; j < soSP; j++) {
                if (arrSP[j] == null) continue;
                if (arrCT[i].getMaSanPham().equalsIgnoreCase(arrSP[j].getMaSP())) {
                    double donGia = arrSP[j].getDonGia();
                    arrCT[i].setDonGia(donGia);
                    arrCT[i].setThanhGia(donGia * arrCT[i].getSoLuong());
                    break;
                }
            }
        }
    }

    public void TinhTienTong() {
        HoaDon[] arrHD = dshd.getHoaDon();
        ChiTietHoaDon[] arrCT = dscthd.getChiTietHoaDon();
        int soHD = dshd.getSoLuongHoaDon();
        int soCT = dscthd.getSoLuongChiTietHoaDon();

        for (int i = 0; i < soHD; i++) {
            if (arrHD[i] == null) continue;
            double tong = 0.0;
            String maHD = arrHD[i].getMaHoaDon();

            for (int j = 0; j < soCT; j++) {
                if (arrCT[j] == null) continue;
                if (maHD.equalsIgnoreCase(arrCT[j].getMaHoaDon())) {
                    tong += arrCT[j].getThanhGia();
                }
            }
            arrHD[i].setTongTien(tong);
        }
    }

    
public void ThemHoaDon() {
    HoaDon hd = new HoaDon();
    hd.nhap();
    dshd.Them(hd);

    System.out.print("Nhap so luong chi tiet hoa don: ");
    int soLuongCT = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < soLuongCT; i++) {
        System.out.println("---- Nhap chi tiet hoa don thu " + (i + 1) + " ----");
        ChiTietHoaDon ct = new ChiTietHoaDon();

        System.out.print("Nhap ma hoa don chi tiet: ");
        ct.setMaHoaDonChiTiet(sc.nextLine()); 
        System.out.print("Nhap ma san pham khach hang mua: ");
        ct.setMaSanPham(sc.nextLine());
        System.out.print("Nhap so luong san pham: ");
        ct.setSoLuong(sc.nextInt());
        sc.nextLine(); // bo ki tu newline con lai

        // Gan ma hoa don cho chi tiet
        ct.setMaHoaDon(hd.getMaHoaDon());
        dscthd.Them(ct);

        // Giam so luong san pham trong kho
        dssp.Sua_SoLuong(ct.getMaSanPham(), ct.getSoLuong());
    }

    capNhatGiaTriChiTiet();
    TinhTienTong();

    System.out.println(">> Da them hoa don va chi tiet thanh cong!");
}

    public void mainQLHD() {
        int choice;
        do {
            System.out.println("\n=== MENU QUAN LY HOA DON ===");
            System.out.println("1. Xuat hoa don");
            System.out.println("2. Them hoa don");
            System.out.println("3. Sua hoa don");
            System.out.println("4. Xoa hoa don");
            System.out.println("5. Tim kiem");
            System.out.println("6. Thong ke");
            System.out.println("0. Quay lai MENU CHINH");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            HoaDon[] arrHD = dshd.getHoaDon();
            ChiTietHoaDon[] arrCT = dscthd.getChiTietHoaDon();
            int soHD = dshd.getSoLuongHoaDon();
            int soCT = dscthd.getSoLuongChiTietHoaDon();

            switch (choice) {
                case 1:
                   {
                    System.out.println("nhap lua chon (1 hoa don rieng , 2 hoa don chi tiet rieng , 3 hoa don va hoa don chi tiet )");
                    int sucb = sc.nextInt();
                    sc.nextLine();
                    switch (sucb) {
                        case 1:
                    capNhatGiaTriChiTiet();
                    TinhTienTong();
                        dshd.xuat();
                            break;
                        case 2:
                    capNhatGiaTriChiTiet();
                    TinhTienTong();    
                        dscthd.xuat();
                            break;
                        case 3:
                    capNhatGiaTriChiTiet();
                    TinhTienTong();
                    if (soHD == 0) {
                        System.out.println("Chua co hoa don nao!");
                        break;
                    }

                    for (int i = 0; i < soHD; i++) {
                        if (arrHD[i] == null) continue;

                        System.out.println("\n==============================");
                        System.out.println("HOA DON: " + arrHD[i].getMaHoaDon());
                        arrHD[i].xuat();

                        System.out.println("---- CHI TIET HOA DON ----");
                        for (int j = 0; j < soCT; j++) {
                            if (arrCT[j] == null) continue;
                            if (arrHD[i].getMaHoaDon().equalsIgnoreCase(arrCT[j].getMaHoaDon())) {
                                arrCT[j].xuat();
                            }
                        }
                    }
                        default:
                        System.out.println("lua chon khong hop le ");
                            break;
                    }
                   }
                    break;

                case 2: ThemHoaDon(); break;

                case 3:
                    System.out.println("=== SUA THONG TIN ===");
                    System.out.println("1. Sua hoa don");
                    System.out.println("2. Sua chi tiết hoa don");
                    System.out.println("3. Quay lại");
                    System.out.print("Nhap lua chon: ");
                    int ch = sc.nextInt(); sc.nextLine();
                    switch (ch) {
                        case 1: dshd.sua(); break;
                        case 2: dscthd.sua(); break;
                        case 3: break;
                        default: System.out.println("Lua chon khong hop le!"); break;
                    }
                    break;

                case 4:
                    System.out.println("=== XOA DU LIEU ===");
                    System.out.println("1. Xoa hoa don");
                    System.out.println("2. Xoa chi tiết hoa don");
                    System.out.println("3. Quay lại");
                    System.out.print("Nhap lua chon: ");
                    int ch1 = sc.nextInt(); sc.nextLine();
                    switch (ch1) {
                        case 1: dshd.xoa(); break;
                        case 2: dscthd.xoa(); break;
                        case 3: break;
                        default: System.out.println("Lua chon khong hop le!"); break;
                    }
                    break;

 case 5:
    System.out.println("Tim kiem (1. Hoa don, 2. Chi tiet hoa don)");
    int tk = sc.nextInt(); sc.nextLine();
    if (tk == 1) {
        System.out.println("Tim hoa don (1. Ma, 2. Ma KH, 3. Ma NV, 4. Ma phu kien)");
        int subChoice = sc.nextInt(); sc.nextLine();
        switch (subChoice) {
            case 1: dshd.Search_Ma(); break;
            case 2: dshd.Search_MaKhachHang(); break;
            case 3: dshd.Search_MaNhanVien(); break;
            case 4: dshd.Search_MaPhuKien(); break;
            default: System.out.println("Lua chon khong hop le!"); break;
        }
    } else {
        System.out.println("Tim chi tiet HD (1. Ma CTHD, 2. Ma HD, 3. Ma SP, 4. SL, 5. Don gia)");
        int subChoice = sc.nextInt(); sc.nextLine();
        switch (subChoice) {
            case 1: dscthd.Search_Ma(); break;
            case 2: dscthd.Search_MaHoaDon(); break;
            case 3: dscthd.Search_MaSanPham(); break;
            case 4: dscthd.Search_SoLuong(); break;
            case 5: dscthd.Search_DonGia(); break;
            default: System.out.println("Lua chon khong hop le!"); break;
        }
    }
    break;

case 6:
    System.out.println("Thong ke (1. Hoa don, 2. Chi tiet hoa don)");
    int tk2 = sc.nextInt(); sc.nextLine();
    if (tk2 == 1) {
        System.out.println("Thong ke hoa don (1. Theo tong tien, 2. Theo ngay lap)");
        int subChoice = sc.nextInt(); sc.nextLine();
        switch (subChoice) {
            case 1: dshd.ThongKe_TongTien(); break;
            case 2: dshd.ThongKe_NgayLap(); break;
            default: System.out.println("Lua chon khong hop le!"); break;
        }
    } else {
        System.out.println("Thong ke chi tiet HD (1. Theo don gia, 2. Theo so luong)");
        int subChoice = sc.nextInt(); sc.nextLine();
        switch (subChoice) {
            case 1: dscthd.ThongKe_DonGia(); break;
            case 2: dscthd.ThongKe_SoLuong(); break;
            default: System.out.println("Lua chon khong hop le!"); break;
        }
    }
    break;

case 0:
    System.out.println("Quay lai MENU CHINH...");
    break;

default:
    System.out.println("Lua chon khong hop le.");
    break;

            }

        } while (choice != 0);
    }
    public void ThongKe_TongTienTuNgay(){
        System.out.println("nhap ngay bat au (dd/MM/yyyy)");
        String ngaybatdaustr = sc.nextLine();
        System.out.println("nhap ngay ket thuc (dd/MM/yyyy)");
        String ngayketthucstr = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            LocalDate ngaybatdau = LocalDate.parse(ngaybatdaustr,formatter);
            LocalDate ngayketthuc = LocalDate.parse(ngayketthucstr,formatter);
            HoaDon[] arrHD = dshd.getHoaDon();
            int num = dshd.getSoLuongHoaDon();
            double tongtien = 0;
            int demhd = 0;
            for(int i = 0 ; i < num;i++){
               LocalDate ngaylap = LocalDate.parse(arrHD[i].getNgayNhap(),formatter);
               if((ngaylap.isEqual(ngaybatdau) || ngaylap.isAfter(ngaybatdau)) && (ngaylap.isEqual(ngayketthuc) || ngaylap.isBefore(ngayketthuc))){
                tongtien += arrHD[i].getTongTien();
                demhd++;
               } 
            }
            System.out.println("tong tien tu ngay bat dau toi ngay ket thuc la " + tongtien);
            System.out.println("so luong hoa don trong khoang thoi gian do la " + demhd); 
        }catch( Exception e){
            System.out.println("loi dinh dang hay nhap kieu dd/MM/yyyy");
        }  
    }
public double[] ThongKe_TheoQuy() {
    System.out.println("vui long nhap nam de thong ke theo quy: ");
    int year = Integer.parseInt(sc.nextLine());  // tránh lỗi xuống dòng

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    double Quy1 = 0, Quy2 = 0, Quy3 = 0, Quy4 = 0;

    HoaDon[] arrHD = dshd.getHoaDon();
    int numhd = dshd.getSoLuongHoaDon();

    for (int i = 0; i < numhd; i++) {

        if (arrHD[i] == null) continue;

        try {
            LocalDate ngay = LocalDate.parse(arrHD[i].getNgayNhap(), formatter);

            int thang = ngay.getMonthValue();
            int nam = ngay.getYear();

            if (nam == year) {
                double tien = arrHD[i].getTongTien();

                if (thang >= 1 && thang <= 3) Quy1 += tien;
                else if (thang >= 4 && thang <= 6) Quy2 += tien;
                else if (thang >= 7 && thang <= 9) Quy3 += tien;
                else Quy4 += tien;
            }

        } catch (Exception e) {
            System.out.println("Loi dinh dang ngay (dd/MM/yyyy): " + arrHD[i].getNgayNhap());
        }
    }

    System.out.printf("%-25s : %.2f\n", "Quy 1 (1–3)", Quy1);
    System.out.printf("%-25s : %.2f\n", "Quy 2 (4–6)", Quy2);
    System.out.printf("%-25s : %.2f\n", "Quy 3 (7–9)", Quy3);
    System.out.printf("%-25s : %.2f\n", "Quy 4 (10–12)", Quy4);

    return new double[]{Quy1, Quy2, Quy3, Quy4};
}

    }

