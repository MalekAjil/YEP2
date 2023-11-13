package com.undp.aep.Model;

import java.util.ArrayList;

public class Certificate {
    public int ID = 0;
    public String Name = "";

    public Certificate(int ID, String name) {
        this.ID = ID;
        this.Name = name;
    }

    @Override
    public String toString() {
        return this.Name;
    }

    public static ArrayList<Certificate> getData() {
        ArrayList data = new ArrayList();
        data.add(new Certificate(1, "أمي"));
        data.add(new Certificate(2, "ابتدائي"));
        data.add(new Certificate(3, "إعدادي"));
        data.add(new Certificate(4, "ثانوي"));
        data.add(new Certificate(5, "معهد"));
        data.add(new Certificate(6, "جامعي"));
        data.add(new Certificate(7, "دراسات عليا "));
        return data;
    }
}
