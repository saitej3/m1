package com.saitej3.medaramjathara.model;

/**
 * Created by Sai Teja on 1/15/2016.
 */
public class RouteObject {

    Location start;
    Location end;

    public RouteObject()
    {

    }

    public RouteObject(Location start, Location end)
    {
        this.start=start;
        this.end=end;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    public Location getEnd() {
        return end;
    }

    public Location getStart() {
        return start;
    }
}
