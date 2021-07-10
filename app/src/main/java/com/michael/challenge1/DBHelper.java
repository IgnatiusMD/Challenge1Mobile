package com.michael.challenge1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "HeroesDB";
    private static final int DB_VERSION = 1;

    public static final String TABLE_HEROES = "Heroes";
    public static final String FIELD_HEROES_ID = "id";
    public static final String FIELD_HEROES_NAME = "name";
    public static final String FIELD_HEROES_SOURCE = "source";

    private static final String CREATE_TABLE_HEROES =
            "CREATE TABLE IF NOT EXISTS " + TABLE_HEROES + " (" +
                    FIELD_HEROES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FIELD_HEROES_NAME + " TEXT UNIQUE," +
                    FIELD_HEROES_SOURCE + " TEXT)";

    private static final String DROP_TABLE_HEROES =
            "DROP TABLE IF EXISTS " + TABLE_HEROES;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_HEROES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE_HEROES);
        onCreate(sqLiteDatabase);
    }
}
