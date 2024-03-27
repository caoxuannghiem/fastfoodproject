package com.example.applicationfastfood.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationfastfood.Helper.ManagmentCart;
import com.example.applicationfastfood.R;
import com.example.applicationfastfood.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {
private ActivityCartBinding binding;
private RecyclerView.Adapter adapter;
private ManagmentCart managmentCart;

private double tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_cart);

        managmentCart=new ManagmentCart(this);

        setVariable();
        calculateCart();

    }

    private void calculateCart()
    {
        double percentTax= 0.2;
        double delivery=10;

        tax=Math.round(managmentCart.getTotalFee()*percentTax*100.0)/100;

        double total=Math.round((managmentCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal=Math.round(managmentCart.getTotalFee()*100)/100;

        binding
    }

    private void setVariable()
    {
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}