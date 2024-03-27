package com.example.applicationfastfood.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationfastfood.Adapter.BestFoodAdapter;
import com.example.applicationfastfood.Adapter.FoodListAdapter;
import com.example.applicationfastfood.Domain.Foods;
import com.example.applicationfastfood.R;
import com.example.applicationfastfood.databinding.ActivityListFoodsBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListFoodsActivity extends BaseActivity {

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
        initList();
        setVariable();

    }

    @NonNull
    @Override
    public BestFoodAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BestFoodAdapter.viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private void setVariable()
    {

    }

    private void initList()
    {
        DatabaseReference myRef=database.getReference("Foods");
        binding.progressBar.setVisibility(View.VISIBLE);
        ArrayList<Foods>list=new ArrayList<>();
        Query query;
        if(isSearch)
        {
            query = myRef.orderByChild("Title").startAt(searchText).endAt(searchText+'\uf8ff');
        }
        else
        {
            query = myRef.orderByChild("CategoryId").equalTo(categoryId);
        }

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    for(DataSnapshot issue :snapshot.getChildren())
                    {
                        list.add(issue.getValue(Foods.class));
                    }
                    if(list.size()>0)
                    {
                        binding.foodListView.setLayoutManager(new GridLayoutManager(ListFoodsActivity.this,2));
                        adapterListFood=new FoodListAdapter(list);
                        binding.foodListView.setAdapter(adapterListFood);
                    }
                    binding.progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void  getIntentExtra()
    {
        categoryId = getIntent().getIntExtra("CategoryId",0);
        categoryName=getIntent().getStringExtra("CategotyName");
        searchText=getIntent().getStringExtra("text");
        isSearch=getIntent().getBooleanExtra("isSearch",false);

        binding.titleTxt.setText(categoryName);
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}