import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
public class DanhSachNhaCungCap{
    private static Scanner sc = new Scanner(System.in);
    private NhaCungCap[] ncc;
    private int numncc;
    public DanhSachNhaCungCap(){};
    public DanhSachNhaCungCap(NhaCungCap[] ncc,int numncc){
           this.ncc = ncc;
           this.numncc = numncc;
    }
    public NhaCungCap[] getDanhSachNhaCungCap(){
        return ncc;
    }
    public void setDanhSachNhaCungCap(NhaCungCap[] ncc){
        this.ncc = ncc;
    }
    public int getSoLuongDanhSachNhaCungCap(){
        return numncc;
    }
    public void setSoLuongDanhSachNhaCungCap(int numncc){
        this.numncc = numncc;
    }
    public void nhap(){
        System.out.println("nhap so luong nha cung cap ");
        numncc = sc.nextInt();
        sc.nextLine();
        ncc = new NhaCungCap[numncc];
        for(int i = 0 ; i < numncc;i++){
            ncc[i] = new NhaCungCap();
            System.out.println("nhap thong tin nha cung cap moi ");
            ncc[i].nhap();
        }
    }
    public void xuat(){
        for(int i = 0 ; i < numncc; i++){
            ncc[i].xuat();
        }
    }
public void DocFile(String TenFile) {
    try {
        int count = 0;
        Scanner scCount = new Scanner(new File(TenFile), "UTF-8");
        while (scCount.hasNextLine()) {
            String line = scCount.nextLine().trim();
            if (!line.isEmpty()) count++;
        }
        scCount.close();

        if (count == 0) {
            System.out.println("File rong hoac khong co dong hop le!");
            return;
        }

        ncc = new NhaCungCap[count];
        numncc = 0;
        Scanner scFile = new Scanner(new File(TenFile), "UTF-8");

        while (scFile.hasNextLine()) {
            String line = scFile.nextLine().trim();
            if (line.isEmpty()) continue;
            line = line.replace("\uFEFF", "");

            String[] p = line.split("-");
            if (p.length != 4) {  
                System.out.println("Dong khong du 4 truong: " + line);
                continue;
            }

            try {
                String maNhaCungCap = p[0].trim();
                String diaChi = p[1].trim();
                String soDienThoai = p[2].trim();
                String email = p[3].trim();

                NhaCungCap ncc1 = new NhaCungCap(maNhaCungCap, diaChi, soDienThoai, email);
                ncc[numncc++] = ncc1;
            } catch (Exception ex) {
                System.out.println("Loi tao doi tuong NhaCungCap: " + line);
                ex.printStackTrace();
            }
        }

        scFile.close();
        System.out.println("Doc file nha cung cap thanh cong! Tong: " + numncc);

    } catch (java.io.FileNotFoundException fnf) {
        System.out.println("File khong tim thay: " + TenFile);
        fnf.printStackTrace();
    } catch (Exception e) {
        System.out.println("Loi doc file '" + TenFile + "': " 
                + (e.getMessage() != null ? e.getMessage() : e.toString()));
        e.printStackTrace();
    }
}

     public void them(NhaCungCap ncc1){
        ncc = Arrays.copyOf(ncc, numncc + 1);
        ncc[numncc] = ncc1;
        numncc++;
        System.out.println("da them nha cung cap thanh cong ");
      }
      public void them(){
        NhaCungCap ncc1 = new NhaCungCap();
        System.out.println("vui long nhap thong tin cua nha cung cap moi ");
        ncc1.nhap();
        them(ncc1);
      }

    public void xoa(String ma){
    boolean found = false;
    for(int i = 0; i < numncc ; i++){
        if(ncc[i].getMaNhaCungCap().equals(ma)){
          found = true;
          for (int j = i; j < numncc - 1; j++) {
                ncc[j] = ncc[j + 1];
            }
          ncc = Arrays.copyOf(ncc,numncc - 1);
          numncc--;
          System.out.println("Da xoa thong tin nha cung cap thanh cong ");
          break;
        }
    }
    if(!found){
        System.out.println("khong tim thay ma nha cung cap hoa don ");
    }
}
public void xoa(){
    String ma ;
    System.out.printf("vui long nhap ma nha cung cap de xoa:");
    ma = sc.nextLine();
    xoa(ma);
}
public void sua(String ma) {
boolean found = false;
for (int i = 0; i < numncc; i++) {
    if (ncc[i].getMaNhaCungCap().equals(ma)) {
        found = true;            
        System.out.println("Da tim thay ma nha cung cap. Vui long nhap lua chon de sua");
        System.out.println("1 dia chi, 2 so dien thoai, 3 email, 0 sua het");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Vui long nhap dia chi moi cho nha cung cap");
                ncc[i].setDiaChi(sc.nextLine());
                System.out.println("Da sua dia chi nha cung cap thanh cong!");
                break;
            case 2:
                System.out.println("Vui long nhap so dien thoai moi cho nha cung cap");
                ncc[i].setSoDienThoai(sc.nextLine());
                System.out.println("Da sua so dien thoai thanh cong!");
                break;
            case 3:
                System.out.println("Vui long nhap email moi cho nha cung cap");
                ncc[i].setEmail(sc.nextLine());
                System.out.println("Da sua email thanh cong!");
                break;
            case 0:
                ncc[i].nhap();
                System.out.println("Sua tat ca thanh cong");
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
    }
}
if (!found) {
    System.out.println("Khong tim thay ma nha cung cap: " + ma);
}
}
public void sua(){
    System.out.println("vui long nhap ma nha cung cap can sua ");
    String ma = sc.nextLine();
    sua(ma); 
}
public NhaCungCap Search_Ma(String ma){
      boolean found = false;
      for(int i = 0 ; i < numncc ; i++){
        if(ncc[i].getMaNhaCungCap().toLowerCase().contains(ma.toLowerCase())){
            found = true;
            System.out.println("da tim thay nha cung cap can tim ");
            ncc[i].xuat();
            return ncc[i];
        }
      }
      if(!found){
        System.out.println("khong tim thay nha cung cap ");
      }
      return null;
}
public void Search_Ma(){
      System.out.println("nhap ma nha cung cap can tim ");
      String ma = sc.nextLine();
      Search_Ma(ma);
}
public NhaCungCap[] Search_DiaChi(String diachi){
      boolean found = false;
      NhaCungCap[] kq = new NhaCungCap[0];
      int count = 0 ;
      for(int i = 0 ; i < numncc ; i++){
        if(ncc[i].getDiaChi().toLowerCase().contains(diachi.toLowerCase())){
            found = true;
            System.out.println("da tim thay ma nha cung cap can tim ");
            ncc[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = ncc[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay ma nha cung cap can tim ");
        return null;
      }
      return kq;
}
public void Search_DiaChi(){
      System.out.println("nhap dia chi nha cung cap can tim ");
      String diachi = sc.nextLine();
      Search_DiaChi(diachi);
}
public NhaCungCap[] Search_SoDienThoai(String sdt){
      boolean found = false;
      NhaCungCap[] kq = new NhaCungCap[0];
      int count = 0 ;
      for(int i = 0 ; i < numncc ; i++){
        if(ncc[i].getSoDienThoai().equalsIgnoreCase(sdt)){
            found = true;
            System.out.println("da tim thay so dien thoai can tim ");
            ncc[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = ncc[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay so dien thoai can tim ");
        return null;
      }
      return kq;
}
public void Search_SoDienThoai(){
      System.out.println("nhap so dien thoai can tim ");
      String sdt = sc.nextLine();
      Search_SoDienThoai(sdt);
}
public NhaCungCap[] Search_Email(String e){
      boolean found = false;
      NhaCungCap[] kq = new NhaCungCap[0];
      int count = 0 ;
      for(int i = 0 ; i < numncc ; i++){
        if(ncc[i].getEmail().equalsIgnoreCase(e)){
            found = true;
            System.out.println("da tim thay email can tim ");
            ncc[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = ncc[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay nha cung cap ");
        return null;
      }
      return kq;
}
public void Search_Email(){
      System.out.println("nhap email nha cung cap can tim ");
      String e = sc.nextLine();
      Search_Email(e);
}

public int[] ThongKe_DiaChi(){
      int hcm = 0, hn = 0 , nn = 0 ;
      for(int i = 0 ; i < numncc ; i++){
        if(ncc[i].getDiaChi().equalsIgnoreCase("HCM")){
            hcm++;
        }else if(ncc[i].getDiaChi().equalsIgnoreCase("HN")){
            hn++;
        }else if(ncc[i].getDiaChi().equalsIgnoreCase("NN")){
            nn++;
        }
      }
      System.out.println("Thong ke dia chi nha cung cap : ");
      System.out.println("So nha cung cap o HCM : " + hcm);
      System.out.println("So nha cung cap o HN : " + hn);
      System.out.println("So nha cung cap o NN : " + nn);
 return new int[]{hcm,hn,nn};      
}
public void GhiFile(String TenFile){
    try(PrintWriter pw = new PrintWriter(new FileWriter(TenFile))){
        for(int i = 0 ; i < numncc ; i++){
           String line = "";
           line = String.join("-",ncc[i].getMaNhaCungCap(),ncc[i].getDiaChi(),ncc[i].getSoDienThoai(),ncc[i].getEmail());
           pw.println(line);
        }
        System.out.println("Da ghi file thanh cong ");
    }catch(Exception e){
        System.out.println("Loi ghi file " + e.getMessage());
    }
}
}