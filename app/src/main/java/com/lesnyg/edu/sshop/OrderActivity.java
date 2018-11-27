package com.lesnyg.edu.sshop;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class OrderActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    Button btnreset,btncheck,btncancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "아메리카노");
        hashMap.put("count", "0");
        hashMap.put("price", "1000");
        arrayList.add(hashMap);
        hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "카페라떼");
        hashMap.put("count", "0");
        hashMap.put("price", "2000");
        arrayList.add(hashMap);
        hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "에그토스트");
        hashMap.put("count", "0");
        hashMap.put("price", "2500");
        arrayList.add(hashMap);
        hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "햄 토스트");
        hashMap.put("count", "0");
        hashMap.put("price", "2500");
        arrayList.add(hashMap);
        hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "샌드위치");
        hashMap.put("count", "0");
        hashMap.put("price", "3000");
        arrayList.add(hashMap);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        btnreset = findViewById(R.id.btnreset);
        btnreset.setOnClickListener(this);
        btncheck = findViewById(R.id.btcheck);
        btncheck.setOnClickListener(this);
        btncancle = findViewById(R.id.btcancel);
        btncancle.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        TextView tvResult = findViewById(R.id.tvresult);
        RecyclerAdapter.MyViewHolder holder;

        switch (v.getId()){
            case R.id.btcheck:
                Integer result = Integer.parseInt(((TextView)holder.itemdetail).getText().toString())*
                        Integer.parseInt((HashMap)price.getText().toString());
                ((TextView)tvResult).setText(result.toString());
                break;
            case R.id.btnreset:
                holder.itemdetail = 0;
                break;
            case R.id.btcancel:
                Intent intent=null;
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;

                        }
    }
}
