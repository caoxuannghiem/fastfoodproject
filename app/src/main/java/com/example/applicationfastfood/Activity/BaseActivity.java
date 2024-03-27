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

import com.example.applicationfastfood.Adapter.BestFoodAdapter;
import com.example.applicationfastfood.R;
import com.example.applicationfastfood.databinding.ActivityIntroBinding;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public abstract class BaseActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    public  String TAG="runnerfood";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        database=FirebaseDatabase.getInstance();
        mAuth=FirebaseAuth.getInstance();
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));

    }

    @NonNull
    public abstract BestFoodAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    public abstract void onBindViewHolder(@NonNull BestFoodAdapter.viewholder holder, int position);

    public abstract int getItemCount();
}