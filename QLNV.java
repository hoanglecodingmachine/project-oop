import java.util.Scanner;
public class QLNV extends MainQLBH {
  private static Scanner sc = new Scanner(System.in);

  public void mainQLNV(){
    System.out.println("1 xuat,2 them , 3 sua ,4 xoa ,5 tim kiem,6 thong ke  ,0 thoat");
    int choice = sc.nextInt();
    switch (choice) {
      case 1:
        dsnv.xuat();
        break;
      case 2:
        dsnv.Them();
        break;
      case 3:
        dsnv.sua();
        break;
      case 4:
        dsnv.xoa();
        break;
      case 5:
        {
          System.out.println("Nhap lua chon tim kiem (1 ma nhan vien , 2 ho nhan vien , 4 ten nhan vien , 5 luong , 6 chuc vu )");
          int subChoice = sc.nextInt();
          sc.nextLine();
          switch (subChoice) {
            case 1:
              dsnv.Search_Ma();
              break;
            case 2:
              dsnv.Search_Ho();
              break;
            case 3:
              dsnv.Search_Ten();
              break;
            case 4:
              dsnv.Search_Luong();
              break;
            case 5:
              dsnv.Search_ChucVu();
              break;
            default:
              System.out.println("Lua chon khong hop le!");
              break;
          }
        }
        break;
      case 6:
        
          System.out.println("Nhap lua chon thong ke (1 theo luong , 2 theo chuc vu )");
          int subChoice = sc.nextInt();
          sc.nextLine();
          switch (subChoice) {
            case 1:
              dsnv.ThongKe_Luong();
              break;
            case 2:
              dsnv.ThongKe_ChucVu();
        break;

      default:
        break;
    }
}
}
}