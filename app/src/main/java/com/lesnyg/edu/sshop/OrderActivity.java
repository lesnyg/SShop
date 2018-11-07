package com.lesnyg.edu.sshop;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Button btcheck = findViewById(R.id.btcheck);
        btcheck.setOnClickListener(this);

        final String[] MENU = new String[] { "아메리카노       1000원", "카페라떼           2000원", "에그토스트       2500","햄 토스트          2500","샌드위치          3000"};
        ListView listviewmenu = (ListView) findViewById(R.id.listviewmenu);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview_single_column,MENU);
        listviewmenu.setAdapter(arrayAdapter);
        listviewmenu.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

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
