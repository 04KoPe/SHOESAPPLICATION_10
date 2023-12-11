package com.example.shoesapplication.Categories_Item;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shoesapplication.AccountDDNActivity;
import com.example.shoesapplication.Cart.CartActivity;
import com.example.shoesapplication.HomePage.HomePage;
import com.example.shoesapplication.Message;
import com.example.shoesapplication.Notifications;
import com.example.shoesapplication.R;
import com.example.shoesapplication.Search.search;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class categories extends AppCompatActivity {
    BottomNavigationView btnavview;
    private TextView txtSneaker, txtBoot, txtFlat, txtSandal, txtStil;
    ImageView imgcart, imgmess, imgsneaker;
    private ImageView imageview;

    public void ReceivedComponent(){
        txtSneaker = findViewById(R.id.txt_sneaker);
        txtBoot = findViewById(R.id.txtBoot);
        txtFlat = findViewById(R.id.txtFlats);
        txtSandal = findViewById(R.id.txtsandal);
        txtStil = findViewById(R.id.txtStilettos);
        btnavview = findViewById(R.id.naviBtn);
    }

    public void OnClickItem(){

        txtSneaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(categories.this, sneaker_categories_layout.class);
                startActivity(intent);
            }
        });

        txtBoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(categories.this, boot_categories_layout.class);
                startActivity(intent);
            }
        });

        txtFlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(categories.this, flat_categories_layout.class);
                startActivity(intent);
            }
        });

        txtSandal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(categories.this, sandal_categories_layout.class);
                startActivity(intent);
            }
        });

        txtStil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(categories.this, stilettos_categories_layout.class);
                startActivity(intent);
            }
        });

    }

    public void OnClickCartMess(){
        //open cart
        imgcart = findViewById(R.id.cart);
        imgcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(categories.this, CartActivity.class);
                startActivity(intent);
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);

        ReceivedComponent();
        OnClickItem();
        OnClickCartMess();


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
