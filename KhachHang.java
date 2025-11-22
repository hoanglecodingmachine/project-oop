import java.util.Scanner;

public class KhachHang {
    private String makhachhang;
    private String hokhachhang;
    private String tenkhachhang;
    private String email;
    private String sodienthoai;
    private String gioitinh;
    private int dotuoi;
    private static Scanner sc = new Scanner(System.in);

    public KhachHang() {}

    // Constructor có tham số
    public KhachHang(String makhachhang,String hokhachhang ,String tenkhachhang, String email, String sodienthoai, String gioitinh, int dotuoi) {
        this.makhachhang = makhachhang;
        this.hokhachhang = hokhachhang;
        this.tenkhachhang = tenkhachhang;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.gioitinh = gioitinh;
        this.dotuoi = dotuoi;
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
    
    public int getDoTuoi() { return dotuoi; }
    public void setDoTuoi(int dotuoi) { this.dotuoi = dotuoi; }

    public void nhap() {
        System.out.print("Nhap ma khach hang: ");
        makhachhang = sc.nextLine();
        System.out.println("Nhap ho khach hang: ");
        hokhachhang = sc.nextLine();
        System.out.print("Nhap ten khach hang: ");
        tenkhachhang = sc.nextLine();
        System.out.print("Nhap email: ");
        email = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        sodienthoai = sc.nextLine();
        System.out.print("Nhap gioi tinh(nam/nu): ");
        gioitinh = sc.nextLine();
        System.out.print("do tuoi cua khach la : ");
        dotuoi = sc.nextInt();
        sc.nextLine();
    }

    // Phương thức hiển thị thông tin
    public void xuat() {
    System.out.printf("%-12s | %-15s | %-12s | %-25s | %-12s | %-8s | %-12d%n",
        makhachhang, hokhachhang, tenkhachhang, email, sodienthoai, gioitinh, dotuoi);

    }
}
