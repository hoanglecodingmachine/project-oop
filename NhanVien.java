import java.util.Scanner;

public class NhanVien {
    private String manhanvien;
    private String ho;
    private String ten;
    private double luong;
    private String chucvu;


    public NhanVien() {}

    // Constructor có tham số
    public NhanVien(String manhanvien, String ho,String ten, double luong, String chucvu) {
        this.manhanvien = manhanvien;
        this.ho = ho;
        this.ten = ten;
        this.luong = luong;
        this.chucvu = chucvu;
    }

    // Getter và Setter
    public String getMaNhanVien() { return manhanvien; }
    public void setMaNhanVien(String manhanvien) { this.manhanvien = manhanvien; }

    public String getHo() { return ho; }
    public void setHo(String ho) { this.ho = ho; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public double getLuong() { return luong; }
    public void setLuong(double luong) { this.luong = luong; }

    public String getChucVu() { return chucvu; }
    public void setChucVu(String chucvu) { this.chucvu = chucvu; }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên: ");
        manhanvien = sc.nextLine();
        System.out.print("Nhập họ: ");
        ho = sc.nextLine();
        System.out.print("Nhập ten: ");
        ten = sc.nextLine(); 
        System.out.print("Nhập lương: ");
        luong = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập chức vụ: ");
        chucvu = sc.nextLine();
    }
    public void xuat() {
        System.out.printf("%-15s %-20s %-10s %0f %15s",manhanvien,ho,ten,luong,chucvu);
    }
}
