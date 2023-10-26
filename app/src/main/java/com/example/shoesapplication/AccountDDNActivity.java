package com.example.shoesapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountDDNActivity extends AppCompatActivity {

    BottomNavigationView btnavview;
    TextView txtpurchases, txtcategories;
    ImageView imgcart, imgmess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_d_d_n);

        btnavview = findViewById(R.id.bottomNavigation);
        btnavview.setSelectedItemId(R.id.accountNav);

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

                        return true;
                    case R.id.notificationNav:

                        return true;
                }
                return false;
            }
        });
        //open purchases
        txtpurchases = findViewById(R.id.txt_purchase);
        txtpurchases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountDDNActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
        //open categoties
        txtcategories = findViewById(R.id.txt_cate);
        txtcategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountDDNActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });

        //open cart
        imgcart = findViewById(R.id.cart);
        imgcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountDDNActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        //open message
        imgmess = findViewById(R.id.message);
        imgmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountDDNActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }
}