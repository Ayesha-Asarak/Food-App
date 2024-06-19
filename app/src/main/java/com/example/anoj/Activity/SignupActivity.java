//package com.example.anoj.Activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.anoj.R;
//import com.example.anoj.databinding.ActivitySignupBinding;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//
//public class SignupActivity extends BaseActivity {
//    private ActivitySignupBinding binding;
//    private FirebaseAuth mAuth;
//    private static final String TAG = "SignupActivity";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivitySignupBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        // Initialize Firebase Auth
//        mAuth = FirebaseAuth.getInstance();
//
//        setVariable();
//    }
//
//    private void setVariable() {
//        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = binding.userEdt.getText().toString();
//                String password = binding.passEdt.getText().toString();
//
//                if (!isValidEmail(email)) {
//                    Toast.makeText(SignupActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                if (password.length() < 6) {
//                    Toast.makeText(SignupActivity.this, "Your password must be at least 6 characters", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Log.i(TAG, "onComplete: Success");
//                            startActivity(new Intent(SignupActivity.this, MainActivity.class));
//                        } else {
//                            Log.e(TAG, "onComplete: Failure", task.getException());
//                            Toast.makeText(SignupActivity.this, "Authentication Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//        });
//
//        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Start the login activity
//                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
//            }
//        });
//    }
//
//    private boolean isValidEmail(CharSequence email) {
//        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
//    }
//}

package com.example.anoj.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.anoj.R;
import com.example.anoj.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends BaseActivity {
    private ActivitySignupBinding binding;
    private FirebaseAuth mAuth;
    private static final String TAG = "SignupActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        setVariable();
    }

    private void setVariable() {
        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.userEdt.getText().toString();
                String password = binding.passEdt.getText().toString();

                if (!isValidEmail(email)) {
                    Toast.makeText(SignupActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(SignupActivity.this, "Your password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.i(TAG, "onComplete: Success");
                            startActivity(new Intent(SignupActivity.this, MainActivity.class));
                        } else {
                            Log.e(TAG, "onComplete: Failure", task.getException());
                            Toast.makeText(SignupActivity.this, "Authentication Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the login activity
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });
    }

    private boolean isValidEmail(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}