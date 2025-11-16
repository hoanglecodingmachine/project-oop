import java.util.Scanner;

public class QLPK extends MainQLBH {
    private static Scanner sc = new Scanner(System.in);

    public void mainQLPKDK() {
        int choice;
        do {
            System.out.println("\n=== MENU QUAN LY PHU KIEN DI KEM ===");
            System.out.println("1. Xuat danh sach phu kien");
            System.out.println("2. Them phu kien");
            System.out.println("3. Xoa phu kien");
            System.out.println("4. Tim kiem");
            System.out.println("5. Thong ke");
            System.out.println("0. Quay lai MENU CHINH");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    dsphukien.xuat();
                    break;
                case 2:
                    dsphukien.them();
                    break;
                case 3:
                    dsphukien.xoa();
                    break;
                case 4:
                    System.out.println("Nhap lua chon tim kiem (1 ma phu kien, 2 ten phu kien, 3 loai phu kien):");
                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    switch (subChoice) {
                        case 1: dsphukien.Search_Ma(); break;
                        case 2: dsphukien.Search_Ten(); break;
                        case 3: dsphukien.Search_Loai(); break;
                        default: System.out.println("Lua chon tim kiem khong hop le!"); break;
                    }
                    break;
                case 5:
                    dsphukien.ThongKe_Loai();
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
