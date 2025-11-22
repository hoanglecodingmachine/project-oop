import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
public class DanhSachChiTietNhapHang{
    private static Scanner sc = new Scanner(System.in);
    private ChiTietPhieuNhapHang[] dsctpnh;
    private int numctpnh;
    public DanhSachChiTietNhapHang(){};
    public DanhSachChiTietNhapHang(ChiTietPhieuNhapHang[] dsctpnh,int numctpnh){
           this.dsctpnh = dsctpnh;
           this.numctpnh = numctpnh;
    }
    public ChiTietPhieuNhapHang[] getChiTietPhieuNhapHang(){
        return dsctpnh;
    }
    public void setChiTietPhieuNhapHang(ChiTietPhieuNhapHang[] dsctpnh){
        this.dsctpnh = dsctpnh;
    }
    public int getSoLuongChiTietPhieuNhapHang(){
        return numctpnh;
    }
    public void setSoLuongChiTietPhieuNhapHang(int numctpnh){
        this.numctpnh = numctpnh;
    }
    public void nhap(){
        System.out.println("nhap so luong hoa don chi tiet ");
        numctpnh = sc.nextInt();
        sc.nextLine();
        ChiTietPhieuNhapHang[] dsctpnh = new ChiTietPhieuNhapHang[numctpnh];
        for(int i = 0 ; i < numctpnh;i++){
            dsctpnh[i] = new ChiTietPhieuNhapHang();
            System.out.println("nhap thong tin hoa don moi ");
            dsctpnh[i].nhap();
        }
    }
    public void xuat(){
        for(int i = 0 ; i < numctpnh; i++){
            dsctpnh[i].xuat();
        }
    }
public void DocFile(String tenFile) {
    try {
        int count = 0;
        Scanner scCount = new Scanner(new File(tenFile));

        while (scCount.hasNextLine()) {
            String line = scCount.nextLine().trim();
            if (!line.isEmpty()) count++;
        }
        scCount.close();

        if (count == 0) {
            System.out.println("File rong hoac khong co dong hop le!");
            return;
        }

        dsctpnh = new ChiTietPhieuNhapHang[count];
        numctpnh = 0;

        Scanner scFile = new Scanner(new File(tenFile));

        while (scFile.hasNextLine()) {
            String line = scFile.nextLine().trim();
            if (line.isEmpty()) continue;

            // Go BOM neu co
            line = line.replace("\uFEFF", "");

            String[] p = line.split("-");

            if (p.length != 6) {
                System.out.println("Dong sai dinh dang (khong du 6 truong): " + line);
                continue;
            }

            String mapnh = p[0].trim();
            String machitietpnh = p[1].trim();
            String masp = p[2].trim();
            int soluong = Integer.parseInt(p[3].trim());
            double dongia = Double.parseDouble(p[4].trim());
            double tongtien = Double.parseDouble(p[5].trim());

            ChiTietPhieuNhapHang ctpnh = new ChiTietPhieuNhapHang(
                    mapnh,
                    machitietpnh,
                    masp,
                    soluong,
                    dongia,
                    tongtien
            );

            dsctpnh[numctpnh++] = ctpnh;
        }

        scFile.close();
        System.out.println("Doc file chi tiet phieu nhap thanh cong! Tong: " + numctpnh);

    } catch (java.io.FileNotFoundException fnf) {
        System.out.println("File khong tim thay: " + tenFile);
    } catch (Exception e) {
        System.out.println("Loi doc file '" + tenFile + "': " + e.getMessage());
    }
}

public void Them(ChiTietPhieuNhapHang ctpnh1){
        dsctpnh = Arrays.copyOf(dsctpnh,numctpnh + 1);
        dsctpnh[numctpnh] = ctpnh1;
        numctpnh++;
        System.out.println("Da them chi tiet phieu nhap hang thanh cong !");
    }
public void Them() {
            ChiTietPhieuNhapHang ctpnh1 = new ChiTietPhieuNhapHang();
            System.out.println("Nhap thong tin chi tiet phieu nhap hang moi:");
            ctpnh1.nhap();
            Them(ctpnh1);
}

    public void xoa(String ma){
    boolean found = false;
    for(int i = 0; i < numctpnh ; i++){
        if(dsctpnh[i].getMaPhieuNhapHangChiTiet().equals(ma)){
          found = true;
          for (int j = i; j < numctpnh - 1; j++) {
                dsctpnh[j] = dsctpnh[j + 1];
            }
          dsctpnh = Arrays.copyOf(dsctpnh,numctpnh - 1);
          numctpnh--;
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
public void sua(String ma) {
    boolean found = false;
    for (int i = 0; i < numctpnh; i++) {
        if (dsctpnh[i].getMaPhieuNhapHangChiTiet().equals(ma)) {
            found = true;
            System.out.println("Da tim thay chi tiet phieu nhap hang. Vui long nhap lua chon de sua");
            System.out.println("1 ma phieu nhap hang, 2 ma san pham, 3 so luong, 4 don gia, 0 sua het");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Vui long nhap ma phieu nhap hang moi cho phieu nhap hang chi tiet");
                    dsctpnh[i].setMaPhieuNhapHang(sc.nextLine());
                    System.out.println("Da sua ma phieu nhap hang thanh cong!");
                    break;

                case 2:
                    System.out.println("Vui long nhap ma san pham moi");
                    dsctpnh[i].setMaSanPham(sc.nextLine());
                    System.out.println("Da sua ma san pham thanh cong!");
                    break;

                case 3:
                    System.out.println("Vui long nhap so luong moi");
                    dsctpnh[i].setSoLuong(sc.nextInt());
                    System.out.println("Da sua so luong thanh cong!");
                    break;

                case 4:
                    System.out.println("Vui long nhap don gia moi");
                    dsctpnh[i].setDonGia(sc.nextDouble());
                    System.out.println("Da sua don gia thanh cong!");
                    break;

                case 0:
                    dsctpnh[i].nhap();
                    System.out.println("Sua tat ca thanh cong!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }
    }

    if (!found) {
        System.out.println("Khong tim thay chi tiet phieu nhap hang: " + ma);
    }
}

public void sua(){
    System.out.println("vui long nhap ma chi tiet hoa don can sua ");
    String ma = sc.nextLine();   
    sua(ma); 
}
public ChiTietPhieuNhapHang Search_Ma(String ma){
      boolean found = false;
      for(int i = 0 ; i < numctpnh ; i++){
        if(dsctpnh[i].getMaPhieuNhapHangChiTiet().toLowerCase().contains(ma.toLowerCase())){
            found = true;
            System.out.println("da tim thay chi tiet hoa don can tim ");
            dsctpnh[i].xuat();
            return dsctpnh[i];
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
public ChiTietPhieuNhapHang[] Search_MaPhieuNhapHang(String mapnh){
      boolean found = false;
      ChiTietPhieuNhapHang[] kq = new ChiTietPhieuNhapHang[0];
      int count = 0 ;
      for(int i = 0 ; i < numctpnh ; i++){
        if(dsctpnh[i].getMaPhieuNhapHang().toLowerCase().contains(mapnh.toLowerCase())){
            found = true;
            System.out.println("da tim thay ma phieu nhap hang can tim ");
            dsctpnh[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = dsctpnh[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay ma phieu nhap hang can tim ");
        return null;
      }
      return kq;
}
public void Search_MaPhieuNhapHang(){
      System.out.println("nhap ma phieu nhap hang can tim ");
      String mapnh = sc.nextLine();
      Search_MaPhieuNhapHang(mapnh);
}
public ChiTietPhieuNhapHang[] Search_MaSanPham(String masp){
      boolean found = false;
      ChiTietPhieuNhapHang[] kq = new ChiTietPhieuNhapHang[0];
      int count = 0 ;
      for(int i = 0 ; i < numctpnh ; i++){
        if(dsctpnh[i].getMaSanPham().toLowerCase().contains(masp.toLowerCase())){
            found = true;
            System.out.println("da tim thay ma san pham can tim ");
            dsctpnh[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = dsctpnh[i];
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
public ChiTietPhieuNhapHang[] Search_SoLuong(int soluong){
      boolean found = false;
      ChiTietPhieuNhapHang[] kq = new ChiTietPhieuNhapHang[0];
      int count = 0 ;
      for(int i = 0 ; i < numctpnh ; i++){
        if(dsctpnh[i].getSoLuong() == soluong){
            found = true;
            System.out.println("da tim thay so luong can tim ");
            dsctpnh[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = dsctpnh[i];
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
      sc.nextLine();
      Search_SoLuong(soluong);
}
public ChiTietPhieuNhapHang[] Search_DonGia(double dongia){
      boolean found = false;
      ChiTietPhieuNhapHang[] kq = new ChiTietPhieuNhapHang[0];
      int count = 0 ;
      for(int i = 0 ; i < numctpnh ; i++){
        if(dsctpnh[i].getTongTien() == dongia){
            found = true;
            System.out.println("da tim thay don gia can tim ");
            dsctpnh[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = dsctpnh[i];
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
public int[] ThongKe_DonGia(){
    int tren10tr = 0 , tu5den10tr = 0 , duoi5tr = 0 ;
    for(int i = 0 ; i < numctpnh ; i++){
        if(dsctpnh[i].getDonGia() > 10000000){
            tren10tr++;
        }else if(dsctpnh[i].getDonGia() >= 5000000 && dsctpnh[i].getDonGia() <= 10000000){
            tu5den10tr++;
        }else{
            duoi5tr++;
        }
    }
    System.out.println("So luong chi tiet phieu nhap hang co don gia tren 10 trieu: " + tren10tr);
    System.out.println("So luong chi tiet phieu nhap hang co don gia tu 5 den 10 trieu: " + tu5den10tr);
    System.out.println("So luong chi tiet phieu nhap hang co don gia duoi 5 trieu: " + duoi5tr);
    return new int[]{tren10tr, tu5den10tr, duoi5tr};
}
public int[] ThongKe_SoLuong(){
    int tren100 = 0 , tu50den100 = 0 , duoi50 = 0 ;
    for(int i = 0 ; i < numctpnh ; i++){
        if(dsctpnh[i].getSoLuong() > 100){
            tren100++;
        }else if(dsctpnh[i].getSoLuong() >= 50 && dsctpnh[i].getSoLuong() <= 100){
            tu50den100++;
        }else{
            duoi50++;
        }
    }
    System.out.println("So luong chi tiet phieu nhap hang co so luong tren 100: " + tren100);
    System.out.println("So luong chi tiet phieu nhap hang co so luong tu 50 den 100: " + tu50den100);
    System.out.println("So luong chi tiet phieu nhap hang co so luong duoi 50: " + duoi50);
    return new int[]{tren100, tu50den100, duoi50};
}
public void GhiFile(String tenFile){
    try(PrintWriter pw = new PrintWriter(new FileWriter(tenFile))){
        for(int i = 0 ; i < numctpnh ; i++){
            String line = "";
            line = String.join("-",dsctpnh[i].getMaPhieuNhapHang(),dsctpnh[i].getMaPhieuNhapHangChiTiet(),dsctpnh[i].getMaSanPham(),String.valueOf(dsctpnh[i].getSoLuong()),String.valueOf(dsctpnh[i].getDonGia()),String.valueOf(dsctpnh[i].getTongTien())); 
            pw.println(line);
        }
        System.out.println("Da ghi file chi tiet phieu nhap hang thanh cong !");
    } catch(Exception e){
        System.out.println("Loi ghi file: " + e.getMessage());
}
}
}