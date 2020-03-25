package com.example.designmodel.thread;

/**
 * Created by hp on 2020/3/25.
 */
public class Bean {
    public String name;
    public String name1;
    public String name2;
    public String name3;
    public String name4;
    public String name5;
    public String name6;
    public String name7;
    public String name8;
    public String name9;
    public String name10;
    public String name11;
    public String name12;
    public String name13;
    public String name14;
    public String name15;
    public String name16;
    public String name17;
    public String name18;
    public String name19;
    public String name20;
    public String name21;
    public String name31;
    public String name41;
    public String name51;
    public String name61;
    public String name71;
    public String name81;
    public String name91;
    public String name101;
    public String name111;
    public String name121;
    public String name131;
    public String name141;

    public void SetName(String name) {
        this.name = name;
        this.name1 = name;
        this.name2 = name;
        this.name3 = name;
        this.name4 = name;
        this.name5 = name;
        this.name6 = name;
        for (int i = 0; i < 100000000; i++) {
            this.name7 = name;
        }
        this.name8 = name;
        this.name9 = name;
        this.name10 = name;
        this.name11 = name;
        this.name12 = name;
        this.name13 = name;
        this.name14 = name;
        this.name15 = name;
        this.name16 = name;
        this.name17 = name;
        this.name18 = name;
        this.name19 = name;
        this.name20 = name;
        this.name21 = name;
        this.name31 = name;
        this.name41 = name;
        this.name51 = name;
        this.name61 = name;
        this.name71 = name;
        this.name81 = name;
        this.name91 = name;
        this.name101 = name;
        this.name111 = name;
        this.name121 = name;
        this.name131 = name;
        this.name141 = name;
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName()+"Bean{" +
                "name='" + name + '\'' +
                ", name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                ", name4='" + name4 + '\'' +
                ", name5='" + name5 + '\'' +
                ", name6='" + name6 + '\'' +
                ", name7='" + name7 + '\'' +
                ", name8='" + name8 + '\'' +
                ", name9='" + name9 + '\'' +
                ", name10='" + name10 + '\'' +
                ", name11='" + name11 + '\'' +
                ", name12='" + name12 + '\'' +
                ", name13='" + name13 + '\'' +
                ", name14='" + name14 + '\'' +
                ", name15='" + name15 + '\'' +
                ", name16='" + name16 + '\'' +
                ", name17='" + name17 + '\'' +
                ", name18='" + name18 + '\'' +
                ", name19='" + name19 + '\'' +
                ", name20='" + name20 + '\'' +
                ", name21='" + name21 + '\'' +
                ", name31='" + name31 + '\'' +
                ", name41='" + name41 + '\'' +
                ", name51='" + name51 + '\'' +
                ", name61='" + name61 + '\'' +
                ", name71='" + name71 + '\'' +
                ", name81='" + name81 + '\'' +
                ", name91='" + name91 + '\'' +
                ", name101='" + name101 + '\'' +
                ", name111='" + name111 + '\'' +
                ", name121='" + name121 + '\'' +
                ", name131='" + name131 + '\'' +
                ", name141='" + name141 + '\'' +
                (name.equals(name141) && name.equals(name19)) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(name141) && name.equals(name19);
    }
}
