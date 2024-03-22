package com.example.applicationfastfood.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.applicationfastfood.R;
import com.example.applicationfastfood.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
    ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding=ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
        getWindow().setStatusBarColor(Color.parseColor("#FFE4B5"));
    }
    private void setVariable(){
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAuth.getCurrentUser()!=null)
                {
                    startActivity(new Intent(IntroActivity.this,MainActivity.class));
                }
                else
                {
                    startActivity(new Intent(IntroActivity.this,LoginActivity.class));
                }
            }
        });

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this,SignUpActivity.class));

            }
        });
    }
}