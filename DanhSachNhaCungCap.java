import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
    public void DocFile(String TenFile){
        try(Scanner scFile = new Scanner(new File(TenFile))){
            int i = 0 ;
            while(scFile.hasNextLine()){
                String line = scFile.nextLine().trim();
                if(!line.isEmpty()) continue;
                String []p = line.split("-");
                if(p.length != 5){
                   continue;
                }
                String maNhaCungCap = p[0];
                String diaChi = p[1];
                String soDienThoai = p[2];
                String email = p[3];
                String thoiGianHopTac = p[4];
                NhaCungCap ncc1 = null;
                ncc1 = new NhaCungCap(maNhaCungCap,diaChi,soDienThoai,email,thoiGianHopTac);
                ncc[i++] = ncc1;
            }
            numncc = i;
            System.out.println("Da doc file thanh cong ");
    }catch(Exception e){
        System.out.println("Loi doc file " + e.getMessage());
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
public void sua(String ma, int choice) {
    boolean found = false;
    for (int i = 0; i < numncc; i++) {
        if (ncc[i].getMaNhaCungCap().equals(ma)) {
            found = true;
            switch (choice) {
                case 1:
                    System.out.println("vui lonng nhap dia chi{HCM,HN,NN} moi cho nha cung cap ");
                    ncc[i].setDiaChi(sc.nextLine());
                    System.out.println("Đã sửa dia chi nha cung cap thành công!");
                    break;
                case 2:
                    System.out.println("vui long nhap so dien thoai moi cho nha cung cap ");
                    ncc[i].setSoDienThoai(sc.nextLine());
                    System.out.println("Đã sửa so dien thoai thành công!");
                    break;
                case 3:
                    System.out.println("vui long nhap email moi cho nha cung cap ");
                    ncc[i].setEmail(sc.nextLine());
                    System.out.println("Đã sua email thành công!");
                    break;
                case 4:
                    System.out.println("vui long nhap thoi gian hop tac moi cho nha cung cap ");
                    ncc[i].setThoiGianHopTac(sc.nextLine());
                    System.out.println("Đã sua thoi gian hop tac thanh cong!");
                    break;
                case 0:
                    ncc[i].nhap();
                    System.out.println("sua tat ca thanh cong ");
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    if (!found) {
        System.out.println("Không tìm thay ma nha cung cap : " + ma);
    }
}
public void sua(){
    System.out.println("vui long nhap ma nha cung cap can sua ");
    String ma = sc.nextLine();
    for(int i = 0 ; i < numncc;i++){
        if(ncc[i].getMaNhaCungCap().equals(ma)){
            System.out.println("da tim thay ma nha cung cap . Vui long nhap lua chon de sua ");
            System.out.println("1 dia chi  , 2 so dien thoai, 3 email, 4 thoi gian hop tac, 0 sua het ");
            int choice = sc.nextInt();
            sc.nextLine();
            sua(ma,choice); 
        }
    }
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
public NhaCungCap[] Search_ThoiGianHopTac(String date){
      boolean found = false;
      NhaCungCap[] kq = new NhaCungCap[0];
      int count = 0 ;
      for(int i = 0 ; i < numncc ; i++){
        if(ncc[i].getThoiGianHopTac().equalsIgnoreCase(date)){
            found = true;
            System.out.println("da tim thay thoi gian hop tac can tim ");
            ncc[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = ncc[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay thoi gian hop tac can tim ");
        return null;
      }
      return kq;
}
public void Search_ThoiGianHopTac(){
      System.out.println("nhap thoi gian hop tac can tim (dd/mm/yyyy) ");
      String date = sc.nextLine();
      Search_ThoiGianHopTac(date);
}
public int[] ThongKe_ThoiGianHopTac(){
      int count = 0 ;
      LocalDate today = LocalDate.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      for(int i = 0 ; i < numncc ; i++){
        LocalDate hopTacDate = LocalDate.parse(ncc[i].getThoiGianHopTac(), formatter);
        long yearsBetween = ChronoUnit.YEARS.between(hopTacDate, today);
        if(yearsBetween >= 1){
            count++;
        }
      }
      System.out.println("So nha cung cap hop tac tren 1 nam : " + count);
      System.out.println("So nha cung cap hop tac duoi 1 nam : " + (numncc - count));
      return new int[]{count,numncc - count};
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
           line = String.join("-",ncc[i].getMaNhaCungCap(),ncc[i].getDiaChi(),ncc[i].getSoDienThoai(),ncc[i].getEmail(),ncc[i].getThoiGianHopTac());
           pw.println(line);
        }
        System.out.println("Da ghi file thanh cong ");
    }catch(Exception e){
        System.out.println("Loi ghi file " + e.getMessage());
    }
}
}