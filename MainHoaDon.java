import java.util.Scanner;
public class MainHoaDon {
   public static Scanner sc = new Scanner(System.in);
   private HoaDon[] hd ;
   private int numhd;
   private int soluongmua;
   public MainHoaDon(){}
   public MainHoaDon(HoaDon[] hd , int numhd , int soluongmua){
    this.hd = hd;
    this.numhd = numhd;
    this.soluongmua = soluongmua;
   }
   public void nhap(DanhSachCuaHangDienThoai[] sp,int num){
    String ma;
    System.out.println("vui long nhap so luong hoa don can nhap hom nay ");
    numhd = sc.nextInt();
    for(int i = 0 ; i < numhd ; i++){
        hd[i] = new HoaDon();
        hd[i].nhap();
        System.out.println("nhap so luong san pham mua ");
        soluongmua = sc.nextInt();
        for(int j = 0 ; i < soluongmua; j++){
           System.out.println("vui long nhap ma san pham mua ");
           ma = sc.nextLine();
           for(int c = 0 ; c < num ;c++){
            if(sp[c].Search_Ma(ma)){
                System.err.println("khong tim thay san pham ");
            }
           }
        }
    }
   }
}   
