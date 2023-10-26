package com.example.shoesapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {
    BottomNavigationView btnavview;
    RecyclerView rv;
    ImageView imgcart, imgmess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        btnavview = findViewById(R.id.bottomNavigation);

        //dieu huong den cac trang
        btnavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:

                        return true;
                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(), AccountDDNActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.search:

                        return true;
                    case R.id.notification:

                        return true;
                }
                return false;
            }
        });

        rv= findViewById(R.id.recyclerview_nike);
        List<Product> nike = new ArrayList<>();
        nike.add(new Product("Nike Air Jordan 1 Low GS ‘White Gym Red’",R.drawable.nike_1));
        nike.add(new Product("Nike Dunk Low Athletic Department Casual Shoes",R.drawable.nike_2));
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ProductsAdapter adapter_nike = new ProductsAdapter(this, nike);
        rv.setAdapter(adapter_nike);

        adapter_nike.setOnItemClickListener(new ProductsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product product) {
                Intent intent = new Intent(ProductsActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        rv= findViewById(R.id.recyclerview_converse);
        List<Product> converse = new ArrayList<>();
        converse.add(new Product("Converse Chuck Taylor All Star Construct",R.drawable.converse_1));
        converse.add(new Product("Converse Converse Chuck 70 Patchwork Floral",R.drawable.converse_2));
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ProductsAdapter adapter_converse = new ProductsAdapter(this, converse);
        rv.setAdapter(adapter_converse);

        rv= findViewById(R.id.recyclerview_vans);
        List<Product> vans = new ArrayList<>();
        vans.add(new Product("Vans Classic Authentic Shoes",R.drawable.vans_1));
        vans.add(new Product("Vans Off The Wall Shoes",R.drawable.vans_2));
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ProductsAdapter adapter_vans = new ProductsAdapter(this, vans);
        rv.setAdapter(adapter_vans);



        //open cart
        imgcart = findViewById(R.id.img_cart);
        imgcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductsActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        //open message
        imgmess = findViewById(R.id.img_message);
        imgmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductsActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }
}
