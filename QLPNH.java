import java.util.Scanner;

public class QLPNH extends MainQLBH {
  private static Scanner sc = new Scanner(System.in);
  // Tính tổng tiền cho từng hóa đơn dựa trên chi tiết hóa đơn
  public void TinhTienTong() {
    // Lấy mảng hóa đơn và mảng chi tiết hóa đơn
    PhieuNhapHang[] arrPNH = dspnh.getDanhSachPhieuNhapHang();
    ChiTietPhieuNhapHang[] arrCT = dsctpnh.getChiTietPhieuNhapHang();
    int soPNH = dspnh.getSoLuongDanhSachPhieuNhapHang();
    int soCT = dsctpnh.getSoLuongChiTietPhieuNhapHang();

    for (int i = 0; i < soPNH; i++) {
      double tong = 0.0;
      if (arrPNH == null || arrPNH[i] == null) continue;
      String maPNH = arrPNH[i].getMaPhieuNhapHang();
      // Cộng tất cả chi tiết có cùng mã phiếu nhập hàng
      for (int j = 0; j < soCT; j++) {
        if (arrCT == null || arrCT[j] == null) continue;
        if (maPNH.equalsIgnoreCase(arrCT[j].getMaPhieuNhapHang())) {
          tong += arrCT[j].getTongTien();
        }
      }
      arrPNH[i].setThanhTien(tong);
    }
  }


public void mainQLPNH() {
    int choice;
    do {
        System.out.println("\n=== MENU QUAN LY PHIEU NHAP HANG ===");
        System.out.println("1. Xuat danh sach");
        System.out.println("2. Them phieu nhap hang");
        System.out.println("3. Sua thong tin");
        System.out.println("4. Xoa du lieu");
        System.out.println("5. Tim kiem");
        System.out.println("6. Thong ke");
        System.out.println("0. Quay lai MENU CHINH");
        System.out.print("Nhap lua chon: ");
        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                TinhTienTong();
                PhieuNhapHang[] arrPNH = dspnh.getDanhSachPhieuNhapHang();
                ChiTietPhieuNhapHang[] arrCT = dsctpnh.getChiTietPhieuNhapHang();
                int soPNH = dspnh.getSoLuongDanhSachPhieuNhapHang();
                int soCT = dsctpnh.getSoLuongChiTietPhieuNhapHang();

                if (soPNH == 0) {
                    System.out.println("Chua co phieu nhap hang nao!");
                    break;
                }

                for (int i = 0; i < soPNH; i++) {
                    if (arrPNH[i] == null) continue;
                    System.out.println("\n==============================");
                    System.out.println("Phieu Nhap Hang: " + arrPNH[i].getMaPhieuNhapHang());
                    arrPNH[i].xuat();

                    System.out.println("---- CHI TIET Phieu Nhap Hang ----");
                    for (int j = 0; j < soCT; j++) {
                        if (arrCT[j] == null) continue;
                        if (arrPNH[i].getMaPhieuNhapHang().equalsIgnoreCase(arrCT[j].getMaPhieuNhapHang())) {
                            arrCT[j].xuat();
                        }
                    }
                }
                break;

            case 2:
                ThemPhieuNhapHang();
                break;

            case 3:
                System.out.println("=== SUA THONG TIN ===");
                System.out.println("1. Sua phieu nhap hang");
                System.out.println("2. Sua chi tiet phieu nhap hang");
                System.out.println("3. Quay lai");
                int ch = sc.nextInt();
                sc.nextLine();
                switch (ch) {
                    case 1: dspnh.sua(); break;
                    case 2: dsctpnh.sua(); break;
                    case 3: break;
                    default: System.out.println("Lua chon khong hop le!"); break;
                }
                break;

            case 4:
                System.out.println("=== XOA DU LIEU ===");
                System.out.println("1. Xoa phieu nhap hang");
                System.out.println("2. Xoa chi tiet phieu nhap hang");
                System.out.println("3. Quay lai");
                int ch1 = sc.nextInt();
                sc.nextLine();
                switch (ch1) {
                    case 1: dspnh.xoa(); break;
                    case 2: dsctpnh.xoa(); break;
                    case 3: break;
                    default: System.out.println("Lua chon khong hop le!"); break;
                }
                break;

            case 5:
                System.out.println("Tim kiem (1 phieu nhap hang, 2 chi tiet phieu nhap hang): ");
                int ch2 = sc.nextInt();
                sc.nextLine();
                if (ch2 == 1) {
                    System.out.println("Tim kiem (1 ma phieu nhap hang, 2 ma nha cung cap, 3 ngay thang, 4 thanh tien):");
                    int ch3 = sc.nextInt();
                    sc.nextLine();
                    switch(ch3) {
                        case 1: dspnh.Search_Ma(); break;
                        case 2: dspnh.Search_MaNhaCungCap(); break;
                        case 3: dspnh.Search_NgayThang(); break;
                        case 4: dspnh.Search_ThanhTien(); break;
                        default: System.out.println("Lua chon khong hop le."); break;
                    }
                } else if (ch2 == 2) {
                    System.out.println("Tim kiem chi tiet (1 ma chi tiet, 2 ma san pham, 3 so luong, 4 don gia):");
                    int ch4 = sc.nextInt();
                    sc.nextLine();
                    switch(ch4) {
                        case 1: dsctpnh.Search_Ma(); break;
                        case 2: dsctpnh.Search_MaSanPham(); break;
                        case 3: dsctpnh.Search_SoLuong(); break;
                        case 4: dsctpnh.Search_DonGia(); break;
                        default: System.out.println("Lua chon khong hop le."); break;
                    }
                } else {
                    System.out.println("Lua chon khong hop le.");
                }
                break;

            case 6:
                System.out.println("Thong ke (1 phieu nhap hang, 2 chi tiet phieu nhap hang): ");
                int ch5 = sc.nextInt();
                sc.nextLine();
                if(ch5 == 1) {
                    System.out.println("Thong ke (1 theo don gia, 2 theo ngay thang): ");
                    int ch6 = sc.nextInt();
                    sc.nextLine();
                    switch(ch6) {
                        case 1: dspnh.ThongKe_ThanhTien(); break;
                        case 2: dspnh.ThongKe_NgayNhap(); break;
                        default: System.out.println("Lua chon khong hop le."); break;
                    }
                } else if(ch5 == 2) {
                    System.out.println("Thong ke chi tiet (1 theo don gia, 2 theo so luong): ");
                    int ch7 = sc.nextInt();
                    sc.nextLine();
                    switch(ch7) {
                        case 1: dsctpnh.ThongKe_DonGia(); break;
                        case 2: dsctpnh.ThongKe_SoLuong(); break;
                        default: System.out.println("Lua chon khong hop le."); break;
                    }
                } else {
                    System.out.println("Lua chon khong hop le.");
                }
                break;

            case 0:
                System.out.println("Quay lai MENU CHINH...");
                break;

            default:
                System.out.println("Lua chon khong hop le!");
        }
    } while(choice != 0); // chạy liên tục cho tới khi nhấn 0
}

public void ThemPhieuNhapHang() {
    // Nhập thông tin phiếu nhập
    PhieuNhapHang pnh = new PhieuNhapHang();
    pnh.nhap();
    dspnh.Them(pnh);

    System.out.print("Nhập số lượng chi tiết phiếu nhập hàng: ");
    int soLuongCT = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < soLuongCT; i++) {
        System.out.println("---- Nhập chi tiết phiếu nhập hàng thứ " + (i + 1) + " ----");
        ChiTietPhieuNhapHang ct = new ChiTietPhieuNhapHang();
        ct.nhap();

        // Gắn mã phiếu nhập cho chi tiết
        ct.setMaPhieuNhapHang(pnh.getMaPhieuNhapHang());

        // Thêm chi tiết vào danh sách chi tiết phiếu nhập
        dsctpnh.Them(ct);
        dssp.Sua_SoLuong(ct.getMaSanPham(),- ( ct.getSoLuong()));
    }

    // Cập nhật tổng tiền cho phiếu nhập
    TinhTienTong();

    System.out.println(">> Đã thêm phiếu nhập hàng và chi tiết thành công!");
}


}