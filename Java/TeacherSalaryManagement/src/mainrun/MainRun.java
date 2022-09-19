package mainrun;

import data.ListGiangVien;
import data.ListKeKhaiGiangDay;
import data.ListMonHoc;
import entity.GiangVien;
import entity.KeKhaiGiangDay;
import entity.MonHoc;

import java.util.Scanner;

public class MainRun {

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
        while (true){
            System.out.println("---QUAN LY KE KHAI GIANG DAY---");
            System.out.println("1. Mon hoc");
            System.out.println("2. Giang vien");
            System.out.println("3. Ke khai giang day");
            System.out.println("4. Sap xep");
            System.out.println("5. Tien cong giang vien");
            System.out.println("6. Thoat");
            System.out.print("Moi chon: ");

            Scanner sc = new Scanner(System.in);
            int choice = -1;
            while (true){
                choice =sc.nextInt();
                if(choice>=1 && choice<=6){
                    break;
                }
                System.err.println("Nhap khong hop le. Moi nhap lai!");
            }
            switch (choice){
                case 1:
                    monHocMenu();
                    break;
                case 2:
                    giangVienMenu();
                    break;
                case 3:
                    keKhaiGiangDayMenu();
                    break;
                case 4:
                    sapXep();
                    break;
                case 5:
                    tinhTienCong();
                    break;
                case 6:
                    return;
            }
        }
    }

    public static void monHocMenu(){
        while (true){
            System.out.println("---MON HOC---");
            System.out.println("1. Nhap danh sach mon hoc moi");
            System.out.println("2. Danh sach mon hoc");
            System.out.println("3. Quay lai");
            Scanner sc = new Scanner(System.in);
            int choice = -1;
            while (true){
                choice =sc.nextInt();
                if(choice>=1 && choice<=3){
                    break;
                }
                System.err.println("Nhap khong hop le. Moi nhap lai!");
            }
            switch (choice){
                case 1:
                    nhapDanhSachMonHoc();
                    break;
                case 2:
                    inDanhSachMonHoc();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void nhapDanhSachMonHoc(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so mon hoc can nhap: ");
        int soMH=-1;
        while (true){
            soMH= sc.nextInt();
            if(soMH>=1){
                break;
            }
            System.err.println("Nhap khong hop le! Moi nhap lai: ");
        }
        for (int i=1;i<=soMH; i++ ){
            System.out.println("Nhap mon hoc thu "+i);
            for (int j=0; j< ListMonHoc.getListMH().length; j++){
                if(ListMonHoc.getListMH()[j]==null){
                    ListMonHoc.getListMH()[j]=new MonHoc();
                    ListMonHoc.getListMH()[j].inputData();
                    break;
                }
            }
        }
    }

    public static void inDanhSachMonHoc(){
        System.out.println("-------------------------DANH SACH MON HOC----------------------------------");
        System.out.printf("%-12s %-15s %-14s %-18s %s", "Ma mon hoc", "Ten mon hoc", "Tong so tiet", "So tiet ly thuyet", "Muc kinh phi"+"\n");
        for (int i=0; i<ListMonHoc.getListMH().length; i++){
            if(ListMonHoc.getListMH()[i]!=null){
                ListMonHoc.getListMH()[i].showData();
            }
        }
    }

    public static void giangVienMenu(){
        while (true){
            System.out.println("---GIANG VIEN---");
            System.out.println("1. Nhap danh sach giang vien moi");
            System.out.println("2. Danh sach giang vien");
            System.out.println("3. Quay lai");
            Scanner sc = new Scanner(System.in);
            int choice = -1;
            while (true){
                choice =sc.nextInt();
                if(choice>=1 && choice<=3){
                    break;
                }
                System.err.println("Nhap khong hop le. Moi nhap lai!");
            }
            switch (choice){
                case 1:
                    nhapDanhSachGiangvien();
                    break;
                case 2:
                    inDanhSachGiangVien();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void nhapDanhSachGiangvien(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so giang vien can nhap: ");
        int soGV=-1;
        while (true){
            soGV= sc.nextInt();
            if(soGV>=1){
                break;
            }
            System.err.println("Nhap khong hop le! Moi nhap lai: ");
        }
        for (int i=1;i<=soGV; i++ ){
            System.out.println("Nhap giang vien thu "+i);
            for (int j = 0; j< ListGiangVien.getListGV().length; j++){
                if(ListGiangVien.getListGV()[j]==null){
                    ListGiangVien.getListGV()[j]=new GiangVien();
                    ListGiangVien.getListGV()[j].inputData();
                    break;
                }
            }
        }
    }

    public static void inDanhSachGiangVien(){
        System.out.println("-------------------------DANH SACH GIANG VIEN----------------------------------");
        System.out.printf("%-15s %-16s %-12s %-11s %s", "Ma giang vien", "Ten giang vien", "Dia chi", "SDT", "Trinh do"+"\n");
        for (int i=0; i<ListGiangVien.getListGV().length; i++){
            if(ListGiangVien.getListGV()[i]!=null){
                ListGiangVien.getListGV()[i].showData();
            }
        }
    }

    public static void keKhaiGiangDayMenu(){
        while (true){
            System.out.println("---KE KHAI GIANG DAY---");
            System.out.println("1. Lap bang ke khai giang day");
            System.out.println("2. In bang ke khai giang day");
            System.out.println("3. Quay lai");
            Scanner sc = new Scanner(System.in);
            int choice = -1;
            while (true){
                choice =sc.nextInt();
                if(choice>=1 && choice<=3){
                    break;
                }
                System.err.println("Nhap khong hop le. Moi nhap lai!");
            }
            switch (choice){
                case 1:
                    lapBangKeKhai();
                    break;
                case 2:
                    inBangKeKhai();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void lapBangKeKhai(){
        if(!checkData()){
            System.err.println("Chua co du lieu Giang vien va Mon hoc!");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so ban can ke khai: ");
        int soBanKeKhai=-1;
        while (true){
            soBanKeKhai = sc.nextInt();
            if(soBanKeKhai>=1){
                break;
            }
            System.err.println("Nhap khong hop le. Moi nhap lai: ");
        }
        for(int i =1; i<=soBanKeKhai; i++){
            System.out.println("Nhap ban ke khai giang day thu "+i);
            KeKhaiGiangDay keKhaiGiangDay = new KeKhaiGiangDay();
            keKhaiGiangDay.inputData();
            for (int j=0; j< ListKeKhaiGiangDay.getListKeKhaiGiangDay().length; j++){
                if(ListKeKhaiGiangDay.getListKeKhaiGiangDay()[j]!=null && ListKeKhaiGiangDay.getListKeKhaiGiangDay()[j].equals(keKhaiGiangDay)==true){
                    ListKeKhaiGiangDay.getListKeKhaiGiangDay()[j].updateMonGiangDay(keKhaiGiangDay);
                    break;
                }
                if(ListKeKhaiGiangDay.getListKeKhaiGiangDay()[j]==null){
                    ListKeKhaiGiangDay.getListKeKhaiGiangDay()[j]=keKhaiGiangDay;
                    break;
                }
            }
        }
    }

    public static boolean checkData(){
        boolean checkDataMonHoc = false;
        for(int i =0; i< ListMonHoc.getListMH().length; i++){
            if(ListMonHoc.getListMH()[i]!=null){
                checkDataMonHoc=true;
                break;
            }
        }
        boolean checkDataGiangVien = false;
        for(int i = 0; i< ListGiangVien.getListGV().length; i++){
            if(ListGiangVien.getListGV()[i]!=null){
                checkDataGiangVien=true;
                break;
            }
        }
        return checkDataMonHoc && checkDataGiangVien;
    }

    public static void inBangKeKhai(){
        if(!checkDataKeKhaiGiangDay()){
            System.err.println("Chua co du lieu!");
            return;
        }
        System.out.println("---BANG KE KHAI GIANG DAY---");
        for (int i=0; i<ListKeKhaiGiangDay.getListKeKhaiGiangDay().length; i++){
            if (ListKeKhaiGiangDay.getListKeKhaiGiangDay()[i]!=null){
                ListKeKhaiGiangDay.getListKeKhaiGiangDay()[i].showData();
            }
        }
    }

    public static boolean checkDataKeKhaiGiangDay(){
        boolean checkDataKeKhaiGiangDay = false;
        for(int i=0; i<ListKeKhaiGiangDay.getListKeKhaiGiangDay().length; i++){
            if(ListKeKhaiGiangDay.getListKeKhaiGiangDay()[i]!=null){
                checkDataKeKhaiGiangDay =true;
                break;
            }
        }
        return checkDataKeKhaiGiangDay;
    }

    public static void sapXep(){
        int length =ListKeKhaiGiangDay.getListKeKhaiGiangDay().length;
        for (int i=0; i<length; i++){
            for (int j=i+1; j<length; j++){
                if(ListKeKhaiGiangDay.getListKeKhaiGiangDay()[i].getGiangVien().getHoTen().compareTo(
                        ListKeKhaiGiangDay.getListKeKhaiGiangDay()[j].getGiangVien().getHoTen())>0){
                    KeKhaiGiangDay temp;
                    temp = ListKeKhaiGiangDay.getListKeKhaiGiangDay()[i];
                    ListKeKhaiGiangDay.getListKeKhaiGiangDay()[i]=  ListKeKhaiGiangDay.getListKeKhaiGiangDay()[j];
                    ListKeKhaiGiangDay.getListKeKhaiGiangDay()[j]= temp;
                }
            }
        }

        for (int i=0; i<length; i++){
            ListKeKhaiGiangDay.getListKeKhaiGiangDay()[i].sortListMonHoc();
            ListKeKhaiGiangDay.getListKeKhaiGiangDay()[i].showData();
        }
    }

    public static void tinhTienCong(){
        System.out.println("---TIEN CONG GIANG VIEN---");
        System.out.printf("%-15s %s","Ten giang vien", "Tien cong"+"\n");
        for(int i=0; i<ListKeKhaiGiangDay.getListKeKhaiGiangDay().length; i++){
            if(ListKeKhaiGiangDay.getListKeKhaiGiangDay()[i]!=null){
                System.out.printf("%-15s %f",ListKeKhaiGiangDay.getListKeKhaiGiangDay()[i].getGiangVien().getHoTen() ,ListKeKhaiGiangDay.getListKeKhaiGiangDay()[i].tinhTienCong());
                System.out.println();
            }
        }484000
    }
}
