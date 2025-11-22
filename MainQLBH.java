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

    // === Doc tat ca file vao chuong trinh ===
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

    // === Ghi tat ca du lieu ra file ===
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
        System.out.println("Du lieu da duoc luu thanh cong!");
    }

    // === Menu tong ===
    public void menuChinh() {
        int chon;
        do {
            System.out.println("\n==== MENU CHINH ====");
            System.out.println("1. Quan ly san pham");
            QLSP qlsp = new QLSP();
            System.out.println("2. Quan ly hoa don");
            QLHD qlhd = new QLHD();
            System.out.println("3. Quan ly khach hang");
            QLKH qlkh = new QLKH();
            System.out.println("4. Quan ly nhan vien");
            QLNV qlnv = new QLNV();
            System.out.println("5. Quan ly nhap hang");
            QLPNH qlpnh = new QLPNH();
            System.out.println("6. Quan ly nha cung cap");
            QLNCC qlncc = new QLNCC();
            System.out.println("7. Quan ly bao hanh");
            QLBH qlbh = new QLBH();
            System.out.println("8. Quan ly phu kien di kem");
            QLPK qlpk = new QLPK();
            System.out.println("9. Thong ke tien trong khoang thoi gian ban");
            System.out.println("10. Thong ke tien theo quy");
            System.out.println("0. Thoat va luu du lieu");
            System.out.print("Nhap lua chon: ");
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
                    GhiFile(); // goi ham ghi file truoc khi thoat
                    System.out.println("Thoat chuong trinh...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);
    }

    public static void main(String[] args) {
        MainQLBH qlbh = new MainQLBH();
        qlbh.DocFile(); // doc du lieu ban dau
        qlbh.menuChinh(); // chay menu
    }
}
