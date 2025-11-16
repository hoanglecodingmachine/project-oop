import java.util.Scanner;
public class QLSP extends MainQLBH {
  private static Scanner sc = new Scanner(System.in);
 public void mainQLSP() {
    int choice = -1;
    do {
        System.out.println("\n=== MENU QUAN LY SAN PHAM ===");
        System.out.println("1. Xuat danh sach");
        System.out.println("2. Them san pham");
        System.out.println("3. Sua san pham");
        System.out.println("4. Xoa san pham");
        System.out.println("5. Tim kiem san pham");
        System.out.println("6. Thong ke san pham");
        System.out.println("0. Quay lai MENU CHINH");
        System.out.print("Nhap lua chon: ");
        try {
            choice = sc.nextInt();
            sc.nextLine();
        } catch (java.util.InputMismatchException e) {
            System.out.println(" Lỗi: vui lòng nhập một số nguyên!");
            sc.nextLine();
            continue;
        }

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
                System.out.println("Nhap lua chon tim kiem (1 ma san pham, 2 ten san pham, 3 don gia ,4 so luong ,5 he dieu hanh ,6 dung luong, 7 ban phim , 8 thoi gian thoai):");
                try {
                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    switch (subChoice) {
                        case 1: dssp.Search_Ma(); break;
                        case 2: dssp.Search_Ten(); break;
                        case 3: dssp.Search_DonGia(); break;
                        case 4: dssp.Search_SoLuong(); break;
                        case 5: dssp.Search_HeDieuHanh(); break;
                        case 6: dssp.Search_DungLuong(); break;
                        case 7: dssp.Search_BanPhim(); break;
                        case 8: dssp.Search_ThoiGianThoai(); break;
                        default: System.out.println("Lua chon khong hop le!"); break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println(" Lỗi: vui lòng nhập một số nguyên!");
                    sc.nextLine();
                }
                break;
            case 6:
                System.out.println("Nhap lua chon thong ke (1 don gia, 2 so luong, 3 he dieu hanh , 4 dung luong , 5 ban phim , 6 thoi gian goi):");
                try {
                    int subChoice2 = sc.nextInt();
                    sc.nextLine();
                    switch (subChoice2) {
                        case 1: dssp.ThongKe_DonGia(); break;
                        case 2: dssp.ThongKe_SoLuong(); break;
                        case 3: dssp.ThongKe_HeDieuHanh(); break;
                        case 4: dssp.ThongKe_DungLuong(); break;
                        case 5: dssp.ThongKe_BanPhim(); break;
                        case 6: dssp.ThongKe_ThoiGianGoi(); break;
                        default: System.out.println("Lua chon khong hop le!"); break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println(" Lỗi: vui lòng nhập một số nguyên!");
                    sc.nextLine();
                }
                break;
            case 0:
                System.out.println("Quay lai menu chinh...");
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                break;
        }
    } while (choice != 0);
}

}
