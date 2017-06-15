package com.example.marcin.wegrzyn.habittrackerapp.data;

import android.provider.BaseColumns;

/**
 * Created by Marcin on 14.06.2017 :)
 */

public final class HabitContract {

    public HabitContract() {
    }

    public static final class HabitEntry implements BaseColumns {


        public static final String TABLE_NAME = "habits";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_DAY = "day";
        public static final String COLUMN_HABIT_DURING = "during";

        public static final int DAY_MON = 0;
        public static final int DAY_TUE = 1;
        public static final int DAY_WED = 2;
        public static final int DAY_THU = 3;
        public static final int DAY_FRI = 4;
        public static final int DAY_SAT = 5;
        public static final int DAY_SUN = 6;

    }

}
