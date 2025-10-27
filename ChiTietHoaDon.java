import java.util.Scanner;
public class ChiTietHoaDon {
    private static Scanner sc = new Scanner(System.in);
    private String masanpham;
    private int soluong;
    private double dongia;
    private double thanhgia;
    public ChiTietHoaDon(){};
    public ChiTietHoaDon(String masanpham,int soluong,double dongia,double thanhgia){
        this.masanpham = masanpham;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhgia = thanhgia;
    }
    public void nhap(){
        System.out.println("nhap ma san pham khach hang mua ");
        masanpham = sc.nextLine();
        System.out.println("nhap so luong san pham khach hang mua ");
        soluong = sc.nextInt();
        System.out.println("Nhap don gia san pham ma khach mua ");
        dongia = sc.nextDouble();
        thanhgia = dongia * soluong;
    }
    public void xuat(){
         System.out.printf("%-10s %-10d %-10f %-10f",masanpham,soluong,dongia,thanhgia);
    }
    public String getMaSanPham(){
        return masanpham;
    }
    public void setMaSanPham(String masanpham){
        this.masanpham = masanpham;
    }
    public int getSoLuong(){
        return soluong;
    }
    public void setSoLuong(int soluong){
        this.soluong = soluong;
    }
    public Double getDonGia(){
        return dongia;
    }
    public void setDonGia(Double dongia){
        this.dongia = dongia;
    }
    public Double getThanhGia(){
        return thanhgia;
    }
    public void setThanhGia(Double thanhgia){
        this.thanhgia = thanhgia;
    }
}