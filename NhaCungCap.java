import java.util.Scanner;
public class NhaCungCap {
  private static Scanner sc = new Scanner(System.in);
  private String mancc;
  private String diachi;
  private String sdt;
  private String email;
  public NhaCungCap(){}
  public NhaCungCap(String mancc,String diachi, String sdt,String email){
    this.mancc = mancc;
    this.diachi = diachi;
    this.sdt = sdt;
    this.email = email;
  }
  public String getMaNhaCungCap(){
    return mancc;
  }
  public void setMaNhaCungCap(String mancc){
    this.mancc = mancc;
  }
  public String getDiaChi(){
    return diachi;
  }
  public void setDiaChi(String diachi){
    this.diachi = diachi;
  }
  public String getSoDienThoai(){
    return sdt;
  }
  public void setSoDienThoai(String sdt){
    this.sdt = sdt;
  }
  public String getEmail(){
    return email;
  }
  public void setEmail(String email){
    this.email = email;
  }

  public void nhap(){
    System.out.println("nhap ma nha cung cap ");
    mancc = sc.nextLine();
    System.out.println("nhap dia chi(HCM,HN,NN) ");
    diachi = sc.nextLine();
    System.out.println("nhap so dien thoai ");
    sdt = sc.nextLine();
    System.out.println("nhap dia chi email ");
    email = sc.nextLine();
  }
  public void xuat(){
    System.out.printf("%-12s | %-15s | %-12s | %-25s%n", mancc, diachi, sdt, email);

  }

} 