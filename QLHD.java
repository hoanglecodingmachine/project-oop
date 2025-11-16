import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QLHD extends MainQLBH {
    private static Scanner sc = new Scanner(System.in);

    // ✅ Cập nhật đơn giá & thành giá cho từng chi tiết hóa đơn
    public void capNhatGiaTriChiTiet() {
        ChiTietHoaDon[] arrCT = dscthd.getChiTietHoaDon();
        CuaHangDienThoai[] arrSP = dssp.getSP();
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

    // ✅ Tính tổng tiền cho từng hóa đơn
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

        System.out.print("Nhập số lượng chi tiết hóa đơn: ");
        int soLuongCT = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < soLuongCT; i++) {
            System.out.println("---- Nhập chi tiết hóa đơn thứ " + (i + 1) + " ----");
            ChiTietHoaDon ct = new ChiTietHoaDon();
            ct.nhap();

            // Gắn mã hóa đơn vào chi tiết
            ct.setMaHoaDon(hd.getMaHoaDon());

            dscthd.Them(ct);

            // Giảm số lượng sản phẩm trong kho
            dssp.Sua_SoLuong(ct.getMaSanPham(), ct.getSoLuong());
        }

        // Cập nhật đơn giá, thành giá, tổng tiền
        capNhatGiaTriChiTiet();
        TinhTienTong();

        System.out.println(">> Đã thêm hóa đơn và chi tiết thành công!");
    }

    public void mainQLHD() {
        int choice;
        do {
            System.out.println("\n=== MENU QUẢN LÝ HÓA ĐƠN ===");
            System.out.println("1. Xuat hóa đơn");
            System.out.println("2. Them hóa đơn");
            System.out.println("3. Sua hóa đơn");
            System.out.println("4. Xoa hóa đơn");
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
                    capNhatGiaTriChiTiet();
                    TinhTienTong();

                    if (soHD == 0) {
                        System.out.println("Chưa có hóa đơn nào!");
                        break;
                    }

                    for (int i = 0; i < soHD; i++) {
                        if (arrHD[i] == null) continue;

                        System.out.println("\n==============================");
                        System.out.println("HÓA ĐƠN: " + arrHD[i].getMaHoaDon());
                        arrHD[i].xuat();

                        System.out.println("---- CHI TIẾT HÓA ĐƠN ----");
                        for (int j = 0; j < soCT; j++) {
                            if (arrCT[j] == null) continue;
                            if (arrHD[i].getMaHoaDon().equalsIgnoreCase(arrCT[j].getMaHoaDon())) {
                                arrCT[j].xuat();
                            }
                        }
                    }
                    break;

                case 2: ThemHoaDon(); break;

                case 3:
                    System.out.println("=== SỬA THÔNG TIN ===");
                    System.out.println("1. Sửa hóa đơn");
                    System.out.println("2. Sửa chi tiết hóa đơn");
                    System.out.println("3. Quay lại");
                    System.out.print("Nhập lựa chọn: ");
                    int ch = sc.nextInt(); sc.nextLine();
                    switch (ch) {
                        case 1: dshd.sua(); break;
                        case 2: dscthd.sua(); break;
                        case 3: break;
                        default: System.out.println("Lựa chọn không hợp lệ!"); break;
                    }
                    break;

                case 4:
                    System.out.println("=== XÓA DỮ LIỆU ===");
                    System.out.println("1. Xóa hóa đơn");
                    System.out.println("2. Xóa chi tiết hóa đơn");
                    System.out.println("3. Quay lại");
                    System.out.print("Nhập lựa chọn: ");
                    int ch1 = sc.nextInt(); sc.nextLine();
                    switch (ch1) {
                        case 1: dshd.xoa(); break;
                        case 2: dscthd.xoa(); break;
                        case 3: break;
                        default: System.out.println("Lựa chọn không hợp lệ!"); break;
                    }
                    break;

                case 5:
                    System.out.println("Tìm kiếm (1. Hóa đơn, 2. Chi tiết hóa đơn)");
                    int tk = sc.nextInt(); sc.nextLine();
                    if (tk == 1) {
                        System.out.println("Tìm hóa đơn (1. Mã, 2. Mã KH, 3. Mã NV, 4. Mã phụ kiện)");
                        int subChoice = sc.nextInt(); sc.nextLine();
                        switch (subChoice) {
                            case 1: dshd.Search_Ma(); break;
                            case 2: dshd.Search_MaKhachHang(); break;
                            case 3: dshd.Search_MaNhanVien(); break;
                            case 4: dshd.Search_MaPhuKien(); break;
                            default: System.out.println("Lựa chọn không hợp lệ!"); break;
                        }
                    } else {
                        System.out.println("Tìm chi tiết HĐ (1. Mã CTHĐ, 2. Mã HĐ, 3. Mã SP, 4. SL, 5. Đơn giá)");
                        int subChoice = sc.nextInt(); sc.nextLine();
                        switch (subChoice) {
                            case 1: dscthd.Search_Ma(); break;
                            case 2: dscthd.Search_MaHoaDon(); break;
                            case 3: dscthd.Search_MaSanPham(); break;
                            case 4: dscthd.Search_SoLuong(); break;
                            case 5: dscthd.Search_DonGia(); break;
                            default: System.out.println("Lựa chọn không hợp lệ!"); break;
                        }
                    }
                    break;

                case 6:
                    System.out.println("Thống kê (1. Hóa đơn, 2. Chi tiết hóa đơn)");
                    int tk2 = sc.nextInt(); sc.nextLine();
                    if (tk2 == 1) {
                        System.out.println("Thống kê hóa đơn (1. Theo tổng tiền, 2. Theo ngày lập)");
                        int subChoice = sc.nextInt(); sc.nextLine();
                        switch (subChoice) {
                            case 1: dshd.ThongKe_TongTien(); break;
                            case 2: dshd.ThongKe_NgayLap(); break;
                            default: System.out.println("Lựa chọn không hợp lệ!"); break;
                        }
                    } else {
                        System.out.println("Thống kê chi tiết HĐ (1. Theo đơn giá, 2. Theo số lượng)");
                        int subChoice = sc.nextInt(); sc.nextLine();
                        switch (subChoice) {
                            case 1: dscthd.ThongKe_DonGia(); break;
                            case 2: dscthd.ThongKe_SoLuong(); break;
                            default: System.out.println("Lựa chọn không hợp lệ!"); break;
                        }
                    }
                    break;

                case 0:
                    System.out.println("Quay lại MENU CHINH...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
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
    public double[] ThongKe_TheoQuy(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int Quy1 = 0 , Quy2 = 0 , Quy3 = 0,Quy4 = 0;
        HoaDon[] arrHD = dshd.getHoaDon();
        int numhd = dshd.getSoLuongHoaDon();
        for(int i = 0 ; i < numhd ; i++){
            if(arrHD[i] == null) continue;   
        try{
                LocalDate Quy = LocalDate.parse(arrHD[i].getNgayNhap(),formatter);
                int thang = Quy.getMonthValue();
                if (thang >= 1 && thang <= 3) Quy1 += arrHD[i].getTongTien();
                else if (thang >= 4 && thang <= 6) Quy2+=arrHD[i].getTongTien();
                else if (thang >= 7 && thang <= 9) Quy3+=arrHD[i].getTongTien();
                else Quy4+=arrHD[i].getTongTien();
            }
            catch(Exception e){
                System.out.println("loi dinh dang ngay nhap dd/MM/yyyy");
            }
        }
    System.out.printf("%-25s : %.2f\n", "Quy 1 (1–3)", (double)Quy1);
    System.out.printf("%-25s : %.2f\n", "Quy 2 (4–6)", (double)Quy2);
    System.out.printf("%-25s : %.2f\n", "Quy 3 (7–9)", (double)Quy3);
    System.out.printf("%-25s : %.2f\n", "Quy 4 (10–12)", (double)Quy4);
     return new double[]{Quy1, Quy2, Quy3, Quy4};
    }
    }

