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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    ArrayList<HashMap<String, Object>> arrayList = null;
    ArrayList<Integer> arrprice = new ArrayList<>();
    SQLiteDatabase mdb;
    int id, result = 0, i = 0, total = 0;
    String name;
    TextView ptvresult;
    Cursor cursor;


    public RecyclerAdapter(ArrayList<HashMap<String, Object>> arrayList) {
        this.arrayList = new ArrayList<HashMap<String, Object>>();
        this.arrayList = arrayList;
    }

    public RecyclerAdapter(SQLiteDatabase db, TextView ptvresult) {
        this.ptvresult = ptvresult;
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

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView itemid,itemtitle, itemdetail, itemprice;
        public ImageButton btnminus;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemid = (TextView) itemView.findViewById(R.id.item_id);
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

        HashMap<String, Object> hashMap = arrayList.get(position);
        holder.itemid.setText((String)hashMap.get("id"));
        holder.itemtitle.setText((String) hashMap.get("title"));
        holder.itemprice.setText((String) hashMap.get("price"));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer c = Integer.parseInt(((TextView) holder.itemdetail).getText().toString()) + 1;
                ((TextView) holder.itemdetail).setText(c.toString());
                String price = ((TextView)holder.itemprice).getText().toString();
                String fkid=((TextView)holder.itemid).getText().toString();
                String query = "insert into shop_order values (null,'"+fkid+"','"+price+"')";
                mdb.execSQL(query);
            }
        });
        holder.btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = ((TextView) holder.itemdetail).getText().toString();
                if (count.equals("0") || count == null) {
                    ((TextView) holder.itemdetail).setText("0");
                } else {
                    Integer c = Integer.parseInt(((TextView) holder.itemdetail).getText().toString()) - 1;
                    ((TextView) holder.itemdetail).setText(c.toString());
                    String strpkid=((TextView)holder.itemid).getText().toString();
                    String query = "delete from shop_order where orderid='"+strpkid+"'";
                    mdb.execSQL(query);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void clear(View v, @NonNull MyViewHolder holder) {
        ((TextView) holder.itemdetail).setText("0");    }

}




