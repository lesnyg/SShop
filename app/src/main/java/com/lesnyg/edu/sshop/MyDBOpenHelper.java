package com.lesnyg.edu.sshop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDBOpenHelper extends SQLiteOpenHelper {
    private static final String name = "shop.db";
    private static final SQLiteDatabase.CursorFactory factory = null;
    private static final int version = 2;

    public static final String menu = "menu";
    public static final String price = "price";
    public static final String count = "count";
    public static final String _id="id";
    public static final String menufkid="menufkid";
    public static final String tablefkid="tablefkid";



    public MyDBOpenHelper(Context context) { super(context, name, factory, version); }

    public MyDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE shop_menu (_id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER);");
        db.execSQL("CREATE TABLE shop_table (_id INTEGER PRIMARY KEY AUTOINCREMENT, tableNumber TEXT);");
        db.execSQL("CREATE TABLE shop_order (_id INTEGER PRIMARY KEY AUTOINCREMENT,menufkid INTEGER,tablefkid INTEGER,date TEXT,count INTEGER);");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE shop_menu ;");
        db.execSQL("DROP TABLE shop_table ;");
        db.execSQL("DROP TABLE shop_order ;");

        onCreate(db);
//       Toast.makeText(this.,"onUpgrade", Toast.LENGTH_LON.G).show();
    }

//    public void deleteRecord(SQLiteDatabase mdb, String menu) {
//        mdb.execSQL("DELETE FROM shop_menu WHERE menu='" + menu + "';");
//    }

}
