import java.util.Scanner;
public class DienThoaiCoDien extends DienThoai{
    private static Scanner sc = new Scanner(System.in);
    private String banphim;
    private int thoigianthoai;
    public DienThoaiCoDien(){}
    public DienThoaiCoDien(String masp,String tensp,int soluong,String donvitien,float dongia,String banphim, int thoigianthoai){
        super(masp,tensp,soluong,donvitien,dongia);
        this.banphim = banphim;
        this.thoigianthoai = thoigianthoai;
    }
    public DienThoaiCoDien(DienThoaiCoDien other){
        super(other);
        this.banphim = other.banphim;
        this.thoigianthoai = other.thoigianthoai;
    }
    public String getBanPhim(){
        return banphim;
    }
    public void setBanPhim(String banphim){
        this.banphim = banphim;
    }
    public int getThoiGianThoai(){
        return thoigianthoai;
    }
    public void setThoiGianThoai(int thoigianthoai){
        this.thoigianthoai = thoigianthoai;
    }
    @Override public void nhap(){
        super.nhap();
        System.out.println("nhap kieu ban phim");
        banphim = sc.nextLine();
        System.out.println("nhap thoi gian thoai ");
        thoigianthoai = sc.nextInt();
        sc.nextLine();
    }
@Override
public void xuat() {
    super.xuat(); // gọi hàm xuất của DienThoai
    System.out.printf(" %-15s %-10d%n", banphim, thoigianthoai);
}


    @Override public double Tinh_Tien_SanPham(){
        return getSoLuong()*getDonGia();
    }
}