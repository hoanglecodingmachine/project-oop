import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
public class DanhSachBaoHanh {
    private static Scanner sc = new Scanner(System.in);
    private BaoHanh[] dsbh;
    private int numbh;

    public DanhSachBaoHanh(){}
    public DanhSachBaoHanh(BaoHanh[] dsbh, int numbh) {
        this.dsbh = dsbh;
        this.numbh = numbh;
    }

    public BaoHanh[] getDsbh() {
        return dsbh;
    }
    public void setDsbh(BaoHanh[] dsbh) {
        this.dsbh = dsbh;
    }
    public int getNumbh() {
        return numbh;
    }
    public void setNumbh(int numbh) {
        this.numbh = numbh;
    }
    public void nhap(){
        System.out.print("Nhap so luong bao hanh can them: ");
        int numbh= sc.nextInt();
        sc.nextLine();
        dsbh= new BaoHanh[numbh];
        for(int i=0;i<numbh;i++){
            System.out.println("---- Nhap bao hanh thu "+(i+1)+" ----");
            dsbh[i] = new BaoHanh();
            dsbh[i].nhap();
        }
    }
    public void xuat(){
        System.out.printf("%-15s %-15s %-15s %-20s\n", "Ma Bao Hanh", "Ma San Pham", "Ngay Mua", "Thoi Gian Bao Hanh (thang)");
        for(int i=0;i<numbh;i++){
            dsbh[i].xuat();
        }
    }
    public void DocFile(String tenFile){
        try(Scanner scfile = new Scanner(new File(tenFile))){
        int i=0;
        while(scfile.hasNextLine()){
            String line = scfile.nextLine().trim();
            if(line.isEmpty()) continue;
            String[] p = line.split("-");
            if(p.length != 3) continue;
            BaoHanh bh1 = null;
            String maBaoHanh = p[0];
            String maSanPham = p[1];
            int thoiGianBaoHanh = Integer.parseInt(p[2]);
            bh1 = new BaoHanh(maBaoHanh,maSanPham,thoiGianBaoHanh);
            dsbh[i++] = bh1;  
        } numbh = i;
        System.out.println("Da doc file thanh cong !");
        } catch (Exception e) {
          System.out.println("Loi doc file: " + e.getMessage());
        }
    }
    public void them(){
        dsbh = Arrays.copyOf(dsbh, numbh + 1);
        System.out.println("Nhap Phieu bao Hanh Moi");
        BaoHanh bhmoi = new BaoHanh();
        bhmoi.nhap();
        them(bhmoi);
        
    }
    public void them(BaoHanh bh1){
        dsbh = Arrays.copyOf(dsbh, numbh + 1);
        dsbh[numbh] = bh1;
        numbh++;
        System.out.println("Da them bao hanh moi thanh cong!");
    }
    public void xoa(String ma){
        boolean found = false;
        for(int i=0;i<numbh;i++){
            if(dsbh[i].getMaBaoHanh().equalsIgnoreCase(ma)){
                found = true;
                for(int j=i;j<numbh-1;j++){
                    dsbh[j] = dsbh[j+1];
                }
                dsbh = Arrays.copyOf(dsbh, numbh - 1);
                numbh--;
                System.out.println("Da xoa bao hanh co ma: " + ma);
                break;
            }
        }
        if(!found){
            System.out.println("Khong tim thay bao hanh co ma: " + ma);
        }
    }
    public void xoa(){
        System.out.print("Nhap ma bao hanh can xoa: ");
        String ma = sc.nextLine();
        xoa(ma);
    }
    public void sua(){
        System.out.print("Nhap ma bao hanh can sua: ");
        String ma = sc.nextLine();
        sua(ma);
    }
    public void sua(String ma){
        boolean found = false;
        for(int i=0;i<numbh;i++){
            if(dsbh[i].getMaBaoHanh().equalsIgnoreCase(ma)){
                found = true;
                System.out.println("Nhap lua chon de sua (1 ma san pham  , 2 thoi gian bao hanh,3 sua het ):");
                int choice = sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 1:
                        System.out.print("Nhap ma san pham moi: ");
                        dsbh[i].setMaSanPham(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhap thoi gian bao hanh moi (thang): ");
                        dsbh[i].setThoiGianBaoHanh(sc.nextInt());
                        break;
                    case 3:
                        dsbh[i].nhap();
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                        break;
                }
            }
        if(!found){
            System.out.println("Khong tim thay bao hanh co ma: " + ma);
        }
    }
}
    public BaoHanh Search_Ma(String ma){
        boolean found = false;
        for(int i=0;i<numbh;i++){
            if(dsbh[i].getMaBaoHanh().equalsIgnoreCase(ma)){
                found = true;
                System.out.println("Bao hanh tim thay:");
                dsbh[i].xuat();
                return dsbh[i];
            }
        }
        if(!found){
            System.out.println("Khong tim thay bao hanh co ma: " + ma);
        }
        return null;
    }
    public void Search_Ma(){
        System.out.print("Nhap ma bao hanh can tim: ");
        String ma = sc.nextLine();
        Search_Ma(ma);
    }
    public void Search_MaSanPham(){
        System.out.print("Nhap ma san pham can tim: ");
        String maSP = sc.nextLine();
        Search_MaSanPham(maSP);
    }
    public BaoHanh[] Search_MaSanPham(String maSP){
        boolean found = false;
        BaoHanh[] ketqua = new BaoHanh[0];
        int count = 0;
        for(int i=0;i<numbh;i++){
            if(dsbh[i].getMaSanPham().equalsIgnoreCase(maSP)){
                found = true;
                System.out.println("Bao hanh tim thay:");
                dsbh[i].xuat();
                ketqua = Arrays.copyOf(ketqua, count + 1);
                count++;
            }
        }
        if(!found){
            System.out.println("Khong tim thay bao hanh co ma san pham: " + maSP);
            return null;
        }
        return ketqua;
    }
    public void Search_ThoiGianBaoHanh(){
        System.out.print("Nhap thoi gian bao hanh can tim (thang): ");
        int tgBH = sc.nextInt();
        sc.nextLine();
        Search_ThoiGianBaoHanh(tgBH);
    }
    public BaoHanh[] Search_ThoiGianBaoHanh(int tgBH){
        boolean found = false;
        BaoHanh[] ketqua = new BaoHanh[0];
        int count = 0;
        for(int i=0;i<numbh;i++){
            if(dsbh[i].getThoiGianBaoHanh() == tgBH){
                found = true;
                System.out.println("Bao hanh tim thay:");
                dsbh[i].xuat();
                ketqua = Arrays.copyOf(ketqua, count + 1);
                count++;
            }
        }
        if(!found){
            System.out.println("Khong tim thay bao hanh co thoi gian bao hanh: " + tgBH + " thang");
            return null;
        }
        return ketqua;
    }
    public int[] ThongKe_ThoiGianBaoHanh(){
        int duoi6thang = 0;
        int tu6den12thang = 0;
        int tren12thang = 0;

        for (int i = 0; i < numbh; i++) {
            int tgBH = dsbh[i].getThoiGianBaoHanh();

            if (tgBH < 6) {
                duoi6thang++;
            } else if (tgBH <= 12) {
                tu6den12thang++;
            } else {
                tren12thang++;
            }
        }


        System.out.println("Thong ke thoi gian bao hanh:");
        System.out.println("So luong bao hanh duoi 6 thang: " + duoi6thang);
        System.out.println("So luong bao hanh tu 6 den 12 thang: " + tu6den12thang);
        System.out.println("So luong bao hanh tren 12 thang: " + tren12thang);

        return new int[]{duoi6thang, tu6den12thang, tren12thang};
    }
    public void GhiFile(String tenFile){
        try(PrintWriter pw = new PrintWriter(new FileWriter(tenFile))){
            for(int i=0;i<numbh;i++){
            String line = "";
            line = String.join("-", dsbh[i].getMaBaoHanh(), dsbh[i].getMaSanPham(), String.valueOf(dsbh[i].getThoiGianBaoHanh()));
            pw.println(line);
            }
            System.out.println("Da ghi file thanh cong !");
        } catch (Exception e) {
          System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
} 