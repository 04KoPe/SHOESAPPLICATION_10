package com.example.shoesapplication.AccountPackage;

import android.content.Intent;
import android.os.Bundle;
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

public class LogInActivity extends AppCompatActivity {
    TextView txtsignup;
    private EditText userName,password;
    private Button loginBtn;
    private FirebaseAuth auth;

    public void direct(){
        txtsignup = findViewById(R.id.signupText);
        loginBtn = findViewById(R.id.logInBtn);
        userName = findViewById(R.id.usernameEdit);
        password = findViewById(R.id.passwordEdit);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        direct();

        loginBtn = findViewById(R.id.logInBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailR = userName.getText().toString();
                String passwordR = password.getText().toString();
                if(!emailR.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailR).matches()) {
                    if (!passwordR.isEmpty()) {
                        auth.signInWithEmailAndPassword(emailR, passwordR)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(LogInActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LogInActivity.this, HomePage.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(LogInActivity.this, "Login Failed! Check your password try again!",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else{
                        loginBtn.setError("Password cannot be empty!");
                        Toast.makeText(LogInActivity.this, "Password cannot be empty!", Toast.LENGTH_SHORT).show();
                    }


                }
                else if(emailR.isEmpty()){
                    loginBtn.setError("Email cannot be empty!");
                    Toast.makeText(LogInActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    loginBtn.setError("Please enter correct email!");
                    Toast.makeText(LogInActivity.this, "Please enter correct email!", Toast.LENGTH_SHORT).show();
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
}