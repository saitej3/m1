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

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_LOCATIONS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_LAT + " DOUBLE" +  KEY_LONG + " DOUBLE" +")";

        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATIONS);
        onCreate(db);
    }

    void addLocation(Location l)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, l.getName()); // Contact Name
        values.put(KEY_LAT, l.getLat()); // Contact Phone
        values.put(KEY_LONG,l.getLon());

        db.insert(TABLE_LOCATIONS, null, values);
        db.close(); //
    }

    public List<Location> getAllContacts() {

        List<Location> locationList = new ArrayList<Location>();
        String selectQuery = " SELECT  * FROM locations";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            do {

                Location location = new Location();
                location.setId(Integer.parseInt(cursor.getString(0)));
                location.setName(cursor.getString(1));
                location.setLat(cursor.getDouble(2));
                location.setLon(cursor.getDouble(3));

                locationList.add(location);

            } while (cursor.moveToNext());

        }

        return locationList;
    }
}
