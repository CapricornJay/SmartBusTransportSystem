package com.example.keerthidhar.getsetgo;

public class Word {

    private String mlocation;
    private Integer mcapacity;
    private Integer mentered;
    private Integer mleft;
    private Integer mavailable;
    private Integer mpercent;


    public Word(String location,Integer capacity,Integer entered,Integer left,Integer available,Integer percent)
    {
        mlocation=location;
        mcapacity=capacity;
        mentered=entered;
        mleft=left;
        mavailable=available;
        mpercent=percent;
    }

    public String getMlocation() {
        return mlocation;
    }

    public Integer getMavailable() {
        return mavailable;
    }

    public Integer getMcapacity() {
        return mcapacity;
    }

    public Integer getMentered() {
        return mentered;
    }

    public Integer getMleft() {
        return mleft;
    }
    public Integer getMpercent(){
        return mpercent;
    }
}
