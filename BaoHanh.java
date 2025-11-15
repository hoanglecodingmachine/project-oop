import java.util.Scanner;
public class BaoHanh {
    private static Scanner sc = new Scanner(System.in);
    private String maBaoHanh;
    private String maSanPham;
    private int thoiGianBaoHanh;
    public BaoHanh() {}
    public BaoHanh(String maBaoHanh, String maSanPham, int thoiGianBaoHanh) {
        this.maBaoHanh = maBaoHanh;
        this.maSanPham = maSanPham;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }
    public String getMaBaoHanh() {
        return maBaoHanh;
    }
    public void setMaBaoHanh(String maBaoHanh) {
        this.maBaoHanh = maBaoHanh;
    }
    public String getMaSanPham() {
        return maSanPham;
    }
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }
    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }
    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }
    public void nhap() {
        System.out.print("Nhap ma bao hanh: ");
        maBaoHanh = sc.nextLine();
        System.out.print("Nhap ma san pham: ");
        maSanPham = sc.nextLine();
        System.out.print("Nhap thoi gian bao hanh (thang): ");
        thoiGianBaoHanh = sc.nextInt();
        sc.nextLine(); 
    }
    public void xuat() {
        System.out.printf("%-15s %-15s %-20d\n", maBaoHanh, maSanPham, thoiGianBaoHanh);
    }

}