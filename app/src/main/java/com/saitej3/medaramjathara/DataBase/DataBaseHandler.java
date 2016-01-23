package com.saitej3.medaramjathara.DataBase;

/**
 * Created by Sai Teja on 1/10/2016.
 */

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import com.saitej3.medaramjathara.model.Location;
import com.saitej3.medaramjathara.model.MarkerItem;

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MedaramJathara";
    private static final String TABLE_LOCATIONS = "locations";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LONG = "long";
    private static final String KEY_STATUS="status";

    private static final String TABLE_NOTIFICATIONS="notifications";
    private static final String TABLE_MARKERS="markers";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

//        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_LOCATIONS + "("
//                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
//                + KEY_LAT + " DOUBLE," +  KEY_LONG + " DOUBLE" +")";
//
//
//        db.execSQL(CREATE_CONTACTS_TABLE);

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_LOCATIONS + "("

                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_LAT + " TEXT,"
                + KEY_LONG + " TEXT" + ")";

        db.execSQL(CREATE_CONTACTS_TABLE);

        String CREATE_MARKERS_TABLE="CREATE TABLE " + TABLE_MARKERS + "("

                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_LAT + " TEXT,"
                + KEY_LONG + " TEXT,"
                + KEY_STATUS + " TEXT" + ")";


        db.execSQL(CREATE_MARKERS_TABLE);


        String CREATE_NOTIFICATIONS_TABLE = "CREATE TABLE " + TABLE_NOTIFICATIONS + "("

                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT" +  ")";

        db.execSQL(CREATE_NOTIFICATIONS_TABLE);

        execInsert(db, 1,"Tadvai", "18.235364", "80.315217");
        execInsert(db,2,"Jangalpally","18.207447","79.984611");
        execInsert(db,3,"Mahabubabad","17.597458","80.001623");
        execInsert(db,4,"Narsampet","17.928733","79.894955");
        execInsert(db,5,"Kamalapur x road","18.483352","79.893851");
        execInsert(db,6,"Medaram Jathara","18.321168", "80.241647");
        execInsert(db,7,"Your Location","0","0");
        execInsert(db,8,"Hyderabad","17.4126274","78.2679573");
        execInsert(db,9,"Karimnagar","18.4348833","79.0981285");
        execInsert(db,10,"Khammam","17.2484248","80.1154152");

        execInsertMarker(db,38,"SS Tadvai RTC Parking Place","18.14156","80.185175","0");
        execInsertMarker(db,39,"VIP parking Place","18.18512","80.15093","0");
        execInsertMarker(db,40,"VVIP Parking Place","18.19091","80.14678","0");
        execInsertMarker(db,41,"Bashagudem (Oorattam-1) Parking Place","18.20306","80.14738","0");
        execInsertMarker(db,42,"Oorattam ? 2A Parking Place","18.20361","80.13921","0");
        execInsertMarker(db,43,"Oorattam ? 2B Parking Place","18.20304","80.13900","0");
        execInsertMarker(db,44,"Oorattam-2C Parking Place","18.20304","80.14039","0");
        execInsertMarker(db,45,"Kannepalli Parking Place","18.19839","80.13631","0");
        execInsertMarker(db,46,"Jampangavai Parking Place","18.19765","80.13572","0");
        execInsertMarker(db,47,"Marasura RF Parking Place","18.19605","80.13373","0");
        execInsertMarker(db,48,"Pochamma Bandhan Parking Place","18 19.430","80 13.283","0");
        execInsertMarker(db,49,"Kothur-1 Parking Place","18 19.396","80 12.938","0");
        execInsertMarker(db,50,"Kothur-2 Parking Place","18 19.671","80 13.001","0");
        execInsertMarker(db,51,"Kalvapally Check Post Parking Place","18 19.217","80 12.626","0");
        execInsertMarker(db,52,"Kalvapally X Road ? 1 Parking Place","18 18.943","80 12.525","0");
        execInsertMarker(db,53,"Kalvapally X Road ? 2 Parking Place","18 18.910","80 12.588","0");
        execInsertMarker(db,54,"Bayyakkapet Parking Place","18 19.008","80 12.008","0");
        execInsertMarker(db,55,"Chinthal RTC Parking Place","18 17 50.5","80 12 22.1","0");
        execInsertMarker(db,56,"Chinthal X Road ? 1 Parking Place","18 17.902","80 12.451","0");
        execInsertMarker(db,57,"Chinthal X Road ? 2 Parking Place","18 17.796","80 12.520","0");
        execInsertMarker(db,58,"Arumalla Gutta Parking Place","18 17.404","80 12.451","0");
        execInsertMarker(db,59,"Erra Cheruvu ? 1 Parking Place","18 17.041","80 12.391","0");
        execInsertMarker(db,60,"Erra Cheruvu ? 2 Parking Place","18 16.883","80 12.394","0");
        execInsertMarker(db,61,"Vengalapur Parking Place","18 16.143","80 12.236","0");
        execInsertMarker(db,62,"Thurkani Chinthal  Parking Place","18 15.950"," 80 12.126","0");
        execInsertMarker(db,63,"Ballani Chinthal Parking Place","18 15.850"," 80 12.128","0");
        execInsertMarker(db,64,"Yasangi Thogu Parking Place","18 15 37.7"," 80 11 50.8","0");
        execInsertMarker(db,65,"Motla Gudem Parking Place","18 15.516"," 80 11.810","0");
        execInsertMarker(db,66,"Kalvapalli-1 Parking Place","18 21 11.8"," 80 11 01.0","0");
        execInsertMarker(db,67,"Kalvapalli-2 Parking Place","18 21 11.0"," 80 11 00.9","0");


    }


    public void execInsert(SQLiteDatabase db,int id,String name,String lat,String lon)
    {
        db.execSQL("insert into " + TABLE_LOCATIONS + "(" + KEY_ID + ","
                + KEY_NAME + ","+KEY_LAT+","+KEY_LONG+") values("+id+",\'"+name+"\',\'"+lat+"\',\'"+lon+"\')");
    }

    public  void execInsertMarker(SQLiteDatabase db,int id,String name,String lat,String lon,String status)
    {
        db.execSQL("insert into " + TABLE_MARKERS + "(" + KEY_ID + ","
                + KEY_NAME + ","+KEY_LAT+","+KEY_LONG+","+KEY_STATUS+") values("+id+",\'"+name+"\',\'"+lat+"\',\'"+lon+"\',\'"+status+"\')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATIONS);
        onCreate(db);
    }

   public  void addLocation(Location l)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, l.getName()); // Contact Name
        values.put(KEY_LAT, l.getLat()); // Contact Phone
        values.put(KEY_LONG, l.getLon());

        db.insert(TABLE_LOCATIONS, null, values);
        db.close(); //
    }



    public Location getLocation(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LOCATIONS, new String[]{KEY_ID,
                KEY_NAME, KEY_LAT,KEY_LONG}, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)

            cursor.moveToFirst();

        Location location = new Location(Integer.parseInt(cursor.getString(0)),

                cursor.getString(1), cursor.getString(2),cursor.getString(3));
        return location;

    }

    public Location getLocationByName(String name) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LOCATIONS, new String[]{KEY_ID,
                KEY_NAME, KEY_LAT,KEY_LONG}, KEY_NAME + "=?", new String[]{name}, null, null, null, null);

        if (cursor != null)

            cursor.moveToFirst();

        Location location = new Location(Integer.parseInt(cursor.getString(0)),

                cursor.getString(1), cursor.getString(2),cursor.getString(3));
        return location;

    }

    public  void addNotification(String m)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, m);
        db.insert(TABLE_NOTIFICATIONS, null, values);
        db.close();
    }


    public String getNotification(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NOTIFICATIONS, new String[]{KEY_ID,
                KEY_NAME}, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)

            cursor.moveToFirst();
               return cursor.getString(1);

    }

    public MarkerItem getMarker(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MARKERS, new String[]{KEY_ID,
                KEY_NAME, KEY_LAT,KEY_LONG,KEY_STATUS}, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        MarkerItem markerItem = new MarkerItem(Integer.parseInt(cursor.getString(0)),

                cursor.getString(1), Double.parseDouble(cursor.getString(2)),Double.parseDouble(cursor.getString(3)),Integer.parseInt(cursor.getString(4)));
        return markerItem;
    }

    public int getNotificationsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NOTIFICATIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public void updateMarker(int id,int status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String strFilter = KEY_ID +"="+id;
        ContentValues args = new ContentValues();
        args.put(KEY_STATUS, String.valueOf(status));
        db.update(TABLE_MARKERS, args, strFilter, null);
    }

    public int getLocationsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_LOCATIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public int getMarkersCount() {
        String countQuery = "SELECT  * FROM " + TABLE_MARKERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }



}
