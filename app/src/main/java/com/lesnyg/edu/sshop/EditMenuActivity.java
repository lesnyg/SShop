package com.lesnyg.edu.sshop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditMenuActivity extends AppCompatActivity {
    SQLiteDatabase mdb;
    MyDBOpenHelper dbHelper;
    Button btnsave, btndele,btnhome;
    String name, price;
    EditText menu_name, menu_price;
    TextView tvmenu;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_menu);

        dbHelper = new MyDBOpenHelper(this, "shop.db", null, 1);
        mdb = dbHelper.getWritableDatabase();

        menu_name = (EditText) findViewById(R.id.menu_name);
        menu_price = (EditText) findViewById(R.id.menu_price);


        btnsave = findViewById(R.id.btnsave);
        btndele = findViewById(R.id.btndele);
        btnhome = findViewById(R.id.btnhome);
        tvmenu = (TextView) findViewById(R.id.tvmenu);


        showmenu();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = menu_name.getText().toString();
                price = menu_price.getText().toString();
                mdb.execSQL("insert into shop_menu values( null, '" + name + "', " + price + " );");


                showmenu();

            }
        });
        btndele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dele = "DELETE FROM shop_menu WHERE name='" + name + "'";
                mdb.execSQL(dele);


                showmenu();

            }

        });
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void showmenu(){
    String query = "SELECT * FROM shop_menu";
    Cursor cursor = mdb.rawQuery(query, null);
    String str = "";
        while (cursor.moveToNext()) {
        id = cursor.getInt(0);
        name = cursor.getString(1);
        price = cursor.getString(2);
        str += (id + " : " + name + " - " + price + "원 \n");
    }
        if (str.length() > 0) {
        tvmenu.setText(str);
    } else {
        Toast.makeText(getApplicationContext(), "Warning Empty DB", Toast.LENGTH_SHORT).show();
        tvmenu.setText("");
    }}
}