import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
public class DanhSachPhieuNhapHang{
    private static Scanner sc = new Scanner(System.in);
    private PhieuNhapHang[] pnh;
    private int numpnh;
    public DanhSachPhieuNhapHang(){};
    public DanhSachPhieuNhapHang(PhieuNhapHang[] pnh,int numpnh){
           this.pnh = pnh;
           this.numpnh = numpnh;
    }
    public PhieuNhapHang[] getDanhSachPhieuNhapHang(){
        return pnh;
    }
    public void setDanhSachPhieuNhapHang(PhieuNhapHang[] pnh){
        this.pnh = pnh;
    }
    public int getSoLuongDanhSachPhieuNhapHang(){
        return numpnh;
    }
    public void setSoLuongDanhSachPhieuNhapHang(int numpnh){
        this.numpnh = numpnh;
    }
    public void nhap(){
        System.out.println("nhap so luong phieu nhap hang ");
        numpnh = sc.nextInt();
        sc.nextLine();
        pnh = new PhieuNhapHang[numpnh];
        for(int i = 0 ; i < numpnh;i++){
            pnh[i] = new PhieuNhapHang();
            System.out.println("nhap thong tin phieu nhap hang moi ");
            pnh[i].nhap();
        }
    }
    public void xuat(){
        for(int i = 0 ; i < numpnh; i++){
            pnh[i].xuat();
        }
    }
public void DocFile(String tenFile) {
    try {
        int count = 0;
        Scanner scCount = new Scanner(new File(tenFile), "UTF-8");
        while (scCount.hasNextLine()) {
            String line = scCount.nextLine().trim();
            if (!line.isEmpty()) count++;
        }
        scCount.close();

        if (count == 0) {
            System.out.println(" File rong hoac khong co dong hop le!");
            return;
        }

        pnh = new PhieuNhapHang[count];
        numpnh = 0;
        Scanner scFile = new Scanner(new File(tenFile), "UTF-8");
        int lineNumber = 0;

        while (scFile.hasNextLine()) {
            String line = scFile.nextLine().trim();
            lineNumber++;
            if (line.isEmpty()) continue;
            line = line.replace("\uFEFF", "");

            String[] parts = line.split("-");
            if (parts.length != 4) {
                System.out.println(" Du lieu khong hop le o dong " + lineNumber + ": " + line);
                continue;
            }

            try {
                String maPhieuNhapHang = parts[0].trim();
                String maNhaCungCap = parts[1].trim();
                String ngayThang = parts[2].trim();
                double thanhTien = Double.parseDouble(parts[3].trim());

                PhieuNhapHang pnh1 = new PhieuNhapHang(maPhieuNhapHang, maNhaCungCap, ngayThang, thanhTien);
                pnh[numpnh++] = pnh1;
            } catch (NumberFormatException nfe) {
                System.out.println(" Loi dinh dang so (thanhTien) o dong " + lineNumber + ": " + line);
            } catch (Exception ex) {
                System.out.println(" Loi tao doi tuong PhieuNhapHang o dong " + lineNumber + ": " + line);
                ex.printStackTrace();
            }
        }

        scFile.close();
        System.out.println(" Da doc du lieu phieu nhap hang thanh cong! Tong: " + numpnh);

    } catch (java.io.FileNotFoundException fnf) {
        System.out.println(" File khong tim thay: " + tenFile);
        fnf.printStackTrace();
    } catch (Exception e) {
        System.out.println(" Loi doc file '" + tenFile + "': " 
                + (e.getMessage() != null ? e.getMessage() : e.toString()));
        e.printStackTrace();
    }
}

public void Them(PhieuNhapHang pnh1){
        pnh = Arrays.copyOf(pnh,numpnh + 1);
        pnh[numpnh] = pnh1;
        numpnh++;
        System.out.println("Da them phieu nhap hang thanh cong !");
    }
public void Them() {
            PhieuNhapHang pnh1 = new PhieuNhapHang();
            System.out.println("Nhap thong tin phieu nhap hang moi:");
            pnh1.nhap();
            Them(pnh1);
}
    public void xoa(String ma){
    boolean found = false;
    for(int i = 0; i < numpnh ; i++){
        if(pnh[i].getMaPhieuNhapHang().equals(ma)){
          found = true;
          for (int j = i; j < numpnh - 1; j++) {
                pnh[j] = pnh[j + 1];
            }
          pnh = Arrays.copyOf(pnh,numpnh - 1);
          numpnh--;
          System.out.println("Da xoa thong tin phieu nhap hang thanh cong ");
          break;
        }
    }
    if(!found){
        System.out.println("khong tim thay ma phieu nhap hang hoa don ");
    }
}
public void xoa(){
    String ma ;
    System.out.printf("vui long nhap ma phieu nhap hang de xoa:");
    ma = sc.nextLine();
    xoa(ma);
}
public void sua(String ma) {
    boolean found = false;
    for (int i = 0; i < numpnh; i++) {
        if (pnh[i].getMaPhieuNhapHang().equals(ma)) {
            found = true;
            System.out.println("da tim thay ma phieu nhap hang. Vui long nhap lua chon de sua");
            System.out.println("1 ma nha cung cap, 2 ngay thang, 3 thanh tien, 0 sua het");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("vui long nhap ma nha cung cap moi cho phieu nhap hang");
                    pnh[i].setMaNhaCungCap(sc.nextLine());
                    System.out.println("da sua ma nha cung cap phieu nhap hang thanh cong!");
                    break;
                case 2:
                    System.out.println("vui long nhap ngay thang moi cho phieu nhap hang");
                    pnh[i].setNgayThang(sc.nextLine());
                    System.out.println("da sua ngay thang thanh cong!");
                    break;
                case 3:
                    System.out.println("vui long nhap tong tien moi cho phieu nhap hang");
                    pnh[i].setThanhTien(sc.nextDouble());
                    System.out.println("da sua thanh tien thanh cong!");
                    break;
                case 0:
                    pnh[i].nhap();
                    System.out.println("sua tat ca thanh cong");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
    if (!found) {
        System.out.println("Khong tim thay ma phieu nhap hang: " + ma);
    }
}

public void sua(){
    System.out.println("vui long nhap ma phieu nhap hang can sua ");
    String ma = sc.nextLine();
            sua(ma); 
}
public PhieuNhapHang Search_Ma(String ma){
      boolean found = false;
      for(int i = 0 ; i < numpnh ; i++){
        if(pnh[i].getMaPhieuNhapHang().toLowerCase().contains(ma.toLowerCase())){
            found = true;
            System.out.println("da tim thay phieu nhap hang can tim ");
            pnh[i].xuat();
            return pnh[i];
        }
      }
      if(!found){
        System.out.println("khong tim thay phieu nhap hang ");
      }
      return null;
}
public void Search_Ma(){
      System.out.println("nhap ma phieu nhap hang can tim ");
      String ma = sc.nextLine();
      Search_Ma(ma);
}
public PhieuNhapHang[] Search_MaNhaCungCap( String ma){
      boolean found = false;
      PhieuNhapHang[] kq = new PhieuNhapHang[0];
      int count = 0 ;
      for(int i = 0 ; i < numpnh ; i++){
        if(pnh[i].getMaNhaCungCap().toLowerCase().contains(ma.toLowerCase())){
            found = true;
            System.out.println("da tim thay ma phieu nhap hang can tim ");
            pnh[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = pnh[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay ma phieu nhap hang can tim ");
        return null;
      }
      return kq;
}
public void Search_MaNhaCungCap(){
      System.out.println("nhap nha cung cap phieu nhap hang can tim ");
      String ma = sc.nextLine();
      Search_MaNhaCungCap(ma);
}
 public PhieuNhapHang[] Search_NgayThang(LocalDate tuNgay, LocalDate denNgay) {
        boolean found = false;
        PhieuNhapHang[] kq = new PhieuNhapHang[0];
        int count = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 0; i < numpnh; i++) {
            try {
                LocalDate ngayNhap = LocalDate.parse(pnh[i].getNgayThang(), formatter);

                if ((ngayNhap.isEqual(tuNgay) || ngayNhap.isAfter(tuNgay)) &&
                    (ngayNhap.isEqual(denNgay) || ngayNhap.isBefore(denNgay))) {

                    found = true;
                    System.out.println("da tim thay phieu nhap hang trong khoang ngay:");
                    pnh[i].xuat();

                    kq = Arrays.copyOf(kq, count + 1);
                    kq[count] = pnh[i];
                    count++;
                }
            } catch (Exception e) {
                System.out.println(" Loi dinh dang ngay o phieu nhap: " + pnh[i].getMaPhieuNhapHang());
            }
        }

        if (!found) {
            System.out.println(" Khong tim thay phieu nhap hang trong khoang thoi gian nay.");
            return null;
        }
        return kq;
    }

    public void Search_NgayThang() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Nhap ngay bat dau (dd/MM/yyyy): ");
        String startStr = sc.nextLine();

        System.out.print("Nhap ngay ket thuc (dd/MM/yyyy): ");
        String endStr = sc.nextLine();

        
            LocalDate tuNgay = LocalDate.parse(startStr, formatter);
            LocalDate denNgay = LocalDate.parse(endStr, formatter);
            Search_NgayThang(tuNgay, denNgay);
    }


public PhieuNhapHang[] Search_ThanhTien(double e){
      boolean found = false;
      PhieuNhapHang[] kq = new PhieuNhapHang[0];
      int count = 0 ;
      for(int i = 0 ; i < numpnh ; i++){
        if(pnh[i].getThanhTien() == e  ){
            found = true;
            System.out.println("da tim thay Thanh Tien can tim ");
            pnh[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = pnh[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay phieu nhap hang ");
        return null;
      }
      return kq;
}
public void Search_ThanhTien(){
      System.out.println("nhap Thanh Tien phieu nhap hang can tim ");
      double e = sc.nextDouble();
      sc.nextLine();
      Search_ThanhTien(e);
}
public int[] ThongKe_NgayNhap(){
    int duoi1thang = 0, tu1den3thang = 0, tren3thang = 0;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate today = LocalDate.now();

    for (int i = 0; i < numpnh; i++) {
        LocalDate ngayNhap = LocalDate.parse(pnh[i].getNgayThang(), formatter);
        long soNgay = ChronoUnit.DAYS.between(ngayNhap, today);

        if (soNgay <= 30) {
            duoi1thang++;
        } else if (soNgay <= 90) {
            tu1den3thang++;
        } else {
            tren3thang++;
        }
    }

    System.out.printf("%-40s %d\n", "So phieu nhap duoi 1 thang:", duoi1thang);
    System.out.printf("%-40s %d\n", "So phieu nhap tu 1-3 thang:", tu1den3thang);
    System.out.printf("%-40s %d\n", "So phieu nhap tren 3 thang:", tren3thang);

    return new int[]{duoi1thang, tu1den3thang, tren3thang};
}

public double[] ThongKe_ThanhTien() {
    double thanhtienduoi20tr = 0, thanhtienden50tr = 0, thanhtientren50tr = 0;
    for (int i = 0; i < numpnh; i++) {
        double thanhTien = pnh[i].getThanhTien();

        if (thanhTien < 20000000) {
            thanhtienduoi20tr += thanhTien;
        } else if (thanhTien <= 50000000) {
            thanhtienden50tr += thanhTien;
        } else {
            thanhtientren50tr += thanhTien;
        }
    }
    System.out.printf("%-40s %.2f\n", "Tong thanh tien duoi 20 trieu:", thanhtienduoi20tr);
    System.out.printf("%-40s %.2f\n", "Tong thanh tien tu 20-50 trieu:", thanhtienden50tr);
    System.out.printf("%-40s %.2f\n", "Tong thanh tien tren 50 trieu:", thanhtientren50tr); 
    return new double[]{thanhtienduoi20tr, thanhtienden50tr, thanhtientren50tr};
}
public void GhiFile(String tenFile){
    try(PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
        for(int i = 0 ; i < numpnh ; i++){
            String line = "";
            line = String.join("-", pnh[i].getMaPhieuNhapHang(),
                                        pnh[i].getMaNhaCungCap(),
                                        pnh[i].getNgayThang(),
                                        String.valueOf(pnh[i].getThanhTien()));
            pw.println(line);
        }
        System.out.println("da ghi du lieu ra file thanh cong.");
    } catch (Exception e) {
        System.out.println("Loi khi ghi file: " + e.getMessage());
    }
}
}