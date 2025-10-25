import java.util.Scanner;
import java.util.Arrays;    
public class DanhSachCuaHangDienThoai{
private static Scanner sc = new Scanner(System.in);
private int num;
private CUAHANGDIENTHOAI[] sp;
public DanhSachCuaHangDienThoai(){}
public DanhSachCuaHangDienThoai(int num,CUAHANGDIENTHOAI[] sp){
        this.num = num;
        this.sp = sp;
    }
public int getNum(){
        return num;
    }
public void setNum(int num){
        this.num = num;
        sp = new CUAHANGDIENTHOAI[num];
    }
public CUAHANGDIENTHOAI[] getSP(){
        return sp;
    }
public void setSP(CUAHANGDIENTHOAI[] sp){
        this.sp = sp;
    }
public void nhap(){
        System.out.println("vui long nhap so luong san pham ban dau ");
        num = sc.nextInt();
        sp = new CUAHANGDIENTHOAI[num];
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
public void ThemSP(CUAHANGDIENTHOAI sp1){
        sp = Arrays.copyOf(sp,num + 1);
        sp[num] = sp1;
        num++;
        System.out.println("Da them san pham thanh cong !");
    }
public void ThemSP() {
    int choice = 0;
    System.out.println("Vui lòng chọn loại sản phẩm cần thêm:");
    System.out.println("1. Smartphone");
    System.out.println("2. Ordinary Phone");
    System.out.print("Lựa chọn của bạn: ");
    choice = sc.nextInt();
    sc.nextLine();

    CUAHANGDIENTHOAI sp1;

    switch (choice) {
        case 1:
            sp1 = new DienThoaiThongMinh();
            System.out.println("Nhập thông tin điện thoại thông minh:");
            sp1.nhap();
            ThemSP(sp1);
            break;

        case 2:
            sp1 = new DienThoaiCoDien();
            System.out.println("Nhập thông tin điện thoại cổ điển:");
            sp1.nhap();
            ThemSP(sp1);
            break;

        default:
            System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
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
    System.out.printf("vui long nhap ma san pham de xoa:");
    ma = sc.nextLine();
    xoa(ma);
}
public void sua(String ma, int choice) {
    boolean found = false;
    for (int i = 0; i < num; i++) {
        if (sp[i].getMaSP().equals(ma)) {
            found = true;
            switch (choice) {
                case 1:
                    System.out.println("vui lonng nhap ten san pham moi");
                    sp[i].setTenSP(sc.nextLine());
                    System.out.println("Đã sửa tên thành công!");
                    break;
                case 2:
                    System.out.println("vui long nhap so luong moi ");
                    sp[i].setSoLuong(sc.nextInt());
                    System.out.println("Đã sửa số lượng thành công!");
                    break;
                case 3:
                    System.out.println("vui long nhap don vi tien moi ");
                    sp[i].setDonViTien(sc.nextLine());
                    System.out.println("Đã sửa đơn vị tiền thành công!");
                    break;
                case 4:
                    System.out.println("vui long nhap don gia moi ");
                    sp[i].setDonGia(sc.nextDouble());
                    System.out.println("Đã sửa đơn giá thành công!");
                    break;
                case 5:
                    if (sp[i] instanceof DienThoaiThongMinh) {
                        System.out.println("vui long nhap he dieu hanh moi ");
                        ((DienThoaiThongMinh) sp[i]).setHeDieuHanh(sc.nextLine());
                        System.out.println("Đã sửa hệ điều hành thành công!");
                    } else {
                        System.out.println("Sản phẩm này không có hệ điều hành!");
                    }
                    break;
                case 6:
                    if (sp[i] instanceof DienThoaiThongMinh) {
                        System.out.println("nhap dung luong moi cho san pham ");
                        ((DienThoaiThongMinh) sp[i]).setDungLuong(sc.nextLine());
                        System.out.println("Đã sửa dung lượng thành công!");
                    } else {
                        System.out.println("Sản phẩm này không có dung lượng!");
                    }
                    break;
                case 7:
                    if (sp[i] instanceof DienThoaiCoDien) {
                        System.out.println("nhap thoi gian thoai moi cho san pham ");
                        ((DienThoaiCoDien) sp[i]).setBanPhim(sc.nextLine());
                        System.out.println("Đã sửa kiểu bàn phím thành công!");
                    } else {
                        System.out.println("Sản phẩm này không có bàn phím!");
                    }
                    break;
                case 8:
                    if (sp[i] instanceof DienThoaiCoDien) {
                        System.out.println("nhap thoi gian thoai moi cho san pham ");
                        ((DienThoaiCoDien) sp[i]).setThoiGianThoai(sc.nextInt());
                        System.out.println("Đã sửa thời gian thoại thành công!");
                    } else {
                        System.out.println("Sản phẩm này không có thời gian thoại!");
                    }
                    break;
                case 0:
                    sp[i].nhap();
                    System.out.println("sua tat ca thanh cong ");
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    if (!found) {
        System.out.println("Không tìm thấy sản phẩm có mã: " + ma);
    }
}
public void sua(){
    System.out.println("vui long nhap ma can sua ");
    String ma = sc.nextLine();
    for(int i = 0 ; i < num;i++){
        if(sp[i].getMaSP().equals(ma)){
            System.out.println("da tim thay san pham . Vui long nhap lua chon de sua ");
            System.out.println("1 sua san pham, 2 so luong, 3 don vi tien,4 don gia ,5 he dieu thanh , 6 dung luong , 7 kieu ban phim , 8 thoi gian thoai , 0 sua het ");
            int choice = sc.nextInt();
            sc.nextLine();
            sua(ma,choice); 
        }
    }
}
public CUAHANGDIENTHOAI Search_Ma(String ma){
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
      boolean found = false;
      for(int i = 0 ; i < num ; i++){
        if(sp[i].getMaSP().toLowerCase().contains(ma.toLowerCase())){
            found = true;
            System.out.println("da tim thay san pham can tim ");
            sp[i].xuat();
        }
      }
      if(!found){
        System.out.println("khong tim thay san pham ");
      }
}
public CUAHANGDIENTHOAI[] Search_Ten(String ten){
      int count = 0;
      CUAHANGDIENTHOAI[] kq = new CUAHANGDIENTHOAI[0]; 
      boolean found = false;
      for(int i = 0 ; i < num ; i++){
        if(sp[i].getMaSP().toLowerCase().contains(ten.toLowerCase())){
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
      boolean found = false;
      for(int i = 0 ; i < num ; i++){
        if(sp[i].getMaSP().toLowerCase().contains(ten.toLowerCase())){
            found = true;
            System.out.println("da tim thay san pham can tim ");
            sp[i].xuat();
        }
      }
      if(!found){
        System.out.println("khong tim thay san pham ");
      }
}
public CUAHANGDIENTHOAI[] Search_SoLuong(int soluong){
      int count = 0;
      CUAHANGDIENTHOAI[] kq = new CUAHANGDIENTHOAI[0]; 
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
      boolean found = false;
      for(int i = 0 ; i < num ; i++){
        if(sp[i].getSoLuong() == soluong){
            found = true;
            System.out.println("da tim thay san pham can tim ");
            sp[i].xuat();
        }
      }
      if(!found){
        System.out.println("khong tim thay san pham ");
      }
}

public CUAHANGDIENTHOAI[] Search_DonGia(double min,double max){
      int count = 0;
      CUAHANGDIENTHOAI[] kq = new CUAHANGDIENTHOAI[0]; 
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
      System.out.println("nhap gia tien lon nhat ");
      double max = sc.nextDouble();
      boolean found = false;
      for(int i = 0 ; i < num ; i++){
        if(sp[i].getDonGia() >= min && sp[i].getDonGia() <= max){
            found = true;
            System.out.println("da tim thay san pham can tim ");
            sp[i].xuat();
        }
      }
      if(!found){
        System.out.println("khong tim thay san pham ");
      }
}
public CUAHANGDIENTHOAI[] Search_HeDieuHanh(String hedieuhanh) {
    boolean found = false;
    CUAHANGDIENTHOAI[] kq = new CUAHANGDIENTHOAI[0];
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
    for(int i = 0 ; i < num; i++){
        if(sp[i] instanceof DienThoaiThongMinh){
           DienThoaiThongMinh d1 = (DienThoaiThongMinh) sp[i];
           if(d1.getHeDieuHanh().toLowerCase().contains(hdh.toLowerCase())){
            System.out.println("da tim thay san pham ");
            d1.xuat();
           }
        }
    }
}
public CUAHANGDIENTHOAI[] Search_DungLuong(String dungluong) {
    boolean found = false;
    CUAHANGDIENTHOAI[] kq = new CUAHANGDIENTHOAI[0];
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
    for(int i = 0 ; i < num; i++){
        if(sp[i] instanceof DienThoaiThongMinh){
           DienThoaiThongMinh d1 = (DienThoaiThongMinh) sp[i];
           if(d1.getDungLuong().toLowerCase().contains(dl.toLowerCase())){
            System.out.println("da tim thay san pham ");
            d1.xuat();
           }
        }
    }
}
public CUAHANGDIENTHOAI[] Search_BanPhim(String banphim) {
    boolean found = false;
    CUAHANGDIENTHOAI[] kq = new CUAHANGDIENTHOAI[0];
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
    for(int i = 0 ; i < num; i++){
        if(sp[i] instanceof DienThoaiCoDien){
           DienThoaiCoDien d1 = (DienThoaiCoDien) sp[i];
           if(d1.getBanPhim().toLowerCase().contains(bp.toLowerCase())){
            System.out.println("da tim thay san pham ");
            d1.xuat();
           }
        }
    }
}
public CUAHANGDIENTHOAI[] Search_ThoiGianThoai(int min , int max) {
    boolean found = false;
    CUAHANGDIENTHOAI[] kq = new CUAHANGDIENTHOAI[0];
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

    System.out.print("Nhập thời gian thoại lớn nhất (h): ");
    int max = sc.nextInt();
    sc.nextLine();
    for(int i = 0 ; i < num; i++){
        if(sp[i] instanceof DienThoaiCoDien){
           DienThoaiCoDien d1 = (DienThoaiCoDien) sp[i];
           if(d1.getThoiGianThoai() >= min && d1.getThoiGianThoai() <= max){
            System.out.println("da tim thay san pham ");
            d1.xuat();
           }
        }
    }
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
    System.out.printf("%-40s %.2f%%\n", "Tỷ lệ sản phẩm Android:", android);
    System.out.printf("%-40s %.2f%%\n", "Tỷ lệ sản phẩm iOS:", ios);
    System.out.printf("%-40s %.2f%%\n", "Tỷ lệ sản phẩm hệ điều hành khác:", other);

    return new double[]{android, ios, other};
}
public int[] ThongKe_DungLuong(){
    int gb = 0 , 256g = 0 , 512g = 0;
     int tongSoLuong = 0;

    for (int i = 0; i < num; i++) {
        tongSoLuong += sp[i].getSoLuong();

        if (sp[i] instanceof DienThoaiThongMinh) {
            DienThoaiThongMinh sp1 = (DienThoaiThongMinh) sp[i];
            String hdh = sp1.getHeDieuHanh();

            if (hdh.equalsIgnoreCase("android")) {
                android += sp1.getSoLuong();
            } else if (hdh.equalsIgnoreCase("ios")) {
                ios += sp1.getSoLuong();
            } else {
                other += sp1.getSoLuong();
            }
        }
    }

    // Tính phần trăm
    double ptAndroid = (android * 100.0) / tongSoLuong;
    double ptIos = (ios * 100.0) / tongSoLuong;
    double ptOther = (other * 100.0) / tongSoLuong;

    // In kết quả
    System.out.printf("%-40s %.2f%%\n", "Tỷ lệ sản phẩm Android:", ptAndroid);
    System.out.printf("%-40s %.2f%%\n", "Tỷ lệ sản phẩm iOS:", ptIos);
    System.out.printf("%-40s %.2f%%\n", "Tỷ lệ sản phẩm khác:", ptOther);

    return new int[]{ios, android, other};
}
}