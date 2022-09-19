package entity;

import java.text.Format;
import java.util.Scanner;

public class GiangVien implements chucnang.inputData, chucnang.showData {

    enum TrinhDo {
        GS_TS("Giao su - Tien sy"), PGS_TS("Pho giao su - Tien sy"), GVC("Giang vien chinh"), THS("Thac sy");
        private String value;

        private TrinhDo(String trinhDo) {
            this.value = trinhDo;
        }
    }
    private static int AUTO_ID=-1;
    private int maGV;
    private String hoTen;
    private String diaChi;
    private int SDT;
    private String trinhDo;

    public GiangVien(){
        if(AUTO_ID==-1){
            AUTO_ID=100;
        }
        else {
            AUTO_ID++;
        }
        this.maGV=AUTO_ID;
    }

    public int getMaGV() {
        return maGV;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    @Override
    public void inputData(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ho ten: ");
        this.hoTen=sc.nextLine();
        System.out.print("Dia chi: ");
        this.diaChi=sc.nextLine();
        System.out.print("So dien thoai: ");
        this.SDT=sc.nextInt();
        System.out.println("Trinh do: ");
        System.out.println("1. Giao su - Tien sy");
        System.out.println("2. Pho giao su - Tien sy");
        System.out.println("3. Giang vien chinh");
        System.out.println("4. Thac sy");
        int choice=-1;
        do{
            System.out.print("Moi chon: ");
            choice=sc.nextInt();
            if(choice>=1 && choice<=4){
                break;
            }
            else{
                System.err.println("Nhap khong hop le!");
            }
        }while (choice<1 || choice>4);
        switch (choice){
            case 1:
                this.trinhDo=TrinhDo.GS_TS.value;
                break;
            case 2:
                this.trinhDo=TrinhDo.PGS_TS.value;
                break;
            case 3:
                this.trinhDo=TrinhDo.GVC.value;
                break;
            case 4:
                this.trinhDo=TrinhDo.THS.value;
                break;
        }

    }

    @Override
    public void showData() {
        System.out.printf("%-15d %-16s %-12s %-11d %s", this.maGV, this.hoTen, this.diaChi, this.SDT, this.trinhDo);
        System.out.println();
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(this.getClass()!=obj.getClass()){
            return false;
        }
        GiangVien other= (GiangVien) obj;
        return this.getMaGV()== other.getMaGV();
    }

    @Override
    public  String toString(){
        return "Ma giang vien: "+maGV+"\nHo ten: "+hoTen+"\nDia chi: "+diaChi+
                "\nSDT: "+SDT+"\nTrinh do: "+trinhDo+"\n";
    }
}

