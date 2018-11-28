package com.lesnyg.edu.sshop;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class OrderActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    Button btnreset,btncheck,btncancle;
    MyDBOpenHelper dbHelper;
    SQLiteDatabase mdb = null;
    String menu,price,tablenumber;
    int menupkid,tablepkid,menufkid,tablefkid;
    TextView tvresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();


        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dbHelper = new MyDBOpenHelper(this);
        adapter = new RecyclerAdapter(dbHelper);
        recyclerView.setAdapter(adapter);



        btnreset = findViewById(R.id.btnreset);
        btnreset.setOnClickListener(this);
        btncheck = findViewById(R.id.btcheck);
        btncheck.setOnClickListener(this);
        btncancle = findViewById(R.id.btcancel);
        btncancle.setOnClickListener(this);
        tvresult = findViewById(R.id.tvresult);


    }

    @Override
    public void onClick(View v) {
        TextView tvResult = findViewById(R.id.tvresult);
        RecyclerAdapter.MyViewHolder holder;
        dbHelper = new MyDBOpenHelper(this, "shop.db", null, 1);
        mdb = dbHelper.getWritableDatabase();


        switch (v.getId()){
/           case R.id.btcheck:
//                Integer result = Integer.parseInt(((TextView)holder.itemdetail).getText().toString())*
//                        Integer.parseInt((HashMap)price.getText().toString());
//                ((TextView)tvResult).setText(result.toString());
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String ordered_date = format.format(new Date());
            String query = "SELECT * FROM shop_menu";
            Cursor cursor = mdb.rawQuery(query, null);
            String str = "";
            while (cursor.moveToNext()) {
                menupkid = cursor.getInt(0);
                menu = cursor.getString(1);
                price = cursor.getString(2);
                }
            query = "SELECT * FROM shop_table";
            cursor = mdb.rawQuery(query, null);
            str = "";
            while (cursor.moveToNext()) {
                tablepkid = cursor.getInt(0);
                tablenumber = cursor.getString(1);
            }

            Integer count = Integer.parseInt(((TextView)holder.itemdetail).getText().toString());
            mdb.execSQL("INSERT INTO shop_order VALUES (null,'"+menupkid+"','"+tablepkid+"','" + ordered_date + "', " + count +" )");

            mdb.execSQL("SELECT menupkid, tablepkid, ordered_date, count "+
                    "FROM shop_menu,shop_table INNER JOIN shop_order " +
                    "ON menupkid = menufkid AND menupkid = '" + menupkid + "' "+
                    "ON tablepkid = tablefkid AND tablepkid = '" + tablepkid + "' ");
            cursor = mdb.rawQuery(query, null);
            int result;
            result = price*count;
            tvresult.setText(result);
                break;
            case R.id.btnreset:
                holder.itemdetail.setText("0");
                break;
            case R.id.btcancel:
                Intent intent=null;
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;

                        }
    }
}
