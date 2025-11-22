import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;    
import java.io.FileWriter;

public class DanhSachSanPham{
private static Scanner sc = new Scanner(System.in);
private int num;
private DienThoai[] sp;
public DanhSachSanPham(){

}
public DanhSachSanPham(int num,DienThoai[] sp){
        this.num = num;
        this.sp = sp;
    }
public DanhSachSanPham(DienThoai[] other) {
    if (other == null) {
        this.sp = new DienThoai[0];
        this.num = 0;
    } else {
        this.sp = Arrays.copyOf(other, other.length);
        this.num = other.length;
    }
}
public int getNum(){
        return num;
    }
public void setNum(int num){
        this.num = num;
        sp = new DienThoai[num];
    }
public DienThoai[] getSP(){
        return sp;
    }
public void setSP(DienThoai[] sp){
        this.sp = sp;
    }


public void DocFile(String tenFile) {
    try {
        int count = 0;
        Scanner scCount = new Scanner(new File(tenFile));

        while (scCount.hasNextLine()) {
            String line = scCount.nextLine().trim();
            if (!line.isEmpty()) {
                count++;
            }
        }
        scCount.close();

        if (count == 0) {
            System.out.println(" File trong hoac khong co dong hop le!");
            return;
        }

  
        sp = new DienThoai[count];
        num = 0;


        Scanner scFile = new Scanner(new File(tenFile));

        while (scFile.hasNextLine()) {
            String line = scFile.nextLine().trim();
            if (line.isEmpty()) continue;

            line = line.replace("\uFEFF", "");

            String[] p = line.split("-");

            if (p.length < 8) {
                System.out.println(" Dong loi (thieu du lieu): " + line);
                continue;
            }

            DienThoai spdt = null;
            String loai = p[0].trim().toUpperCase();

            if (loai.equals("DTM")) {
                spdt = new DienThoaiThongMinh(
                        p[1], p[2],
                        Integer.parseInt(p[3]),
                        p[4],
                        Double.parseDouble(p[5]),
                        p[6], p[7]
                );
            } else if (loai.equals("DTC")) {
                spdt = new DienThoaiCoDien(
                        p[1], p[2],
                        Integer.parseInt(p[3]),
                        p[4],
                        Float.parseFloat(p[5]),
                        p[6],
                        Integer.parseInt(p[7])
                );
            } else {
                System.out.println(" Loai san pham khong hop le: " + line);
                continue;
            }

            sp[num++] = spdt;
        }

        scFile.close();
        System.out.println(" doc file thanh cong! Tong san pham: " + num);

    } catch (FileNotFoundException fnf) {
        System.out.println(" Khong tim thay file: " + tenFile);
    } catch (Exception e) {
        System.out.println(" Loi doc file: " + e.getMessage());
    }
}


public void nhap(){
        System.out.println("vui long nhap so luong san pham ban dau ");
        num = sc.nextInt();
        sp = new DienThoai[num];
        int i = 0;
        while(i < num){
            int choice = 0;
            System.out.println("nhap lua chon de nhap san pham (1 smartphone , 2 ordinary phone): ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
            case 1:
               System.out.println("vui long nhap thong tin cua dien thoai thong minh:");
               sp[i] = new DienThoaiThongMinh();
               sp[i].nhap();
               i++;
               break;
            
            case 2:
                System.out.println("vui long nhap thong tin cua dien thoai co dien:");
                sp[i] = new DienThoaiCoDien();
                sp[i].nhap();
                i++;
                break;
            
            default:
               System.out.println("loi vui long nhap lai ");
               break;
          }
        }
    }
public void xuat(){
        System.out.printf("%50s","danh sach san pham co trong cua hang la ");
        for(int i = 0 ; i < num ; i++){
            sp[i].xuat();
        }
    }
public void Them(DienThoai sp1){
        sp = Arrays.copyOf(sp,num + 1);
        sp[num] = sp1;
        num++;
        System.out.println("Da them san pham thanh cong !");
    }
public void Them() {
    int choice = 0;
    System.out.println("Vui long chon loai san pham can them:");
    System.out.println("1. Smartphone");
    System.out.println("2. Ordinary Phone");
    System.out.print("Lua chon cua ban: ");
    choice = sc.nextInt();
    sc.nextLine();

    DienThoai sp1;

    switch (choice) {
        case 1:
            sp1 = new DienThoaiThongMinh();
            System.out.println("Nhap thong tin dien thoai thong minh:");
            sp1.nhap();
            Them(sp1);
            break;

        case 2:
            sp1 = new DienThoaiCoDien();
            System.out.println("Nhap thong tin dien thoai co dien:");
            sp1.nhap();
            Them(sp1);
            break;

        default:
            System.out.println("Lua chon khong hop le. Vui long thu lai!");
            break;
    }
}
public void xoa(String ma){
    boolean found = false;
    for(int i = 0; i < num ; i++){
        if(sp[i].getMaSP().equals(ma)){
          found = true;
          for (int j = i; j < num - 1; j++) {
                sp[j] = sp[j + 1];
            }
          sp = Arrays.copyOf(sp,num - 1);
          num--;
          System.out.println("Da xoa san pham thanh cong ");
          break;
        }
    }
    if(!found){
        System.out.println("khong tim thay san pham ");
    }
}
public void xoa(){
    String ma ;
    sc.nextLine(); 
    System.out.printf("vui long nhap ma san pham de xoa:");
    ma = sc.nextLine();
    xoa(ma);
}
public void sua(String ma) {
    boolean found = false;
    for (int i = 0; i < num; i++) {
        if (sp[i].getMaSP().equals(ma)) {
            System.out.println("Nhap lua chon can sua (1 ten san pham, 2 so luong, 3 don vi tien, 4 don gia, 5 he dieu hanh, 6 dung luong, 7 ban phim, 8 thoi gian goi, 0 sua tat ca):");
            int choice = sc.nextInt();
            sc.nextLine();
            found = true;
            switch (choice) {
                case 1:
                    System.out.println("vui long nhap ten san pham moi");
                    sp[i].setTenSP(sc.nextLine());
                    System.out.println("da sua ten thanh cong!");
                    break;
                case 2:
                    System.out.println("vui long nhap so luong moi");
                    sp[i].setSoLuong(sc.nextInt());
                    System.out.println("da sua so luong thanh cong!");
                    break;
                case 3:
                    System.out.println("vui long nhap don vi tien moi");
                    sp[i].setDonViTien(sc.nextLine());
                    System.out.println("da sua don vi tien thanh cong!");
                    break;
                case 4:
                    System.out.println("vui long nhap don gia moi");
                    sp[i].setDonGia(sc.nextDouble());
                    System.out.println("da sua don gia thanh cong!");
                    break;
                case 5:
                    if (sp[i] instanceof DienThoaiThongMinh) {
                        System.out.println("vui long nhap he dieu hanh moi");
                        ((DienThoaiThongMinh) sp[i]).setHeDieuHanh(sc.nextLine());
                        System.out.println("da sua he dieu hanh thanh cong!");
                    } else {
                        System.out.println("San pham nay khong co he dieu hanh!");
                    }
                    break;
                case 6:
                    if (sp[i] instanceof DienThoaiThongMinh) {
                        System.out.println("nhap dung luong moi cho san pham");
                        ((DienThoaiThongMinh) sp[i]).setDungLuong(sc.nextLine());
                        System.out.println("da sua dung luong thanh cong!");
                    } else {
                        System.out.println("San pham nay khong co dung luong!");
                    }
                    break;
                case 7:
                    if (sp[i] instanceof DienThoaiCoDien) {
                        System.out.println("nhap thoi gian thoai moi cho san pham");
                        ((DienThoaiCoDien) sp[i]).setBanPhim(sc.nextLine());
                        System.out.println("da sua kieu ban phim thanh cong!");
                    } else {
                        System.out.println("San pham nay khong co ban phim!");
                    }
                    break;
                case 8:
                    if (sp[i] instanceof DienThoaiCoDien) {
                        System.out.println("nhap thoi gian thoai moi cho san pham");
                        ((DienThoaiCoDien) sp[i]).setThoiGianThoai(sc.nextInt());
                        System.out.println("da sua thoi gian thoai thanh cong!");
                    } else {
                        System.out.println("San pham nay khong co thoi gian thoai!");
                    }
                    break;
                case 0:
                    sp[i].nhap();
                    System.out.println("sua tat ca thanh cong");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
    if (!found) {
        System.out.println("Khong tim thay san pham co ma: " + ma);
    }
}

public void sua(){
    System.out.println("vui long nhap ma can sua ");
    String ma = sc.nextLine();       
            sua(ma); 

}
public DienThoai Search_Ma(String ma){
      boolean found = false;
      for(int i = 0 ; i < num ; i++){
        if(sp[i].getMaSP().toLowerCase().contains(ma.toLowerCase())){
            found = true;
            System.out.println("da tim thay san pham can tim ");
            sp[i].xuat();
            return sp[i];
        }
      }
      if(!found){
        System.out.println("khong tim thay san pham ");
      }
      return null;
}
public void Search_Ma(){
      System.out.println("nhap ma san pham can tim ");
      String ma = sc.nextLine();
      Search_Ma(ma);
}
public DienThoai[] Search_Ten(String ten){
      int count = 0;
      DienThoai[] kq = new DienThoai[0]; 
      boolean found = false;
      for(int i = 0 ; i < num ; i++){
        if(sp[i].getTenSP().toLowerCase().contains(ten.toLowerCase())){
            found = true;
            System.out.println("da tim thay san pham can tim ");
            sp[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = sp[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay san pham ");
        return null;
      }
      return kq;
}
public void Search_Ten(){
      System.out.println("nhap ten san pham can tim ");
      String ten = sc.nextLine();
      Search_Ten(ten);
}
public DienThoai[] Search_SoLuong(int soluong){
      int count = 0;
      DienThoai[] kq = new DienThoai[0]; 
      boolean found = false;
      for(int i = 0 ; i < num ; i++){
        if(sp[i].getSoLuong() == soluong){
            found = true;
            System.out.println("da tim thay san pham can tim ");
            sp[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = sp[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay san pham ");
        return null;
      }
      return kq;
}
public void Search_SoLuong(){
      System.out.println("nhap so luong san pham con lai ");
      int soluong = sc.nextInt();
      sc.nextLine();
      Search_SoLuong(soluong);
}

public DienThoai[] Search_DonGia(double min,double max){
      int count = 0;
      DienThoai[] kq = new DienThoai[0]; 
      boolean found = false;
      for(int i = 0 ; i < num ; i++){
        if(sp[i].getDonGia() >= min && sp[i].getDonGia() <= max){
            found = true;
            System.out.println("da tim thay san pham can tim ");
            sp[i].xuat();
            kq = Arrays.copyOf(kq, count + 1);
            kq[count] = sp[i];
            count++;
        }
      }
      if(!found){
        System.out.println("khong tim thay san pham ");
        return null;
      }
      return kq;
}
public void Search_DonGia(){
      System.out.println("nhap gia tien nho nhat ");
      double min = sc.nextDouble();
      sc.nextLine(); 
      System.out.println("nhap gia tien lon nhat ");
      double max = sc.nextDouble();
      sc.nextLine(); 
      Search_DonGia(min, max);
}
public DienThoai[] Search_HeDieuHanh(String hedieuhanh) {
    boolean found = false;
    DienThoai[] kq = new DienThoai[0];
    int count = 0;

    for (int i = 0; i < num; i++) {
        if (sp[i] instanceof DienThoaiThongMinh) {
            DienThoaiThongMinh dtm = (DienThoaiThongMinh) sp[i];
            if (dtm.getHeDieuHanh().toLowerCase().contains(hedieuhanh.toLowerCase())) {
                found = true;
                System.out.println("Tim thay danh sach san pham:");
                dtm.xuat();
                kq = Arrays.copyOf(kq, count + 1);
                kq[count] = dtm;
                count++;
            }
        }
    }

    if (!found) {
        System.out.println("Khong tim thay danh sach ");
        return null;
    }
    return kq;
}
public void Search_HeDieuHanh(){
    System.out.println("nhap he dieu hanh can tim");
    String hdh = sc.nextLine();
    Search_HeDieuHanh(hdh);
}
public DienThoai[] Search_DungLuong(String dungluong) {
    boolean found = false;
    DienThoai[] kq = new DienThoai[0];
    int count = 0;

    for (int i = 0; i < num; i++) {
        if (sp[i] instanceof DienThoaiThongMinh) {
            DienThoaiThongMinh dtm = (DienThoaiThongMinh) sp[i];
            if (dtm.getDungLuong().toLowerCase().contains(dungluong.toLowerCase())) {
                found = true;
                System.out.println("Tim thay danh sach san pham:");
                dtm.xuat();
                kq = Arrays.copyOf(kq, count + 1);
                kq[count] = dtm;
                count++;
            }
        }
    }

    if (!found) {
        System.out.println("Khong tim thay danh sach ");
        return null;
    }
    return kq;
}
public void Search_DungLuong(){
    System.out.println("nhap dung luong dien thoai can tim(128g,256g,512g)");
    String dl = sc.nextLine();
    Search_DungLuong(dl);
}
public DienThoai[] Search_BanPhim(String banphim) {
    boolean found = false;
    DienThoai[] kq = new DienThoai[0];
    int count = 0;

    for (int i = 0; i < num; i++) {
        if (sp[i] instanceof DienThoaiCoDien) {
            DienThoaiCoDien dcd = (DienThoaiCoDien) sp[i];
            if (dcd.getBanPhim().toLowerCase().contains(banphim.toLowerCase())) {
                found = true;
                System.out.println("Tim thay danh sach san pham:");
                dcd.xuat();
                kq = Arrays.copyOf(kq, count + 1);
                kq[count] = dcd;
                count++;
            }
        }
    }

    if (!found) {
        System.out.println("Khong tim thay danh sach ");
        return null;
    }
    return kq;
}
public void Search_BanPhim(){
    System.out.println("nhap kieu ban phim cua dien thoai can tim( 12 nut , qwerty, flip)");
    String bp = sc.nextLine();
    Search_BanPhim(bp);
}
public DienThoai[] Search_ThoiGianThoai(int min , int max) {
    boolean found = false;
    DienThoai[] kq = new DienThoai[0];
    int count = 0;

    for (int i = 0; i < num; i++) {
        if (sp[i] instanceof DienThoaiCoDien) {
            DienThoaiCoDien dcd = (DienThoaiCoDien) sp[i];
            if (dcd.getThoiGianThoai() <= max && dcd.getThoiGianThoai() >= min) {
                found = true;
                System.out.println("Tim thay danh sach san pham:");
                dcd.xuat();
                kq = Arrays.copyOf(kq, count + 1);
                kq[count] = dcd;
                count++;
            }
        }
    }

    if (!found) {
        System.out.println("Khong tim thay danh sach ");
        return null;
    }
    return kq;
}
public void Search_ThoiGianThoai(){
        System.out.print("Nhập thời gian thoại nhỏ nhất (h): ");
    int min = sc.nextInt();
    sc.nextLine();
    System.out.print("Nhập thời gian thoại lớn nhất (h): ");
    int max = sc.nextInt();
    sc.nextLine();
    Search_ThoiGianThoai(min, max);
}
public int[] ThongKe_SoLuong(){
    int duoi20 = 0 , tren20 = 0 , tren50 = 0;
    for(int i = 0 ; i < num ; i++){
        if(sp[i].getSoLuong() < 20){
            duoi20++;
        }else if(sp[i].getSoLuong() >= 20 && sp[i].getSoLuong() < 50){
            tren20++;
        }else tren50++;
    }
    System.out.printf( "%-50s %d\n","so luong san pham ton kho duoi 20 san pham la " , duoi20);
    System.out.printf( "%-50s %d\n","so luong san pham ton kho tren 20 san pham la " , tren20);
    System.out.printf( "%-50s %d\n","so luong san pham ton kho tren 50 san pham nao la " , tren50);
    return new int[]{duoi20,tren20,tren50};
}
public int[] ThongKe_DonGia(){
    int duoi10tr = 0 , khoang20tr = 0 , tren20tr = 0;
    for(int i = 0 ; i < num ; i++){
        if(sp[i].getDonGia() < 10000000){
            duoi10tr++;
        }else if(sp[i].getDonGia() < 20000000 && sp[i].getDonGia() >= 10000000){
            khoang20tr++;
        }else tren20tr++;
    }
    System.out.printf("%-50s %d\n", "So luong san pham co gia duoi 10 trieu la", duoi10tr);
    System.out.printf("%-50s %d\n", "So luong san pham co gia tam 20 trieu la", khoang20tr);
    System.out.printf("%-50s %d\n", "So luong san pham co gia tren 20 trieu la", tren20tr);

    return new int[]{duoi10tr,khoang20tr,tren20tr};
}
public double[] ThongKe_HeDieuHanh(){
  double android = 0.0, ios = 0.0, other = 0.0;
    double tongSoLuong = 0.0;

    for (int i = 0; i < num; i++) {
        if (sp[i] instanceof DienThoaiThongMinh) {
            DienThoaiThongMinh sp1 = (DienThoaiThongMinh) sp[i];
            String hdh = sp1.getHeDieuHanh().toLowerCase();
            int sl = sp1.getSoLuong();

            tongSoLuong += sl;

            if (hdh.equals("android")) {
                android += sl;
            } else if (hdh.equals("ios")) {
                ios += sl;
            } else {
                other += sl;
            }
        }
    }

     android = (android * 100.0) / tongSoLuong;
    ios     = (ios * 100.0) / tongSoLuong;
    other   = (other * 100.0) / tongSoLuong;

    // Xuất kết quả
    System.out.printf("%-40s %.2f%%\n", "Ty le san pham Android:", android);
    System.out.printf("%-40s %.2f%%\n", "Ty le san pham iOS:", ios);
    System.out.printf("%-40s %.2f%%\n", "Ty le san pham he dieu hanh khac:", other);

    return new double[]{android, ios, other};
}
public int[] ThongKe_DungLuong(){
    int gb128 = 0 , gb256 = 0 , gb512 = 0;

    for (int i = 0; i < num; i++) {

        if (sp[i] instanceof DienThoaiThongMinh) {
            DienThoaiThongMinh sp1 = (DienThoaiThongMinh) sp[i];
            String dl = sp1.getDungLuong();

            if (dl.equalsIgnoreCase("128gb")) {
                gb128++;
            } else if (dl.equalsIgnoreCase("256gb")) {
                gb256++;
            } else {
                gb512++;
            }
        }
    }
    System.out.printf("%-40s %d\n", "So luong dien thoai co dung luong 128gb la ", gb128);
    System.out.printf("%-40s %d\n", "So luong dien thoai co dung luong 256gb la :", gb256);
    System.out.printf("%-40s %d\n", "So luong dien thoai co dung luong 512gb la ", gb512);

    return new int[]{gb128,gb256,gb512};
}
public int[] ThongKe_BanPhim(){
    int nut = 0 , qwerty = 0 , gap = 0;

    for (int i = 0; i < num; i++) {

        if (sp[i] instanceof DienThoaiCoDien) {
            DienThoaiCoDien sp1 = (DienThoaiCoDien) sp[i];
            String bp = sp1.getBanPhim();

            if (bp.equalsIgnoreCase("12nut")) {
                nut++;
            } else if (bp.equalsIgnoreCase("qwerty")) {
                qwerty++;
            } else {
                gap++;
            }
        }
    }
    System.out.printf("%-40s %d\n", "So luong dien thoai co ban phim 12 nut la ", nut);
    System.out.printf("%-40s %d\n", "So luong dien thoai co ban phim qwerty nut la  ", qwerty);
    System.out.printf("%-40s %d\n", "So luong dien thoai co ban phim gap la ", gap);

    return new int[]{nut,qwerty,gap};
}
public int[] ThongKe_ThoiGianGoi(){
    int oneday = 0 , oneweek = 0 , onemonth = 0;

    for (int i = 0; i < num; i++) {

        if (sp[i] instanceof DienThoaiCoDien) {
            DienThoaiCoDien sp1 = (DienThoaiCoDien) sp[i];
            int tgt = sp1.getThoiGianThoai();

            if (tgt <= 24) {
                oneday++;
            } else if (tgt <= 24*7 && tgt > 24) {
                oneweek++;
            } else {
                onemonth++;
            }
        }
    }
    System.out.printf("%-40s %d\n", "So luong dien thoai co thoi gian goi trung binh 1 ngay la ", oneday);
    System.out.printf("%-40s %d\n", "So luong dien thoai co thoi gian goi trung binh 1 tuan la  ", oneweek);
    System.out.printf("%-40s %d\n", "So luong dien thoai co thoi gian goi trung binh 1 thang la ", onemonth);

    return new int[]{oneday,oneweek,onemonth};
}
public void Sua_SoLuong(String ma,int soluong){
    for(int i = 0 ; i < num ; i++){
        if(sp[i].getMaSP().equalsIgnoreCase(ma)){
             sp[i].setSoLuong(sp[i].getSoLuong() - soluong);
        }
    }
}

public void GhiFile(String tenFile) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {

        for (int i = 0; i < num; i++) {
            if (sp[i] == null) continue;

            String loai = ""; 
            String line = "";

            if (sp[i] instanceof DienThoaiThongMinh) {
                loai = "DTM"; 
                DienThoaiThongMinh dtm = (DienThoaiThongMinh) sp[i];
                line = String.join("-",
                        loai,
                        dtm.getMaSP(),
                        dtm.getTenSP(),
                        String.valueOf(dtm.getSoLuong()),
                        dtm.getDonViTien(),
                        String.valueOf(dtm.getDonGia()),
                        dtm.getHeDieuHanh(),
                        dtm.getDungLuong()
                );
            } else if (sp[i] instanceof DienThoaiCoDien) {
                loai = "DTC"; 
                DienThoaiCoDien dtc = (DienThoaiCoDien) sp[i];
                line = String.join("-",
                        loai,
                        dtc.getMaSP(),
                        dtc.getTenSP(),
                        String.valueOf(dtc.getSoLuong()),
                        dtc.getDonViTien(),
                        String.valueOf(dtc.getDonGia()),
                        dtc.getBanPhim(),
                        String.valueOf(dtc.getThoiGianThoai())
                );
            }

            pw.println(line); 
        }

        System.out.println(" Ghi file thanh cong! Tong san pham: " + num);

    } catch (Exception e) {
        System.out.println(" Loi ghi file: " + e.getMessage());
    }
}

}