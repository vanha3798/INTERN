package data;

import entity.KeKhaiGiangDay;

public class ListKeKhaiGiangDay {
    private static KeKhaiGiangDay[] listKeKhaiGiangDay = new KeKhaiGiangDay[100];

    public static KeKhaiGiangDay[] getListKeKhaiGiangDay() {
        return listKeKhaiGiangDay;
    }

    public static void setListKeKhaiGiangDay(KeKhaiGiangDay[] listKeKhaiGiangDay) {
        ListKeKhaiGiangDay.listKeKhaiGiangDay = listKeKhaiGiangDay;
    }
}
