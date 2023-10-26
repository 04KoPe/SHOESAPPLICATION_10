package com.example.shoesapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountDDNActivity extends AppCompatActivity {

    BottomNavigationView btnavview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_d_d_n);

        btnavview = findViewById(R.id.bottomNavigation);
        btnavview.setSelectedItemId(R.id.account);

        //dieu huong den cac trang
        btnavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.account:
                        return true;
                    case R.id.home:

                        return true;
                    case R.id.search:

                        return true;
                    case R.id.notification:

                        return true;
                }
                return false;
            }
        });

    }
}
