package entity;

import chucnang.InputData;
import chucnang.ShowData;
import mainrun.MainRun;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SinhVien extends Object implements Serializable, InputData, ShowData {

    private static int AUTO_ID =-1;
    private static SinhVien[] listSinhVien = new SinhVien[100];
    private int maSV;
    private String hoTen;
    private String diaChi;
    private int SDT;
    private String lop;

    public SinhVien() {
        if(MainRun.coDuLieuSinhVien()){
            for(int i=0; i<listSinhVien.length; i++){
                if(listSinhVien[i]==null){
                    AUTO_ID= listSinhVien[i-1].maSV + 1;
                    break;
                }
            }
        }
        else {
            AUTO_ID = 10000;
        }
        this.maSV = AUTO_ID;
    }

    public static SinhVien[] getListSinhVien() {
        return listSinhVien;
    }

    public static void setListSinhVien(SinhVien[] listSinhVien) {
        SinhVien.listSinhVien = listSinhVien;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
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

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    @Override
    public void inputData() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Ten sinh vien: ");
        hoTen = sc.nextLine();
        System.out.print("Dia chi: ");
        diaChi = sc.nextLine();
        int sdt= -1;
        System.out.print("So dien thoai: ");
        while (sdt<0){
            sdt= nhapSDT(sdt);
        }
        SDT = sdt;
        System.out.print("Lop: ");
        lop =sc.nextLine();
    }

    public static int nhapSDT(int sdt) {
        Scanner sc= new Scanner(System.in);
        try{
            sdt = sc.nextInt();
        }catch (InputMismatchException ie){
            System.err.println("Nhap khong hop le! Nhap lai");
        }
        return sdt;
    }

    @Override
    public void showData() {
        System.out.printf("%-13d %-20s %-10s %-14d %s", maSV, hoTen, diaChi, SDT, lop+"\n");
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
        SinhVien other= (SinhVien) obj;
        return this.getMaSV()== other.getMaSV();
    }
}
