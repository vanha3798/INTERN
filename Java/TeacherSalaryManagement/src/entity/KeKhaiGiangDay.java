package entity;

import data.ListGiangVien;
import data.ListKeKhaiGiangDay;
import data.ListMonHoc;

import java.util.Objects;
import java.util.Scanner;

public class KeKhaiGiangDay implements chucnang.inputData, chucnang.showData{
    private GiangVien giangVien;
    private MonGiangDay[] listMonGiangDay = new MonGiangDay[20];

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public MonGiangDay[] getListMonGiangDay() {
        return listMonGiangDay;
    }

    public void setListMonGiangDay(MonGiangDay[] listMonGiangDay) {
        this.listMonGiangDay = listMonGiangDay;
    }

    @Override
    public void inputData() {
        Scanner sc= new Scanner(System.in);
        String tenGV;
        boolean check = false;
        /////nhập giảng viên
        do{
            System.out.print("Giang vien: ");
            tenGV=sc.nextLine();
            for(int i =0; i< ListGiangVien.getListGV().length; i++){
                if(ListGiangVien.getListGV()[i]!=null){
                    if(tenGV.equalsIgnoreCase(ListGiangVien.getListGV()[i].getHoTen())){
                        this.giangVien=ListGiangVien.getListGV()[i];
                        check=true;
                        break;
                    }
                }
                System.err.println("Giang vien khong ton tai. Moi nhap lai!");
                break;
            }
        }while (check==false);

        ///////Nhập danh sách môn giảng dạy
        int soMon;
        System.out.println("Mon hoc giang day: ");
        System.out.print("Nhap so mon hoc giang day: ");
        while (true){
            soMon= sc.nextInt();
            if(soMon>=1){
                break;
            }
            System.err.println("Nhap khong hop le. Moi nhap lai!");
        }

        int tongSoTiet=0;
        for(int i=1; i<=soMon; i++){
            System.out.println("Mon giang day thu "+i+":");
            MonGiangDay monGiangDay=new MonGiangDay();
            monGiangDay.inputData();

            boolean checkTonTai=false;
            for (int j=0; j<listMonGiangDay.length; j++){
                if(listMonGiangDay[j]!=null && monGiangDay.equals(listMonGiangDay[j])){
                    System.out.println("Mon giang day nay da duoc ke khai!");
                    checkTonTai=true;
                    break;
                }
            }
            if(checkTonTai==true){
                continue;
            }
            tongSoTiet+= monGiangDay.getMonHoc().getTongSoTiet();
            if(tongSoTiet>200){
                System.err.println("Tong so tiet giang day vuot qua quy dinh (200)!");
                return;
            }
            listMonGiangDay[i]=monGiangDay;
        }
    }

    public void sortListMonHoc(){
        for(int i=0; i<listMonGiangDay.length; i++){
            for(int j=i+1; j<listMonGiangDay.length; j++){
                if(listMonGiangDay[i].getSoLop()<listMonGiangDay[j].getSoLop()){
                    MonGiangDay temp = listMonGiangDay[i];
                    listMonGiangDay[i] = listMonGiangDay[j];
                    listMonGiangDay[j] = temp;
                }
            }
        }
    }

    public void updateMonGiangDay(KeKhaiGiangDay keKhaiGiangDay){
        int j=0;
        for(int i=0; i<this.listMonGiangDay.length; i++){
            if(this.listMonGiangDay[i]==null){
                if(keKhaiGiangDay.listMonGiangDay[j]!=null){
                    this.listMonGiangDay[i]=keKhaiGiangDay.listMonGiangDay[j];
                    j++;
                }
                else {
                    break;
                }
            }
        }
    }

    public float tinhTienCong(){
        float tienCong=0;
        for(int i=0; i<listMonGiangDay.length; i++){
            if(listMonGiangDay[i]!=null){
                int soTietLyThuyet = listMonGiangDay[i].getMonHoc().getSoTietLyThuyet();
                int kinhPhi = listMonGiangDay[i].getMonHoc().getMucKinhPhi();
                int soTietThucHanh = listMonGiangDay[i].getMonHoc().getTongSoTiet()-listMonGiangDay[i].getMonHoc().getSoTietLyThuyet();
                tienCong+= (soTietLyThuyet * kinhPhi + soTietThucHanh*(kinhPhi * (float)70/100))*listMonGiangDay[i].getSoLop();
            }
        }
        return tienCong;
    }

    @Override
    public void showData() {
        System.out.println("Giang vien: "+this.giangVien.getHoTen());
        System.out.printf("%-15s %s","Mon giang day", "So lop"+"\n");
        for(int i = 0; i< listMonGiangDay.length; i++){
            if(listMonGiangDay[i]!=null){
                listMonGiangDay[i].showData();
            }
        }
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
        KeKhaiGiangDay other = (KeKhaiGiangDay) obj;
        return Objects.equals(this.giangVien, other.giangVien);
    }

}
