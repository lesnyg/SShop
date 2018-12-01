package com.lesnyg.edu.sshop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDBOpenHelper extends SQLiteOpenHelper {
    private static final String name = "shop.db";
    private static final SQLiteDatabase.CursorFactory factory = null;
    private static final int version = 5;
    public static final String menu = "menu";
    public static final String price = "price";
    public static final String count = "count";
    public static final String id="id";
    public MyDBOpenHelper(Context context) { super(context, name, factory, version); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE shop_menu (id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price TEXT);");
        db.execSQL("CREATE TABLE shop_order (orderid INTEGER PRIMARY KEY AUTOINCREMENT,fkid INTEGER,price TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE shop_menu ;");
        onCreate(db);
    }
}
