import java.util.Arrays;
import java.util.Scanner;
public class DanhSachChiTietHoaDon{
    private static Scanner sc = new Scanner(System.in);
    private ChiTietHoaDon[] dscthd;
    private int numcthd;
    public DanhSachChiTietHoaDon(){};
    public DanhSachChiTietHoaDon(ChiTietHoaDon[] dscthd,int numcthd){
           this.dscthd = dscthd;
           this.numcthd = numcthd;
    }
    public ChiTietHoaDon[] getChiTietHoaDon(){
        return dscthd;
    }
    public void setChiTietHoaDon(ChiTietHoaDon[] dscthd){
        this.dscthd = dscthd;
    }
    public int getSoLuongChiTietHoaDon(){
        return numcthd;
    }
    public void setSoLuongChiTietHoaDon(int numcthd){
        this.numcthd = numcthd;
    }
    public void nhap(){
        System.out.println("nhap so luong hoa don chi tiet ");
        numcthd = sc.nextInt();
        ChiTietHoaDon[] dscthd = new ChiTietHoaDon[numcthd];
        for(int i = 0 ; i < numcthd;i++){
            dscthd[i] = new ChiTietHoaDon();
            System.out.println("nhap thong tin hoa don moi ");
            dscthd[i].nhap();
        }
    }
    public void xuat(){
        for(int i = 0 ; i < numcthd; i++){
            dscthd[i].xuat();
        }
    }
public double TongThanhGiaCuaHoaDon() {
    double tong = 0;
    for (int i = 0; i < numcthd; i++) {
        tong += dscthd[i].getThanhGia();
    }
    return tong;
}

    public void xoa(String ma){
    boolean found = false;
    for(int i = 0; i < numcthd ; i++){
        if(dscthd[i].getMaHoaDonChiTiet().equals(ma)){
          found = true;
          for (int j = i; j < numcthd - 1; j++) {
                dscthd[j] = dscthd[j + 1];
            }
          dscthd = Arrays.copyOf(dscthd,numcthd - 1);
          numcthd--;
          System.out.println("Da xoa chi tiet hoa don thanh cong ");
          break;
        }
    }
    if(!found){
        System.out.println("khong tim thay chi tiet hoa don ");
    }
}
public void xoa(){
    String ma ;
    System.out.printf("vui long nhap ma chi tiet hoa don de xoa:");
    ma = sc.nextLine();
    xoa(ma);
}
public void sua(String ma, int choice) {
    boolean found = false;
    for (int i = 0; i < numcthd; i++) {
        if (dscthd[i].getMaHoaDonChiTiet().equals(ma)) {
            found = true;
            switch (choice) {
                case 1:
                    System.out.println("vui lonng nhap ma san pham moi cho san pham ");
                    dscthd[i].setMaSanPham(sc.nextLine());
                    System.out.println("Đã sửa ma san pham thành công!");
                    break;
                case 2:
                    System.out.println("vui long nhap so luong moi cho san pham ");
                    dscthd[i].setSoLuong(sc.nextInt());
                    System.out.println("Đã sửa so luong thành công!");
                    break;
                case 3:
                    System.out.println("vui long nhap luong don gia moi cua san pham ");
                    dscthd[i].setDonGia(sc.nextDouble());
                    System.out.println("Đã sửa don gia thành công!");
                    break;
                case 0:
                    dscthd[i].nhap();
                    System.out.println("sua tat ca thanh cong ");
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    if (!found) {
        System.out.println("Không tìm thay chi tiet hoa don : " + ma);
    }
}
public void sua(){
    System.out.println("vui long nhap ma chi tiet hoa don can sua ");
    String ma = sc.nextLine();
    for(int i = 0 ; i < numcthd;i++){
        if(dscthd[i].getMaHoaDonChiTiet().equals(ma)){
            System.out.println("da tim thay chi tiet hoa don . Vui long nhap lua chon de sua ");
            System.out.println("1 ma san pham , 2 so luong, 3 don gia, 0 sua het ");
            int choice = sc.nextInt();
            sc.nextLine();
            sua(ma,choice); 
        }
    }
}
public ChiTietHoaDon Search_Ma(String ma){
      boolean found = false;
      for(int i = 0 ; i < numcthd ; i++){
        if(dscthd[i].getMaHoaDonChiTiet().toLowerCase().contains(ma.toLowerCase())){
            found = true;
            System.out.println("da tim thay chi tiet hoa don can tim ");
            dscthd[i].xuat();
            return dscthd[i];
        }
      }
      if(!found){
        System.out.println("khong tim thay chi tiet hoa don ");
      }
      return null;
}
public void Search_Ma(){
      System.out.println("nhap ma chi tiet hoa don can tim ");
      String ma = sc.nextLine();
      Search_Ma(ma);
}
public ChiTietHoaDon[] Search_MaSanPham(String masp){
      boolean found = false;
      ChiTietHoaDon[] kq = new ChiTietHoaDon[0];
      int count = 0 ;
      for(int i = 0 ; i < numcthd ; i++){
        if(dscthd[i].getMaSanPham().toLowerCase().contains(masp.toLowerCase())){
            found = true;
            System.out.println("da tim thay ma san pham can tim ");
            dscthd[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = dscthd[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay ma san pham can tim ");
        return null;
      }
      return kq;
}
public void Search_MaSanPham(){
      System.out.println("nhap ma san pham can tim ");
      String masp = sc.nextLine();
      Search_MaSanPham(masp);
}
public ChiTietHoaDon[] Search_SoLuong(int soluong){
      boolean found = false;
      ChiTietHoaDon[] kq = new ChiTietHoaDon[0];
      int count = 0 ;
      for(int i = 0 ; i < numcthd ; i++){
        if(dscthd[i].getSoLuong() == soluong){
            found = true;
            System.out.println("da tim thay so luong can tim ");
            dscthd[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = dscthd[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay so luong can tim ");
        return null;
      }
      return kq;
}
public void Search_SoLuong(){
      System.out.println("nhap so luong can tim ");
      int soluong = sc.nextInt();
      Search_SoLuong(soluong);
}
public ChiTietHoaDon[] Search_DonGia(double dongia){
      boolean found = false;
      ChiTietHoaDon[] kq = new ChiTietHoaDon[0];
      int count = 0 ;
      for(int i = 0 ; i < numcthd ; i++){
        if(dscthd[i].getDonGia() == dongia){
            found = true;
            System.out.println("da tim thay don gia can tim ");
            dscthd[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = dscthd[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay nhan vien ");
        return null;
      }
      return kq;
}
public void Search_DonGia(){
      System.out.println("nhap don gia san pham can tim can tim ");
      Double dongia = sc.nextDouble();
      sc.nextLine();
      Search_DonGia(dongia);
}
}