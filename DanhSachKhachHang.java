import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
public class DanhSachKhachHang {
      private static Scanner sc = new Scanner(System.in);
      private KhachHang[] kh;
      private int numkh;
      public DanhSachKhachHang(){};
      public DanhSachKhachHang(KhachHang[] kh,int numkh){
        this.kh = kh;
        this.numkh = numkh;
      }
public KhachHang[] getKhachHang(){
        return kh;
      }
public int getNumKhachHang(){
            return numkh;
        }
public void setKhachHang(KhachHang[] kh){
        this.kh = kh;
      }
public void setNumKhachHang(int numkh){
        this.numkh = numkh;
      }
      public void nhap(){
        System.out.println("vui long nhap danh sach khach hang ");
        numkh = sc.nextInt();
        sc.nextLine();
        kh = new KhachHang[numkh];
        for(int i = 0 ; i < numkh; i++){
            kh[i] = new KhachHang();
            kh[i].nhap();
        }
      }
      public void xuat(){
        for(int i = 0 ; i < numkh ;i++){
            kh[i].xuat();
        }
      }
public void DocFile(String tenFile) {
        try (Scanner scFile = new Scanner(new File(tenFile))){
        int i = 0;
        while (scFile.hasNextLine()) {
            String line = scFile.nextLine().trim();
            if(line.isEmpty()) continue;
            String[] p = line.split("-");
            if(p.length != 7) continue;
            KhachHang kh1 = null;
            String makhachhang = p[0];
            String hokhachhang = p[1];
            String tenkhachhang = p[2];
            String email = p[3];
            String sodienthoai = p[4];
            String gioitinh = p[5];
            String ngaysinh = p[6];
            kh1 = new KhachHang(makhachhang,hokhachhang,tenkhachhang,email,sodienthoai,gioitinh,ngaysinh);
            kh[i++] = kh1;
        }
        numkh = i;
        System.out.println("Da doc file thanh cong !");
    }catch(Exception e) {
        System.out.println("Loi doc file: " + e.getMessage());
    }
}
      public void them(KhachHang kh1){
        kh = Arrays.copyOf(kh, numkh + 1);
        kh[numkh] = kh1;
        numkh++;
        System.out.println("da them khach hang thanh cong ");
      }
      
      public void them(){
        KhachHang kh1 = new KhachHang();
        System.out.println("vui long nhap thong tin cua khach hang moi ");
        kh1.nhap();
        them(kh1);
      }
      public void xoa(String ma){
        boolean found = false;
        for(int i = 0 ; i < numkh; i++){
            if(kh[i].getMaKhachHang().toLowerCase().contains(ma)){
                found = true;
                for(int j = i; j < numkh - 1 ; j++){
                    kh[j] = kh[j + 1];
                    kh = Arrays.copyOf(kh, numkh - 1);
                    numkh--;
                    break;
                }
            }
        }
        if(found){
             System.out.println("da xoa thong tin khach hang thanh cong ");
        }else{
            System.out.println("khong tim thay thong tin khach hang ");
        }
      }
      public void xoa(){
        System.out.println("nhap ma khach hang can tim ");
        String ma = sc.nextLine();
        xoa(ma);
      }
      public void sua(String ma ,int choice){
        boolean found = false;   
        for(int i = 0 ; i < numkh;i++){
            if(kh[i].getMaKhachHang().toLowerCase().contains(ma.toLowerCase())){
                found = true;
                switch (choice) {
                    case 1:
                        System.out.println("da sua thanh cong ho khach hang ");
                        kh[i].setHoKhachHang(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("da sua thanh cong ten khach hang ");
                        kh[i].setTenKhachHang(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("da sua thanh cong dia chi email cua khach hang ");
                        kh[i].setEmail(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("da sua thanh cong so dien thoai cua khach hang ");
                        kh[i].setSoDienThoai(sc.nextLine());
                        break;
                    case 5:
                        System.out.println("da sua thanh cong gioi tinh cua khach hang ");
                        kh[i].setGioiTinh(sc.nextLine());
                        break;
                    case 6:
                        System.out.println("da sua thanh cong ngay sinh cua khach hang ");
                        kh[i].setNgaySinh(sc.nextLine());
                        break;
                    case 7:
                        kh[i].nhap();
                        System.out.println("da sua het thong tin khach hang ");
                        break;
                    case 0:
                        System.out.println("da thoat che do sua ");
                        break;
                    default:
                        System.out.println("lua chon khong hop le , vui long nhap lai ");
                        break;
                }
                break;
            }
           }
           if(!found){
            System.out.println("khong tim thay ma khach hang de sua ");
           }
      }
      public void sua(){
        System.out.println("vui long nhap ma khach hang de sua ");
        String ma = sc.nextLine();
        System.out.println("Vui long nhap lua chon sua cua ban (1 ho,2 ten,3 email,4 so dien thoai , 5 gioi tinh,6 ngay sinh , 7 sua het , 0 thoat ) ");
        int choice = sc.nextInt();
        sc.nextLine();
        sua(ma,choice);
    }
    public KhachHang Search_MaKhachHang(String ma){
        boolean found = false;
        for(int i = 0 ; i < numkh ; i++){
            if(kh[i].getMaKhachHang().equalsIgnoreCase(ma)){
                found = true;
                System.out.println("Da tim thay ma khach hanh ");
                kh[i].xuat();
                return kh[i];
            }
        }
        if(!found){
            System.out.println("khong tim thay ma khach hang ");
        }
        return null;
    }
    public void Search_MaKhachHang(){
        boolean found = false;
        System.out.println("vui long nhap ma khach hang can tim ");
        String ma = sc.nextLine();
        for(int i = 0 ; i < numkh; i ++){
            if(kh[i].getMaKhachHang().equalsIgnoreCase(ma)){
                System.out.println("da tim thay ");
                kh[i].xuat();
                found = true;
                return;
            }
        }
        if(!found){
            System.out.println("khong tim thay ");
        }
    }
    public KhachHang[] Search_TenKhachHang(String ten){
        boolean found = false;
        KhachHang[] kq = new KhachHang[0];
        int count = 0 ; 
        for(int i = 0 ; i < numkh ; i++){
            if(kh[i].getTenKhachHang().equalsIgnoreCase(ten)){
                found = true;
                System.out.println("Da tim thay ten khach hanh ");
                kh[i].xuat();
                kq = Arrays.copyOf(kq, count + 1);
                kq[i] = kh[i];
                count++;
            }
        }
        if(!found){
            System.out.println("khong tim thay ten khach hang ");
            return null;
        }
        return kq;
    }
    public void Search_TenKhachHang(){
        boolean found = false;
        System.out.println("vui long nhap ten khach hang can tim ");
        String ten = sc.nextLine();
        for(int i = 0 ; i < numkh; i ++){
            if(kh[i].getTenKhachHang().equalsIgnoreCase(ten)){
                System.out.println("da tim thay ");
                kh[i].xuat();
                found = true;
                return;
            }
        }
        if(!found){
            System.out.println("khong tim thay ");
        }
    }
    public KhachHang[] Search_SoDT_KhachHang(String sdt){
        boolean found = false;
        KhachHang[] kq = new KhachHang[0];
        int count = 0 ; 
        for(int i = 0 ; i < numkh ; i++){
            if(kh[i].getSoDienThoai().equalsIgnoreCase(sdt)){
                found = true;
                System.out.println("Da tim thay so dien thoai khach hanh ");
                kh[i].xuat();
                kq = Arrays.copyOf(kq, count + 1);
                kq[i] = kh[i];
                count++;
            }
        }
        if(!found){
            System.out.println("khong tim thay so dien thoai khach hang ");
            return null;
        }
        return kq;
    }
    public void Search_SoDT_KhachHang(){
        boolean found = false;
        System.out.println("vui long nhap so dien thoai khach hang can tim ");
        String sdt = sc.nextLine();
        for(int i = 0 ; i < numkh; i ++){
            if(kh[i].getSoDienThoai().equalsIgnoreCase(sdt)){
                System.out.println("da tim thay ");
                kh[i].xuat();
                found = true;
                return;
            }
        }
        if(!found){
            System.out.println("khong tim thay ");
        }
    }
    public KhachHang[] Search_EmailKhachHang(String email){
        boolean found = false;
        KhachHang[] kq = new KhachHang[0];
        int count = 0 ; 
        for(int i = 0 ; i < numkh ; i++){
            if(kh[i].getEmail().equalsIgnoreCase(email)){
                found = true;
                System.out.println("Da tim thay email khach hanh ");
                kh[i].xuat();
                kq = Arrays.copyOf(kq, count + 1);
                kq[i] = kh[i];
                count++;
            }
        }
        if(!found){
            System.out.println("khong tim thay email khach hang ");
            return null;
        }
        return kq;
    }
    public void Search_EmailKhachHang(){
        boolean found = false;
        System.out.println("vui long nhap email khach hang can tim ");
        String email = sc.nextLine();
        for(int i = 0 ; i < numkh; i ++){
            if(kh[i].getEmail().equalsIgnoreCase(email)){
                System.out.println("da tim thay ");
                kh[i].xuat();
                found = true;
                return;
            }
        }
        if(!found){
            System.out.println("khong tim thay ");
        }
    }
        public KhachHang[] Search_GioiTinhKhachHang(String gt){
        boolean found = false;
        KhachHang[] kq = new KhachHang[0];
        int count = 0 ; 
        for(int i = 0 ; i < numkh ; i++){
            if(kh[i].getGioiTinh().equalsIgnoreCase(gt)){
                found = true;
                System.out.println("Da tim thay danh sach gioi tinh khach hanh ");
                kh[i].xuat();
                kq = Arrays.copyOf(kq, count + 1);
                kq[i] = kh[i];
                count++;
            }
        }
        if(!found){
            System.out.println("khong tim thay danh sach gioi tinh khach hang ");
            return null;
        }
        return kq;
    }
    public void Search_GioiTinhKhachHang(){
        boolean found = false;
        System.out.println("vui long nhap gioi tinh khach hang can tim ");
        String gt = sc.nextLine();
        for(int i = 0 ; i < numkh; i ++){
            if(kh[i].getGioiTinh().equalsIgnoreCase(gt)){
                System.out.println("da tim thay ");
                kh[i].xuat();
                found = true;
                return;
            }
        }
        if(!found){
            System.out.println("khong tim thay ");
        }
    }
    public KhachHang[] Search_DoTuoiKhachHang(int tuoi){
        boolean found = false;
        KhachHang[] kq = new KhachHang[0];
        int count = 0 ; 
        for(int i = 0 ; i < numkh ; i++){
            if(Tinh_DoTuoi(kh[i].getNgaySinh()) == tuoi){
                found = true;
                System.out.println("Da tim thay danh sach khach hang co do tuoi can tim ");
                kh[i].xuat();
                kq = Arrays.copyOf(kq, count + 1);
                kq[i] = kh[i];
                count++;
            }
        }
        if(!found){
            System.out.println("khong tim thay danh sach khach hang co do tuoi can tim ");
            return null;
        }
        return kq;
    }
    public void Search_DoTuoiKhachHang(){
        boolean found = false;
        System.out.println("vui long nhap do tuoi khach hang can tim ");
        int tuoi = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i < numkh; i ++){
            if(Tinh_DoTuoi(kh[i].getNgaySinh()) == tuoi){
                System.out.println("da tim thay ");
                kh[i].xuat();
                found = true;
                return;
            }
        }
        if(!found){
            System.out.println("khong tim thay ");
        }
    }
    public int[] ThongKe_GioiTinh(){
       int nam = 0 , nu = 0;
       for(int i = 0 ; i < numkh ; i++){
        if(kh[i].getGioiTinh().equalsIgnoreCase("nam")){
            nam++;
        }else if(kh[i].getGioiTinh().equalsIgnoreCase("nu")){
            nu++;
        }
       }
       System.out.println("so luong khach hang nam la : " + nam);
         System.out.println("so luong khach hang nu la : " + nu);
         return new int[]{nam,nu};
    }
    public int Tinh_DoTuoi(String ngaysinh){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(ngaysinh, formatter);
        LocalDate currentDate = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(birthDate, currentDate);
    }
    public int[] ThongKe_DoTuoi(){
        int duoi20 = 0 , tu20den40 = 0 , tren40 = 0;
        for(int i = 0 ; i < numkh ; i++){
            int tuoi = Tinh_DoTuoi(kh[i].getNgaySinh());
            if(tuoi < 20){
                duoi20++;
            }else if(tuoi >=20 && tuoi <=40){
                tu20den40++;
            }else{
                tren40++;
            }
        }
        System.out.println("so luong khach hang duoi 20 tuoi la : " + duoi20);
        System.out.println("so luong khach hang tu 20 den 40 tuoi la : " + tu20den40);
        System.out.println("so luong khach hang tren 40 tuoi la : " + tren40);
        return new int[]{duoi20,tu20den40,tren40};
    }
    public void GhiFile(String tenFile) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            for (int i = 0; i < numkh; i++) {
                String line = "";
                line = String.join("-",kh[i].getMaKhachHang(),kh[i].getHoKhachHang(),kh[i].getTenKhachHang(),kh[i].getEmail(),kh[i].getSoDienThoai(),kh[i].getGioiTinh(),kh[i].getNgaySinh());
                pw.println(line);
            }
            System.out.println("Da ghi file thanh cong !");
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
}
}
