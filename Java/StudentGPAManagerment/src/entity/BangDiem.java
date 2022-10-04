package entity;

import chucnang.InputData;
import chucnang.ShowData;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class BangDiem implements Serializable, InputData, ShowData {
    private static BangDiem[] listBangDiem = new BangDiem[100];
    private SinhVien sinhVien;
    private Diem[] listDiem = new Diem[100];

    public static BangDiem[] getListBangDiem() {
        return listBangDiem;
    }

    public static void setListBangDiem(BangDiem[] listBangDiem) {
        BangDiem.listBangDiem = listBangDiem;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public Diem[] getListDiem() {
        return listDiem;
    }

    public void setListDiem(Diem[] listDiem) {
        this.listDiem = listDiem;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        String tenSinhVien;
        System.out.print("Nhap sinh vien: ");
        tenSinhVien = sc.nextLine();
        int n = SinhVien.getListSinhVien().length;
        for(int i =0; i<n; i++){
            if(SinhVien.getListSinhVien()[i]!= null && SinhVien.getListSinhVien()[i].getHoTen().equalsIgnoreCase(tenSinhVien)){
                this.sinhVien = SinhVien.getListSinhVien()[i];
                break;
            }
            if(MonHoc.getListMonHoc()[i]==null){
                System.err.println("Sinh vien nay khong ton  tai!");
                return;
            }
        }
        System.out.print("Nhap so mon hoc can nhap diem: ");
        int soMon =-1;
        while (true){
            soMon= nhapSoMon(soMon, sc);
            if(soMon>0){
                break;
            }
            else {
                System.out.println("Nhap lai");
            }
        }
        for (int i=1; i<=soMon; i++){
            System.out.println("Nhap diem mon thu "+i);
            Diem diem = new Diem();
            diem.inputData();
            for (int j=0; j<listDiem.length; j++){
                if(listDiem[j]!=null && listDiem[j].equals(diem)){
                    System.err.println("Diem nay da ton tai!");
                    break;
                }
                if(listDiem[j]==null){
                    listDiem[j]=diem;
                    break;
                }
            }
        }
    }

    public static int nhapSoMon(int soMon, Scanner sc){
        try {
            soMon = sc.nextInt();
        }catch (InputMismatchException ie){
            System.err.print("Phai nhap so!");
        }
        return soMon;
    }

    public float GPA(){
        int tinChi =0;
        float tongDiem=0;
        for(int i= 0; i< getListDiem().length; i++){
            if(getListDiem()[i]!= null){
                tinChi+= getListDiem()[i].getMonHoc().getSoTinChi();
                tongDiem+= getListDiem()[i].getDiem();
            }
        }
        return tongDiem/ tinChi;
    }

    @Override
    public void showData() {
        System.out.println("Sinh vien: "+this.sinhVien.getHoTen());
        System.out.printf("%-20s %s", "Mon hoc", "Diem"+"\n");
        for(int i=0; i<listDiem.length; i++){
            if(listDiem[i]!=null){
                listDiem[i].showData();
            }
        }
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
        BangDiem other= (BangDiem) obj;
        return this.sinhVien.equals(other.sinhVien) ;
    }
}
