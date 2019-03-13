package com.bw.weekone01.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.weekone01.R;
import com.bw.weekone01.bean.Data;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    ArrayList<Data> data;

    public MyAdapter(Context context, ArrayList<Data> data) {
        this.context = context;
        this.data = data;
    }

//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item1,null));
//}
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//       MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
//       myViewHolder.text1.setText(data.get(i).getCommodityId());
//       myViewHolder.text2.setText(data.get(i).getCommodityName());
//        Glide.with(context).load(data.get(i).getMasterPic()).into(myViewHolder.imageView);
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item1,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ViewHolder myViewHolder=  viewHolder;
       myViewHolder.text1.setText(data.get(i).getCommodityId());
        Log.i("xxxx",""+data.get(i).getCommodityId());
       myViewHolder.text2.setText(data.get(i).getCommodityName());
        Glide.with(context).load(data.get(i).getMasterPic()).into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private  ImageView imageView;
        private  TextView text1;
        private  TextView text2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            text1 = itemView.findViewById(R.id.item_text1);
            text2 = itemView.findViewById(R.id.item_text);
        }
    }
}
