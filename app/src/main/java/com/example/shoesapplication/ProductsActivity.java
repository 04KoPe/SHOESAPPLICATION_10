package com.example.shoesapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapplication.listener.IProductLoadListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity implements IProductLoadListener {
    BottomNavigationView btnavview;
    RecyclerView rv;
    DatabaseReference database;
    ImageView imgcart, imgmess;

    //IProductLoadListener productLoadListener;

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
                    case R.id.homeNav:
                        startActivity(new Intent(getApplicationContext(), HomePage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.accountNav:
                        startActivity(new Intent(getApplicationContext(), AccountDDNActivity.class));
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

        rv = findViewById(R.id.recyclerview_nike);
        database = FirebaseDatabase.getInstance().getReference("Nike");
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<Product> nike = new ArrayList<>();
        ProductsAdapter adapter_nike = new ProductsAdapter(this, nike);
        rv.setAdapter(adapter_nike);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot nikeSnapshot : snapshot.getChildren()) {
                    Product product = nikeSnapshot.getValue(Product.class);
                    nike.add(product);
                }
                adapter_nike.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("Failed to read value.", error.toException());
            }
        });


//        nike.add(new Product("Nike Air Jordan 1 Low GS ‘White Gym Red’",R.drawable.nike_1));
//        nike.add(new Product("Nike Dunk Low Athletic Department Casual Shoes",R.drawable.nike_2));
//        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        ProductsAdapter adapter_nike = new ProductsAdapter(this, nike);
//        rv.setAdapter(adapter_nike);
//
//        adapter_nike.setOnItemClickListener(new ProductsAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(Product product) {
//                Intent intent = new Intent(ProductsActivity.this, detailproduct.class);
//                startActivity(intent);
//            }
//        });
//
//u


                //open cart
                imgcart = findViewById(R.id.cart);
        imgcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductsActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        //open message
        imgmess = findViewById(R.id.message);
        imgmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductsActivity.this, Message.class);
                startActivity(intent);
            }
        });

        //firebase
//        init();
//        loadNikeFromFireBase();
    }

//    private void init() {
//        productLoadListener = this;
//    }

//    private void loadNikeFromFireBase() {
//        List<Product> nike = new ArrayList<>();
//        FirebaseDatabase.getInstance().getReference("Nike")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            for (DataSnapshot productSnapshot : snapshot.getChildren()) {
//                                Product product = productSnapshot.getValue(Product.class);
//                                product.setKey(productSnapshot.getKey());
//                                nike.add(product);
//                            }
//                            productLoadListener.onProductLoadSuccess(nike);
//                        } else
//                            productLoadListener.onProductLoadFailed("Can't find product");
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//                        productLoadListener.onProductLoadFailed(error.getMessage());
//                    }
//                });
//    }

    @Override
    public void onProductLoadSuccess(List<Product> productList) {
        ProductsAdapter adapter_nike = new ProductsAdapter(this, productList);
        rv.setAdapter(adapter_nike);
    }

    @Override
    public void onProductLoadFailed(String message) {

    }
}