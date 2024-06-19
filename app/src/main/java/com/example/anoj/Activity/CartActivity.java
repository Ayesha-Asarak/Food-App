package com.example.anoj.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anoj.Activity.Adapter.CartAdapter;
import com.example.anoj.Activity.Helper.ChangeNumberItemsListener;
import com.example.anoj.Activity.Helper.ManagmentCart;
import com.example.anoj.databinding.ActivityCartBinding;

public class CartActivity extends BaseActivity {
 private ActivityCartBinding binding;
 private RecyclerView.Adapter adapter;
 private ManagmentCart managmentCart;
 private double tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managmentCart = new ManagmentCart(this);
        setVariable();
        calculateCart();
        initList();


    }

    private void initList() {
        if(managmentCart.getListCart().isEmpty()){
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollviewCart.setVisibility(View.GONE);
        }else {
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollviewCart.setVisibility(View.VISIBLE);
        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.cardView.setLayoutManager(linearLayoutManager);
        adapter=new CartAdapter(managmentCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void change() {
                calculateCart();
            }
        });
        binding.cardView.setAdapter(adapter);
    }

    private void calculateCart() {
        double percentTax = 0.02;
        double delivery = 10;

        tax = Math.round(managmentCart.getTotalFee() * percentTax * 100.0)/100;

        double total = Math.round((managmentCart.getTotalFee() + tax +delivery)*100)/100;
        double itemTotal = Math.round(managmentCart.getTotalFee()*100)/100;

        binding.totalFeeTxt.setText("$"+itemTotal);
        binding.taxTxt.setText("$"+tax);
        binding.deliveryTxt.setText("$"+delivery);
        binding.totalTxt.setText("$"+total);
    }

    private void setVariable(){
        binding.backBtn.setOnClickListener(v -> finish());
    }

}

////package com.example.anoj.Activity;
////
////import android.os.Bundle;
////import android.view.View;
////
////import androidx.appcompat.app.AppCompatActivity;
////import androidx.recyclerview.widget.LinearLayoutManager;
////
////import com.example.anoj.Activity.Adapter.CartAdapter;
////import com.example.anoj.Activity.Helper.ChangeNumberItemsListener;
////import com.example.anoj.Activity.Helper.ManagementCart;
////import com.example.anoj.databinding.ActivityCartBinding;
////
////public class CartActivity extends AppCompatActivity {
////    private ActivityCartBinding binding;
////    private CartAdapter adapter;
////    private ManagementCart managementCart;
////    private double tax;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        binding = ActivityCartBinding.inflate(getLayoutInflater());
////        setContentView(binding.getRoot());
////
////        managementCart = new ManagementCart(this);
////        setVariable();
////        calculateCart();
////        initList();
////    }
////
////    private void initList() {
////        if (managementCart.getListCart().isEmpty()) {
////            binding.emptyTxt.setVisibility(View.VISIBLE);
////            binding.scrollViewCart.setVisibility(View.GONE);
////        } else {
////            binding.emptyTxt.setVisibility(View.GONE);
////            binding.scrollViewCart.setVisibility(View.VISIBLE);
////
////            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
////            binding.cartView.setLayoutManager(linearLayoutManager);
////
////            adapter = new CartAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
////                @Override
////                public void change() {
////                    calculateCart();
////                }
////            });
////            binding.cartView.setAdapter(adapter);
////        }
////    }
////
////    private void calculateCart() {
////        double percentTax = 0.02;
////        double delivery = 10;
////
////        double totalFee = managementCart.getTotalFee();
////        tax = Math.round(totalFee * percentTax * 100.0) / 100.0;
////
////        double total = Math.round((totalFee + tax + delivery) * 100.0) / 100.0;
////        double itemTotal = Math.round(totalFee * 100.0) / 100.0;
////
////        binding.totalFeeTxt.setText("$" + itemTotal);
////        binding.taxtxt.setText("$" + tax);
////        binding.deliveryTxt.setText("$" + delivery);
////        binding.totalTxt.setText("$" + total);
////    }
////
////    private void setVariable() {
////        binding.backBtn.setOnClickListener(v -> finish());
////    }
////}
