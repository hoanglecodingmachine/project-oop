import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
public class DanhSachNhanVien {
    private static Scanner sc = new Scanner(System.in);
    private NhanVien[] nv;
    private int numnv;
    public DanhSachNhanVien(){}
    public DanhSachNhanVien(NhanVien[] nv , int numnv){
        this.nv = nv;
        this.numnv = numnv;
    }
    public NhanVien[] getNV() {
        return nv;
    }
    public int getNumNV() {
        return numnv;
    }
    public void setNV(NhanVien[] nv) {
        this.nv = nv;
    }
    public void setNumNV(int numnv) {
        this.numnv = numnv;
    }
    public void nhap(){
        System.out.println("vui long nhap so luong nhan vien cua cua hang ");
        numnv = sc.nextInt();
        sc.nextLine();
        nv = new NhanVien[numnv];
        for(int i = 0 ; i < numnv; i++){
            nv[i] = new NhanVien();
            nv[i].nhap();
        }
    }
    public void xuat(){
        for(int i = 0 ; i < numnv ; i++){
            nv[i].xuat();
        }
    }
    public void DocFile(String tenFile){
        try(Scanner scfile = new Scanner(new File(tenFile))) {
            int i = 0 ;
             while(scfile.hasNextLine()){
                String line = scfile.nextLine().trim();
                if(line.isEmpty()) continue;
                String[] parts = line.split("-");
                if(parts.length == 4){
                    continue;
                }
                String maNV = parts[0];
                String ho = parts[1];
                String ten = parts[2];
                double luong = Double.parseDouble(parts[3]);
                String chucVu = parts[4];
                NhanVien nv1 = null;
                nv1 = new NhanVien(maNV,ho,ten,luong,chucVu);
                nv[i++] = nv1;
             }
                numnv = i;
                System.out.println("Da doc file thanh cong !");
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
    public void Them(NhanVien nv1){
        nv = Arrays.copyOf(nv,numnv + 1);
        nv[numnv] = nv1;
        numnv++;
        System.out.println("Da them nhan vien moi thanh cong !");
    }
    public void Them() {
    System.out.println("Vui long nhap thong tin nhan vien moi :");
    NhanVien nv1 = new NhanVien();
    nv1.nhap();
    Them(nv1);    
}
public void xoa(String ma){
    boolean found = false;
    for(int i = 0; i < numnv ; i++){
        if(nv[i].getMaNhanVien().equals(ma)){
          found = true;
          for (int j = i; j < numnv - 1; j++) {
                nv[j] = nv[j + 1];
            }
          nv = Arrays.copyOf(nv,numnv - 1);
          numnv--;
          System.out.println("Da xoa nhan vien thanh cong ");
          break;
        }
    }
    if(!found){
        System.out.println("khong tim thay nhan vien ");
    }
}
public void xoa(){
    String ma ;
    System.out.printf("vui long nhap ma nhan vien de xoa:");
    ma = sc.nextLine();
    xoa(ma);
}
public void sua(String ma, int choice) {
    boolean found = false;
    for (int i = 0; i < numnv; i++) {
        if (nv[i].getMaNhanVien().equals(ma)) {
            found = true;
            switch (choice) {
                case 1:
                    System.out.println("vui lonng nhap ho moi cua nhan vien ");
                    nv[i].setHo(sc.nextLine());
                    System.out.println("Đã sửa ho thành công!");
                    break;
                case 2:
                    System.out.println("vui long nhap ten moi cho nhan vien ");
                    nv[i].setTen(sc.nextLine());
                    System.out.println("Đã sửa ten thành công!");
                    break;
                case 3:
                    System.out.println("vui long nhap luong moi cua nhan vien ");
                    nv[i].setLuong(sc.nextDouble());
                    System.out.println("Đã sửa luong thành công!");
                    break;
                case 4:
                    System.out.println("vui long nhap chuc vu moi cua nhan vien");
                    nv[i].setChucVu(sc.nextLine());
                    System.out.println("Đã sửa chuc vu thành công!");
                    break;
                case 0:
                    nv[i].nhap();
                    System.out.println("sua tat ca thanh cong ");
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    if (!found) {
        System.out.println("Không tìm thấy nhan vien co mã: " + ma);
    }
}
public void sua(){
    System.out.println("vui long nhap ma nhan vien can sua ");
    String ma = sc.nextLine();
    for(int i = 0 ; i < numnv;i++){
        if(nv[i].getMaNhanVien().equals(ma)){
            System.out.println("da tim thay nhan vien . Vui long nhap lua chon de sua ");
            System.out.println("1 ho, 2 ten, 3 luong,4 chuc vu , 0 sua het ");
            int choice = sc.nextInt();
            sc.nextLine();
            sua(ma,choice); 
        }
    }
}
public NhanVien Search_Ma(String ma){
      boolean found = false;
      for(int i = 0 ; i < numnv ; i++){
        if(nv[i].getMaNhanVien().toLowerCase().contains(ma.toLowerCase())){
            found = true;
            System.out.println("da tim thay nhan vien can tim ");
            nv[i].xuat();
            return nv[i];
        }
      }
      if(!found){
        System.out.println("khong tim thay nhan vien ");
      }
      return null;
}
public void Search_Ma(){
      System.out.println("nhap ma nhan vien can tim ");
      String ma = sc.nextLine();
      Search_Ma(ma);
}
public NhanVien[] Search_Ho(String ho){
      boolean found = false;
      NhanVien[] kq = new NhanVien[0];
      int count = 0 ;
      for(int i = 0 ; i < numnv ; i++){
        if(nv[i].getHo().toLowerCase().contains(ho.toLowerCase())){
            found = true;
            System.out.println("da tim thay nhan vien can tim ");
            nv[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = nv[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay nhan vien ");
        return null;
      }
      return kq;
}
public void Search_Ho(){
      System.out.println("nhap ho nhan vien can tim ");
      String ho = sc.nextLine();
      Search_Ho(ho);
}
public NhanVien[] Search_Ten(String ten){
      boolean found = false;
      NhanVien[] kq = new NhanVien[0];
      int count = 0 ;
      for(int i = 0 ; i < numnv ; i++){
        if(nv[i].getTen().toLowerCase().contains(ten.toLowerCase())){
            found = true;
            System.out.println("da tim thay nhan vien can tim ");
            nv[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = nv[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay nhan vien ");
        return null;
      }
      return kq;
}
public void Search_Ten(){
      System.out.println("nhap ten nhan vien can tim ");
      String ten = sc.nextLine();
      Search_Ten(ten);
}
public NhanVien[] Search_Luong(Double min , Double max){
      boolean found = false;
      NhanVien[] kq = new NhanVien[0];
      int count = 0 ;
      for(int i = 0 ; i < numnv ; i++){
        if(nv[i].getLuong() >= min && nv[i].getLuong() <= max){
            found = true;
            System.out.println("da tim thay nhan vien can tim ");
            nv[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = nv[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay nhan vien ");
        return null;
      }
      return kq;
}
public void Search_Luong(){
      System.out.println("nhap luong nho nhat nhan vien can tim ");
      Double min = sc.nextDouble();
      System.out.println("nhap luong lon nhat nhan vien can tim ");
      Double max = sc.nextDouble();
      sc.nextLine();
      Search_Luong(min , max);
}
public NhanVien[] Search_ChucVu(String cv){
      boolean found = false;
      NhanVien[] kq = new NhanVien[0];
      int count = 0 ;
      for(int i = 0 ; i < numnv ; i++){
        if(nv[i].getChucVu().toLowerCase().contains(cv.toLowerCase())){
            found = true;
            System.out.println("da tim thay nhan vien can tim ");
            nv[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = nv[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay nhan vien ");
        return null;
      }
      return kq;
}
public void Search_ChucVu(){
      System.out.println("nhap chuc vu nhan vien can tim(ban hang,nhan vien truong,quan ly) ");
      String cv = sc.nextLine();
      Search_ChucVu(cv);
}
public int[] ThongKe_Luong(){
     int duoi20tr = 0 , tren20tr = 0 , tren50tr = 0;
     for(int i = 0 ; i < numnv ; i++){
        if(nv[i].getLuong() < 20000000){
            duoi20tr++;
        } else if(nv[i].getLuong() >= 20000000 && nv[i].getLuong() < 50000000){
            tren20tr++;
        } else tren50tr++;
     }
     System.out.printf("%-10s %d%n","so nhan vien co luong duoi 20 trieu la ",duoi20tr);
     System.out.printf("%-10s %d%n","so nhan vien co luong tu 20 - 50 trieu la ",tren20tr);
     System.out.printf("%-10s %d%n","so nhan vien co luong tren 50 trieu la ",tren50tr);
     return new int[]{duoi20tr,tren20tr,tren50tr};
}
public int[] ThongKe_ChucVu(){
     int banhang = 0 , nhanvientruong = 0 , quanly = 0;
     for(int i = 0 ; i < numnv ; i++){
        if(nv[i].getChucVu().toLowerCase().contains(" ban hang")){
            banhang++;
        } else if(nv[i].getChucVu().toLowerCase().contains("nhan vien truong")){
            nhanvientruong++;
        } else quanly++;
     }
     System.out.printf("%-10s %d%n","so nhan vien co chuc ban hang la ",banhang);
     System.out.printf("%-10s %d%n","so nhan vien co chuc nhan vien truong la ",nhanvientruong);
     System.out.printf("%-10s %d%n","so nhan vien co chuc quan ly la ",quanly);
     return new int[]{banhang,nhanvientruong,quanly};
}
public void GhiFile(String tenFile){
    try(PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
        for(int i = 0 ; i < numnv ; i++){
           String line = "";
           line = String.join("-", nv[i].getMaNhanVien(), nv[i].getHo(), nv[i].getTen(), String.valueOf(nv[i].getLuong()), nv[i].getChucVu());
           pw.println(line);
        }
        System.out.println("Da ghi file thanh cong !");
    } catch (Exception e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
}
}