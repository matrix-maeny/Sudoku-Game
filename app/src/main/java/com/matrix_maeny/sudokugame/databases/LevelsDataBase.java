package com.matrix_maeny.sudokugame.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LevelsDataBase extends SQLiteOpenHelper {

    public LevelsDataBase(@Nullable Context context) {
        super(context, "Levels.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table Levels(levelName TEXT primary key, level1 INT, level2 INT, level3 INT, level4 INT, level5 INT, level6 INT, level7 INT, level8 INT, level9 INT, level10 INT, level11 INT, level12 INT, level13 INT, level14 INT, level15 INT, level16 INT, level17 INT, level18 INT, level19 INT, level20 INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Levels");
    }

    public boolean insertData(String levelName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("levelName", levelName);
        cv.put("level1", 1);
        cv.put("level2", 0);
        cv.put("level3", 0);
        cv.put("level4", 0);
        cv.put("level5", 0);
        cv.put("level6", 0);
        cv.put("level7", 0);
        cv.put("level8", 0);
        cv.put("level9", 0);
        cv.put("level10", 0);

        cv.put("level11", 0);
        cv.put("level12", 0);
        cv.put("level13", 0);
        cv.put("level14", 0);
        cv.put("level15", 0);
        cv.put("level16", 0);
        cv.put("level17", 0);
        cv.put("level18", 0);
        cv.put("level19", 0);
        cv.put("level20", 0);

        long result = db.insert("Levels", null, cv);

        return result != -1;

    }


    public boolean updateData(String levelName, int levelNumber, int levelStatus) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("level1", 1);

        switch (levelNumber) {
            case 2:
                cv.put("level2", levelStatus);
//                cv.put("level3", 0);
//                cv.put("level4", 0);
//                cv.put("level5", 0);
//                cv.put("level6", 0);
//                cv.put("level7", 0);
//                cv.put("level8", 0);
//                cv.put("level9", 0);
//                cv.put("level10", 0);
//
//                cv.put("level11", 0);
//                cv.put("level12", 0);
//                cv.put("level13", 0);
//                cv.put("level14", 0);
//                cv.put("level15", 0);
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);

                break;
            case 3:

                cv.put("level3", levelStatus);
//                cv.put("level2", 0);
//                cv.put("level4", 0);
//                cv.put("level5", 0);
//                cv.put("level6", 0);
//                cv.put("level7", 0);
//                cv.put("level8", 0);
//                cv.put("level9", 0);
//                cv.put("level10", 0);
//
//                cv.put("level11", 0);
//                cv.put("level12", 0);
//                cv.put("level13", 0);
//                cv.put("level14", 0);
//                cv.put("level15", 0);
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);

                break;
            case 4:

                cv.put("level4", levelStatus);
//                cv.put("level2", 0);
//                cv.put("level3", 0);
//                cv.put("level5", 0);
//                cv.put("level6", 0);
//                cv.put("level7", 0);
//                cv.put("level8", 0);
//                cv.put("level9", 0);
//                cv.put("level10", 0);
//
//                cv.put("level11", 0);
//                cv.put("level12", 0);
//                cv.put("level13", 0);
//                cv.put("level14", 0);
//                cv.put("level15", 0);
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);

                break;
            case 5:
                cv.put("level5", levelStatus);
//                cv.put("level2", 0);
//                cv.put("level3", 0);
//                cv.put("level4", 0);
//
//                cv.put("level6", 0);
//                cv.put("level7", 0);
//                cv.put("level8", 0);
//                cv.put("level9", 0);
//                cv.put("level10", 0);
//
//                cv.put("level11", 0);
//                cv.put("level12", 0);
//                cv.put("level13", 0);
//                cv.put("level14", 0);
//                cv.put("level15", 0);
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);

                break;
            case 6:
                cv.put("level6", levelStatus);
//                cv.put("level2", 0);
//                cv.put("level3", 0);
//                cv.put("level4", 0);
//                cv.put("level5", 0);
//                cv.put("level7", 0);
//                cv.put("level8", 0);
//                cv.put("level9", 0);
//                cv.put("level10", 0);
//
//                cv.put("level11", 0);
//                cv.put("level12", 0);
//                cv.put("level13", 0);
//                cv.put("level14", 0);
//                cv.put("level15", 0);
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);

                break;
            case 7:
                cv.put("level7", levelStatus);
//                cv.put("level2", 0);
//                cv.put("level3", 0);
//                cv.put("level4", 0);
//                cv.put("level5", 0);
//                cv.put("level6", 0);
//                cv.put("level8", 0);
//                cv.put("level9", 0);
//                cv.put("level10", 0);
//
//                cv.put("level11", 0);
//                cv.put("level12", 0);
//                cv.put("level13", 0);
//                cv.put("level14", 0);
//                cv.put("level15", 0);
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);

                break;
            case 8:
                cv.put("level8", levelStatus);
//                cv.put("level2", 0);
//                cv.put("level3", 0);
//                cv.put("level4", 0);
//                cv.put("level5", 0);
//                cv.put("level6", 0);
//                cv.put("level7", 0);
//                cv.put("level9", 0);
//                cv.put("level10", 0);
//
//                cv.put("level11", 0);
//                cv.put("level12", 0);
//                cv.put("level13", 0);
//                cv.put("level14", 0);
//                cv.put("level15", 0);
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);

                break;
            case 9:
                cv.put("level9", levelStatus);
//                cv.put("level2", 0);
//                cv.put("level3", 0);
//                cv.put("level4", 0);
//                cv.put("level5", 0);
//                cv.put("level6", 0);
//                cv.put("level7", 0);
//                cv.put("level8", 0);
//                cv.put("level10", 0);
//
//                cv.put("level11", 0);
//                cv.put("level12", 0);
//                cv.put("level13", 0);
//                cv.put("level14", 0);
//                cv.put("level15", 0);
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);

                break;
            case 10:
                cv.put("level10", levelStatus);
//                cv.put("level2", 0);
//                cv.put("level3", 0);
//                cv.put("level4", 0);
//                cv.put("level5", 0);
//                cv.put("level6", 0);
//                cv.put("level7", 0);
//                cv.put("level8", 0);
//                cv.put("level9", 0);
//
//                cv.put("level11", 0);
//                cv.put("level12", 0);
//                cv.put("level13", 0);
//                cv.put("level14", 0);
//                cv.put("level15", 0);
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);

                break;

            case 11:
                cv.put("level11", levelStatus);
//                cv.put("level2", 0);
//                cv.put("level3", 0);
//                cv.put("level4", 0);
//                cv.put("level5", 0);
//                cv.put("level6", 0);
//                cv.put("level7", 0);
//                cv.put("level8", 0);
//                cv.put("level9", 0);
//                cv.put("level10", 0);
//
//                cv.put("level12", 0);
//                cv.put("level13", 0);
//                cv.put("level14", 0);
//                cv.put("level15", 0);
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);

                break;
            case 12:
                cv.put("level12", levelStatus);
//                cv.put("level2", 0);
//                cv.put("level3", 0);
//                cv.put("level4", 0);
//                cv.put("level5", 0);
//                cv.put("level6", 0);
//                cv.put("level7", 0);
//                cv.put("level8", 0);
//                cv.put("level9", 0);
//                cv.put("level10", 0);
//
//                cv.put("level11", 0);
//
//                cv.put("level13", 0);
//                cv.put("level14", 0);
//                cv.put("level15", 0);
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);

                break;
            case 13:
                cv.put("level13", levelStatus);
//                cv.put("level2", 0);
//                cv.put("level3", 0);
//                cv.put("level4", 0);
//                cv.put("level5", 0);
//                cv.put("level6", 0);
//                cv.put("level7", 0);
//                cv.put("level8", 0);
//                cv.put("level9", 0);
//                cv.put("level10", 0);
//
//                cv.put("level11", 0);
//                cv.put("level12", 0);
//
//                cv.put("level14", 0);
//                cv.put("level15", 0);
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);

                break;
            case 14:
                cv.put("level14", levelStatus);
//                cv.put("level2", 0);
//                cv.put("level3", 0);
//                cv.put("level4", 0);
//                cv.put("level5", 0);
//                cv.put("level6", 0);
//                cv.put("level7", 0);
//                cv.put("level8", 0);
//                cv.put("level9", 0);
//                cv.put("level10", 0);
//
//                cv.put("level11", 0);
//                cv.put("level12", 0);
//                cv.put("level13", 0);
//
//                cv.put("level15", 0);
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);

                break;
            case 15:
                cv.put("level15", levelStatus);
//                cv.put("level2", 0);
//                cv.put("level3", 0);
//                cv.put("level4", 0);
//                cv.put("level5", 0);
//                cv.put("level6", 0);
//                cv.put("level7", 0);
//                cv.put("level8", 0);
//                cv.put("level9", 0);
//                cv.put("level10", 0);
//
//                cv.put("level11", 0);
//                cv.put("level12", 0);
//                cv.put("level13", 0);
//                cv.put("level14", 0);
//
//                cv.put("level16", 0);
//                cv.put("level17", 0);
//                cv.put("level18", 0);
//                cv.put("level19", 0);
//                cv.put("level20", 0);
                break;
            case 16:
                cv.put("level16", levelStatus);
//                cv.put("level2",0);
//                cv.put("level3",0);
//                cv.put("level4",0);
//                cv.put("level5",0);
//                cv.put("level6",0);
//                cv.put("level7",0);
//                cv.put("level8",0);
//                cv.put("level9",0);
//                cv.put("level10",0);
//
//                cv.put("level11",0);
//                cv.put("level12",0);
//                cv.put("level13",0);
//                cv.put("level14",0);
//                cv.put("level15",0);
//
//                cv.put("level17",0);
//                cv.put("level18",0);
//                cv.put("level19",0);
//                cv.put("level20",0);
                break;
            case 17:
                cv.put("level17", levelStatus);
//                cv.put("level2",0);
//                cv.put("level3",0);
//                cv.put("level4",0);
//                cv.put("level5",0);
//                cv.put("level6",0);
//                cv.put("level7",0);
//                cv.put("level8",0);
//                cv.put("level9",0);
//                cv.put("level10",0);
//
//                cv.put("level11",0);
//                cv.put("level12",0);
//                cv.put("level13",0);
//                cv.put("level14",0);
//                cv.put("level15",0);
//                cv.put("level16",0);
//
//                cv.put("level18",0);
//                cv.put("level19",0);
//                cv.put("level20",0);
                break;
            case 18:
                cv.put("level18", levelStatus);
//                cv.put("level2",0);
//                cv.put("level3",0);
//                cv.put("level4",0);
//                cv.put("level5",0);
//                cv.put("level6",0);
//                cv.put("level7",0);
//                cv.put("level8",0);
//                cv.put("level9",0);
//                cv.put("level10",0);
//
//                cv.put("level11",0);
//                cv.put("level12",0);
//                cv.put("level13",0);
//                cv.put("level14",0);
//                cv.put("level15",0);
//                cv.put("level16",0);
//                cv.put("level17",0);
//
//                cv.put("level19",0);
//                cv.put("level20",0);
                break;
            case 19:
                cv.put("level19", levelStatus);
//                cv.put("level2",0);
//                cv.put("level3",0);
//                cv.put("level4",0);
//                cv.put("level5",0);
//                cv.put("level6",0);
//                cv.put("level7",0);
//                cv.put("level8",0);
//                cv.put("level9",0);
//                cv.put("level10",0);
//
//                cv.put("level11",0);
//                cv.put("level12",0);
//                cv.put("level13",0);
//                cv.put("level14",0);
//                cv.put("level15",0);
//                cv.put("level16",0);
//                cv.put("level17",0);
//                cv.put("level18",0);
//
//                cv.put("level20",0);
                break;
            case 20:
                cv.put("level20", levelStatus);
//                cv.put("level2",0);
//                cv.put("level3",0);
//                cv.put("level4",0);
//                cv.put("level5",0);
//                cv.put("level6",0);
//                cv.put("level7",0);
//                cv.put("level8",0);
//                cv.put("level9",0);
//                cv.put("level10",0);
//
//                cv.put("level11",0);
//                cv.put("level12",0);
//                cv.put("level13",0);
//                cv.put("level14",0);
//                cv.put("level15",0);
//                cv.put("level16",0);
//                cv.put("level17",0);
//                cv.put("level18",0);
//                cv.put("level19",0);

                break;

        }

        long result = db.update("Levels", cv, "levelName=?", new String[]{levelName});

        return result != -1;
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("Select * from Levels", null);
    }
}
