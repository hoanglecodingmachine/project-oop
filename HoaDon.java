import java.util.Scanner;
import java.util.Arrays;

public class HoaDon {
    private static Scanner sc = new Scanner(System.in);
    private String mahoadon;
    private String makhachhang;
    private String manhanvien;
    private double tongtien;

    // Danh sách sản phẩm trong hóa đơn
    private String[] maSanPhamMua;
    private int[] soLuongMua;
    private int soSanPham;

    public HoaDon() {}

    public HoaDon(String mahoadon, String makhachhang, String manhanvien, double tongtien) {
        this.mahoadon = mahoadon;
        this.makhachhang = makhachhang;
        this.manhanvien = manhanvien;
        this.tongtien = tongtien;
    }

    // --- Getter / Setter ---
    public String getMahoadon() { return mahoadon; }
    public void setMahoadon(String maHoaDon) { this.mahoadon = maHoaDon; }

    public String getMakhachhang() { return makhachhang; }
    public void setMakhachhang(String makhachhang) { this.makhachhang = makhachhang; }

    public String getMaNhanVien() { return manhanvien; }
    public void setMaNhanVien(String manhanvien) { this.manhanvien = manhanvien; }

    public double getTongtien() { return tongtien; }
    public void setTongtien(double tongtien) { this.tongtien = tongtien; }

    // --- Hàm nhập ---
    public void nhap(
        KhachHang[] dsKhachHang, int soKH,
        NhanVien[] dsNhanVien, int soNV,
        DanhSachCuaHangDienThoai[] dsCuaHang, int soCuaHang
    ) {
        System.out.print("Nhập mã hóa đơn: ");
        mahoadon = sc.nextLine();

        // Kiểm tra mã KH
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
            if (!hopLeKH) System.err.println("❌ Mã khách hàng không tồn tại, vui lòng nhập lại!");
        } while (!hopLeKH);

        // Kiểm tra mã NV
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
            if (!hopLeNV) System.err.println("❌ Mã nhân viên không tồn tại, vui lòng nhập lại!");
        } while (!hopLeNV);

        // Nhập danh sách sản phẩm
        System.out.print("Nhập số lượng sản phẩm khách mua: ");
        soSanPham = sc.nextInt();
        sc.nextLine();

        maSanPhamMua = new String[soSanPham];
        soLuongMua = new int[soSanPham];

        for (int i = 0; i < soSanPham; i++) {
            System.out.print("Nhập mã sản phẩm thứ " + (i + 1) + ": ");
            maSanPhamMua[i] = sc.nextLine();

            System.out.print("Nhập số lượng mua: ");
            soLuongMua[i] = sc.nextInt();
            sc.nextLine();
        }

        // Sau khi nhập xong gọi hàm tính tổng
        tongtien = tinhTongTien(dsCuaHang, soCuaHang);
        System.out.printf("✅ Tổng tiền hóa đơn này: %.0fđ%n", tongtien);
    }

    // --- Hàm tính tổng riêng ---
    public double tinhTongTien(DanhSachCuaHangDienThoai[] dsCuaHang, int soCuaHang) {
        double tong = 0;
        for (int i = 0; i < soSanPham; i++) {
            double giaSP = 0;
            boolean timThay = false;

            for (int j = 0; j < soCuaHang; j++) {
                CUAHANGDIENTHOAI sp = dsCuaHang[j].Search_Ma(maSanPhamMua[i]);
                if (sp != null) {
                    giaSP = sp.getDonGia();
                    timThay = true;
                    break;
                }
            }

            if (timThay) {
                double thanhTien = soLuongMua[i] * giaSP;
                tong += thanhTien;
                System.out.printf("→ %s | SL: %d | Giá: %.0f | Thành tiền: %.0fđ%n",
                                  maSanPhamMua[i], soLuongMua[i], giaSP, thanhTien);
            } else {
                System.out.println("⚠️ Không tìm thấy sản phẩm có mã " + maSanPhamMua[i]);
            }
        }
        return tong;
    }

    // --- Xuất hóa đơn ---
    public void xuat() {
        System.out.printf("%-10s | %-10s | %-10s | Tổng: %.0fđ%n",
            mahoadon, makhachhang, manhanvien, tongtien);
    }
}
