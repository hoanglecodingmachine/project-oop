import java.util.Scanner;

public class QLPNH extends MainQLBH {
  private static Scanner sc = new Scanner(System.in);
  // Tính tổng tiền cho từng hóa đơn dựa trên chi tiết hóa đơn
  public void TinhTienTong() {
    // Lấy mảng hóa đơn và mảng chi tiết hóa đơn
    PhieuNhapHang[] arrPNH = dspnh.getDanhSachPhieuNhapHang();
    ChiTietPhieuNhapHang[] arrCT = dsctpnh.getChiTietPhieuNhapHang();
    int soPNH = dspnh.getSoLuongDanhSachPhieuNhapHang();
    int soCT = dsctpnh.getSoLuongChiTietPhieuNhapHang();

    for (int i = 0; i < soPNH; i++) {
      double tong = 0.0;
      if (arrPNH == null || arrPNH[i] == null) continue;
      String maPNH = arrPNH[i].getMaPhieuNhapHang();
      // Cộng tất cả chi tiết có cùng mã phiếu nhập hàng
      for (int j = 0; j < soCT; j++) {
        if (arrCT == null || arrCT[j] == null) continue;
        if (maPNH.equalsIgnoreCase(arrCT[j].getMaPhieuNhapHang())) {
          tong += arrCT[j].getTongTien();
        }
      }
      arrPNH[i].setThanhTien(tong);
    }
  }

  // Menu tối thiểu cho quản lý phieu nhan hang (đảm bảo cú pháp hợp lệ)
  public void mainQLPNH() {
    PhieuNhapHang[] arrPNH = dspnh.getDanhSachPhieuNhapHang();
    ChiTietPhieuNhapHang[] arrCT = dsctpnh.getChiTietPhieuNhapHang();
    int soPNH = dspnh.getSoLuongDanhSachPhieuNhapHang();
    int soCT = dsctpnh.getSoLuongChiTietPhieuNhapHang();
    System.out.println("Nhap lua chon (1xuat,2them,3sua,4xoa,5timkiem,6thongke)");
    int choice = sc.nextInt();
    sc.nextLine();
    switch (choice) {
      case 1:
    TinhTienTong();
    if (soPNH == 0) {
        System.out.println("Chua co phieu nhap hang nao!");
        return;
    }

    for (int i = 0; i < soPNH; i++) {
        if (arrPNH[i] == null) continue;

        System.out.println("\n==============================");
        System.out.println("Phieu Nhap Hang: " + arrPNH[i].getMaPhieuNhapHang());
        arrPNH[i].xuat(); // giả sử bạn có hàm xuat() trong PhieuNhapHang

        System.out.println("---- CHI TIẾT Phieu Nhap Hang ----");
        for (int j = 0; j < soCT; j++) {
            if (arrCT[j] == null) continue;
            if (arrPNH[i].getMaPhieuNhapHang().equalsIgnoreCase(arrCT[j].getMaPhieuNhapHang())) {
                arrCT[j].xuat(); // giả sử bạn có hàm xuat() trong ChiTietPhieuNhapHang
            }
        }     
    }
        break;
      case 2:
        ThemPhieuNhapHang();
        break;
      case 3:
        System.out.println("=== SỬA THÔNG TIN ===");
        System.out.println("1. Sửa phieu nhap hang");
        System.out.println("2. Sửa chi tiết phieu nhap hang");
        System.out.println("3. Quay lại");
        System.out.print("Nhập lựa chọn: ");
    
    int ch = sc.nextInt();
    sc.nextLine();
    switch (ch) {
        case 1:
            dspnh.sua(); // gọi phương thức sửa 
            break;
        case 2:
            dsctpnh.sua(); // gọi phương thức sửa chi tiết 
            break;
        case 3:
            return;
        default:
            System.out.println("Lựa chọn không hợp lệ!");
    }
        break;
      case 4:
            System.out.println("=== XÓA DỮ LIỆU ===");
    System.out.println("1. Xóa phieu nhap hang");
    System.out.println("2. Xóa chi tiết phieu nhap hang");
    System.out.println("3. Quay lại");
    System.out.print("Nhập lựa chọn: ");
    
    int ch1 = sc.nextInt();
    sc.nextLine();
    switch (ch1) {
        case 1:
            dspnh.xoa(); // xóa phieu nhap hang
            break;
        case 2:
            dsctpnh.xoa(); // xóa chi tiết phieu nhap hang
            break;
        case 3:
            return;
        default:
            System.out.println("Lựa chọn không hợp lệ!");
    }
        break;
      case 5:
        {
          System.out.println("tim kiem (1 phieu nhap hang,2 chi tiet phieu nhap hang) ");
          int ch2 = sc.nextInt();
          sc.nextLine();
          if(ch2 == 1){
            System.out.println("tim kiem (1 ma phieu nhap hang , 2 ma nha cung cap , 3 ngay thang , 4 thanh tien )");
            int ch3 = sc.nextInt();
            sc.nextLine();
            switch(ch3){
              case 1:
                dspnh.Search_Ma();
                break;
              case 2:
                dspnh.Search_MaNhaCungCap();
                break;
              case 3:
                dspnh.Search_NgayThang();
                break;
              case 4:
                dspnh.Search_ThanhTien();
                break;
              default:
                System.out.println("Lua chon khong hop le.");
            }
          }else{
            System.out.println("tim kiem chi tiet (1 ma chi tiet , 2 ma san pham, 3 so luong , 4 don gia) ");
            int ch4 = sc.nextInt();
            sc.nextLine();
            switch(ch4){
              case 1:
                dsctpnh.Search_Ma();
                break;
              case 2:
                dsctpnh.Search_MaSanPham();
                break;
              case 3:
                dsctpnh.Search_SoLuong();
                break;
              case 4:
                dsctpnh.Search_DonGia();
                break;
              default:
                System.out.println("Lua chon khong hop le.");
            }
          }
        break;
          }
      case 6:
        {
          System.out.println("thong ke (1 phieu nhap hang,2 chi tiet phieu nhap hang) ");
          int ch5 = sc.nextInt();
          sc.nextLine();
          if(ch5 == 1){
            System.out.println("thong ke (1 theo don gia , 2 theo ngay thang )");
            int ch6 = sc.nextInt();
            sc.nextLine();
            switch(ch6){
              case 1:
                dspnh.ThongKe_ThanhTien();
                break;
              case 2:
                dspnh.ThongKe_NgayNhap();
                break;
              default:
                System.out.println("Lua chon khong hop le.");
            }
          }else{
            System.out.println("thong ke chi tiet (1 theo don gia , 2 theo so luong )");
            int ch7 = sc.nextInt();
            sc.nextLine();
            switch(ch7){
              case 1:
                dsctpnh.ThongKe_DonGia();
                break;
              case 2:
                dsctpnh.ThongKe_SoLuong();
                break;
              default:
                System.out.println("Lua chon khong hop le.");
            }
          }
        }
        break;
      default:
        System.out.println("Lua chon khong hop le.");
    }
  }
public void ThemPhieuNhapHang() {
    // Nhập thông tin phiếu nhập
    PhieuNhapHang pnh = new PhieuNhapHang();
    pnh.nhap();
    dspnh.Them(pnh);

    System.out.print("Nhập số lượng chi tiết phiếu nhập hàng: ");
    int soLuongCT = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < soLuongCT; i++) {
        System.out.println("---- Nhập chi tiết phiếu nhập hàng thứ " + (i + 1) + " ----");
        ChiTietPhieuNhapHang ct = new ChiTietPhieuNhapHang();
        ct.nhap();

        // Gắn mã phiếu nhập cho chi tiết
        ct.setMaPhieuNhapHang(pnh.getMaPhieuNhapHang());

        // Thêm chi tiết vào danh sách chi tiết phiếu nhập
        dsctpnh.Them(ct);

        // **Cập nhật số lượng sản phẩm trong kho (TĂNG SỐ LƯỢNG)**
        for (int j = 0; j < dssp.getNum(); j++) {
            if (dssp.getSP()[j].getMaSP().equalsIgnoreCase(ct.getMaSanPham())) {
                int soLuongMoi = dssp.getSP()[j].getSoLuong() + ct.getSoLuong();
                dssp.getSP()[j].setSoLuong(soLuongMoi);
                break;
            }
        }
    }

    // Cập nhật tổng tiền cho phiếu nhập
    TinhTienTong();

    System.out.println(">> Đã thêm phiếu nhập hàng và chi tiết thành công!");
}


}