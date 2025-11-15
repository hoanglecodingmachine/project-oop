import java.util.Scanner;

public class ChiTietHoaDon {
    private static Scanner sc = new Scanner(System.in);

    private String maHoaDon;
    private String maHoaDonChiTiet;
    private String maSanPham;
    private int soLuong;
    private double donGia;
    private double thanhGia;

    public ChiTietHoaDon() {}

    public ChiTietHoaDon(String maHoaDon, String maHoaDonChiTiet, String maSanPham, int soLuong, double donGia, double thanhGia) {
        this.maHoaDon = maHoaDon;
        this.maHoaDonChiTiet = maHoaDonChiTiet;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhGia = thanhGia;
    }

    // ========================= NHAP =============================
    public void nhap() {
        System.out.print("Nhap ma hoa don: ");
        maHoaDon = sc.nextLine();

        System.out.print("Nhap ma hoa don chi tiet: ");
        maHoaDonChiTiet = sc.nextLine();

        System.out.print("Nhap ma san pham khach hang mua: ");
        maSanPham = sc.nextLine();

        System.out.print("Nhap so luong san pham: ");
        soLuong = sc.nextInt();
        sc.nextLine(); // NGĂN TRÔI LỆNH — cần thiết
        // Không nhập donGia và thanhGia vì bạn set trong QLHD
    }

    // ========================= XUAT =============================
    public void xuat() {
        System.out.printf(
            "%-15s %-20s %-15s %-10d %-12.2f %-12.2f\n",
            maHoaDon, maHoaDonChiTiet, maSanPham, soLuong, donGia, thanhGia
        );
    }

    // ========================= GET / SET =========================
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaHoaDonChiTiet() {
        return maHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String maHoaDonChiTiet) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhGia() {
        return thanhGia;
    }

    public void setThanhGia(double thanhGia) {
        this.thanhGia = thanhGia;
    }
}
