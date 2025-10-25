import java.util.Scanner;

public class HoaDon {
    private static Scanner sc = new Scanner(System.in);
    private String mahoadon;
    private String makhachhang;
    private String manhanvien;
    private double tongTien;

    // Constructor không tham số
    public HoaDon() {}

    // Constructor có tham số
    public HoaDon(String mahoadon, String makhachhang, String manhanvien, double tongTien) {
        this.mahoadon = mahoadon;
        this.makhachhang = makhachhang;
        this.manhanvien = manhanvien;
        this.tongTien = tongTien;
    }

    
    public String getMahoadon() { return mahoadon; }
    public void setMahoadon(String maHoaDon) { this.mahoadon = maHoaDon; }

    public String getMakhachhang() { return makhachhang; }
    public void setMakhachhang(String maKhachHang) { this.makhachhang = maKhachHang; }

    public String getMaNhanVien() { return manhanvien; }
    public void setMaNhanVien(String manhanvien) { this.manhanvien = manhanvien; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

    
    public void nhapThongTin() {

        System.out.print("Nhập mã hóa đơn: ");
        mahoadon = sc.nextLine();
        System.out.print("Nhập mã khách hàng: ");
        makhachhang = sc.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        manhanvien = sc.nextLine();
        System.out.print("Nhập tổng tiền: ");
        tongTien = Double.parseDouble(sc.nextLine());
    }

    
    public void hienThiThongTin() {
        
    }
}
