package com.michael.challenge1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class HeroesDB {

    DBHelper dbHelper;

    public HeroesDB(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public void insertHeroes(Hero hero) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(
                DBHelper.FIELD_HEROES_NAME,
                hero.getHeroName()
        );
        contentValues.put(
                DBHelper.FIELD_HEROES_SOURCE,
                hero.getHeroSource()
        );

        db.insert(DBHelper.TABLE_HEROES, null, contentValues);
//        db.update();
//        db.delete();
        db.close();
    }

    public Hero getHeroByName(String name) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selection = "name=?";
        String[] selectionArgs = {name};
        Cursor cursor = db.query(DBHelper.TABLE_HEROES,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null
        );

        Hero hero = new Hero();

        if (cursor.moveToFirst()){
            hero.setHeroName(
                    cursor.getString(
                            cursor.getColumnIndex(DBHelper.FIELD_HEROES_NAME)
                    )
            );

            hero.setHeroSource(
                    cursor.getString(
                            cursor.getColumnIndex(DBHelper.FIELD_HEROES_SOURCE)
                    )
            );
        }

        return hero;
    }

}
