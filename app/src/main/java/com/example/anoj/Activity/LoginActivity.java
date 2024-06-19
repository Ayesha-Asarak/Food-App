//package com.example.anoj.Activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.anoj.databinding.ActivityLoginBinding;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//
//public class LoginActivity extends BaseActivity {
//    private ActivityLoginBinding binding;
//    private FirebaseAuth mAuth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityLoginBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        // Initialize Firebase Auth
//        mAuth = FirebaseAuth.getInstance();
//
//        setVariable();
//    }
//
//    private void setVariable() {
//        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = binding.userEdt.getText().toString();
//                String password = binding.passEdt.getText().toString();
//
//                if (!email.isEmpty() && !password.isEmpty()) {
//                    mAuth.signInWithEmailAndPassword(email, password)
//                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if (task.isSuccessful()) {
//                                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
//                                    } else {
//                                        Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            });
//                } else {
//                    Toast.makeText(LoginActivity.this, "Please fill in username and password", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Start the login activity
//                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
//            }
//        });
//    }
//}
//
//
package com.example.anoj.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.anoj.databinding.ActivityLoginBinding;
import com.example.anoj.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        setVariable();
    }

    private void setVariable() {
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.userEdt.getText().toString();
                String password = binding.passEdt.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(LoginActivity.this, "Please fill in username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the login activity
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });
    }
}
