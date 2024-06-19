package com.example.anoj.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anoj.Activity.Adapter.BestFoodsAdapter;
import com.example.anoj.Activity.Adapter.CategoryAdapter;
import com.example.anoj.Activity.Domain.Category;
import com.example.anoj.Activity.Domain.Foods;
import com.example.anoj.Activity.Domain.Location;
import com.example.anoj.Activity.Domain.Price;
import com.example.anoj.Activity.Domain.Time;
import com.example.anoj.R;
import com.example.anoj.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private FirebaseDatabase database;
    private DatabaseReference locationRef, timeRef, priceRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = FirebaseDatabase.getInstance();
        locationRef = database.getReference("Location");
        timeRef = database.getReference("Time");
        priceRef = database.getReference("Price");

        initLocation();
        initTime();
        initPrice();
        initBestFood();
        initCategory();
        setVariable();

    }

    private void setVariable(){
        binding.logoutBtn.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });
        binding.searchBtn.setOnClickListener(v -> {
            String text=binding.searchEdt.getText().toString();
            if(!text.isEmpty()){
                Intent intent = new Intent(MainActivity.this, ListFoodsActivity.class);
                intent.putExtra("text",text);
                intent.putExtra("isSearch",true);
                startActivity(intent);
            }
        });
       binding.cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CartActivity.class)));
    }

    private  void initBestFood(){
        DatabaseReference myRef = database.getReference("Foods");
        binding.progressBarBestFood.setVisibility(View.VISIBLE);
        ArrayList<Foods> list = new ArrayList<>();
        Query query = myRef.orderByChild("BestFood").equalTo(true);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot issue : snapshot.getChildren()){
                        list.add(issue.getValue(Foods.class));
                    }
                    if(list.size() > 0){
                        binding.bestFoodView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                        RecyclerView.Adapter adapter = new BestFoodsAdapter(list);
                        binding.bestFoodView.setAdapter(adapter);
                    }
                    binding.progressBarBestFood.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private  void initCategory(){
        DatabaseReference myRef = database.getReference("Category");
        binding.progressBarCategory.setVisibility(View.VISIBLE);
        ArrayList<Category> list = new ArrayList<>();

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot issue : snapshot.getChildren()){
                        list.add(issue.getValue(Category.class));
                    }
                    if(list.size() > 0){
                        binding.categoryView.setLayoutManager(new GridLayoutManager(MainActivity.this,4));;
                        RecyclerView.Adapter adapter = new CategoryAdapter(list);
                        binding.categoryView.setAdapter(adapter);
                    }
                    binding.progressBarCategory.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }




    private void initLocation() {
        DatabaseReference myRef= database.getReference("Location");
        ArrayList<Location> list = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                for (DataSnapshot issue : snapshot.getChildren()) {
                    list.add(issue.getValue(Location.class));
                }
                ArrayAdapter<Location> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sp_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                binding.locationSp.setAdapter(adapter);
            }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle possible errors.
            }
        });
    }

    private void initTime() {
        ArrayList<Time> list = new ArrayList<>();
        timeRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    list.add(dataSnapshot.getValue(Time.class));
                }
                ArrayAdapter<Time> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sp_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                binding.timeSp.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle possible errors.
            }
        });
    }

    private void initPrice() {
        ArrayList<Price> list = new ArrayList<>();
        priceRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    list.add(dataSnapshot.getValue(Price.class));
                }
                ArrayAdapter<Price> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sp_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                binding.priceSp.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle possible errors.
            }
        });
    }
}
