import java.util.Scanner;
public class QLSP extends MainQLBH {
  private static Scanner sc = new Scanner(System.in);
  public void mainQLSP() {
    System.out.println("Nhap lua chon (1xuat,2them,3sua,4xoa,5timkiem,6thongke)");
    int choice = sc.nextInt();
    sc.nextLine();
    switch (choice) {
      case 1:
        dssp.xuat();
        break;
      case 2:
        dssp.Them();
        break;
      case 3:
        dssp.sua();
        break;
      case 4:
        dssp.xoa();
        break;
      case 5:
        {
          System.out.println("Nhap lua chon tim kiem (1ma san pham,2ten san pham,3don gia,4 so luong, 5 he dieu hanh , 6 dung luong , 7 ban phim , 8 thoi gian goi )");
          int subChoice = sc.nextInt();
          sc.nextLine();
          switch (subChoice) {
            case 1:
              dssp.Search_Ma();
              break;
            case 2:
              dssp.Search_Ten();
              break;
            case 3:
              dssp.Search_DonGia();
              break;
            case 4:
              dssp.Search_SoLuong();
              break;
            case 5:
              dssp.Search_HeDieuHanh();
              break;
            case 6:
              dssp.Search_DungLuong();
              break;
            case 7:
              dssp.Search_BanPhim();
              break;
            case 8:
              dssp.Search_ThoiGianThoai();
              break;
            default:
              System.out.println("Lua chon khong hop le!");
              break;
          }
        }
        break;
      case 6:
        {
          System.out.println("Nhap lua chon thong ke (1 theo don gia,2 theo so luong , 3 thong ke he dieu hanh, 4 thong ke dung luong   , 5 thong ke ban phim , 6 thong ke thoi gian goi  )");
          int subChoice = sc.nextInt();
          sc.nextLine();
          switch (subChoice) {
            case 1:
              dssp.ThongKe_DonGia();
              break;
            case 2:
              dssp.ThongKe_SoLuong();
              break;
            case 3:
              dssp.ThongKe_HeDieuHanh();
              break;
            case 4:
              dssp.ThongKe_DungLuong();
              break;
            case 5:
              dssp.ThongKe_BanPhim();
              break;  
            case 6: 
              dssp.ThongKe_ThoiGianGoi();
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
