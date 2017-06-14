package com.example.marcin.wegrzyn.habittrackerapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.marcin.wegrzyn.habittrackerapp.data.HabitContract.HabitEntry;

/**
 * Created by Marcin on 14.06.2017 :)
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habit.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_HABITS_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME
                + "( "
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_DAY + " INTEGER, "
                + HabitEntry.COLUMN_HABIT_DURING + " INTEGER "
                + "); ";

        db.execSQL(CREATE_HABITS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
