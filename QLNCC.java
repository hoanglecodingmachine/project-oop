import java.util.Scanner;
public class QLNCC extends MainQLBH{
  private static Scanner sc = new Scanner(System.in);
  public void MainQLNCC(){
  System.out.println("1 xuat, 2 them, 3 sua, 4 xoa, 5 tim kiem , 6 thong ke ");
    int choice = sc.nextInt();
    sc.nextLine();
    switch (choice) {
      case 1:
        dsncc.xuat();
        break;
      case 2:
        dsncc.them();
        break;
      case 3:
        {
          dsncc.sua();
        }
        break;
      case 4:
        {
          dsncc.xoa();
        }
        break;
      case 5:
        {
          System.out.println("Nhap lua chon tim kiem (1ma nha cung cap,2so dien thoai,3 dia chi ,4 email)");
          int subChoice = sc.nextInt();
          sc.nextLine();
          switch (subChoice) {
              case 1:
                dsncc.Search_Ma();
                break;
              case 2:
                dsncc.Search_SoDienThoai();
                break;
              case 3:
                dsncc.Search_DiaChi();
                break;
              case 4:
                dsncc.Search_Email();
                break;
              default:
                System.out.println("Lua chon khong hop le!");
                break;
            }
        }
        break;
      case 6:
        {
          System.out.println("Thong ke (1 theo dia chi  )");
          int tk = sc.nextInt();
          sc.nextLine();  
          switch (tk) {
              case 1:
                dsncc.ThongKe_DiaChi();
                break;
              default:
                System.out.println("Lua chon khong hop le!");
                break;
          }
        }
        break;
      default:
        System.out.println("Lua chon khong hop le!");
        break;
    }
}
}