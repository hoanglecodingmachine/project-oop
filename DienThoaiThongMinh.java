import java.util.Scanner;
public class DienThoaiThongMinh extends DienThoai{
    private static Scanner sc = new Scanner(System.in);
    private String hedieuhanh;
    private String dungluong;
    public DienThoaiThongMinh(){}
    public DienThoaiThongMinh(String masp,String tensp,int soluong,String donvitien,double dongia,String hedieuhanh, String dungluong){
     super(masp,tensp,soluong,donvitien,dongia);
     this.hedieuhanh = hedieuhanh;
     this.dungluong = dungluong;   
    }
    public DienThoaiThongMinh(DienThoaiThongMinh other){
        super(other);
        this.hedieuhanh = other.hedieuhanh;
        this.dungluong = other.dungluong;
    }
    public DienThoaiThongMinh(String string, String string2, String string3, String string4, int int1, int int2,
            double double1, int int3, int int4, int int5) {
        
    }
    public String getHeDieuHanh(){
        return hedieuhanh;
    }
    public void setHeDieuHanh(String hedieuhanh){
        this.hedieuhanh = hedieuhanh;
    }
    public String getDungLuong(){
        return dungluong;
    }
    public void setDungLuong(String dungluong){
        this.dungluong = dungluong;
    }
    @Override 
    public void nhap(){
        super.nhap();
        System.out.println("nhap he dieu hanh cua may ");
        hedieuhanh = sc.nextLine();
        System.out.println("nhap dung luong cua may(128g,256g,512g) ");
        dungluong = sc.nextLine();
    }
    @Override
    public void xuat() {
        super.xuat();   // kế thừa phần in chung
        System.out.printf(" %-15s %-10s%n", hedieuhanh, dungluong);
    }

    @Override public double Tinh_Tien_SanPham(){
        return getSoLuong()*getDonGia();
    }
}