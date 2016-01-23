package com.saitej3.medaramjathara.model;

/**
 * Created by Sai Teja on 1/11/2016.
 */
public class MarkerItem {

    int markerId;
    String name;
    double lat, lon;
    int status;

    public MarkerItem()
    {

    }
    public MarkerItem(int markerId,String name,double lon,double lat)
    {
        this.markerId=markerId;
        this.name = name;
        this.lat =lat;
        this.lon = lon;
    }

    public MarkerItem(int markerId,String name,double lon,double lat,int status)
    {
        this.markerId=markerId;
        this.name = name;
        this.lat =lat;
        this.lon = lon;
        this.status=status;
    }


    public int getMarkerId(){return markerId;}
    public void setMarkerId(int num){this.markerId=num;}

    public String getName(){return name;}
    public void setName(String name){this.name =name;}

//    public String getVenue(){return venue;}
//    public void setVenue(String name){this.venue =name;}

    public double getLat(){return lat;}
    public void setLat(double num){this.lat =num;}

    public double getLon(){return lon;}
    public void setLon(double num){this.lon =num;}

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status=status;
    }

}
