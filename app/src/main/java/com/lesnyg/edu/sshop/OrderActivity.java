package com.lesnyg.edu.sshop;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {
    int i;

    MySShopDB dbHelper;
    SQLiteDatabase mdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Button btcheck = findViewById(R.id.btcheck);
        btcheck.setOnClickListener(this);


        dbHelper = new MySShopDB(this, "sshopdb.db", null, 1);
        mdb = dbHelper.getWritableDatabase();

        String[] menu= new String[]{"아메리카노","카페라떼","에그토스트","햄 토스트","샌드위치","스콘"};
        Integer[] price = new Integer[]{1000,2000,2500,2500,3000,1500};
        for(int i=0; i<menu.length; i++){
            mdb.execSQL("INSERT INTO sshoString VALUES( i, '"+menu[i]+"','"+price[i]+"');");}
        String[] tablenum= new String[]{"T1","T2","T3","takeout"};
        for(int i=0; i<tablenum.length; i++){
            mdb.execSQL("INSERT INTO sshopdb_seat VALUES( i, '"+tablenum[i]+"');");}
        mdb.execSQL("INSERT INTO sshopdb_order VALUES( null, '"+"date"+"', '"+"menu"+"','"+"count"+"','"+"tablenum"+"');");

        ListView listviewmenu = (ListView) findViewById(R.id.listviewmenu);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview_single_column,menu);
        listviewmenu.setAdapter(arrayAdapter);

        listviewmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int i=0;
                i=i+1;
                // 관련 Activity 이동 구현
            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btcheck:
                intent = new Intent(this,MainActivity.class);
                startActivity(intent); break;
        }


    }
}
