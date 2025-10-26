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
    public void setMahoadon(String maHoaDon) { this.mahoadon = maHoaDon; }

    public String getMakhachhang() { return makhachhang; }
    public void setMakhachhang(String makhachhang) { this.makhachhang = makhachhang; }

    public String getMaNhanVien() { return manhanvien; }
    public void setMaNhanVien(String manhanvien) { this.manhanvien = manhanvien; }

    public double getTongtien() { return tongtien; }
    public void setTongtien(double tongtien) { this.tongtien = tongtien; }
    public void nhap(KhachHang[] dsKhachHang, int soKH, NhanVien[] dsNhanVien, int soNV) {
        System.out.print("Nhập mã hóa đơn: ");
        mahoadon = sc.nextLine();
        boolean hopLeKH = false;
        do {
            System.out.print("Nhập mã khách hàng: ");
            makhachhang = sc.nextLine();
            for (int i = 0; i < soKH; i++) {
                if (makhachhang.equalsIgnoreCase(dsKhachHang[i].getMakhachhang())) {
                    hopLeKH = true;
                    break;
                }
            }
            if (!hopLeKH) {
                System.err.println(" Mã khách hàng không tồn tại, vui lòng nhập lại!");
            }
        } while (!hopLeKH);

        boolean hopLeNV = false;
        do {
            System.out.print("Nhập mã nhân viên: ");
            manhanvien = sc.nextLine();
            for (int i = 0; i < soNV; i++) {
                if (manhanvien.equalsIgnoreCase(dsNhanVien[i].getMaNhanVien())) {
                    hopLeNV = true;
                    break;
                }
            }
            if (!hopLeNV) {
                System.err.println("❌ Mã nhân viên không tồn tại, vui lòng nhập lại!");
            }
        } while (!hopLeNV);
        
    }

    public void xuat() {
        System.out.printf("%-15s %-15s %-15s %-20.2f\n", mahoadon, makhachhang, manhanvien, tongtien);
    }
}
