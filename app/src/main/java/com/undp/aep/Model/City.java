package com.undp.aep.Model;

import com.undp.aep.R;

import java.util.ArrayList;

public class City {
    public int ID = 0;
    public String Name = "";
    public Integer Img=0;

    public City(int ID, String name,Integer img) {
        this.ID = ID;
        this.Name = name;
        this.Img=img;
    }

    @Override
    public String toString() {
        return this.ID +
                " - " + this.Name;
    }
    
    public static ArrayList<City> getData() {
        ArrayList data = new ArrayList();
        data.add(new City(1, "حلب", R.drawable.aleppo3));
        data.add(new City(2, "دمشق", R.drawable.damascus3));
        data.add(new City(3, "حمص",R.drawable.homs3));
        data.add(new City(4, "حماة",R.drawable.hama3));
        data.add(new City(5, "السويداء",R.drawable.swedaa3));
        data.add(new City(6, "اللاذقية",R.drawable.latakia3));
        data.add(new City(7, "طرطوس",R.drawable.tartous3));
        data.add(new City(8, "دير الزور",R.drawable.deir_azzor));
        data.add(new City(9, "الحسكة",R.drawable.hasakah3));
        return data;
    }
}
