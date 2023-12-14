package com.example.shoesapplication.AccountPackage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shoesapplication.AccountPackage.SignUpActivity;
import com.example.shoesapplication.MainPage.HomePage;
import com.example.shoesapplication.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LogInActivity extends AppCompatActivity {
    TextView txtsignup;
    private EditText userName, passWord;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        txtsignup = findViewById(R.id.signupText);
        loginBtn = findViewById(R.id.logIn_Btn);
        userName = findViewById(R.id.username_Edit);
        passWord = findViewById(R.id.password_Edit);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateUsername() | !validatePassword()) {

                } else {
                    checkUser();
                }
            }
        });

        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public Boolean validateUsername() {
        String val = userName.getText().toString();
        if (val.isEmpty()) {
            userName.setError("Không để trống Username!");
            return false;
        } else {
            userName.setError(null);
        }
        return true;
    }

    public Boolean validatePassword() {
        String val = passWord.getText().toString();
        if (val.isEmpty()) {
            passWord.setError("Không để trống Password!");
            return false;
        } else {
            passWord.setError(null);
        }
        return true;
    }

    public void checkUser() {
        String username = userName.getText().toString().trim();
        String password = passWord.getText().toString().trim();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = databaseReference.orderByChild("userName").equalTo(username);
        checkUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    userName.setError(null);
                    for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                        String passwordDB = userSnapshot.child("password").getValue(String.class);
                        if (passwordDB.equals(password)) {
                            userName.setError(null);
                            passWord.setError(null);
                            Intent intent = new Intent(LogInActivity.this, AccountDDNActivity.class);
                            startActivity(intent);
                            return;
                        } else {
                            passWord.setError("Sai Pasword");
                            passWord.requestFocus();
                        }
                    }
                } else {
                    userName.setError("Không có tài khoản này!");
                    userName.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("Failed to read value.", error.toException());
            }
        });
    }
}