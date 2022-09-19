package data;

import entity.GiangVien;

public class ListGiangVien {
    private static GiangVien[] listGV=new GiangVien[100];

    public static GiangVien[] getListGV() {
        return listGV;
    }

    public static void setListGV(GiangVien[] listGV) {
        ListGiangVien.listGV = listGV;
    }
}

