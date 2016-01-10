package com.saitej3.medaramjathara.model;

/**
 * Created by Sai Teja on 1/10/2016.
 */
public class Location {

    private int id;
    private String name;
    private double lat;
    private double lon;

     public Location()
    {

    }

    public Location(int id,String name,double lat,double lon)
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
    public double getLat()
    {
        return lat;
    }

    public void setLat(double num)
    {
        this.lat=num;
    }


    public double getLon()
    {
        return lon;
    }

    public void setLon(double num)
    {
        this.lon=num;
    }



}
