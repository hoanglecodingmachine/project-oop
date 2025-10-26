import java.util.Scanner;

public class HoaDon {
    private static Scanner sc = new Scanner(System.in);
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

    
    public void nhapThongTin() {
        System.out.print("Nhập mã hóa đơn: ");
        maHoaDon = sc.nextLine();
        System.out.print("Nhập mã khách hàng: ");
        maKhachHang = sc.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        maNhanVien = sc.nextLine();
    }

    public void hienThiThongTin() {
        System.out.printf("%15s %20s %15s %20s",maHoaDon,maKhachHang,maNhanVien,tongTien);
    }
}
