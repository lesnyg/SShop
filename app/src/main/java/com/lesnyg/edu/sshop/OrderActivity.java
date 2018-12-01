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
    String dele;
    RecyclerAdapter.MyViewHolder holder;

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

        String dele="delete from shop_order";
        mdb.execSQL(dele);




    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btcheck:
                String query1 = "SELECT * FROM shop_order";
                cursor = mdb.rawQuery(query1, null);
                String str = "";
                int total=0 ;
                while(cursor.moveToNext()){
                    price=cursor.getString(2);
                    Integer count = Integer.parseInt(price);
                    total = total+count;}
                    tvresult.setText(String.valueOf(total));


                break;
            case R.id.btnreset:
            dele="delete from shop_order";
            mdb.execSQL(dele);

            break;

            case R.id.btcancel:
                String dele="delete from shop_order";
                mdb.execSQL(dele);

                Intent intent = null;
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;


//    }
        }
        }
    }

