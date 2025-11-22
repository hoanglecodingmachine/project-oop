import java.util.Scanner;
public class HoaDon {
    private static Scanner sc = new Scanner(System.in);
    private String mahoadon;
    private String ngaynhap;
    private String makhachhang;
    private String manhanvien;
    private double tongtien;
    private String maphukien;
    public HoaDon() {}

    public HoaDon(String mahoadon,String ngaynhap ,String makhachhang, String manhanvien, double tongtien,String maphukien) {
        this.mahoadon = mahoadon;
        this.ngaynhap = ngaynhap;
        this.makhachhang = makhachhang;
        this.manhanvien = manhanvien;
        this.tongtien = tongtien;
        this.maphukien = maphukien;
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

    public String getMaPhuKien() { return maphukien; }
    public void setMaPhuKien(String maphukien) { this.maphukien = maphukien; }
    public void nhap() {
        System.out.print("Nhap ma hoa don: ");
        mahoadon = sc.nextLine();

        System.out.println("Nhap ngay nhap (dd/mm/yyyy): ");
        ngaynhap = sc.nextLine();

        System.out.print("Nhap ma khach hang: ");
        makhachhang = sc.nextLine();

        System.out.print("Nhap ma nhan vien: ");
        manhanvien = sc.nextLine();
        
        System.out.println("nhap ma phu kien di kem ");
        maphukien = sc.nextLine();
    }

    public void xuat() {
        
       System.out.printf("%-12s| %-12s | %-12s | %-12s | %-12s | %-12.0fđ%n",
        mahoadon, ngaynhap, makhachhang, manhanvien, maphukien, tongtien);

    }
}
