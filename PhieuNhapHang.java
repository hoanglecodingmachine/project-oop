import java.util.Scanner;
public class PhieuNhapHang {
  private static Scanner sc = new Scanner(System.in);
  private String mancc;
  private String maphieunhap;
  private String ngaythangnam;
  private double thanhtien;
  public PhieuNhapHang(){}
  public PhieuNhapHang(String mancc,String maphieunhap, String ngaythangnam,double thanhtien){
    this.mancc = mancc;
    this.maphieunhap = maphieunhap;
    this.ngaythangnam = ngaythangnam;
    this.thanhtien = thanhtien;
  }
  public String getMaNhaCungCap(){
    return mancc;
  }
  public void setMaNhaCungCap(String mancc){
    this.mancc = mancc;
  }
  public String getMaPhieuNhapHang(){
    return maphieunhap;
  }
  public void setMaPhieuNhapHang(String maphieunhap){
    this.maphieunhap = maphieunhap;
  }
  public String getNgayThang(){
    return ngaythangnam;
  }
  public void setNgayThang(String ngaythangnam){
    this.ngaythangnam = ngaythangnam;
  }
  public double getThanhTien(){
    return thanhtien;
  }
  public void setThanhTien(double thanhtien){
    this.thanhtien = thanhtien;
  }
  public void nhap(){
    System.out.println("nhap phieu nhap hang ");
    maphieunhap = sc.nextLine();
    System.out.println("nhap ma nha cung cap ");
    mancc = sc.nextLine();
    System.out.println("nhap ngay nhap (dd/mm/yyyy) ");
    ngaythangnam = sc.nextLine();
  }
  public void xuat(){
    System.out.printf("%-10s %-10s %-10s %-10s",maphieunhap,mancc,ngaythangnam,thanhtien);
  }

} 