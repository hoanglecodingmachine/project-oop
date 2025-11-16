import java.util.Scanner;

public class QLKH extends MainQLBH {
    private static Scanner sc = new Scanner(System.in);

    public void mainQLKH() {
        int choice;
        do {
            System.out.println("\n=== MENU QUAN LY KHACH HANG ===");
            System.out.println("1. Xuat danh sach khach hang");
            System.out.println("2. Them khach hang");
            System.out.println("3. Sua khach hang");
            System.out.println("4. Xoa khach hang");
            System.out.println("5. Tim kiem");
            System.out.println("6. Thong ke");
            System.out.println("0. Quay lai MENU CHINH");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
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
                    System.out.println("Nhap lua chon tim kiem:");
                    System.out.println("1. Ma khach hang");
                    System.out.println("2. Ten khach hang");
                    System.out.println("3. So dien thoai");
                    System.out.println("4. Do tuoi");
                    System.out.println("5. Email");
                    System.out.println("6. Gioi tinh");
                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    switch (subChoice) {
                        case 1: dskh.Search_MaKhachHang(); break;
                        case 2: dskh.Search_TenKhachHang(); break;
                        case 3: dskh.Search_SoDT_KhachHang(); break;
                        case 4: dskh.Search_DoTuoiKhachHang(); break;
                        case 5: dskh.Search_EmailKhachHang(); break;
                        case 6: dskh.Search_GioiTinhKhachHang(); break;
                        default: System.out.println("Lua chon tim kiem khong hop le!"); break;
                    }
                    break;
                case 6:
                    System.out.println("Thong ke:");
                    System.out.println("1. Theo do tuoi");
                    System.out.println("2. Theo gioi tinh");
                    int tkChoice = sc.nextInt();
                    sc.nextLine();
                    switch (tkChoice) {
                        case 1: dskh.ThongKe_DoTuoi(); break;
                        case 2: dskh.ThongKe_GioiTinh(); break;
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
