import java.util.Arrays;
import java.util.Scanner;
public class MainKH {
      private static Scanner sc = new Scanner(System.in);
      private KhachHang[] kh;
      private int numkh;
      public MainKH(){};
      public MainKH(KhachHang[] kh,int numkh){
        this.kh = kh;
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
                for(int j = i; j < numkh - 1 ;j++){
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
      public void sua(String ma ,String object,int choice){
        boolean found = false;   
        for(int i = 0 ; i < numkh;i++){
            if(kh[i].getMaKhachHang().toLowerCase().contains(ma.toLowerCase())){
                found = true;
                switch (choice) {
                    case 1:
                        System.out.println("da sua thanh cong ten khach hang ");
                        kh[i].setTenKhachHang(object);
                        break;
                    case 2:
                        System.out.println("da sua thanh cong dia chi email cua khach hang ");
                        kh[i].setEmail(object);
                        break;
                    case 3:
                        System.out.println("da sua thanh cong so dien thoai cua khach hang ");
                        kh[i].setSoDienThoai(object);
                        break;
                    case 4:
                        System.out.println("da sua thanh cong dia chi cua khach hang ");
                        kh[i].setDiaChi(object);
                        break;
                    case 5:
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
        System.out.println("Vui long nhap lua chon sua cua ban (1 ten,2 email,3 so dien thoai , 4 dia chi , 5 sua het , 0 thoat ) ");
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice != 5 && choice != 0){
            System.out.println("Vui long nhap noi dung sua ");
            String object = sc.nextLine();
            sua(ma,object,choice);
        }else sua(ma,null,choice);
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
        public KhachHang[] Search_DiaChiKhachHang(String dc){
        boolean found = false;
        KhachHang[] kq = new KhachHang[0];
        int count = 0 ; 
        for(int i = 0 ; i < numkh ; i++){
            if(kh[i].getDiaChi().equalsIgnoreCase(dc)){
                found = true;
                System.out.println("Da tim thay dia chi khach hanh ");
                kh[i].xuat();
                kq = Arrays.copyOf(kq, count + 1);
                kq[i] = kh[i];
                count++;
            }
        }
        if(!found){
            System.out.println("khong tim thay dia chi khach hang ");
            return null;
        }
        return kq;
    }
    public void Search_DiaChiKhachHang(){
        boolean found = false;
        System.out.println("vui long nhap dia chi khach hang can tim ");
        String dc = sc.nextLine();
        for(int i = 0 ; i < numkh; i ++){
            if(kh[i].getDiaChi().equalsIgnoreCase(dc)){
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
    public int[] ThongKe_DiaChi(){
        int hcm = 0 , hanoi = 0 ,ncngoai = 0;
        for(int i = 0 ; i < numkh; i++){
            if(kh[i].getDiaChi().toLowerCase().contains("ho chi minh")){
                hcm++;
            }else if(kh[i].getDiaChi().toLowerCase().contains("ha noi")){
                hanoi++;
            }
            else ncngoai++;
        }
     System.out.printf("%-10s %d%n","so luong khach hang o Ho Chi Minh la ",hcm);
     System.out.printf("%-10s %d%n","so luong khach hang o Ha Noi la  ",hanoi);
     System.out.printf("%-10s %d%n","so luong khach hang o nuoc ngoai la ",ncngoai);
     return new int[]{hcm,hanoi,ncngoai};
    }
}
