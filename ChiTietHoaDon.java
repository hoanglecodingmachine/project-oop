import java.util.Scanner;
public class ChiTietHoaDon {
    private static Scanner sc = new Scanner(System.in);
    private String mahoadon;
    private String mahoadonchitiet;
    private String masanpham;
    private int soluong;
    private double dongia;
    private double thanhgia;
    public ChiTietHoaDon(){};
    public ChiTietHoaDon(String mahoadon ,String mahoadonchitiet ,String masanpham,int soluong,double dongia,double thanhgia){
        this.mahoadon = mahoadon;
        this.mahoadonchitiet = mahoadonchitiet;
        this.masanpham = masanpham;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhgia = thanhgia;
    }
    public void nhap(){
        System.out.println("nhap ma hoa don ");
        mahoadon = sc.nextLine();
        System.out.println("nhap ma hoa don chi tiet ");
        mahoadonchitiet = sc.nextLine();
        System.out.println("nhap ma san pham khach hang mua ");
        masanpham = sc.nextLine();
        System.out.println("nhap so luong san pham khach hang mua ");
        soluong = sc.nextInt();
    }
    public void xuat(){
         System.out.printf("%-10s %-10s %-10s %-10d %-10f %-10f",mahoadon,mahoadonchitiet,masanpham,soluong,dongia,thanhgia);
    }
    public String getMaHoaDon(){
        return mahoadon;
    }
    public void setMaHoaDon(String mahoadon){
        this.mahoadon = mahoadon;
    }
    public String getMaHoaDonChiTiet(){
        return mahoadonchitiet;
    }
    public void setMaHoaDonChiTiet(String mahoadonchitiet){
        this.mahoadonchitiet = mahoadonchitiet;
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