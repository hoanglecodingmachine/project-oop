import java.util.Scanner;

public class KhachHang {
    private String makhachhang;
    private String hokhachhang;
    private String tenkhachhang;
    private String email;
    private String sodienthoai;
    private String gioitinh;
    private String ngaysinh;
    private static Scanner sc = new Scanner(System.in);

    public KhachHang() {}

    // Constructor có tham số
    public KhachHang(String makhachhang,String hokhachhang ,String tenkhachhang, String email, String sodienthoai, String gioitinh, String ngaysinh) {
        this.makhachhang = makhachhang;
        this.hokhachhang = hokhachhang;
        this.tenkhachhang = tenkhachhang;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
    }

    // Getter và Setter
    public String getMaKhachHang() { return makhachhang; }
    public void setMaKhachHang(String makhachhang) { this.makhachhang = makhachhang; }

    public String getTenKhachHang() { return tenkhachhang; }
    public void setTenKhachHang(String tenkhachhang) { this.tenkhachhang = tenkhachhang; }

    public String getHoKhachHang() { return hokhachhang; }
    public void setHoKhachHang(String hokhachhang) { this.hokhachhang = hokhachhang; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSoDienThoai() { return sodienthoai; }
    public void setSoDienThoai(String sodienthoai) { this.sodienthoai = sodienthoai; }

    public String getGioiTinh() { return gioitinh; }
    public void setGioiTinh(String gioitinh) { this.gioitinh = gioitinh; }
    
    public String getNgaySinh() { return ngaysinh; }
    public void setNgaySinh(String ngaysinh) { this.ngaysinh = ngaysinh; }

    public void nhap() {
        System.out.print("Nhập mã khách hàng: ");
        makhachhang = sc.nextLine();
        System.out.println("Nhập họ khách hàng: ");
        hokhachhang = sc.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        tenkhachhang = sc.nextLine();
        System.out.print("Nhập email: ");
        email = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        sodienthoai = sc.nextLine();
        System.out.print("Nhập gioi tinh(nam/nu): ");
        gioitinh = sc.nextLine();
        System.out.print("Nhập ngày sinh (dd/mm/yyyy): ");
        ngaysinh = sc.nextLine();
    }

    // Phương thức hiển thị thông tin
    public void xuat() {
    System.out.printf("%-12s | %-15s | %-12s | %-25s | %-12s | %-8s | %-12s%n",
        makhachhang, hokhachhang, tenkhachhang, email, sodienthoai, gioitinh, ngaysinh);

    }
}
