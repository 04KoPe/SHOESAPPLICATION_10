package com.example.shoesapplication.AccountPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shoesapplication.MainPage.HomePage;
import com.example.shoesapplication.Message;
import com.example.shoesapplication.Notifications;
import com.example.shoesapplication.R;
import com.example.shoesapplication.SearchPackage.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class account extends AppCompatActivity {
    BottomNavigationView btnavview;
    Button btnsignup, btnsignin;
    ImageView imgcart, imgmess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        btnavview = findViewById(R.id.naviBtn);
        btnavview.setSelectedItemId(R.id.accountNav);
        btnsignin=findViewById(R.id.btn_signin);
        btnsignup=findViewById(R.id.btn_signup);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(account.this, com.example.shoesapplication.AccountPackage.LogInActivity.class);
                startActivity(intent);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(account.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        //dieu huong den cac trang
        btnavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.accountNav:

                        return true;
                    case R.id.homeNav:
                        startActivity(new Intent(getApplicationContext(), HomePage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.searchNav:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.notificationNav:
                        startActivity(new Intent(getApplicationContext(), Notifications.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
        //open cart
        imgcart = findViewById(R.id.img_cart);
        imgcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(account.this, com.example.shoesapplication.AccountPackage.LogInActivity.class);
                startActivity(intent);
            }
        });

        //open message
        imgmess = findViewById(R.id.img_mess);
        imgmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(account.this, Message.class);
                startActivity(intent);
            }
        });

    }
}
