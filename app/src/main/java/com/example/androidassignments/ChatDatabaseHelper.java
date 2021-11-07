package com.example.androidassignments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ChatDatabaseHelper extends SQLiteOpenHelper {

    public static final String ACTIVITY_NAME = "ChatDatabaseHelper";
    public static final String  DATABASE_NAME = "Messages.db";
    public static final int VERSION_NUM = 2;
    public static final String KEY_ID = "KEY_ID";
    public static final String KEY_MESSAGE = "KEY_MESSAGE";
    public static final String TABLE_NAME = "Messages";
    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME+ "(" + KEY_ID + " integer primary key autoincrement, "
            + KEY_MESSAGE + " text not null);";
    private static final String DATABASE_UPGRADE = " DROP TABLE IF EXISTS " + TABLE_NAME;


    public ChatDatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE);
        Log.i(ACTIVITY_NAME, "Calling onCreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DATABASE_UPGRADE);
        onCreate(db);
        Log.i(ACTIVITY_NAME, "Calling onUpgrade, oldVersion = " + i + "newVersion =" + i1);
    }

//



}
