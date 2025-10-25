import java.util.Scanner;

public class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private double luong;
    private String chucVu;

    // Constructor không tham số
    public NhanVien() {}

    // Constructor có tham số
    public NhanVien(String maNhanVien, String hoTen, double luong, String chucVu) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.luong = luong;
        this.chucVu = chucVu;
    }

    // Getter và Setter
    public String getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(String maNhanVien) { this.maNhanVien = maNhanVien; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public double getLuong() { return luong; }
    public void setLuong(double luong) { this.luong = luong; }

    public String getChucVu() { return chucVu; }
    public void setChucVu(String chucVu) { this.chucVu = chucVu; }

    // Phương thức nhập thông tin nhân viên
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên: ");
        maNhanVien = sc.nextLine();
        System.out.print("Nhập họ tên: ");
        hoTen = sc.nextLine();
        System.out.print("Nhập lương: ");
        luong = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập chức vụ: ");
        chucVu = sc.nextLine();
    }

    // Phương thức hiển thị thông tin nhân viên
    public void hienThiThongTin() {
        System.out.println("\n===== THÔNG TIN NHÂN VIÊN =====");
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Lương: " + luong);
        System.out.println("Chức vụ: " + chucVu);
    }
}
