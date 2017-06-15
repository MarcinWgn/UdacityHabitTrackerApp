package com.example.marcin.wegrzyn.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.marcin.wegrzyn.habittrackerapp.data.HabitContract.HabitEntry;
import com.example.marcin.wegrzyn.habittrackerapp.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.TextView);

        insertHabit(getString(R.string.test_habit), HabitEntry.DAY_SUN, 30);
        readCursor();
    }


    private boolean insertHabit(String name, int day, int during) {

        HabitDbHelper dbHelper = new HabitDbHelper(this);

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(HabitEntry.COLUMN_HABIT_NAME, name);
        contentValues.put(HabitEntry.COLUMN_HABIT_DAY, day);
        contentValues.put(HabitEntry.COLUMN_HABIT_DURING, during);

        long RowId = database.insert(HabitEntry.TABLE_NAME, null, contentValues);

        return RowId == -1;
    }

    private Cursor readBase() {

        HabitDbHelper dbHelper = new HabitDbHelper(this);

        SQLiteDatabase database = dbHelper.getReadableDatabase();

        String[] columns = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_DAY,
                HabitEntry.COLUMN_HABIT_DURING
        };
        return database.query(HabitEntry.TABLE_NAME, columns, null, null, null, null, null);
    }


    private void readCursor() {

        Cursor cursor = readBase();

        try {

            String out = getString(R.string.contains)
                    + " " + cursor.getCount()
                    + " " + getString(R.string.enties)
                    + "\n\n";

            int idIndex = cursor.getColumnIndex(HabitEntry._ID);
            int nameIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
            int dayIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_DAY);
            int duringIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_DURING);

            while (cursor.moveToNext()) {

                int currentId = cursor.getInt(idIndex);
                String currentName = cursor.getString(nameIndex);
                int currentDay = cursor.getInt(dayIndex);
                int currentDuring = cursor.getInt(duringIndex);

                out += String.valueOf(currentId)
                        + " " + currentName
                        + " " + String.valueOf(currentDay)
                        + " " + String.valueOf(currentDuring)
                        + "\n";
            }
            textView.setText(out);

        } finally {
            cursor.close();
        }
    }


}
