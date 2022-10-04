package entity;

import chucnang.InputData;
import chucnang.ShowData;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Diem implements Serializable, InputData, ShowData {
    private MonHoc monHoc;
    private float diem;

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mon hoc: ");
        String tenMonHoc = sc.nextLine();
        int n = MonHoc.getListMonHoc().length;
        for(int i =0; i<n; i++){
            if(MonHoc.getListMonHoc()[i]!= null && tenMonHoc.equalsIgnoreCase(MonHoc.getListMonHoc()[i].getTenMH())){
                this.monHoc = MonHoc.getListMonHoc()[i];
                break;
            }
            if(MonHoc.getListMonHoc()[i]==null){
                System.out.println("Mon hoc nay khong ton  tai!");
                return;
            }
        }
        System.out.print("Nhap diem: ");
        float diem =-1;
        while (true){
            diem = nhapDiem(diem);
            if(diem >=0 && diem <=10){
                break;
            }
            else {
                System.err.println("Nhap diem tu 0 den 10!");
            }
        }
        this.diem = diem;

    }

    public static float nhapDiem(float diem){
        Scanner sc = new Scanner(System.in);
        try {
            diem = sc.nextFloat();
        }catch (InputMismatchException ie){
            System.err.print("Nhap khong hop le!");
        }
        return diem;
    }

    @Override
    public void showData() {
        System.out.printf("%-20s %f", monHoc.getTenMH(), diem );
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
        Diem other= (Diem) obj;
        return this.monHoc.getMaMH()==other.monHoc.getMaMH();
    }
}
