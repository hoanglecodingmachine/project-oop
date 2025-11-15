import java.util.Scanner;
public class ChiTietPhieuNhapHang {
  private static Scanner sc = new Scanner(System.in);
  private String mapnh;
  private String machitietpnh;
  private String masp;
  private int soluong;
  private double dongia;
  private Double tongtien;
  public ChiTietPhieuNhapHang(){};
  public ChiTietPhieuNhapHang(String mapnh,String machitietpnh,String masp, int soluong,double dongia,double tongtien){
    this.mapnh = mapnh;
    this.machitietpnh = machitietpnh;
    this.masp = masp;
    this.soluong = soluong;
    this.dongia = dongia;
    this.tongtien = tongtien;
  }
  public String getMaSanPham(){
    return masp;
  }
  public void setMaSanPham(String masp){
    this.masp = masp;
  }
  public String getMaPhieuNhapHang(){
    return mapnh;
  }
  public void setMaPhieuNhapHang(String mapnh){
    this.mapnh = mapnh;
  }
  public String getMaPhieuNhapHangChiTiet(){
    return machitietpnh;
  }
  public void setMaPhieuNhapHangChiTiet(String machitietpnh){
    this.machitietpnh = machitietpnh;
  }
  public int getSoLuong(){
    return soluong;
  }
  public void setSoLuong(int soluong){
    this.soluong = soluong;
  }
  public double getTongTien(){
    return tongtien;
  }
  public void setTongTien(double tongtien){
    this.tongtien = tongtien;
  }
    public double getDonGia(){
    return dongia;
  }
  public void setDonGia(double dongia){
    this.dongia = dongia;
  }
  public void nhap(){
    System.out.println("nhap ma phieu nhap hang ");
    mapnh = sc.nextLine();
    System.out.println("nhap ma chi tiet phieu nhap hang ");
    machitietpnh = sc.nextLine();
    System.out.println("nhap ma nha ma san pham ");
    masp = sc.nextLine();
    System.out.println("nhap so luong san pham ");
    soluong = sc.nextInt();
    System.out.println("nha don gia cua ma san pham ");
    dongia = sc.nextDouble();
    tongtien = soluong * dongia;
  }
  public void xuat(){
    System.out.printf("%-10s %-10s %-10s %-10s %-10f %-10s",mapnh,machitietpnh,masp,soluong,dongia,tongtien);
  }

} 