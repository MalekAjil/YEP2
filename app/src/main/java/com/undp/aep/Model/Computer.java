package com.undp.aep.Model;

public class Computer {
    public String program="";
    public int percent=0;

    public Computer(){}

    public Computer(String program, int percent) {
        this.program = program;
        this.percent = percent;
    }

    @Override
    public String toString() {
        return program + percent ;
    }
}

