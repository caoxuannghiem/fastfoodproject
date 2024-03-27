package com.example.applicationfastfood.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.target.ViewTarget;
import com.example.applicationfastfood.Domain.Foods;
import com.example.applicationfastfood.Helper.ChangeNumberItemsListener;
import com.example.applicationfastfood.Helper.ManagmentCart;
import com.example.applicationfastfood.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewholder>{
    ArrayList<Foods> list;
    private ManagmentCart managmentCart;
    ChangeNumberItemsListener changeNumberItemsListener;
    public CartAdapter(ArrayList<Foods> list, Context context, ChangeNumberItemsListener changeNumberItemsListener)
    {
        this.list = list;
        managmentCart=new ManagmentCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }
    @NonNull
    @Override
    public CartAdapter.viewholder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);
        return new viewholder(inflate);
    }
    public void onBindViewHolder(@NonNull CartAdapter.viewholder holder, int position)
    {
        holder.title.setText(list.get(position).getTitle());
        holder.feeEachItem.setText("$"+list.get(position).getPrice());
        holder.totalEachItem.setText(list.get(position).getNumberInCart()+"*$"+(
                list.get(position).getNumberInCart()*list.get(position).getPrice()
        ));
        holder.num.setText(list.get(position).getNumberInCart()+"");

        Glide.with(holder.itemView.getContext())
                .load(list.get(position).getImagePath())
                .into(holder.pic);
        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managmentCart.plusNumberItem(list, position, new ChangeNumberItemsListener() {
                    @Override
                    public void change() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.change();
                    }
                });
            }
        });

        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managmentCart.minusNumberItem(list, position, new ChangeNumberItemsListener() {
                    @Override
                    public void change() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.change();
                    }
                });
            }
        });
    }
    public int getItemCount()
    {
        return 0;
    }

    public class viewholder extends RecyclerView.ViewHolder{

        TextView title,feeEachItem,plusItem,minusItem;
        ImageView pic;
        TextView totalEachItem, num;

        public viewholder(@NonNull View itemView)
        {
            super(itemView);

            title = itemView.findViewById(R.id.titleTxt);
            feeEachItem = itemView.findViewById(R.id.feelEachItem);
            plusItem = itemView.findViewById(R.id.plusCartBtn);
            minusItem = itemView.findViewById(R.id.minusCartBtn);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            num = itemView.findViewById(R.id.numTxt);

        }
    }
}