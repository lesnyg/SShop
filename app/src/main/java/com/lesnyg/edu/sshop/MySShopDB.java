package com.lesnyg.edu.sshop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySShopDB extends SQLiteOpenHelper {
    private static final String name = "sshopdb.db";
    private static final SQLiteDatabase.CursorFactory factory = null;
    private static final int version = 1;

    public MySShopDB(Context context) {
        super(context, name, factory, version);
    }

    public MySShopDB(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE sshopdb_menu (_id INTEGER PRIMARY KEY, menu TEXT, price INTEGER);");
//        db.execSQL("CREATE TABLE sshopdb_seat (pkid TEXT PRIMARY KEY, tablenum TEXT);");
//        db.execSQL("CREATE TABLE sshopdb_order (_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, menu TEXT,count int,tablenum TEXT);");
//        db.execSQL("INSERT INTO sshopdb_order VALUES( null, '"+"date"+"', '"+"menu"+"','"+"count"+"','"+"tablenum"+"');");
        }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE sshopdb_menu ;");
        db.execSQL("DROP TABLE sshopdb_seat ;");
        db.execSQL("DROP TABLE sshopdb_order ;");
        onCreate(db);
//        Toast.makeText(this.,"onUpgrade", Toast.LENGTH_LONG).show();
    }

    public void deleteRecord(SQLiteDatabase mdb, String country) {
        mdb.execSQL("DELETE FROM awe_country WHERE country='" + country + "';");
    }

}
