package com.example.applicationfastfood.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.applicationfastfood.Activity.DetailActivity;
import com.example.applicationfastfood.Domain.Foods;
import com.example.applicationfastfood.R;

import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.viewholder> {

    ArrayList<Foods> items;
    Context context;


    public FoodListAdapter(ArrayList<Foods> items)
    {
        this.items = items;
    }
    @NonNull
    @Override
    public FoodListAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.viewholder_list_food, parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.viewholder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.timeTxt.setText(items.get(position).getTimeValue()+"min");
        holder.priceTxt.setText("$"+items.get(position).getPrice());
        holder.rateTxt.setText(""+items.get(position).getPrice());

        Glide.with(context)
                .load(items.get(position).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.pic);



    }
    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView titleTxt, priceTxt, starTxt, timeTxt, rateTxt;
        ImageView pic;
        public viewholder (@NonNull View itemView)
        {
            super (itemView);
            titleTxt=itemView.findViewById(R.id.titleTxt);
            priceTxt=itemView.findViewById(R.id.priceTxt);
            starTxt=itemView.findViewById(R.id.starTxt);
            timeTxt=itemView.findViewById(R.id.timeTxt);
            rateTxt=itemView.findViewById(R.id.rateTxt);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}
