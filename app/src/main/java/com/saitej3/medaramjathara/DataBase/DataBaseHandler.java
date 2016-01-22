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

        execInsert(db, 1, "Tadvai", "18.235364", "80.315217");
        execInsert(db,2,"Jangalpally","18.207447","79.984611");
        execInsert(db,3,"Mahabubabad","17.597458","80.001623");
        execInsert(db,4,"Narsampet","17.928733","79.894955");
        execInsert(db,5,"Kamalapur x road","18.483352","79.893851");
        execInsert(db,6,"Medaram Jathara","18.321168", "80.241647");
        execInsert(db,7,"Your Location","0","0");
        execInsert(db,8,"Hyderabad","17.4126274","78.2679573");
        execInsert(db,9,"Karimnagar","18.4348833","79.0981285");
        execInsert(db,10,"Khammam","17.2484248","80.1154152");

        execInsert(db,11, "Helipad at Medaram", "80.241976", "18.318956");
        execInsert(db,12, "VIP  Parking Place", "80.248239", "18.308466");
        execInsert(db,13, "Chintal 'X' road Parking Place 2", "80.208382", "18.297904");
        execInsert(db,14, "Chintal 'X' road Parking Place 1", "80.207901", "18.298847");
        execInsert(db,15, "Aremalla Gutta Parking Place", "80.207206", "18.290028");
        execInsert(db,16, "Erra Cheruvu Parking Place 1", "80.207543", "18.284121");
        execInsert(db,17, "Erra Cheruvu Parking Place 2", "80.206608", "18.279084");
        execInsert(db,18, "Mettugutta Parking Place", "80.188299", "18.238476");
        execInsert(db,19, "VVIP Parking Place", "80.244183", "18.318038");
        execInsert(db,20, "Vengalapur Parking Place", "80.203632", "18.269525");
        execInsert(db,21, "Ballani Chintal Parking Place", "80.20187", "18.264437");
        execInsert(db,22, "Kalvapally 'X' Road Parking Place 2", "80.209746", "18.315459");
        execInsert(db,23, "Kannepally Parking Place", "80.226724", "18.330212");
        execInsert(db,24, "Bayyakkapet Parking Place", "80.199724", "18.315164");
        execInsert(db,25, "Kalvapally 'X' road Parking Place 1", "80.21015200000001", "18.318128");
        execInsert(db,26, "Jampanna Vai Parking Place", "80.226304", "18.329196");
        execInsert(db,27, "Manasura Parking Place", "80.223382", "18.326562");
        execInsert(db,28, "Kalvapally check post", "80.210512", "18.319158");
        execInsert(db,29, "Kothur Parking Place - 2", "80.216524", "18.327826");
        execInsert(db,30, "Thurkani chintal Parking Place", "80.202808", "18.266136");
        execInsert(db,31, "Pochamma Bandan Parking Place", "80.223198", "18.32606");
        execInsert(db,32, "Kothur Parking Place - 1", "80.215589", "18.323283");
        execInsert(db,33, "Kamaram Parking Place", "80.303504", "18.252803");
        execInsert(db,34, "Oorattam Parking Place-II", "80.232492", "18.338437");
        execInsert(db,35, "Oorattam Parking Palce-I", "80.232757", "18.338855");
        execInsert(db,36, "Oorattam Parking Place-III", "80.234059", "18.339005");


    }


    public void execInsert(SQLiteDatabase db,int id,String name,String lat,String lon)
    {
        db.execSQL("insert into " + TABLE_LOCATIONS + "(" + KEY_ID + ","
                + KEY_NAME + ","+KEY_LAT+","+KEY_LONG+") values("+id+",\'"+name+"\',\'"+lat+"\',\'"+lon+"\')");
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
