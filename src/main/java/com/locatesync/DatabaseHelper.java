package com.locatesync;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "locatesync.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTable = "CREATE TABLE users (" +
                "id INTEGER PRIMARY KEY, " +
                "email TEXT, " +
                "username TEXT)";

        String createDevicesTable = "CREATE TABLE devices (" +
                "imei TEXT PRIMARY KEY, " +
                "latitude REAL, " +
                "longitude REAL, " +
                "is_locked INTEGER, " +
                "is_reset INTEGER, " +
                "lock_password TEXT)";

        String createUserPhoneTable = "CREATE TABLE user_phone (" +
                "user_id INTEGER, " +
                "phone_id INTEGER, " +
                "PRIMARY KEY(user_id, phone_id))";

        db.execSQL(createUsersTable);
        db.execSQL(createDevicesTable);
        db.execSQL(createUserPhoneTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS devices");
        db.execSQL("DROP TABLE IF EXISTS user_phone");
        onCreate(db);
    }
}
