import java.util.Scanner;
public class QLKH extends MainQLBH {
  private static Scanner sc = new Scanner(System.in);
  public void mainQLKH() {
    System.out.println("Nhap lua chon (1xuat,2them,3sua,4xoa,5timkiem,6thongke)");
    int choice = sc.nextInt();
    sc.nextLine();
    switch (choice) {
      case 1:
        dskh.xuat();
        break;
      case 2:
        dskh.them();
        break;
      case 3:
        dskh.sua();
        break;
      case 4:
        dskh.xoa();
        break;
      case 5:
        {
          System.out.println("Nhap lua chon tim kiem (1 ma khach hang , 2 ten khach hang , 3 so dien thoai , 4 do tuoi , 5 email, 6 gioi tinh )");
          int subChoice = sc.nextInt();
          sc.nextLine();
          switch (subChoice) {
            case 1:
              dskh.Search_MaKhachHang();
              break;
            case 2:
              dskh.Search_TenKhachHang();
              break;
            case 3:
              dskh.Search_SoDT_KhachHang();
              break;
            case 4:
              dskh.Search_DoTuoiKhachHang();
              break;
            case 5:
              dskh.Search_EmailKhachHang();
              break;
            case 6:
              dskh.Search_GioiTinhKhachHang();
              break;
            default:
              System.out.println("Lua chon khong hop le!");
              break;
          }
        break;
        }
      case 6:
        {
          System.out.println("thong ke (1 theo tuoi , 2 theo gioi tinh )");
          int ch = sc.nextInt();
          sc.nextLine();
          switch(ch){
            case 1:
              dskh.ThongKe_DoTuoi();
              break;
            case 2:
              dskh.ThongKe_GioiTinh();
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