package com.example.shoesapplication.AccountPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shoesapplication.R;

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
                Intent intent = new Intent(SignUpActivity.this, com.example.shoesapplication.AccountPackage.LogInActivity.class);
                startActivity(intent);
            }
        });
        signupBtn.setOnClickListener(v-> {
            String emailR = getValue(editUserName);
            String passwordR = getValue(editPassWord);
            String confirmPassword = getValue(editConfirmPassword);
            if(passwordR.equals(confirmPassword)) {
                User user =  User.signUp(SignUpActivity.this,new User(emailR, passwordR));
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