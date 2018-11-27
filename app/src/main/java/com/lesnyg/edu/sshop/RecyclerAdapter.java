package com.lesnyg.edu.sshop;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    ArrayList<HashMap<String,Object>> arrayList = null;
//    private SQLiteDatabase mdb;
    public RecyclerAdapter(ArrayList<HashMap<String,Object>> arrayList){
        this.arrayList = new ArrayList<HashMap<String, Object>>();
        this.arrayList = arrayList;
    }

//    public RecyclerAdapter(SQLiteDatabase db){
//        this.mdb = db;
//        String query = new StringBuilder().append("select*from sshopdb_order").toString();
//        Cursor cursor = mdb.rawQuery(query,null);
//        ArrayList<HashMap<String,Object>> arrayListTemp = new ArrayList<>();
//        HashMap<String,Object> hashMap = null;
//
//        }
//
//    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView itemtitle, itemdetail,itemprice;
        public ImageButton btnminus;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemprice = (TextView) itemView.findViewById(R.id.item_price);
            itemtitle = (TextView) itemView.findViewById(R.id.item_title);
            itemdetail = (TextView) itemView.findViewById(R.id.item_detail);
            btnminus = (ImageButton) itemView.findViewById(R.id.btnminus);


        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        View view = inflate.inflate(R.layout.item_cardlayout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final HashMap<String,Object> hashMap = arrayList.get(position);
        holder.itemtitle.setText((String)hashMap.get("title"));
        holder.itemprice.setText((String)hashMap.get("price"));
        holder.itemdetail.setText((String)hashMap.get("count"));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer count = Integer.parseInt(((TextView)holder.itemdetail).getText().toString())+1;
                ((TextView)holder.itemdetail).setText(count.toString());
            }
        });
        holder.btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer count = Integer.parseInt(((TextView)holder.itemdetail).getText().toString())-1;
                ((TextView)holder.itemdetail).setText(count.toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}

