package com.example.anoj.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.example.anoj.R;

public class BaseActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro); // Make sure you have a layout for this activity

        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));
    }
}
