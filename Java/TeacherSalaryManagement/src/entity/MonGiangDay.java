package entity;

import data.ListMonHoc;

import java.util.Scanner;

public class MonGiangDay implements chucnang.inputData, chucnang.showData{
    private MonHoc monHoc;
    private int soLop;

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public int getSoLop() {
        return soLop;
    }

    public void setSoLop(int soLop) {
        this.soLop = soLop;
    }

    @Override
    public void inputData() {
        boolean check=false;
        Scanner sc=new Scanner(System.in);
        String tenMonHoc;
        do{
            System.out.print("Mon hoc: ");
            tenMonHoc=sc.nextLine();
            for(int i =0; i< ListMonHoc.getListMH().length; i++){
                if(ListMonHoc.getListMH()[i]!=null){
                    if(tenMonHoc.equalsIgnoreCase(ListMonHoc.getListMH()[i].getTenMonHoc())){
                        this.monHoc=ListMonHoc.getListMH()[i];
                        check=true;
                        break;
                    }
                }
                else {
                    System.err.println("Mon hoc khong ton tai. Moi nhap lai!");
                    break;
                }
            }
        }while (check==false);
        System.out.print("So lop: ");
        int soLop=-1;
        while(true){
            soLop=sc.nextInt();
            if(soLop>=1 && soLop<=3){
                break;
            }
            else{
                System.err.println("So lop phai trong khoang tu 1 den 3. Moi nhap lai!");
            }
        }
        this.soLop=soLop;
    }

    @Override
    public void showData() {
        System.out.printf("%-15s %s", this.monHoc.getTenMonHoc(), this.soLop+"\n");
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
        MonGiangDay other = (MonGiangDay) obj;
        return this.getMonHoc()==other.getMonHoc();
    }

    @Override
    public String toString(){
        return "Ten mon hoc: "+monHoc.getTenMonHoc()+" So lop: "+soLop;
    }
}
