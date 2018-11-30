package com.lesnyg.edu.sshop;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    SQLiteDatabase mdb;
    MyDBOpenHelper dbHelper;
    String name, count;
    String str = "";
    Cursor cursor;

//    ArrayList<HashMap<String, Object>> arrayList = null;
//    ArrayList<Integer> arrprice = new ArrayList<>();
    private ArrayList<ItemData> arrayList;
    public MainAdapter(ArrayList<ItemData> arrayList) {
        this.arrayList = arrayList;
    }
//    public MainAdapter(ArrayList<HashMap<String,Object>> arrayList){
//        this.arrayList = new ArrayList<HashMap<String, Object>>();
//        this.arrayList = arrayList;
//    }

//    public MainAdapter(SQLiteDatabase mdb) {
//
//    }
//
//    public MainAdapter(ArrayList<ItemData> arrayList) {
//        this.arrayList = arrayList;
//    }


    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView tv1, tv2,tv3,tv4;
        Button btn1,btn2;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
            tv3=itemView.findViewById(R.id.tv3);
            tv4=itemView.findViewById(R.id.tv4);
            btn1=itemView.findViewById(R.id.btn1);
            btn2=itemView.findViewById(R.id.btn2);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_cardlayout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder myViewHolder=(MyViewHolder)viewHolder;
        //myViewHolder.tv3.setText(str);
        myViewHolder.tv3.setText(arrayList.get(i).getName());
        myViewHolder.tv4.setText(arrayList.get(i).getNum());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    private void showmenu() {
        String query = "SELECT * FROM shop_order";
        cursor = mdb.rawQuery(query, null);
        while (cursor.moveToNext()) {
            name = cursor.getString(1);
            count = cursor.getString(2);
            str += ( name + " - " + count + " \n");

    }
}}
