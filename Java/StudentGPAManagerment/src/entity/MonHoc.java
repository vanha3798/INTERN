package entity;

import chucnang.InputData;
import chucnang.ShowData;
import mainrun.MainRun;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MonHoc implements Serializable, InputData, ShowData {

    private static int AUTO_ID =-1;
    private static MonHoc[] listMonHoc = new MonHoc[100];
    private int maMH;
    private String tenMH;
    private int soTinChi;
    private String loaiMon;

    enum LoaiMon {
        DC("Dai cuong"), CSN("Co so nganh"), CN("Chuyen nganh");
        private String value;
        private LoaiMon(String loaiMon){
            this.value = loaiMon;
        }
    }

    public MonHoc() {
        if(MainRun.coDuLieuMonHoc()){
            for(int i=0; i<listMonHoc.length; i++){
                if(listMonHoc[i]==null){
                    AUTO_ID= listMonHoc[i-1].maMH + 1;
                    break;
                }
            }
        }
        else {
            AUTO_ID = 10000;
        }
        this.maMH = AUTO_ID;
    }

    public static MonHoc[] getListMonHoc() {
        return listMonHoc;
    }

    public static void setListMonHoc(MonHoc[] listMonHoc) {
        MonHoc.listMonHoc = listMonHoc;
    }

    public int getMaMH() {
        return maMH;
    }

    public void setMaMH(int maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }

    @Override
    public void inputData() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Ten mon hoc: ");
        this.tenMH = sc.nextLine();
        System.out.print("So tin chi: ");
        int STC =-1;
        while (STC<1){
            STC=nhapSTC(STC);
            if(STC < 1){
                System.out.println("So tin chi phai lon hon 0");
            }
        }
        this.soTinChi = STC;
        System.out.println("Loai mon: ");
        System.out.println("1. Dai cuong ");
        System.out.println("2. Co so nganh ");
        System.out.println("3. Chuyen nganh ");
        int choice =-1;
        while (choice<1 || choice >3){
            choice=luaChon(choice);
            if(choice<1 || choice >3){
                System.out.println("Nhap lai");
            }
        }
        switch (choice){
            case 1:
                this.loaiMon = LoaiMon.DC.value;
                break;
            case 2:
                this.loaiMon = LoaiMon.CSN.value;
                break;
            case 3:
                this.loaiMon = LoaiMon.CN.value;
                break;
        }
    }

    public static int luaChon(int choice) {
        Scanner sc= new Scanner(System.in);
        try{
            choice = sc.nextInt();
        }catch (InputMismatchException ie){
            System.err.println("Nhap khong hop le!");
        }
        return choice;
    }

    public static int nhapSTC(int stc) {
        Scanner sc= new Scanner(System.in);
        try{
            stc = sc.nextInt();
        }catch (InputMismatchException ie){
            System.err.println("Nhap khong hop le!");
        }
        return stc;
    }

    @Override
    public void showData() {
        System.out.printf("%-11d %-20s %-11s %s", maMH, tenMH, soTinChi, loaiMon+"\n");
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
        MonHoc other= (MonHoc) obj;
        return this.maMH==other.maMH;
    }
}
