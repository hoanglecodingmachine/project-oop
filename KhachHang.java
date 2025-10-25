import java.util.Scanner;

public class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private String email;
    private String soDienThoai;
    private String diaChi;

    // Constructor không tham số
    public KhachHang() {}

    // Constructor có tham số
    public KhachHang(String maKhachHang, String tenKhachHang, String email, String soDienThoai, String diaChi) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    // Getter và Setter
    public String getMaKhachHang() { return maKhachHang; }
    public void setMaKhachHang(String maKhachHang) { this.maKhachHang = maKhachHang; }

    public String getTenKhachHang() { return tenKhachHang; }
    public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    // Phương thức nhập thông tin
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng: ");
        maKhachHang = sc.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        tenKhachHang = sc.nextLine();
        System.out.print("Nhập email: ");
        email = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        soDienThoai = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        diaChi = sc.nextLine();
    }

    // Phương thức hiển thị thông tin
    public void hienThiThongTin() {
        System.out.println("\n===== THÔNG TIN KHÁCH HÀNG =====");
        System.out.println("Mã KH: " + maKhachHang);
        System.out.println("Tên KH: " + tenKhachHang);
        System.out.println("Email: " + email);
        System.out.println("SĐT: " + soDienThoai);
        System.out.println("Địa chỉ: " + diaChi);
    }
}
