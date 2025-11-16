import java.util.Scanner;

public class MainQLBH {
    public static Scanner sc = new Scanner(System.in);
    public static DanhSachSanPham dssp = new DanhSachSanPham();
    public static DanhSachHoaDon dshd = new DanhSachHoaDon();
    public static DanhSachChiTietHoaDon dscthd = new DanhSachChiTietHoaDon();
    public static DanhSachNhanVien dsnv = new DanhSachNhanVien();
    public static DanhSachKhachHang dskh = new DanhSachKhachHang();
    public static DanhSachNhaCungCap dsncc = new DanhSachNhaCungCap();
    public static DanhSachPhieuNhapHang dspnh = new DanhSachPhieuNhapHang();
    public static DanhSachChiTietNhapHang dsctpnh = new DanhSachChiTietNhapHang();
    public static DanhSachBaoHanh dsbh = new DanhSachBaoHanh();
    public static DanhSachPhuKienDiKem dsphukien = new DanhSachPhuKienDiKem();

    // === Đọc tất cả file vào chương trình ===
    public void DocFile() {
        dssp.DocFile("SanPham.txt");
        dshd.DocFile("HoaDon.txt");
        dscthd.DocFile("ChiTietHoaDon.txt");
        dsnv.DocFile("NhanVien.txt");
        dskh.DocFile("KhachHang.txt");
        dsncc.DocFile("NhaCungCap.txt");
        dspnh.DocFile("PhieuNhap.txt");
        dsctpnh.DocFile("ChiTietPhieuNhap.txt");
        dsbh.DocFile("BaoHanh.txt");
        dsphukien.DocFile("PhuKienDiKem.txt");
    }

    // === Ghi tất cả dữ liệu ra file ===
    public void GhiFile() {
        dssp.GhiFile("SanPham.txt");
        dshd.GhiFile("HoaDon.txt");
        dscthd.GhiFile("ChiTietHoaDon.txt");
        dsnv.GhiFile("NhanVien.txt");
        dskh.GhiFile("KhachHang.txt");
        dsncc.GhiFile("NhaCungCap.txt");
        dspnh.GhiFile("PhieuNhap.txt");
        dsctpnh.GhiFile("ChiTietPhieuNhap.txt");
        dsbh.GhiFile("BaoHanh.txt");
        dsphukien.GhiFile("PhuKienDiKem.txt");
        System.out.println(" Dữ liệu đã được lưu thành công!");
    }

    // === Ví dụ menu tổng ===
    public void menuChinh() {
        int chon;
        do {
            System.out.println("\n==== MENU CHÍNH ====");
            System.out.println("1. Quản lý sản phẩm");
            QLSP qlsp = new QLSP();
            System.out.println("2. Quản lý hóa đơn");
            QLHD qlhd = new QLHD();
            System.out.println("3. Quản lý khách hàng");
            QLKH qlkh = new QLKH();
            System.out.println("4. Quản lý nhân viên");
            QLNV qlnv = new QLNV();
            System.out.println("5. Quản lý nhập hàng");
            QLPNH qlpnh = new QLPNH();
            System.out.println("6. Quản lý nhà cung cấp");
            QLNCC qlncc = new QLNCC();
            System.out.println("7. Quản lý bảo hành");
            QLBH qlbh = new QLBH();
            System.out.println("8. Quản lý phụ kiện đi kèm");
            QLPK qlpk = new QLPK();
            System.out.println("9. Thong Ke Tien Trong Khoang Thoi Gian Ban");
            System.out.println("10. Thong Ke Tien Theo Quy");
            System.out.println("0. Thoát và lưu dữ liệu");
            System.out.print("Nhập lựa chọn: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    qlsp.mainQLSP(); break;
                case 2:
                    qlhd.mainQLHD(); break;
                case 3:
                    qlkh.mainQLKH(); break;
                case 4:
                    qlnv.mainQLNV(); break;
                case 5:
                    qlpnh.mainQLPNH(); break;
                case 6:
                    qlncc.MainQLNCC(); break;
                case 7:
                    qlbh.mainQLBH(); break;
                case 8:
                    qlpk.mainQLPKDK(); break;
                case 9:
                    qlhd.ThongKe_TongTienTuNgay(); break;
                case 10:
                    qlhd.ThongKe_TheoQuy(); break;
                case 0:
                    GhiFile(); // gọi hàm ghi file trước khi thoát
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (chon != 0);
    }

    public static void main(String[] args) {
        MainQLBH qlbh = new MainQLBH();
        qlbh.DocFile(); // đọc dữ liệu ban đầu
        qlbh.menuChinh(); // chạy menu
    }
}
