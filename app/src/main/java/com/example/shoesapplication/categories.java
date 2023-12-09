package com.example.shoesapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

public class categories extends AppCompatActivity {
    BottomNavigationView btnavview;
    private TextView txtsneaker;
    ImageView imgcart, imgmess;
    TextView txtcartNoti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);

        txtsneaker = (TextView) findViewById(R.id.txt_sneaker);

        txtsneaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển đổi activity để khi nhấn vào imageview nó chuyển qua layout khác
                Intent intent = new Intent(categories.this, ProductsActivity.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });

        //open cart
        imgcart = findViewById(R.id.cart);
        imgcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(categories.this, CartActivity.class);
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
                Intent intent = new Intent(categories.this, Message.class);
                startActivity(intent);
            }
        });

        btnavview = findViewById(R.id.naviBtn);

        //dieu huong den cac trang
        btnavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.accountNav:
                        startActivity(new Intent(getApplicationContext(), AccountDDNActivity.class));
                        overridePendingTransition(0, 0);
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
    }
}
