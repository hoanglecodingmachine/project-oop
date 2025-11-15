import java.util.Scanner;
public class QLPK extends MainQLBH {
    private static Scanner sc = new Scanner(System.in);
    public void mainQLPKDK() {
        System.out.println("Nhap lua chon (1xuat,2them,3xoa,4 tim kiem , 5 thong ke )");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                dsphukien.xuat();
                break;
            case 2:
                {
                    dsphukien.them();
                }
                break;
            case 3:
                {
                    
                    dsphukien.xoa();
                }
                break;
            case 4:
                {
                    System.out.println("Nhap lua chon tim kiem (1 ma phu kien , 2 ten phu kien,3 loai phu kien )");
                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    switch (subChoice) {
                        case 1:
                            dsphukien.Search_Ma();
                            break;
                        case 2:
                            dsphukien.Search_Ten();
                            break;
                        case 3:
                            dsphukien.Search_Loai();
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }
                }
            case 5:
                dsphukien.ThongKe_Loai();
            default:
                System.out.println("Lua chon khong hop le!");
                break;
        }
    }
}