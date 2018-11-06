package com.lesnyg.edu.sshop;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btorder = findViewById(R.id.btorder);
        btorder.setOnClickListener(this);
        Button btorderlist = findViewById(R.id.btorderlist);
        btorderlist.setOnClickListener(this);
        Button btordermanage = findViewById(R.id.btordermanage);
        btordermanage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btorder:
                intent = new Intent(this,OrderActivity.class);
                startActivityForResult(intent,Activity.RESULT_FIRST_USER); break;
            case R.id.btorderlist:
                intent = new Intent(this,OrderListActivity.class);
                startActivityForResult(intent,Activity.RESULT_FIRST_USER); break;
            case R.id.btordermanage:
                intent = new Intent(this,EditMenuActivity.class);
                startActivityForResult(intent,Activity.RESULT_FIRST_USER); break;
        }

    }
}
