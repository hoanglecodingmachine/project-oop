import java.util.Scanner;
public class HoaDon {
    private static Scanner sc = new Scanner(System.in);
    private String mahoadon;
    private String makhachhang;
    private String manhanvien;
    private double tongtien;

    public HoaDon() {}

    public HoaDon(String mahoadon, String makhachhang, String manhanvien, double tongtien) {
        this.mahoadon = mahoadon;
        this.makhachhang = makhachhang;
        this.manhanvien = manhanvien;
        this.tongtien = tongtien;
    }
    public String getMahoadon() { return mahoadon; }
    public void setMahoadon(String mahoadon) { this.mahoadon = mahoadon; }

    public String getMakhachhang() { return makhachhang; }
    public void setMakhachhang(String makhachhang) { this.makhachhang = makhachhang; }

    public String getManhanvien() { return manhanvien; }
    public void setManhanvien(String manhanvien) { this.manhanvien = manhanvien; }

    public double getTongtien() { return tongtien; }
    public void setTongtien(double tongtien) { this.tongtien = tongtien; }

    public void nhap() {
        System.out.print("Nhập mã hóa đơn: ");
        mahoadon = sc.nextLine();

        System.out.print("Nhập mã khách hàng: ");
        makhachhang = sc.nextLine();

        System.out.print("Nhập mã nhân viên: ");
        manhanvien = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s | %-10s | %-10s | Tổng tiền: %.0fđ%n",
                mahoadon, makhachhang, manhanvien, tongtien);
    }
}
