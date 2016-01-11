package com.saitej3.medaramjathara.model;

/**
 * Created by Sai Teja on 1/10/2016.
 */
public class Location {

     int id;
     String name;
     String lat;
     String lon;

     public Location()
    {

    }

    public Location(int id,String name,String lat,String lon)
    {
        this.id=id;
        this.name=name;
        this.lat=lat;
        this.lon=lon;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int num)
    {
        this.id=num;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }


    public String getLat()
    {
        return lat;
    }
    public void setLat(String num)
    {
        this.lat=num;
    }

    public String getLon()
    {
        return lon;
    }
    public void setLon(String num)
    {
        this.lon=num;
    }



//    public double getLon()
//    {
//        return lon;
//    }
//    public void setLon(double num)
//    {
//        this.lon=num;
//    }



}
