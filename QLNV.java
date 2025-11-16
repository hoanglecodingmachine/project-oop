import java.util.Scanner;

public class QLNV extends MainQLBH {
    private static Scanner sc = new Scanner(System.in);

    public void mainQLNV() {
        int choice;
        do {
            System.out.println("\n=== MENU QUAN LY NHAN VIEN ===");
            System.out.println("1. Xuat danh sach");
            System.out.println("2. Them nhan vien");
            System.out.println("3. Sua nhan vien");
            System.out.println("4. Xoa nhan vien");
            System.out.println("5. Tim kiem");
            System.out.println("6. Thong ke");
            System.out.println("0. Quay lai MENU CHINH");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();

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
                    System.out.println("Nhap lua chon tim kiem (1 ma nhan vien, 2 ho nhan vien, 3 ten nhan vien, 4 luong, 5 chuc vu):");
                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    switch (subChoice) {
                        case 1: dsnv.Search_Ma(); break;
                        case 2: dsnv.Search_Ho(); break;
                        case 3: dsnv.Search_Ten(); break;
                        case 4: dsnv.Search_Luong(); break;
                        case 5: dsnv.Search_ChucVu(); break;
                        default: System.out.println("Lua chon tim kiem khong hop le!"); break;
                    }
                    break;
                case 6:
                    System.out.println("Nhap lua chon thong ke (1 theo luong, 2 theo chuc vu):");
                    int tkChoice = sc.nextInt();
                    sc.nextLine();
                    switch (tkChoice) {
                        case 1: dsnv.ThongKe_Luong(); break;
                        case 2: dsnv.ThongKe_ChucVu(); break;
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
