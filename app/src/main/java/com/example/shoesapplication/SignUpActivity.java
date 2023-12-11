package com.example.shoesapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Singleton;

public class SignUpActivity extends AppCompatActivity {
    TextView txtlogin;
    private EditText editUserName, editPassWord, editConfirmPassword;
    private AppCompatButton signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editUserName = findViewById(R.id.usernameEdit);
        editPassWord = findViewById(R.id.passwordEdit);
        editConfirmPassword = findViewById(R.id.rePasswordEdit);
        signupBtn = findViewById(R.id.signInBtn);


        txtlogin = findViewById(R.id.signupTextsuggest);
        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
        signupBtn.setOnClickListener(v-> {
            String userName = getValue(editUserName);
            String password = getValue(editPassWord);
            String confirmPassword = getValue(editConfirmPassword);
            if(password.equals(confirmPassword)) {
                User  user =  User.signUp(SignUpActivity.this,new User(userName, password));
                if(user != null) {
                    Intent intent = new Intent(SignUpActivity.this, account.class );
                    startActivity(intent);
                }
            }
        });
    }

    private String getValue(EditText editText) {
        return String.valueOf(editText.getText()).trim();
    }
}