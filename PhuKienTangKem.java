import java.util.Scanner;
public class PhuKienTangKem {
 private static Scanner sc = new Scanner(System.in);
 private String maphukien;
 private String tenphukien;
 private String loai;
 public PhuKienTangKem(){}
 public PhuKienTangKem(String maphukien, String tenphukien,String loai) {
     this.maphukien = maphukien;
     this.tenphukien = tenphukien;
     this.loai = loai;
 }
    public String getMaphukien() {
        return maphukien;
    }
    public void setMaphukien(String maphukien) {
        this.maphukien = maphukien;
    }
    public String getTenphukien() {
        return tenphukien;
    }
    public void setTenphukien(String tenphukien) {
        this.tenphukien = tenphukien;
    }
    public String getLoai() {
        return loai;
    }
    public void setLoai(String loai) {
        this.loai = loai;
    }
    public void nhap(){
        System.out.print("Nhap ma phu kien: ");
        maphukien = sc.nextLine();
        System.out.print("Nhap ten phu kien: ");
        tenphukien = sc.nextLine();
        System.out.print("Nhap loai phu kien(tai nghe,op lung,cuong luc): ");
        loai = sc.nextLine();
    }
    public void xuat(){
       System.out.printf("%-12s | %-20s | %-25s%n", maphukien, tenphukien, loai);

    } 
}