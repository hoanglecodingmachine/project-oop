  import java.util.Scanner;

  public abstract class DienThoai implements inhapxuat{
    private static final Scanner sc = new Scanner(System.in);
    private String masp;
    private String tensp;
    private int soluong;
    private String donvitien;
    private double dongia;
    public DienThoai(){}
    public DienThoai(String masp,String tensp,int soluong,String donvitien ,double dongia){
      this.masp = masp;
      this.tensp = tensp;
      this.soluong = soluong;
      this.donvitien = donvitien;
      this.dongia = dongia;
    }
    public DienThoai(DienThoai other){
      this.masp = other.masp;
      this.tensp = other.tensp;
      this.soluong = other.soluong;
      this.donvitien = other.donvitien;
      this.dongia = other.dongia;
    }
    public String getMaSP(){
      return masp;
    }
    public void setMaSP(String masp){
      this.masp = masp;
    }
    public String getTenSP(){
      return tensp;
    }
    public void setTenSP(String tensp){
      this.tensp = tensp;
    }
    public int getSoLuong(){
      return soluong;
    }
  public void setSoLuong(int soluong){
      this.soluong = soluong;
    }
  public String getDonViTien(){
      return donvitien;
    }
  public void setDonViTien(String donvitien){
      this.donvitien = donvitien;
    }
  public double getDonGia(){
      return dongia;
    }
  public void setDonGia (double dongia){
      this.dongia = dongia;
    }
  
    
  public void nhap(){
          System.out.println("nhap ma san pham ");
          masp = sc.nextLine();
          System.out.println("nhap ten san pham ");
          tensp = sc.nextLine();
          System.out.println("nhap so luong san pham ");
          soluong = sc.nextInt();
          sc.nextLine();
          System.out.println("nhap don vi tien ");
          donvitien = sc.nextLine();
          System.out.println("nhap don gia cho san pham ");
          dongia = sc.nextDouble();
          sc.nextLine();
      }
public void xuat() {
    System.out.printf("%-15s %-25s %-10d %-12s %-12.2f",
            masp, tensp, soluong, donvitien, dongia);
}

  public abstract double Tinh_Tien_SanPham();
  
  } 