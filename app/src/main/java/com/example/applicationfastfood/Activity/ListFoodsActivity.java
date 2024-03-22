package com.example.applicationfastfood.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationfastfood.R;
import com.example.applicationfastfood.databinding.ActivityListFoodsBinding;

public class ListFoodsActivity extends AppCompatActivity {

    ActivityListFoodsBinding binding;
private RecyclerView.Adapter adapterListFood;
private int categoryId ;
private String categoryName;
private boolean isSearch;
private String searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityListFoodsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getIntentExtra();
    }

    private void  getIntentExtra()
    {
        categoryId = getIntent().getIntExtra("CategoryId",0);
        categoryName=getIntent().getStringExtra("Categoty");
        searchText=getIntent().getStringExtra("text");
        isSearch=getIntent().getBooleanExtra("isSearch",false);
    }
}