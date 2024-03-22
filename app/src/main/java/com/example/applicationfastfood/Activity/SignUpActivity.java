package com.example.applicationfastfood.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.applicationfastfood.R;
import com.example.applicationfastfood.databinding.ActivityIntroBinding;
import com.example.applicationfastfood.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class SignUpActivity extends BaseActivity {


    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
    }

    private void setVariable()
    {
        binding.signupBtn.setOnClickListener(v -> {
            String email = binding.useremailaddress.getText().toString();
            String password = binding.password.getText().toString();

            if (password.length()<6)
            {
                Toast.makeText(SignUpActivity.this, "Your Password must be at least 6 character", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUpActivity.this, task -> {
                if(task.isComplete())
                {
                    Log.i(TAG,"onComplete: ");
                    startActivity(new Intent(SignUpActivity.this,MainActivity.class));
                }
                else
                {
                    Log.i(TAG,"failure: "+task.getException());
                    Toast.makeText(SignUpActivity.this,"Authentication Failed",Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}