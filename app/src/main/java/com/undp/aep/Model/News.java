package com.undp.aep.Model;

import com.google.gson.annotations.SerializedName;

public class News {
    @SerializedName("ID")
    public int ID=0;

    @SerializedName("Title")
    public String Title;

    @SerializedName("Description")
    public String Description="";

    @SerializedName("Type")
    public int Type=0;

    @SerializedName("Date")
    public String Date="";

    @SerializedName("Image")
    public String Image="";

public News(){}
    public News(int ID, String Title, String description, int type, String date, String image) {
        this.ID = ID;
        this. Title = Title;
        this. Description = description;
        this. Type = type;
        this. Date = date;
        this. Image = image;
    }


}
