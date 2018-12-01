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

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    SQLiteDatabase mdb;
    MyDBOpenHelper dbHelper;
    int id;
    String name, price,count;
    String str = "";
    Cursor cursor;

    ArrayList<HashMap<String, Object>> arrayList = null;


    public MainAdapter(SQLiteDatabase db){
        this.mdb = db;
        String query = new StringBuilder().append("select*from shop_menu").toString();
        Cursor cursor = mdb.rawQuery(query, null);
        ArrayList<HashMap<String, Object>> arrayListTemp = new ArrayList<>();
        HashMap<String, Object> hashMap = null;
        while (cursor.moveToNext()) {
            hashMap = new HashMap<String, Object>();
            hashMap.put("id",cursor.getString(0));
            hashMap.put("title", cursor.getString(1));
            hashMap.put("price", cursor.getString(2));

            arrayListTemp.add(hashMap);

        }
        this.arrayList = arrayListTemp;

    }
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
  //      showmenu();
        }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

//    private void showmenu() {
//int total=0;
//        String query = "SELECT * FROM shop_order where orderid=1";
//        cursor = mdb.rawQuery(query, null);
//        if(cursor.getCount()>0){
//            cursor.moveToFirst();
//            total += cursor.getInt(1);
//        }
//        ((TextView)holder.tv3).setText(total);
//
//
//    }
//}
}
