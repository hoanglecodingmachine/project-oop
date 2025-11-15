import java.util.Scanner;

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

    // ✅ Menu quản lý hóa đơn
    public void mainQLHD() {
        System.out.println("Nhap lua chon (1.Xuat, 2.Them, 3.Sua, 4.Xoa, 5.Tim kiem, 6.Thong ke)");
        int choice = sc.nextInt();
        sc.nextLine();

        HoaDon[] arrHD = dshd.getHoaDon();
        ChiTietHoaDon[] arrCT = dscthd.getChiTietHoaDon();
        int soHD = dshd.getSoLuongHoaDon();
        int soCT = dscthd.getSoLuongChiTietHoaDon();

        switch (choice) {
            // ======== XUẤT ========
            case 1:
                capNhatGiaTriChiTiet();
                TinhTienTong();

                if (soHD == 0) {
                    System.out.println("Chưa có hóa đơn nào!");
                    return;
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

            // ======== THÊM ========
            case 2:
                ThemHoaDon();
                break;

            // ======== SỬA ========
            case 3:
                System.out.println("=== SỬA THÔNG TIN ===");
                System.out.println("1. Sửa hóa đơn");
                System.out.println("2. Sửa chi tiết hóa đơn");
                System.out.println("3. Quay lại");
                System.out.print("Nhập lựa chọn: ");
                int ch = sc.nextInt();
                sc.nextLine();
                switch (ch) {
                    case 1: dshd.sua();
                    break;
                    case 2: dscthd.sua();
                    break;
                    case 3:  return;
                    
                    default: System.out.println("Lựa chọn không hợp lệ!");
                    break;
                }
                break;

            // ======== XÓA ========
            case 4:
                System.out.println("=== XÓA DỮ LIỆU ===");
                System.out.println("1. Xóa hóa đơn");
                System.out.println("2. Xóa chi tiết hóa đơn");
                System.out.println("3. Quay lại");
                System.out.print("Nhập lựa chọn: ");
                int ch1 = sc.nextInt();
                sc.nextLine();
                switch (ch1) {
                    case 1: dshd.xoa();
                    break;
                    case 2: dscthd.xoa();
                    break;
                    case 3:  return; 
                    
                    default: System.out.println("Lựa chọn không hợp lệ!");
                    break;
                }
                break;

            // ======== TÌM KIẾM ========
            case 5:
                System.out.println("Tìm kiếm (1. Hóa đơn, 2. Chi tiết hóa đơn)");
                int tk = sc.nextInt();
                sc.nextLine();
                if (tk == 1) {
                    System.out.println("Tìm hóa đơn (1. Mã, 2. Mã KH, 3. Mã NV, 4 Ma Phu kien)");
                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    switch (subChoice) {
                        case 1: dshd.Search_Ma();
                        break;
                        case 2: dshd.Search_MaKhachHang();
                        break;
                        case 3: dshd.Search_MaNhanVien();
                        break;
                        case 4: dshd.Search_MaPhuKien();
                        break;
                        default: System.out.println("Lựa chọn không hợp lệ!");
                        break;
                    }
                } else {
                    System.out.println("Tìm chi tiết HĐ (1. Mã CTHĐ, 2. Mã HĐ, 3. Mã SP, 4. SL, 5. Đơn giá)");
                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    switch (subChoice) {
                        case 1: dscthd.Search_Ma();
                        break;
                        case 2: dscthd.Search_MaHoaDon();
                        break;
                        case 3: dscthd.Search_MaSanPham();
                        break;
                        case 4: dscthd.Search_SoLuong();
                        break;
                        case 5: dscthd.Search_DonGia();
                        break;
                        default: System.out.println("Lựa chọn không hợp lệ!");
                        break;
                    }
                }
                break;

            // ======== THỐNG KÊ ========
            case 6:
                System.out.println("Thống kê (1. Hóa đơn, 2. Chi tiết hóa đơn)");
                int tk2 = sc.nextInt();
                sc.nextLine();
                if (tk2 == 1) {
                    System.out.println("Thống kê hóa đơn (1. Theo tổng tiền, 2. Theo ngày lập)");
                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    switch (subChoice) {
                        case 1: dshd.ThongKe_TongTien();
                        break;
                        case 2: dshd.ThongKe_NgayLap();
                        break;
                        default: System.out.println("Lựa chọn không hợp lệ!");
                    }
                } else {
                    System.out.println("Thống kê chi tiết HĐ (1. Theo đơn giá, 2. Theo số lượng)");
                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    switch (subChoice) {
                        case 1: dscthd.ThongKe_DonGia();
                        break;
                        case 2: dscthd.ThongKe_SoLuong();
                        break;
                        default: System.out.println("Lựa chọn không hợp lệ!");
                        break;
                    }
                }
                break;

            // ======== KHÔNG HỢP LỆ ========
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }
}
