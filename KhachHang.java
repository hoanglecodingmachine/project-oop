import java.util.Scanner;

public class KhachHang {
    private String makhachhang;
    private String tenkhachhang;
    private String email;
    private String sodienthoai;
    private String diachi;
    private static Scanner sc = new Scanner(System.in);

    public KhachHang() {}

    // Constructor có tham số
    public KhachHang(String makhachhang, String tenkhachhang, String email, String sodienthoai, String diachi) {
        this.makhachhang = makhachhang;
        this.tenkhachhang = tenkhachhang;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
    }

    // Getter và Setter
    public String getMaKhachHang() { return makhachhang; }
    public void setMaKhachHang(String makhachhang) { this.makhachhang = makhachhang; }

    public String getTenKhachHang() { return tenkhachhang; }
    public void setTenKhachHang(String tenkhachhang) { this.tenkhachhang = tenkhachhang; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSoDienThoai() { return sodienthoai; }
    public void setSoDienThoai(String sodienthoai) { this.sodienthoai = sodienthoai; }

    public String getDiaChi() { return diachi; }
    public void setDiaChi(String diachi) { this.diachi = diachi; }
    public void nhap() {
        System.out.print("Nhập mã khách hàng: ");
        makhachhang = sc.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        tenkhachhang = sc.nextLine();
        System.out.print("Nhập email: ");
        email = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        sodienthoai = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        diachi = sc.nextLine();
    }

    // Phương thức hiển thị thông tin
    public void xuat() {
     System.out.printf("%-15s %-20s %-10s %-10s %-10s",makhachhang,tenkhachhang,email,sodienthoai,diachi);
    }
}
