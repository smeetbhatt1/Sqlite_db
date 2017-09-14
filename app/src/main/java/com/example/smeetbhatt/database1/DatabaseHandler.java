package com.example.smeetbhatt.database1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smeetbhatt on 10/09/17.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "fruitdb";

    // Contacts table name
    private static final String TABLE_NAME = "fruit_table";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String FRUIT_NAME = "fruitName";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + FRUIT_NAME + " TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    //add Fruit
    public boolean addFruit(Fruit fruit) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FRUIT_NAME, fruit.getFruitName());
        // Inserting Row
       if(db.insert(TABLE_NAME, null, values)>0){
           db.close();
           return true;
       }
        else {
           return false;
       }
    }

    //get all fruit
    public String getAllFruits() {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        String result="";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                result += c.getInt(c.getColumnIndex("id"));
                result +="      ";
                result += c.getString(c.getColumnIndex("fruitName"));
                result += "\n";
            } while (c.moveToNext());
        }
        // return contact list
        return result;
    }

    //update fruit
    public boolean updateFruit(String id,String newName) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FRUIT_NAME, newName);

        // updating row
         if(db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[] { String.valueOf(id) }) >0)
             return true;
        else
            return false;
    }

    //delete fruit

    public Integer deleteFruit (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }

}