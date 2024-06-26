package com.example.applicationfastfood.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.applicationfastfood.Domain.Foods;
import com.example.applicationfastfood.Helper.ManagmentCart;
import com.example.applicationfastfood.R;
import com.example.applicationfastfood.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    private Foods object;
    private int num=1;
    private ManagmentCart managmentCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        getIntentExtra();
        setVariable();
    }

    private void setVariable()
    {
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        managmentCart= new ManagmentCart(this);
        Glide.with(DetailActivity.this)
                .load(object.getImagePath())
                .into(binding.pic);
        binding.priceTxt.setText("$"+object.getPrice());
        binding.titleTxt.setText(object.getTitle());
        binding.descriptionTxt.setText(object.getStar()+"Rating");
        binding.ratingBar.setRating((float) object.getStar());
        binding.totalTxt.setText((num*object.getPrice()+"$"));

        binding.plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=num+1;
                binding.numTxt.setText(num+"");
                binding.totalTxt.setText("$"+(num*object.getPrice()));
            }
        });
        binding.minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num>1)
                {
                    num=num+1;
                    binding.numTxt.setText(num+"");
                    binding.totalTxt.setText("$"+(num*object.getPrice()));
                }
            }
        });

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(num);
                managmentCart.insertFood(object);
            }
        });
    }
    private void getIntentExtra()
    {
        object= (Foods) getIntent().getSerializableExtra("object");
    }
}