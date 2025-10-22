package com.riaytech.saludinteligente;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "saludinteligente.db";
    private static final int DB_VERSION = 1;

    private static final String TABLE_USERS = "users";
    private static final String COL_ID = "id";
    private static final String COL_USER = "username";
    private static final String COL_PASS = "password";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsers = "CREATE TABLE " + TABLE_USERS + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_USER + " TEXT UNIQUE, " + COL_PASS + " TEXT)";
        db.execSQL(createUsers);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public boolean createUser(String user, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_USER, user);
        cv.put(COL_PASS, pass);
        long id = db.insert(TABLE_USERS, null, cv);
        return id != -1;
    }

    public boolean checkUser(String user, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(TABLE_USERS, new String[]{COL_ID}, COL_USER + "=? AND " + COL_PASS + "=?",
                new String[]{user, pass}, null, null, null);
        boolean exists = false;
        if (c != null) {
            exists = c.getCount() > 0;
            c.close();
        }
        return exists;
    }

    public boolean hasAnyUser() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_USERS, null);
        boolean has = false;
        if (c != null) {
            c.moveToFirst();
            has = c.getInt(0) > 0;
            c.close();
        }
        return has;
    }
}
