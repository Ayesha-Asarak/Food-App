
package com.example.anoj.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anoj.Activity.Adapter.FoodListAdapter;
import com.example.anoj.Activity.Domain.Foods;
import com.example.anoj.R;
import com.example.anoj.databinding.ActivityListFoodsBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListFoodsActivity extends BaseActivity {
    ActivityListFoodsBinding binding;
    private RecyclerView.Adapter adapterListFood;
    private int categoryId;
    private String categoryName;
    private String searchText;
    private boolean isSearch;
//    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListFoodsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        database = FirebaseDatabase.getInstance().getReference();
        getIntentExtra();
        initList();
        setVariable();

    }



    private void setVariable() {

    }



    private void initList() {
        DatabaseReference myRef = database.getReference("Foods");
        binding.progressBar.setVisibility(View.VISIBLE);
        ArrayList<Foods> list = new ArrayList<>();

        Query query;
        if (isSearch) {
            query = myRef.orderByChild("Title").startAt(searchText).endAt(searchText+ '\uf8ff');
        } else {
            query = myRef.orderByChild("CategoryId").equalTo(categoryId);
        }

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               if(snapshot.exists()) {
                   for (DataSnapshot issue : snapshot.getChildren()) {
                       list.add(issue.getValue(Foods.class));
                   }
                   if (list.size()>0) {
                       binding.foodListView.setLayoutManager(new GridLayoutManager(ListFoodsActivity.this, 2));
                       adapterListFood = new FoodListAdapter(list);
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

//    private void getIntentExtra() {
//        categoryId = getIntent().getIntExtra("CategoryId", 0);
//        categoryName = getIntent().getStringExtra("CategoryName");
//        searchText = getIntent().getStringExtra("text");
//        isSearch = getIntent().getBooleanExtra("isSearch", false);
//
//
////        Log.d("ListFoodsActivity", "CategoryId: " + categoryId); // Debug log for CategoryId
////        Log.d("ListFoodsActivity", "CategoryName: " + categoryName); // Debug log for CategoryName
//        binding.titleTxt.setText(categoryName);
//        binding.backBtn.setOnClickListener(v -> finish());
//    }
private void getIntentExtra() {
    categoryId = getIntent().getIntExtra("CategoryId",0);
    categoryName = getIntent().getStringExtra("CategoryName");
    searchText = getIntent().getStringExtra("text");
    isSearch = getIntent().getBooleanExtra("isSearch", false);

    binding.titleTxt.setText(categoryName);
    binding.backBtn.setOnClickListener(v -> finish());
}

}
