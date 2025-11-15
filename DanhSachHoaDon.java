import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
public class DanhSachHoaDon {
    public static Scanner sc = new Scanner(System.in);
    private HoaDon[] hd;
    private int numhd;
    public DanhSachHoaDon(){}
    public DanhSachHoaDon(HoaDon[] hd,int numhd){
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
public void DocFile(String tenFile){
    try(Scanner scFile = new Scanner(new File(tenFile))){
        int i = 0;
        while(scFile.hasNextLine()){
            String line = scFile.nextLine().trim();
            if(line.isEmpty()) continue;
            String [] p = line.split("-");
            if(p.length != 5){
                System.out.println("Du lieu trong file khong hop le ");
                continue;
            }
            String mahoadon = p[0];
            String ngaynhap = p[1];
            String makhachhang = p[2];  
            String manhanvien = p[3];
            double tongtien = Double.parseDouble(p[4]);
            HoaDon hd1 = null;
            hd1 = new HoaDon(mahoadon,ngaynhap,makhachhang,manhanvien,tongtien);
            hd[i++] = hd1;
        }
        numhd = i;
        System.out.println("Da doc file thanh cong ! ");
    }
    catch(Exception e){
        System.out.println("Loi doc file : " + e.getMessage());
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
public void Them(HoaDon hd1){
        hd = Arrays.copyOf(hd,numhd + 1);
        hd[numhd] = hd1;
        numhd++;
        System.out.println("Da them hoa don thanh cong !");
    }
public void Them() {
            HoaDon hd1 = new HoaDon();
            System.out.println("Nhập thông tin hoa don moi:");
            hd1.nhap();
            Them(hd1);
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
public HoaDon[] Search_NgayThang(LocalDate tuNgay, LocalDate denNgay) {
        boolean found = false;
        HoaDon[] kq = new HoaDon[0];
        int count = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 0; i < numhd; i++) {
            try {
                LocalDate ngayNhap = LocalDate.parse(hd[i].getNgayNhap(), formatter);

                if ((ngayNhap.isEqual(tuNgay) || ngayNhap.isAfter(tuNgay)) &&
                    (ngayNhap.isEqual(denNgay) || ngayNhap.isBefore(denNgay))) {

                    found = true;
                    System.out.println("Đã tìm thấy hoa don trong khoảng ngày:");
                    hd[i].xuat();

                    kq = Arrays.copyOf(kq, count + 1);
                    kq[count] = hd[i];
                    count++;
                }
            } catch (Exception e) {
                System.out.println(" Lỗi định dạng ngày ở phiếu nhập: " );
            }
        }

        if (!found) {
            System.out.println(" Không tìm thấy hoa don trong khoảng thời gian này.");
            return null;
        }
        return kq;
    }

    public void Search_NgayThang() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Nhập ngày bắt đầu (dd/MM/yyyy): ");
        String startStr = sc.nextLine();

        System.out.print("Nhập ngày kết thúc (dd/MM/yyyy): ");
        String endStr = sc.nextLine();

        try {
            LocalDate tuNgay = LocalDate.parse(startStr, formatter);
            LocalDate denNgay = LocalDate.parse(endStr, formatter);

            Search_NgayThang(tuNgay, denNgay);
        } catch (Exception e) {
            System.out.println(" Định dạng ngày không hợp lệ. Vui lòng nhập theo dạng dd/MM/yyyy.");
        }
    }


public int[] ThongKe_NgayLap() {
    int duoi1thang = 0, tu1den3thang = 0, tren3thang = 0;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate today = LocalDate.now();

    for (int i = 0; i < numhd; i++) {
        try {
            LocalDate ngayLap = LocalDate.parse(hd[i].getNgayNhap(), formatter);
            long soNgay = ChronoUnit.DAYS.between(ngayLap, today);

            if (soNgay <= 30) {
                duoi1thang++;
            } else if (soNgay <= 90) {
                tu1den3thang++;
            } else {
                tren3thang++;
            }
        } catch (Exception e) {
            System.out.println("Lỗi định dạng ngày ở hóa đơn: " + hd[i].getMaHoaDon());
        }
    }

    System.out.printf("%-40s %d\n", "Số hóa đơn dưới 1 tháng:", duoi1thang);
    System.out.printf("%-40s %d\n", "Số hóa đơn từ 1–3 tháng:", tu1den3thang);
    System.out.printf("%-40s %d\n", "Số hóa đơn trên 3 tháng:", tren3thang);

    return new int[]{duoi1thang, tu1den3thang, tren3thang};
}
public double[] ThongKe_TongTien() {
    double duoi1trieu = 0, tu1den5trieu = 0, tren5trieu = 0;

    for (int i = 0; i < numhd; i++) {
        double tongTien = hd[i].getTongTien();

        if (tongTien < 1_000_000) {
            duoi1trieu++;
        } else if (tongTien <= 5_000_000) {
            tu1den5trieu++;
        } else {
            tren5trieu++;
        }
    }

    System.out.printf("%-40s %.0f\n", "Số hóa đơn dưới 1 triệu:", duoi1trieu);
    System.out.printf("%-40s %.0f\n", "Số hóa đơn từ 1–5 triệu:", tu1den5trieu);
    System.out.printf("%-40s %.0f\n", "Số hóa đơn trên 5 triệu:", tren5trieu);

    return new double[]{duoi1trieu, tu1den5trieu, tren5trieu};
}
public void GhiFile(String tenFile){
    try(PrintWriter pw = new PrintWriter(new FileWriter(tenFile))){
        for(int i = 0 ; i < numhd ; i++){
            String line = "";
            line = String.join("-",hd[i].getMaHoaDon(),hd[i].getNgayNhap(),hd[i].getMaKhachHang(),hd[i].getMaNhanVien(),String.valueOf(hd[i].getTongTien()));
            pw.println(line);
        }
        System.out.println("Da ghi file thanh cong ! ");
    }
    catch(Exception e){
        System.out.println("Loi ghi file : " + e.getMessage());
    }
}
}
