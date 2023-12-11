package com.example.shoesapplication.Log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shoesapplication.R;

public class lSignUpActivity extends AppCompatActivity {
    TextView txtlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtlogin = findViewById(R.id.signupTextsuggest);
        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lSignUpActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
    }
}