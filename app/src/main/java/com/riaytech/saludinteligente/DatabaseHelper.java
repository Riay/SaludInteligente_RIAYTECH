package com.riaytech.saludinteligente;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DBHelper";
    private static final String DB_NAME = "salud_inteligente.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_USERS = "users";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASS = "password";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_NAME + " TEXT,"
                + COL_EMAIL + " TEXT UNIQUE,"
                + COL_PASS + " TEXT)";
        db.execSQL(CREATE_TABLE);
        Log.d(TAG, "DB created: " + CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Insertar usuario
    public boolean addUser(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, name.trim());
        cv.put(COL_EMAIL, email.trim().toLowerCase());
        cv.put(COL_PASS, password); // no trim password if you allow spaces (but could trim)
        long result = db.insertWithOnConflict(TABLE_USERS, null, cv, SQLiteDatabase.CONFLICT_IGNORE);
        Log.d(TAG, "addUser result=" + result + " email=" + email.trim().toLowerCase());
        db.close();
        return result != -1;
    }

    // Validar usuario (email + password)
    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String emailNorm = email.trim().toLowerCase();
        Cursor cursor = db.query(TABLE_USERS,
                new String[]{COL_ID},
                COL_EMAIL + "=? AND " + COL_PASS + "=?",
                new String[]{emailNorm, password},
                null, null, null);
        boolean exists = false;
        if (cursor != null) {
            exists = cursor.getCount() > 0;
            cursor.close();
        }
        db.close();
        Log.d(TAG, "checkUser email=" + emailNorm + " exists=" + exists);
        return exists;
    }

    public String getPasswordForEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String emailNorm = email.trim().toLowerCase();
        Cursor c = db.query(TABLE_USERS, new String[]{COL_PASS}, COL_EMAIL + "=?", new String[]{emailNorm}, null, null, null);
        String pass = null;
        if (c != null) {
            if (c.moveToFirst()) pass = c.getString(0);
            c.close();
        }
        db.close();
        Log.d(TAG, "getPasswordForEmail email=" + emailNorm + " pass=" + pass);
        return pass;
    }
}
