import java.util.Scanner;

public class HoaDon {
    private String maHoaDon;
    private String maKhachHang;
    private String maNhanVien;
    private double tongTien;

    // Constructor không tham số
    public HoaDon() {}

    // Constructor có tham số
    public HoaDon(String maHoaDon, String maKhachHang, String maNhanVien, double tongTien) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.tongTien = tongTien;
    }

    // Getter & Setter
    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }

    public String getMaKhachHang() { return maKhachHang; }
    public void setMaKhachHang(String maKhachHang) { this.maKhachHang = maKhachHang; }

    public String getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(String maNhanVien) { this.maNhanVien = maNhanVien; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

    // Phương thức nhập thông tin hóa đơn
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã hóa đơn: ");
        maHoaDon = sc.nextLine();
        System.out.print("Nhập mã khách hàng: ");
        maKhachHang = sc.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        maNhanVien = sc.nextLine();
        System.out.print("Nhập tổng tiền: ");
        tongTien = Double.parseDouble(sc.nextLine());
    }

    // Phương thức hiển thị thông tin hóa đơn
    public void hienThiThongTin() {
        System.out.println("\n===== THÔNG TIN HÓA ĐƠN =====");
        System.out.println("Mã hóa đơn: " + maHoaDon);
        System.out.println("Mã khách hàng: " + maKhachHang);
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Tổng tiền: " + tongTien);
    }
}
