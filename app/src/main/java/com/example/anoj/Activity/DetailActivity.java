//package com.example.anoj.Activity;
//
//import android.os.Bundle;
//import android.view.View;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.content.ContextCompat;
//
//import com.bumptech.glide.Glide;
//import com.example.anoj.Activity.Domain.Foods;
//import com.example.anoj.Activity.Helper.ManagmentCart;
//import com.example.anoj.R;
//import com.example.anoj.databinding.ActivityDetailBinding;
//
//public class DetailActivity extends BaseActivity {
//    private ActivityDetailBinding binding;
//    private Foods object;
//    private int num = 1;
//private ManagmentCart managmentCart;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityDetailBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot()); // Use binding.getRoot() to set the content view
//        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black));
//        getIntentExtra();
//        setVariable();
//    }
//
//    private void setVariable() {
//        managmentCart=new ManagmentCart(this);
//        binding.backBtn.setOnClickListener(v -> finish());
//
//        if (object != null) {
//            Glide.with(DetailActivity.this)
//                    .load(object.getImagePath())
//                    .into(binding.pic);
//
//            binding.priceTxt.setText("$" + object.getPrice());
//            binding.titleTxt.setText(object.getTitle());
//            binding.descriptionTxt.setText(object.getDescription());
//            binding.rateTxt.setText(object.getStar() + " Rating");
//            binding.ratingBar.setRating((float) object.getStar());
//            binding.totalTxt.setText(num * object.getPrice() + "$");
//
//            binding.plusBtn.setOnClickListener(v -> {
//                num = num + 1;
//                binding.numTxt.setText(num + " ");
//                binding.totalTxt.setText(("$" + num * object.getPrice()));
//            });
//            binding.minusBtn.setOnClickListener(v -> {
//                if (num > 1) {
//                    num = num - 1;
//                    binding.numTxt.setText(num + "");
//                    binding.totalTxt.setText("$" + (num * object.getPrice()));
//                }
//            });
//
//            binding.addBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    object.setNumberInCart(num);
//                }
//            });
//        }
//
//    }
//
//    private void getIntentExtra() {
//        object = (Foods) getIntent().getSerializableExtra("object");
//        managmentCart.insertFood(object);
//    }
//}
package com.example.anoj.Activity;

import android.os.Bundle;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.anoj.Activity.Domain.Foods;
import com.example.anoj.Activity.Helper.ManagmentCart;
import com.example.anoj.R;
import com.example.anoj.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity {
    ActivityDetailBinding binding;
    private Foods object;
    private int num = 1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black));
        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        managmentCart = new ManagmentCart(this);
        binding.backBtn.setOnClickListener(v -> finish());


            Glide.with(DetailActivity.this)
                    .load(object.getImagePath())
                    .into(binding.pic);

            binding.priceTxt.setText("$" + object.getPrice());
            binding.titleTxt.setText(object.getTitle());
            binding.descriptionTxt.setText(object.getDescription());
            binding.rateTxt.setText(object.getStar() + " Rating");
            binding.ratingBar.setRating((float) object.getStar());
            binding.totalTxt.setText( (num * object.getPrice()+"$"));

            binding.plusBtn.setOnClickListener(v -> {
                num++;
                binding.numTxt.setText(String.valueOf(num));
                binding.totalTxt.setText("$" + (num * object.getPrice()));
            });

            binding.minusBtn.setOnClickListener(v -> {
                if (num > 1) {
                    num--;
                    binding.numTxt.setText(num+"");
                    binding.totalTxt.setText("$"+(num * object.getPrice()));
                }
            });

            binding.addBtn.setOnClickListener(v -> {
                object.setNumberInCart(num);
                managmentCart.insertFood(object);
            });

    }

    private void getIntentExtra() {
        object = (Foods) getIntent().getSerializableExtra("object");
    }
}
