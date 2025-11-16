import java.util.Arrays;
import java.util.Scanner;
import java.io.File;    
import java.io.PrintWriter;
import java.io.FileWriter;
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
public void DocFile(String tenFile) {
    try {
        // ======= BƯỚC 1: ĐẾM SỐ DÒNG =======
        int count = 0;
        Scanner scCount = new Scanner(new File(tenFile));

        while (scCount.hasNextLine()) {
            String line = scCount.nextLine().trim();
            if (!line.isEmpty()) count++;
        }
        scCount.close();

        if (count == 0) {
            System.out.println("⚠️ File rỗng hoặc không có dữ liệu hợp lệ!");
            return;
        }

        // ======= BƯỚC 2: TẠO MẢNG ĐÚNG KÍCH THƯỚC =======
        dscthd = new ChiTietHoaDon[count];
        numcthd = 0;

        // ======= BƯỚC 3: ĐỌC FILE =======
        Scanner scfile = new Scanner(new File(tenFile));

        while (scfile.hasNextLine()) {
            String line = scfile.nextLine().trim();
            if (line.isEmpty()) continue;

            line = line.replace("\uFEFF", ""); // Gỡ BOM

            String[] p = line.split("-");

            if (p.length != 6) {
                System.out.println("⚠️ Dòng lỗi (không đủ 6 trường): " + line);
                continue;
            }

            String mahoadon = p[0].trim();
            String mahoadonchitiet = p[1].trim();
            String masanpham = p[2].trim();
            int soluong = Integer.parseInt(p[3].trim());
            double dongia = Double.parseDouble(p[4].trim());
            double thanhgia = Double.parseDouble(p[5].trim());

            ChiTietHoaDon hdct = new ChiTietHoaDon(
                    mahoadon,
                    mahoadonchitiet,
                    masanpham,
                    soluong,
                    dongia,
                    thanhgia
            );

            dscthd[numcthd++] = hdct;
        }

        scfile.close();

        System.out.println("✅ Đọc file thành công! Tổng chi tiết hóa đơn: " + numcthd);

    } catch (java.io.FileNotFoundException fnf) {
        System.out.println("❌ File không tìm thấy: " + tenFile);
    } catch (Exception e) {
        System.out.println("❌ Lỗi đọc file '" + tenFile + "': " + e.getMessage());
    }
}

public void Them(ChiTietHoaDon hdct1){
        dscthd = Arrays.copyOf(dscthd,numcthd + 1);
        dscthd[numcthd] = hdct1;
        numcthd++;
        System.out.println("Da them hoa don chi tiet thanh cong !");
    }
public void Them() {
            ChiTietHoaDon hdct1 = new ChiTietHoaDon();
            System.out.println("Nhập thông tin hoa don chi tiet moi:");
            hdct1.nhap();
            Them(hdct1);
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
                    System.out.println("vui long nhap ma hoa don moi cho san pham ");
                    dscthd[i].setMaHoaDon(sc.nextLine());
                    System.out.println("Đã sửa ma hoa don thành công!");
                    break;
                case 2:
                    System.out.println("vui lonng nhap ma san pham moi cho san pham ");
                    dscthd[i].setMaSanPham(sc.nextLine());
                    System.out.println("Đã sửa ma san pham thành công!");
                    break;
                case 3:
                    System.out.println("vui long nhap so luong moi cho san pham ");
                    dscthd[i].setSoLuong(sc.nextInt());
                    System.out.println("Đã sửa so luong thành công!");
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
            System.out.println("1 ma hoa don ,2 ma san pham , 3 so luong, 0 sua het ");
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
public ChiTietHoaDon[] Search_MaHoaDon(String mahd){
      boolean found = false;
      ChiTietHoaDon[] kq = new ChiTietHoaDon[0];
      int count = 0 ;
      for(int i = 0 ; i < numcthd ; i++){
        if(dscthd[i].getMaHoaDon().toLowerCase().contains(mahd.toLowerCase())){
            found = true;
            System.out.println("da tim thay ma hoa don can tim ");
            dscthd[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = dscthd[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay ma hoa don can tim ");
        return null;
      }
      return kq;
}
public void Search_MaHoaDon(){
      System.out.println("nhap ma hoa don can tim ");
      String mahd = sc.nextLine();
      Search_MaHoaDon(mahd);
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
public int[] ThongKe_SoLuong(){
      int sl20 = 0 , sl50 = 0 , sl100 = 0 ;
      for(int i = 0 ; i < numcthd ; i++){
        if(dscthd[i].getSoLuong() < 20){
            sl20++;
        }else if(dscthd[i].getSoLuong() >=20 && dscthd[i].getSoLuong() < 50){
            sl50++;
        }else{
            sl100++;
        }
      }
      System.out.println("so luong san pham mua duoi 20 la " + sl20);
        System.out.println("so luong san pham mua tu 20 den 50 la " + sl50);
        System.out.println("so luong san pham mua tren 50 la " + sl100);
        return new int[]{sl20, sl50, sl100};
}
public int[] ThongKe_DonGia(){
      int dg1tr = 0 , dg5tr = 0 , dg10tr = 0 ;
      for(int i = 0 ; i < numcthd ; i++){
        if(dscthd[i].getDonGia() < 1000000){
            dg1tr++;
        }else if(dscthd[i].getDonGia() >=1000000 && dscthd[i].getDonGia() < 5000000){
            dg5tr++;
        }else{
            dg10tr++;
        }
      }
      System.out.println("so luong san pham co don gia duoi 1 trieu la " + dg1tr);
        System.out.println("so luong san pham co don gia tu 1 trieu den 5 trieu la " + dg5tr);
        System.out.println("so luong san pham co don gia tren 5 trieu la " + dg10tr);
        return new int[]{dg1tr, dg5tr, dg10tr}; 
    }
public void GhiFile(String tenFile){
    try(PrintWriter pw = new PrintWriter(new FileWriter(tenFile))){
        for(int i = 0 ; i < numcthd ; i++){
            if(dscthd[i] == null) continue;
            String line = "";
            line = String.join("-", dscthd[i].getMaHoaDon(), dscthd[i].getMaHoaDonChiTiet(), dscthd[i].getMaSanPham(), String.valueOf(dscthd[i].getSoLuong()),String.valueOf(dscthd[i].getDonGia()), String.valueOf(dscthd[i].getThanhGia()));
            pw.println(line);
        }
        System.out.println("Da ghi file thanh cong !");
    } catch (Exception e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
}
}