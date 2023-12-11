package com.example.shoesapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AccountDDNActivity extends AppCompatActivity {

    BottomNavigationView btnavview;
    TextView txtpurchases, txtcategories, txtsetting;
    ImageView imgcart, imgmess;
    TextView txtcartNoti, txtUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_d_d_n);

        btnavview = findViewById(R.id.bottomNavigation);
        btnavview.setSelectedItemId(R.id.accountNav);
        txtUserName = findViewById(R.id.user_name);

        User user = User.getUser(AccountDDNActivity.this);
        Log.d("USER", String.valueOf(user));
        if (user != null) {
            txtUserName.setText(user.getUserName());
        }
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
                        startActivity(new Intent(getApplicationContext(), search.class));
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
        //open purchases
        txtpurchases = findViewById(R.id.txt_purchase);
        txtpurchases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountDDNActivity.this, Purchase.class);
                startActivity(intent);
            }
        });
        //open categoties
        txtcategories = findViewById(R.id.txt_cate);
        txtcategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountDDNActivity.this, categories.class);
                startActivity(intent);
            }
        });

        txtsetting = findViewById(R.id.txt_setting);
        txtsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountDDNActivity.this, AboutUs.class);
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
        //count amount item in cart
        txtcartNoti = findViewById(R.id.txt_cartNoti);
        DatabaseReference amountDatabase = FirebaseDatabase.getInstance().getReference("Cart");
        amountDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int itemCount = (int) snapshot.getChildrenCount();
                txtcartNoti.setText(String.valueOf(itemCount));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("Failed to read value.", error.toException());
            }
        });

        //open message
        imgmess = findViewById(R.id.message);
        imgmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountDDNActivity.this, Message.class);
                startActivity(intent);
            }
        });
    }
}