package data;

import entity.MonHoc;

public class ListMonHoc {
    private static MonHoc[] listMH= new MonHoc[100];

    public static MonHoc[] getListMH() {
        return listMH;
    }

    public static void setListMH(MonHoc[] listMH) {
        ListMonHoc.listMH = listMH;
    }
}
