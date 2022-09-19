package entity;

import java.util.Scanner;

public class MonHoc implements chucnang.inputData, chucnang.showData{
    private static int AUTO_ID=-1;
    private int maMonHoc;
    private String tenMonHoc;
    private int tongSoTiet;
    private int soTietLyThuyet;
    private int mucKinhPhi;

    public MonHoc(){
        if(AUTO_ID==-1){
            AUTO_ID=100;
        }
        else {
            AUTO_ID++;
        }
        this.maMonHoc=AUTO_ID;
    }

    public int getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(int maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public int getTongSoTiet() {
        return tongSoTiet;
    }

    public void setTongSoTiet(int tongSoTiet) {
        this.tongSoTiet = tongSoTiet;
    }

    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public void setSoTietLyThuyet(int soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }

    public int getMucKinhPhi() {
        return mucKinhPhi;
    }

    public void setMucKinhPhi(int mucKinhPhi) {
        this.mucKinhPhi = mucKinhPhi;
    }

    @Override
    public void inputData(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ten mon hoc: ");
        this.tenMonHoc=sc.nextLine();
        System.out.print("Tong so tiet: ");
        this.tongSoTiet=sc.nextInt();
        System.out.print("So tiet ly thuyet: ");
        int soTietLT=-1;
        while (true){
            soTietLT=sc.nextInt();
            if(soTietLT>=0 && soTietLT<=this.tongSoTiet){
                break;
            }
            System.err.print("So tiet ly thuyet khong duoc lon hon tong so tiet. Moi nhap lai: ");
        }
        this.soTietLyThuyet=soTietLT;
        System.out.print("Muc kinh phi: ");
        this.mucKinhPhi=sc.nextInt();
    }

    @Override
    public void showData(){
        System.out.printf("%-12d %-15s %-14d %-18d %d", this.maMonHoc, this.tenMonHoc, this.tongSoTiet, this.soTietLyThuyet, this.mucKinhPhi);
        System.out.println();
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(this!=obj){
            return false;
        }
        if(this.getClass()!=obj.getClass()){
            return false;
        }
        MonHoc other = (MonHoc) obj;
        return this.getMaMonHoc()==other.getMaMonHoc();
    }

    public int soTietThucHanh(){
        return this.tongSoTiet-this.soTietLyThuyet;
    }

    @Override
    public String toString(){
        return "Ma mon hoc: "+maMonHoc+"\nTen mon hoc: "+tenMonHoc+"\nTong so tiet: "+tongSoTiet+
                "\nSo tiet ly thuyet: "+soTietLyThuyet+"\nMuc kinh phi: "+mucKinhPhi;
    }

}
