import java.util.Scanner;

public class MainHoaDon {
    public static Scanner sc = new Scanner(System.in);
    private HoaDon[] hd;
    private int numhd;

    public void nhap(
        KhachHang[] dsKhachHang, int soKH,
        NhanVien[] dsNhanVien, int soNV,
        DanhSachCuaHangDienThoai[] dsCuaHang, int soCuaHang
    ) {
        System.out.print("Nhập số lượng hóa đơn: ");
        numhd = sc.nextInt();
        sc.nextLine();

        hd = new HoaDon[numhd];
        for (int i = 0; i < numhd; i++) {
            System.out.println("\n===== Hóa đơn thứ " + (i + 1) + " =====");
            hd[i] = new HoaDon();
            hd[i].nhap(dsKhachHang, soKH, dsNhanVien, soNV, dsCuaHang, soCuaHang);
        }
    }

    public void xuat() {
        System.out.println("\n===== DANH SÁCH HÓA ĐƠN =====");
        for (int i = 0; i < numhd; i++) {
            hd[i].xuat();
        }
    }
}
