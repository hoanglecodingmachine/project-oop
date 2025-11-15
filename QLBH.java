import java.util.Scanner;
public class QLBH extends MainQLBH {
    private static Scanner sc = new Scanner(System.in);
    public void mainQLBH() {
        System.out.println("Nhap lua chon (1xuat,2them,3timkiem , 4 thong ke )");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                dsbh.xuat();
                break;
            case 2:
                dsbh.them();
                break;
            case 3:
                {
                    System.out.println("Nhap lua chon tim kiem (1 ma bao hanh , 2 ma san pham, 3 thoi gian bao hanh )");
                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    switch (subChoice) {
                        case 1:
                            dsbh.Search_Ma();
                            break;
                        case 2:
                            dsbh.Search_MaSanPham();
                            break;
                        case 3:
                            dsbh.Search_ThoiGianBaoHanh();
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }
                }
                break;
            case 4:
                {
                    System.out.println("Thong ke theo thoi gian bao hanh:");
                    dsbh.ThongKe_ThoiGianBaoHanh();
                }
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                break;
        }
    }
}