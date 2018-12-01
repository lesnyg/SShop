package com.lesnyg.edu.sshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class OrderListActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        Button btorderlist01 = findViewById(R.id.btorderlist01);
        btorderlist01.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btorderlist01:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent); break;
        }}
}
