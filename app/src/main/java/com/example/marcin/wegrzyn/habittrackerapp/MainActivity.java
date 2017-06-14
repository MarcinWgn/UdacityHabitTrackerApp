package com.example.marcin.wegrzyn.habittrackerapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.marcin.wegrzyn.habittrackerapp.data.HabitContract.HabitEntry;
import com.example.marcin.wegrzyn.habittrackerapp.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertHabit("Pływanie",HabitEntry.DAY_SUN,30);
    }


    private void insertHabit(String name, int day, int during){

        HabitDbHelper dbHelper = new HabitDbHelper(this);

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(HabitEntry.COLUMN_HABIT_NAME,name);
        contentValues.put(HabitEntry.COLUMN_HABIT_DAY,day);
        contentValues.put(HabitEntry.COLUMN_HABIT_DURING,during);

        long RowId = database.insert(HabitEntry.TABLE_NAME,null,contentValues);

        if (RowId == -1){
            Log.d("test","error saving base");
        } else {
            Log.d("test","saving base ok :) ");
        }

    }
}
