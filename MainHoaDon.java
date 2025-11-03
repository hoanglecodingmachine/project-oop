import java.util.Arrays;
import java.util.Scanner;

public class MainHoaDon {
    public static Scanner sc = new Scanner(System.in);
    private HoaDon[] hd;
    private int numhd;
    public MainHoaDon(){}
    public MainHoaDon(HoaDon[] hd,int numhd){
        this.hd = hd;
        this.numhd = numhd;
    }
    public HoaDon[] getHoaDon(){
        return hd;
    }
    public void setHoaDon(HoaDon[] hd){
        this.hd = hd;
    }
    public int getSoLuongHoaDon(){
        return numhd;
    }
    public void setSoLuongHoaDon(int numhd){
        this.numhd = numhd;
    }
    public void nhap() {
        System.out.print("Nhập số lượng hóa đơn: ");
        numhd = sc.nextInt();
        sc.nextLine();
        hd = new HoaDon[numhd];
        for (int i = 0; i < numhd; i++) {
            System.out.println("\n=== Nhập hóa đơn thứ " + (i + 1) + " ===");
            hd[i] = new HoaDon();
            hd[i].nhap();
        }
    }
    public void xuat() {
        for (int i = 0; i < numhd; i++) {
            hd[i].xuat();
        }
    }
    public void xoa(String ma){
    boolean found = false;
    for(int i = 0; i < numhd ; i++){
        if(hd[i].getMaHoaDon().equals(ma)){
          found = true;
          for (int j = i; j < numhd - 1; j++) {
                hd[j] = hd[j + 1];
            }
          hd = Arrays.copyOf(hd,numhd - 1);
          numhd--;
          System.out.println("Da xoa hoa don thanh cong ");
          break;
        }
    }
    if(!found){
        System.out.println("khong tim thay hoa don ");
    }
}
public void xoa(){
    System.out.printf("vui long nhap ma hoa don de xoa:");
    String ma = sc.nextLine();
    xoa(ma);
}
public void sua(String ma, int choice) {
    boolean found = false;
    for (int i = 0; i < numhd; i++) {
        if (hd[i].getMaHoaDon().equals(ma)) {
            found = true;
            switch (choice) {
                case 1:
                    System.out.println("vui lonng nhap ma khach hang moi ");
                    hd[i].setMaKhachHang(sc.nextLine());
                    System.out.println("Đã sửa ma khach hang thành công!");
                    break;
                case 2:
                    System.out.println("vui long nhap ma nhan vien moi ");
                    hd[i].setMaNhanVien(sc.nextLine());
                    System.out.println("Đã sửa ma nhan vien thành công!");
                    break;
                case 0:
                    hd[i].nhap();
                    System.out.println("sua tat ca thanh cong ");
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    if (!found) {
        System.out.println("Không tìm thay ma hoa don : " + ma);
    }
}
public void sua(){
    System.out.println("vui long nhap ma hoa don can sua ");
    String ma = sc.nextLine();
    for(int i = 0 ; i < numhd;i++){
        if(hd[i].getMaHoaDon().equals(ma)){
            System.out.println("da tim thay ma hoa don . Vui long nhap lua chon de sua ");
            System.out.println("1 ma khach hanh , 2 ma nhan vien , 0 sua het ");
            int choice = sc.nextInt();
            sc.nextLine();
            sua(ma,choice); 
        }
    }
}
public HoaDon Search_Ma(String ma){
      boolean found = false;
      for(int i = 0 ; i < numhd ; i++){
        if(hd[i].getMaHoaDon().toLowerCase().contains(ma.toLowerCase())){
            found = true;
            System.out.println("da tim thay hoa don can tim ");
            hd[i].xuat();
            return hd[i];
        }
      }
      if(!found){
        System.out.println("khong tim thay chi tiet hoa don ");
      }
      return null;
}
public void Search_Ma(){
      System.out.println("nhap ma hoa don can tim ");
      String ma = sc.nextLine();
      Search_Ma(ma);
}
public HoaDon[] Search_MaKhachHang(String masp){
      boolean found = false;
      HoaDon[] kq = new HoaDon[0];
      int count = 0 ;
      for(int i = 0 ; i < numhd ; i++){
        if(hd[i].getMaKhachHang().toLowerCase().contains(masp.toLowerCase())){
            found = true;
            System.out.println("da tim thay hoa don co ma khach hang can tim ");
            hd[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = hd[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay hoa don co ma khach hang can tim ");
        return null;
      }
      return kq;
}
public void Search_MaKhachHang(){
      System.out.println("nhap ma khach hang can tim trong hoa don ");
      String makh = sc.nextLine();
      Search_MaKhachHang(makh);
}
public HoaDon[] Search_MaNhanVien(String manv){
      boolean found = false;
      HoaDon[] kq = new HoaDon[0];
      int count = 0 ;
      for(int i = 0 ; i < numhd ; i++){
        if(hd[i].getMaNhanVien().equalsIgnoreCase(manv)){
            found = true;
            System.out.println("da tim thay hoa don co ma nhan vien can tim ");
            hd[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = hd[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay nhan vien trong hoa don can tim ");
        return null;
      }
      return kq;
}
public void Search_MaNhanVien(){
      System.out.println("nhap ma nhan vien trong hoa don can tim ");
      String manv = sc.nextLine();
      Search_MaNhanVien(manv);
}

}
