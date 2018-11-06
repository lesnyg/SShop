package com.lesnyg.edu.sshop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout baseLayout;
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
        baseLayout = (LinearLayout)findViewById(R.id.baseLayout);

        TextView tvdate = findViewById(R.id.tvdate);
        //String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA);
        Date curDate = new Date();
        String strCurTime = sdf.format(curDate);
        tvdate.setText(strCurTime);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);  //메뉴를 띄우는 행위
        return true;

        }

    @Override  //메뉴를 눌렀을때의 행위
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.itemorder:
                intent = new Intent(this,OrderActivity.class);
                startActivity(intent);
                return true;
            case R.id.itemmenu:
                intent = new Intent(this,EditMenuActivity.class);
                startActivity(intent);
                return true;
            case R.id.itemlist:
                intent = new Intent(this,OrderListActivity.class);
                startActivity(intent);
                return true;

        }
        return false;
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
