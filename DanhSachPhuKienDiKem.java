import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
public class DanhSachPhuKienDiKem {
    private static Scanner sc = new Scanner(System.in);
    private PhuKienTangKem[] dsphukien;
    private int numphukien;

    public DanhSachPhuKienDiKem(){}
    public DanhSachPhuKienDiKem(PhuKienTangKem[] dsphukien, int numphukien) {
        this.dsphukien = dsphukien;
        this.numphukien = numphukien;
    }

    public PhuKienTangKem[] getDsphukien() {
        return dsphukien;
    }
    public void setDsphukien(PhuKienTangKem[] dsphukien) {
        this.dsphukien = dsphukien;
    }
    public int getNumphukien() {
        return numphukien;
    }
    public void setNumphukien(int numphukien) {
        this.numphukien = numphukien;
    }
    public void nhap(){
        System.out.print("Nhap so luong phu kien can them: ");
        int numphukien= sc.nextInt();
        sc.nextLine();
        dsphukien= new PhuKienTangKem[numphukien];
        for(int i=0;i<numphukien;i++){
            System.out.println("---- Nhap phu kien thu "+(i+1)+" ----");
            dsphukien[i] = new PhuKienTangKem();
            dsphukien[i].nhap();
        }
    }
    public void xuat(){
        for(int i=0;i<numphukien;i++){
            dsphukien[i].xuat();
        }
    }
public void DocFile(String tenFile) {
    try {
        // ======= BƯỚC 1: ĐẾM SỐ DÒNG =======
        int count = 0;
        Scanner scCount = new Scanner(new File(tenFile), "UTF-8");
        while (scCount.hasNextLine()) {
            String line = scCount.nextLine().trim();
            if (!line.isEmpty()) count++;
        }
        scCount.close();

        if (count == 0) {
            System.out.println("⚠️ File rỗng hoặc không có dòng hợp lệ!");
            return;
        }

        // ======= BƯỚC 2: CẤP PHÁT MẢNG =======
        dsphukien = new PhuKienTangKem[count];
        numphukien = 0;

        // ======= BƯỚC 3: ĐỌC FILE THẬT =======
        Scanner scFile = new Scanner(new File(tenFile), "UTF-8");
        int lineNumber = 0;

        while (scFile.hasNextLine()) {
            String line = scFile.nextLine().trim();
            lineNumber++;
            if (line.isEmpty()) continue;

            // Loại bỏ BOM nếu có
            line = line.replace("\uFEFF", "");

            String[] p = line.split("-");
            if (p.length != 3) {
                System.out.println("⚠️ Dữ liệu không hợp lệ ở dòng " + lineNumber + ": " + line);
                continue;
            }

            try {
                String maphukien = p[0].trim();
                String tenphukien = p[1].trim();
                String loai = p[2].trim();

                PhuKienTangKem pk1 = new PhuKienTangKem(maphukien, tenphukien, loai);
                dsphukien[numphukien++] = pk1;
            } catch (Exception ex) {
                System.out.println("⚠️ Lỗi tạo đối tượng PhuKienTangKem ở dòng " + lineNumber + ": " + line);
                ex.printStackTrace();
            }
        }

        scFile.close();
        System.out.println("✅ Đã đọc dữ liệu phụ kiện thành công! Tổng: " + numphukien);

    } catch (java.io.FileNotFoundException fnf) {
        System.out.println("❌ File không tìm thấy: " + tenFile);
        fnf.printStackTrace();
    } catch (Exception e) {
        System.out.println("❌ Lỗi đọc file '" + tenFile + "': " 
                + (e.getMessage() != null ? e.getMessage() : e.toString()));
        e.printStackTrace();
    }
}

    public void them(PhuKienTangKem pk1){
        dsphukien = Arrays.copyOf(dsphukien, numphukien + 1);
        dsphukien[numphukien] = pk1;
        numphukien++;
        System.out.println("Da them phu kien thanh cong!");
    }
    public void them(){
        PhuKienTangKem pk1 = new PhuKienTangKem();
        System.out.println("---- Nhap phu kien can them ----");
        pk1.nhap();
        them(pk1);
    }
    public void xoa(String ma){
        boolean found = false;
        for(int i=0;i<numphukien;i++){
            if(dsphukien[i].getMaphukien().equalsIgnoreCase(ma)){
                found = true;
                for(int j=i;j<numphukien-1;j++){
                    dsphukien[j] = dsphukien[j+1];
                }
                dsphukien = Arrays.copyOf(dsphukien, numphukien - 1);
                numphukien--;
                System.out.println("Da xoa phu kien co ma: " + ma);
                break;
            }
        }
        if(!found){
            System.out.println("Khong tim thay phu kien co ma: " + ma);
        }
    }
    public void xoa(){
        System.out.print("Nhap ma phu kien can xoa: ");
        String ma = sc.nextLine();
        xoa(ma);
    }
    public void sua(String ma){
        boolean found = false;
        for(int i=0;i<numphukien;i++){
            if(dsphukien[i].getMaphukien().equalsIgnoreCase(ma)){
                found = true;
                System.out.println("nhap lua chon de sua (1 ten phu kien, 2 loai )");
                int subChoice = sc.nextInt();
                switch (subChoice) {
                    case 1:
                        System.out.println("---- Nhap ten moi cho san pham ----");
                        dsphukien[i].setTenphukien(sc.nextLine());
                        System.out.println("Da sua phu kien co ma: " + ma);
                        break;
                    case 2:
                        System.out.println("---- Nhap loai moi cho san pham ----");
                        dsphukien[i].setLoai(sc.nextLine());
                        System.out.println("Da sua phu kien co ma: " + ma);
                        break;
                    default:
                        break;
                }
            }
        }
        if(!found){
            System.out.println("Khong tim thay phu kien co ma: " + ma);
        }
    }
    public void sua(){
        System.out.print("Nhap ma phu kien can sua: ");
        String ma = sc.nextLine();
        sua(ma);
    }
    public PhuKienTangKem Search_Ma(String ma){
        boolean found = false;
        for(int i=0;i<numphukien;i++){
            if(dsphukien[i].getMaphukien().equalsIgnoreCase(ma)){
                found = true;
                System.out.println("Phu kien tim thay:");
                dsphukien[i].xuat();
                return dsphukien[i];
            }
        }
        if(!found){
            System.out.println("Khong tim thay phu kien co ma: " + ma);
        }
        return null;
    }
    public void Search_Ma(){
        System.out.print("Nhap ma phu kien can tim: ");
        String ma = sc.nextLine();
        Search_Ma(ma);
    }
    public PhuKienTangKem[] Search_Ten(String ten){
        boolean found = false;
        PhuKienTangKem[] result = new PhuKienTangKem[0];
        int count = 0;
        for(int i=0;i<numphukien;i++){
            if(dsphukien[i].getTenphukien().equalsIgnoreCase(ten)){
                found = true;
                dsphukien[i].xuat();
                result = Arrays.copyOf(result, count + 1);
                result[count] = dsphukien[i];
                count++;
            }
        }
        if(!found){
            System.out.println("Khong tim thay phu kien co ten: " + ten);
            return null;
        }
        return result;
    }
    public void Search_Ten(){
        System.out.print("Nhap ten phu kien can tim: ");
        String ten = sc.nextLine();
        Search_Ten(ten);
    }
    public PhuKienTangKem[] Search_Loai(String loai){
        boolean found = false;
        PhuKienTangKem[] kq = new PhuKienTangKem[0];
        int count = 0;
        for(int i = 0 ; i < numphukien; i++){
            if(dsphukien[i].getLoai().equalsIgnoreCase(loai)){
                found = true;
                dsphukien[i].xuat();
                kq = Arrays.copyOf(kq, count ++);
                kq[count] = dsphukien[i];
                count++;
            }
        }
        if(!found){
            System.out.println("khong tim thay loai");
            return null;
        }
        return kq;
    }
    public void Search_Loai(){
        System.out.println("nhap loai phu kien can tim ");
        String pk1 = sc.nextLine();
        Search_Loai(pk1);
    }
// ...existing code...
public int[] ThongKe_Loai(){
    int op_lung = 0, tai_nghe = 0, cuong_luc = 0;
    if (dsphukien == null) return new int[]{0,0,0};

    for (int i = 0; i < numphukien; i++) {
        String loai = dsphukien[i].getLoai();
        if (loai.equalsIgnoreCase("oplung")) {
            op_lung++;
        } else if (loai.equalsIgnoreCase("tainghe")) {
            tai_nghe++;
        } else {
            cuong_luc++;
        }
    }

    System.out.println("so luong phu kien op lung la " + op_lung);
    System.out.println("so luong phu kien tai nghe la " + tai_nghe);
    System.out.println("so luong phu kien cuong luc la " + cuong_luc);

    return new int[]{op_lung, tai_nghe, cuong_luc};
}
// ...existing code...
    public void GhiFile(String tenFile){
        try(PrintWriter pw = new PrintWriter(new FileWriter(tenFile))){
            for(int i=0;i<numphukien;i++){
                String line = "";
                line = String.join("-", dsphukien[i].getMaphukien(), dsphukien[i].getTenphukien());
                pw.println(line);
            }
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
}
