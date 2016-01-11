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

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MedaramJathara";
    private static final String TABLE_LOCATIONS = "locations";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LONG = "long";

    private static final String TABLE_NOTIFICATIONS="notifications";

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


        String CREATE_NOTIFICATIONS_TABLE = "CREATE TABLE " + TABLE_NOTIFICATIONS + "("

                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT" +  ")";

        db.execSQL(CREATE_NOTIFICATIONS_TABLE);


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
        values.put(KEY_LONG,l.getLon());

        db.insert(TABLE_LOCATIONS, null, values);
        db.close(); //
    }

    public List<Location> getAllLocations() {

        List<Location> locationList = new ArrayList<Location>();
        String selectQuery = " SELECT  * FROM "+TABLE_LOCATIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            do {

                Location location = new Location();
                location.setId(Integer.parseInt(cursor.getString(0)));
                location.setName(cursor.getString(1));
                location.setLat(cursor.getString(2));
                //location.setLon(cursor.getDouble(3));

                locationList.add(location);

            } while (cursor.moveToNext());

        }
        db.close();
        return locationList;
    }

    public List<Location> getLocations()
    {
        List<Location> locationList=new ArrayList<>();
        Cursor cursor = this.getReadableDatabase().query(TABLE_LOCATIONS, new String[]{KEY_ID, KEY_NAME, KEY_LAT}, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            Location l=new Location();
            l.setId(cursor.getInt(0));
            l.setName(cursor.getString(1));
            l.setLat(cursor.getString(2));
            cursor.moveToNext();

        }
        return locationList;
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

    public int getNotificationsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NOTIFICATIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public int getLocationsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_LOCATIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }


}
