package com.undp.aep.Model;

public class ApplyReason {
   public String name="";
    public int  num=0;
public ApplyReason(){}

    public ApplyReason(String name, int num) {
        this.name = name;
        this.num = num;
    }


    @Override
    public String toString() {
        return name ;
    }
}

