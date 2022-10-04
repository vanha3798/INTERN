package mainrun;

import entity.BangDiem;
import entity.Diem;
import entity.MonHoc;
import entity.SinhVien;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static entity.SinhVien.*;

public class MainRun {

    public static void main(String[] args) throws IOException {
        loadData();
        mainMenu();
    }

    public static void mainMenu() throws IOException{
        while (true){
            System.out.println("1. Sinh vien");
            System.out.println("2. Mon hoc");
            System.out.println("3. Bang diem");
            System.out.println("4. Sap xep bang diem");
            System.out.println("5. GPA sinh vien");
            System.out.println("6. Thoat");
            System.out.println("Moi chon: ");

            int choice =-1;
            do{
                choice = luaChon(choice);
                if(choice <1 || choice >6){
                    System.out.println("Nhap tu 1 den 6");
                }
            }while (choice <1 || choice >6);

            switch (choice){
                case 1:
                    sinhVienMenu();
                    break;
                case 2:
                    monHocMenu();
                    break;
                case 3:
                    bangDiemMenu();
                    break;
                case 4:
                    sortBangDiem();
                    break;
                case 5:
                    break;
                case 6:
                    return;
            }
        }
    }

    public static void loadData() throws IOException{
        int i=0;
        try {
            FileInputStream fis = new FileInputStream("D:\\FileData\\GPA\\listSinhVien.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            SinhVien.setListSinhVien((SinhVien[]) ois.readObject());
            fis.close();
            ois.close();
        }catch (ClassNotFoundException clnfe){
            System.out.println(clnfe);
        }catch (IOException ioe){
            System.out.println(ioe);
        }

        i=0;
        try {
            FileInputStream fis = new FileInputStream("D:\\FileData\\GPA\\listMonHoc.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            MonHoc.setListMonHoc((MonHoc[]) ois.readObject());
            fis.close();
            ois.close();
        }catch (ClassNotFoundException clnfe){
            System.out.println(clnfe);
        }catch (IOException ioe){
            System.out.println(ioe);
        }

        try {
            FileInputStream fis = new FileInputStream("D:\\FileData\\GPA\\listBangDiem.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            BangDiem.setListBangDiem((BangDiem[]) ois.readObject());
            fis.close();
            ois.close();
        }catch (ClassNotFoundException clnfe){
            System.out.println(clnfe);
        }catch (IOException ioe){
            System.out.println(ioe);
        }
    }

    public static void sinhVienMenu(){
        while (true){
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. In danh sach sinh vien");
            System.out.println("3. Quay lai");
            System.out.println("Moi chon: ");

            int choice =-1;
            while (choice<1 || choice >3){
                choice= luaChon(choice);
                if(choice<1 || choice >3){
                    System.out.println("Nhap tu 1 den 3");
                }
            }

            switch (choice){
                case 1:
                    nhapSinhVien();
                    break;
                case 2:
                    inDanhSachSinhVien();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void nhapSinhVien(){
        int n= getListSinhVien().length;
        System.out.println("Nhap so sinh vien can them: ");
        int soSV=-1;
        while (soSV<1){
            soSV= luaChon(soSV);
            if(soSV<1){
                System.out.println("Nhap so lon hon 0");
            }
        }

        for(int i=1; i<=soSV; i++){
            System.out.println("Nhap sinh vien thu "+i);
            SinhVien sinhVien = new SinhVien();
            sinhVien.inputData();
            for (int j=0; j<n; j++){
                if(getListSinhVien()[j]!=null && getListSinhVien()[j].getHoTen().equalsIgnoreCase(sinhVien.getHoTen())){
                    System.err.println("Sinh vien nay da ton tai!");
                    break;
                }
                if(getListSinhVien()[j]==null){
                    getListSinhVien()[j] = sinhVien;
                    try {
                        ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("D:\\FileData\\GPA\\listSinhVien.txt"));
                        oss.writeObject(SinhVien.getListSinhVien());
                    }catch (IOException ioe){
                        System.out.println(ioe);
                    }
                    break;
                }
            }
        }
    }

    public static void inDanhSachSinhVien(){
        if(coDuLieuSinhVien()){
            System.err.printf("%-13s %-20s %-10s %-14s %s", "Ma sinh vien", "Ho ten", "Dia chi", "So dien thoai", "Lop"+"\n");
            for (int i = 0; i< getListSinhVien().length; i++){
                if(SinhVien.getListSinhVien()[i]!=null){
                    SinhVien.getListSinhVien()[i].showData();
                }
                else {
                    return;
                }
            }
        }
        else {
            System.err.println("Chua co du lieu sinh vien!");
            return;
        }
    }

    public static void monHocMenu(){
        while (true){
            System.out.println("1. Nhap danh sach mon hoc");
            System.out.println("2. In danh sach mon hoc");
            System.out.println("3. Quay lai");
            System.out.println("Moi chon: ");

            int choice =-1;
            while (choice<1 || choice >3){
                choice= luaChon(choice);
                if(choice<1 || choice >3){
                    System.out.println("Nhap tu 1 den 3");
                }
            }

            switch (choice){
                case 1:
                    nhapMonHoc();
                    break;
                case 2:
                    inDanhSachMonHoc();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void nhapMonHoc(){
        int n= MonHoc.getListMonHoc().length;
        System.out.println("Nhap so mon hoc can them: ");
        int soMH=-1;
        while (soMH<1){
            soMH= luaChon(soMH);
            if(soMH<1){
                System.out.println("Nhap so lon hon 0");
            }
        }

        for(int i=1; i<=soMH; i++){
            System.out.println("Nhap mon hoc thu "+i);
            MonHoc monHoc = new MonHoc();
            monHoc.inputData();
            for (int j=0; j<n; j++){
                if(MonHoc.getListMonHoc()[j]!=null && MonHoc.getListMonHoc()[j].getTenMH().equalsIgnoreCase(monHoc.getTenMH())){
                    System.err.println("Mon hoc nay da ton tai!");
                    break;
                }
                if(MonHoc.getListMonHoc()[j]==null){
                    MonHoc.getListMonHoc()[j] = monHoc;
                    try {
                        FileOutputStream fos = new FileOutputStream("D:\\FileData\\GPA\\listMonHoc.txt");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(MonHoc.getListMonHoc());
                        fos.close();
                        oos.close();
                    }catch (IOException ioe){
                        System.out.println(ioe);
                    }
                    break;
                }
            }
        }
    }

    public static void inDanhSachMonHoc(){
        if(coDuLieuMonHoc()){
            System.err.printf("%-11s %-20s %-11s %s", "Ma mon hoc", "Ten mon hoc", "So tin chi", "Loai mon"+"\n");
            for (int i=0; i<MonHoc.getListMonHoc().length; i++){
                if(MonHoc.getListMonHoc()[i]!=null){
                    MonHoc.getListMonHoc()[i].showData();
                }
                else {
                    return;
                }
            }
        }
        else {
            System.err.println("Chua co du lieu mon hoc!");
            return;
        }
    }

    public static void bangDiemMenu(){
        while (true){
            System.out.println("1. Nhap bang diem");
            System.out.println("2. In bang diem");
            System.out.println("3. Quay lai");
            System.out.println("Moi chon: ");

            int choice =-1;
            while (choice<1 || choice >3){
                choice= luaChon(choice);
                if(choice<1 || choice >3){
                    System.out.println("Nhap tu 1 den 3");
                }
            }

            switch (choice){
                case 1:
                    if(coDuLieuSinhVien() && coDuLieuMonHoc()){
                        nhapBangDiem();
                    }
                    else {
                        System.err.println("Chua co du du lieu de nhap bang diem!");
                    }
                    break;
                case 2:
                    inBangDiem();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void nhapBangDiem(){
        System.out.println("Nhap so sinh vien can them diem: ");
        int soSV=-1;
        while (soSV<1){
            soSV= luaChon(soSV);
            if(soSV<1){
                System.out.println("Nhap so lon hon 0");
            }
        }

        for(int i=1; i<=soSV; i++){
            System.out.println("Nhap diem cho sinh vien thu "+i);
            BangDiem bangDiem = new BangDiem();
            bangDiem.inputData();
            if(bangDiem.getListDiem()==null){
                continue;
            }
            int n= BangDiem.getListBangDiem().length;
            for (int j=0; j<n; j++){
                if(BangDiem.getListBangDiem()[j]!=null && BangDiem.getListBangDiem()[j].equals(bangDiem)){
                    System.err.println("Sinh vien nay da nhap diem!");
                    break;
                }
                if(BangDiem.getListBangDiem()[j]==null){
                    BangDiem.getListBangDiem()[j] = bangDiem;
                    try {
                        FileOutputStream fos = new FileOutputStream("D:\\FileData\\GPA\\listBangDiem.txt");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(BangDiem.getListBangDiem());
                        fos.close();
                        oos.close();
                    }catch (IOException ioe){
                        System.out.println(ioe);
                    }
                    break;
                }
            }
        }
    }

    public static void inBangDiem(){
        if(coDuLieuBangDiem()){
            int n= BangDiem.getListBangDiem().length;
            for (int i=0; i<n; i++){
                if(BangDiem.getListBangDiem()[i]!=null){
                    BangDiem.getListBangDiem()[i].showData();
                    System.out.println();
                }
                else {
                    return;
                }
            }
        }
        else {
            System.err.println("Chua co du lieu bang diem!");
            return;
        }
    }

    public static void sortBangDiem(){
        if(!coDuLieuBangDiem()){
            System.err.println("Chua co du lieu");
            return;
        }
        for(int i=0; i<BangDiem.getListBangDiem().length; i++){
            BangDiem bangDiemi = BangDiem.getListBangDiem()[i];
            for (int j=i+1; j<BangDiem.getListBangDiem().length; j++){
                BangDiem bangDiemj = BangDiem.getListBangDiem()[j];
                if( bangDiemi!= null && bangDiemj != null && bangDiemi.getSinhVien().getHoTen().compareToIgnoreCase(bangDiemj.getSinhVien().getHoTen()) < 0){
                    BangDiem bangDiem =BangDiem.getListBangDiem()[i];
                    BangDiem.getListBangDiem()[i] = BangDiem.getListBangDiem()[j];
                    BangDiem.getListBangDiem()[j] = bangDiem;
                }
            }
        }

        for(int i=0; i<BangDiem.getListBangDiem().length; i++){
            if(BangDiem.getListBangDiem()[i]!= null){
                for (int j =0; j< BangDiem.getListBangDiem()[i].getListDiem().length; j++){
                    Diem diemj = BangDiem.getListBangDiem()[i].getListDiem()[j];
                    for(int k =j+1; k< BangDiem.getListBangDiem()[i].getListDiem().length; k++){
                        Diem diemk = BangDiem.getListBangDiem()[i].getListDiem()[k];
                        if(diemj!= null && diemk!= null && diemj.getMonHoc().getTenMH() .compareToIgnoreCase(diemk.getMonHoc().getTenMH())<0){
                            Diem diem = BangDiem.getListBangDiem()[i].getListDiem()[j];
                            BangDiem.getListBangDiem()[i].getListDiem()[j] = BangDiem.getListBangDiem()[i].getListDiem()[k];
                            BangDiem.getListBangDiem()[i].getListDiem()[k] = diem;
                        }
                    }
                }
            }
        }

        for (int i=0; i< BangDiem.getListBangDiem().length; i++){
            if(BangDiem.getListBangDiem()[i]!= null){
                BangDiem.getListBangDiem()[i].showData();
            }
        }
    }

    public static void tinhGPA(){
        for(int i=0; i< BangDiem.getListBangDiem().length; i++){
            if(BangDiem.getListBangDiem()[i]!= null){
                System.out.println("Ten sinh vien: "+ BangDiem.getListBangDiem()[i].getSinhVien().getHoTen());
                System.out.println("Diem: "+ BangDiem.getListBangDiem()[i].GPA());
                System.out.println();
            }
        }
    }

    public static boolean coDuLieuSinhVien(){
        boolean check= false;
        for (int i = 0; i< getListSinhVien().length; i++){
            if(getListSinhVien()[i]!= null){
                check = true;
            }
        }
        return check;
    }

    public static boolean coDuLieuMonHoc(){
        boolean check= false;
        for (int i = 0; i< MonHoc.getListMonHoc().length; i++){
            if(MonHoc.getListMonHoc()[i]!= null){
                check = true;
            }
        }
        return check;
    }

    public static boolean coDuLieuBangDiem(){
        boolean check= false;
        for (int i = 0; i< BangDiem.getListBangDiem().length; i++){
            if(BangDiem.getListBangDiem()[i]!= null){
                check = true;
            }
        }
        return check;
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

}
