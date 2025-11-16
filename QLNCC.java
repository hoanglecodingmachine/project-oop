import java.util.Scanner;

public class QLNCC extends MainQLBH {
    private static Scanner sc = new Scanner(System.in);

    public void MainQLNCC() {
        int choice;
        do {
            System.out.println("\n=== MENU QUAN LY NHA CUNG CAP ===");
            System.out.println("1. Xuat danh sach");
            System.out.println("2. Them nha cung cap");
            System.out.println("3. Sua nha cung cap");
            System.out.println("4. Xoa nha cung cap");
            System.out.println("5. Tim kiem");
            System.out.println("6. Thong ke");
            System.out.println("0. Quay lai MENU CHINH");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    dsncc.xuat();
                    break;
                case 2:
                    dsncc.them();
                    break;
                case 3:
                    dsncc.sua();
                    break;
                case 4:
                    dsncc.xoa();
                    break;
                case 5:
                    System.out.println("Nhap lua chon tim kiem (1 ma nha cung cap, 2 so dien thoai, 3 dia chi, 4 email):");
                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    switch (subChoice) {
                        case 1: dsncc.Search_Ma(); break;
                        case 2: dsncc.Search_SoDienThoai(); break;
                        case 3: dsncc.Search_DiaChi(); break;
                        case 4: dsncc.Search_Email(); break;
                        default: System.out.println("Lua chon tim kiem khong hop le!"); break;
                    }
                    break;
                case 6:
                    System.out.println("Thong ke (1 theo dia chi):");
                    int tk = sc.nextInt();
                    sc.nextLine();
                    switch (tk) {
                        case 1: dsncc.ThongKe_DiaChi(); break;
                        default: System.out.println("Lua chon thong ke khong hop le!"); break;
                    }
                    break;
                case 0:
                    System.out.println("Quay lai MENU CHINH...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }

        } while (choice != 0);
    }
}
