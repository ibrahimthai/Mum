package com.example.mum.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBRecipeHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "breakfastRecipes.db";
    public static final String TABLE_NAME = "BreakfastRecipes";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_TITLE = "TITLE";
    public static final String COLUMN_CALORIES = "CALORIES";
    public static final String COLUMN_COMPLETION_TIME = "COMPLETIONTIME";
    public static final String COLUMN_INGREDIENTS = "INGREDIENTS";
    public static final String COLUMN_INSTRUCTIONS = "INSTRUCTIONS";

    // Constructor
    public DBRecipeHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITLE + " TEXT, "
                + COLUMN_CALORIES + " TEXT, "
                + COLUMN_COMPLETION_TIME + " TEXT, "
                + COLUMN_INGREDIENTS + " TEXT, "
                + COLUMN_INSTRUCTIONS + " TEXT)");
        System.out.println("TABLE CREATED");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean addRecipe(String title, String completionTime, String ingredients, String instructions, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, title);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }



}
