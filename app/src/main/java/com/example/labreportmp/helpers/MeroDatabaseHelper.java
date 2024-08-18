package com.example.labreportmp.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MeroDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "books.db";
    public static final String TABLE_NAME = "books";
    public static final String COLUMN_SBN = "sbn";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_PRICE = "price";
    public static final int DATABASE_VERSION = 1;


    public MeroDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String createQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_SBN + " TEXT PRIMARY KEY, "
                + COLUMN_TITLE + " TEXT , "
                + COLUMN_AUTHOR + " TEXT , "
                + COLUMN_PRICE + " REAL)";
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    //insert operation
    public boolean insert(String sbn, String title, String author, double price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SBN,sbn);
        values.put(COLUMN_TITLE,title);
        values.put(COLUMN_AUTHOR,author);
        values.put(COLUMN_PRICE,price);
        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    //read operation
    public Cursor getAllBooks(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    //delete
    public int delete(String sbn){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COLUMN_SBN + " = ?", new String[]{sbn});
    }

    //update
    public boolean update(String sbn, String title, String author, double price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put(COLUMN_TITLE, title);
        newValues.put(COLUMN_AUTHOR, author);
        newValues.put(COLUMN_PRICE, price);
        int result = db.update(TABLE_NAME, newValues, COLUMN_SBN + " = ?", new String[]{sbn});
        return result > 0;
    }
}
