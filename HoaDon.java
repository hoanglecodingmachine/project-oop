import java.util.Scanner;
public class HoaDon {
    private static Scanner sc = new Scanner(System.in);
    private String mahoadon;
    private String ngaynhap;
    private String makhachhang;
    private String manhanvien;
    private double tongtien;

    public HoaDon() {}

    public HoaDon(String mahoadon,String ngaynhap ,String makhachhang, String manhanvien, double tongtien) {
        this.mahoadon = mahoadon;
        this.ngaynhap = ngaynhap;
        this.makhachhang = makhachhang;
        this.manhanvien = manhanvien;
        this.tongtien = tongtien;
    }
    public String getMaHoaDon() { return mahoadon; }
    public void setMaHoaDon(String mahoadon) { this.mahoadon = mahoadon; }
    
    public String getNgayNhap() { return ngaynhap; }
    public void setNgayNhap(String ngaynhap) { this.ngaynhap = ngaynhap; }
    
    public String getMaKhachHang() { return makhachhang; }
    public void setMaKhachHang(String makhachhang) { this.makhachhang = makhachhang; }

    public String getMaNhanVien() { return manhanvien; }
    public void setMaNhanVien(String manhanvien) { this.manhanvien = manhanvien; }

    public double getTongTien() { return tongtien; }
    public void setTongTien(double tongtien) { this.tongtien = tongtien; }

    public void nhap() {
        System.out.print("Nhập mã hóa đơn: ");
        mahoadon = sc.nextLine();

        System.out.println("Nhập ngày nhập (dd/mm/yyyy): ");
        ngaynhap = sc.nextLine();

        System.out.print("Nhập mã khách hàng: ");
        makhachhang = sc.nextLine();

        System.out.print("Nhập mã nhân viên: ");
        manhanvien = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s| %-10s | %-10s | %-10s | Tổng tiền: %.0fđ%n",
                mahoadon,ngaynhap, makhachhang, manhanvien, tongtien);
    }
}
