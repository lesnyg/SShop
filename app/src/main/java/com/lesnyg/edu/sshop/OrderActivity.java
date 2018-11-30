package com.lesnyg.edu.sshop;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class OrderActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    Button btnreset, btncheck, btncancle;
    MyDBOpenHelper dbHelper;
    SQLiteDatabase mdb = null;
    String menu, price, tablenumber, query, date;
    int menupkid, tablepkid, menufkid, tablefkid;
    TextView tvresult;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();//ArrayList를 HashMap형으로 만든다


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);   //방금 선언한 layoutManager을 recyclerView에 넣는다

        dbHelper = new MyDBOpenHelper(this);
        mdb = dbHelper.getWritableDatabase();
        adapter = new RecyclerAdapter(mdb, tvresult);
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

//        switch (v.getId()) {
//            case R.id.btcheck:
//                pkid = editTextPkID.getText().toString();
//                query = "SELECT pkid, country, capital, count(fkid) visitedTotal " +
//                        "FROM awe_country INNER JOIN awe_country_visitedcount " +
//                        "ON pkid = fkid AND pkid = '" + pkid + "' ";
//                cursor = mdb.rawQuery(query, null);
//                if (cursor.getCount() > 0) {
//                    cursor.moveToFirst(); ...
//                    visitedTotal = cursor.getInt(cursor.getColumnIndex("visitedTotal"));
//                    editTextVisitedTotal.setText(String.valueOf(visitedTotal));



//                Integer count = Integer.parseInt ((TextView)mdb.item_detail.getText().toString());
//                mdb.execSQL("insert into shop_order values( null, " + menufkid + ", " + tablefkid + ",'"+date+"',"+count+" );");



//                break;
//            case R.id.btnreset:
//                //             (EditText)item_detail.setText("0");
//                break;
//
//            case R.id.btcancel:
//                Intent intent = null;
//                intent = new Intent(this, MainActivity.class);
//                startActivity(intent);
//                break;

        }
//    }

    @NonNull
    private String dbRead() {
        String query = "Select * From shop_menu";
        cursor = mdb.rawQuery(query, null);
        String str = "";

        while (cursor.moveToNext()) {
            menupkid = cursor.getInt(0);
            menu = cursor.getString(1);
            price = cursor.getString(2);
            str += (menufkid + " : " + menu + " - " + price + "\n");
        }
        if (str.equals(""))
            str = "no record";
        return str;
    }
}
