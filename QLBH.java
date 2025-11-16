import java.util.Scanner;

public class QLBH extends MainQLBH {
    private static Scanner sc = new Scanner(System.in);

    public void mainQLBH() {
        int choice;
        do {
            System.out.println("\n==== MENU QUẢN LÝ BẢO HÀNH ====");
            System.out.println("1. Xuat danh sach bao hanh");
            System.out.println("2. Them bao hanh");
            System.out.println("3. Tim kiem");
            System.out.println("4. Thong ke");
            System.out.println("0. Quay lai MENU CHINH");
            System.out.print("Nhap lua chon: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // === XUẤT ===
                case 1:
                    dsbh.xuat();
                    break;

                // === THÊM ===
                case 2:
                    dsbh.them();
                    break;

                // === TÌM KIẾM ===
                case 3:
                    System.out.println("\nNhap lua chon tim kiem:");
                    System.out.println("1. Ma bao hanh");
                    System.out.println("2. Ma san pham");
                    System.out.println("3. Thoi gian bao hanh");
                    System.out.print("Lua chon: ");
                    int subChoice = sc.nextInt();
                    sc.nextLine();

                    switch (subChoice) {
                        case 1: dsbh.Search_Ma(); break;
                        case 2: dsbh.Search_MaSanPham(); break;
                        case 3: dsbh.Search_ThoiGianBaoHanh(); break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }
                    break;

                // === THỐNG KÊ ===
                case 4:
                    System.out.println("\nThong ke theo thoi gian bao hanh:");
                    dsbh.ThongKe_ThoiGianBaoHanh();
                    break;

                // === QUAY LẠI ===
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
