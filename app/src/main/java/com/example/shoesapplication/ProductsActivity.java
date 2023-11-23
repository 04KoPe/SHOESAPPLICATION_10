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

//        // Write nike shoes to the database
//        FirebaseDatabase nikeDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference nikeRef = nikeDatabase.getReference("Sneakers/Nike");
//
//        nikeRef.child("01").child("name").setValue("Nike Air Jordan 1 Low GS ‘White Gym Red’");
//        nikeRef.child("01").child("price").setValue("800.000");
//        nikeRef.child("01").child("image").setValue("https://www.pricerunner.com/product/1200x630/3001856768/Nike-Air-Jordan-1-Low-GS-White-Gym-Red-Black.jpg");
//
//        nikeRef.child("02").child("name").setValue("Nike Dunk Low Athletic Department Casual Shoes");
//        nikeRef.child("02").child("price").setValue("820.000");
//        nikeRef.child("02").child("image").setValue("https://cdn.flightclub.com/750/TEMPLATE/374011/1.jpg");
//
//        nikeRef.child("03").child("name").setValue("Nike Air Jordan 1 Low ‘Ice Blue’ Like Auth Shoes");
//        nikeRef.child("03").child("price").setValue("920.000");
//        nikeRef.child("03").child("image").setValue("https://shopgiayreplica.com/wp-content/uploads/2023/05/air-jordan-1-low-se-reverse-ice-blue.jpg");
//
//        // Write converse shoes to the database
//        FirebaseDatabase converseDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference converseRef = converseDatabase.getReference("Sneakers/Converse");
//
//        converseRef.child("01").child("name").setValue("Converse Chuck Taylor All Star Construct");
//        converseRef.child("01").child("price").setValue("900.000");
//        converseRef.child("01").child("image").setValue("https://product.hstatic.net/200000265619/product/a02832c-01-web_b944845b8e7945a1851dc890140ee7af_1024x1024.jpg");
//
//        converseRef.child("02").child("name").setValue("Converse Chuck 70 Patchwork Floral");
//        converseRef.child("02").child("price").setValue("950.000");
//        converseRef.child("02").child("image").setValue("https://m.media-amazon.com/images/I/51ywaDC0F5L._AC_SY695_.jpg");
//
//        // Write vans shoes to the database
//        FirebaseDatabase vansDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference vansRef = vansDatabase.getReference("Sneakers/Vans");
//
//        vansRef.child("01").child("name").setValue("Vans Classic Authentic Shoes");
//        vansRef.child("01").child("price").setValue("500.000");
//        vansRef.child("01").child("image").setValue("https://bizweb.dktcdn.net/thumb/1024x1024/100/140/774/products/vans-authentic-classic-black-vn000ee3blk-1.png");
//
//        vansRef.child("02").child("name").setValue("Vans Off The Wall Shoes");
//        vansRef.child("02").child("price").setValue("900.000");
//        vansRef.child("02").child("image").setValue("https://bizweb.dktcdn.net/thumb/1024x1024/100/347/923/products/vn0a38g1vri-5.png");

        //


        //////////
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

        //get nike shoes from realtime database
        rv = findViewById(R.id.rv_product);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<ListProduct> listProducts = new ArrayList<>();
        ListProductAdapter listProductAdapter = new ListProductAdapter(this, listProducts);
        rv.setAdapter(listProductAdapter);

        database = FirebaseDatabase.getInstance().getReference("Sneakers");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot brandSnapshot : snapshot.getChildren()) {
                    String brandName = brandSnapshot.getKey();
                    List<Product> products = new ArrayList<>();
                    for (DataSnapshot productSnapshot : brandSnapshot.getChildren()) {
                        Product product = productSnapshot.getValue(Product.class);
                        product.setKey(productSnapshot.getKey());
                        products.add(product);
                    }
                    ListProduct listProduct = new ListProduct(brandName, products);
                    listProducts.add(listProduct);
                }
                listProductAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("Failed to read value.", error.toException());
            }
        });


        //get converse shoes from realtime database
//        rv = findViewById(R.id.recyclerview_converse);
//        database = FirebaseDatabase.getInstance().getReference("Sneakers/Converse");
//        rv.setHasFixedSize(true);
//        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//
//        List<Product> converse = new ArrayList<>();
//        ProductsAdapter adapter_converse = new ProductsAdapter(this, converse);
//        rv.setAdapter(adapter_converse);
//
//        database.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot converseSnapshot : snapshot.getChildren()) {
//                    Product product = converseSnapshot.getValue(Product.class);
//                    converse.add(product);
//                }
//                adapter_converse.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.w("Failed to read value.", error.toException());
//            }
//        });
//
//        //get vans shoes from realtime database
//        rv = findViewById(R.id.recyclerview_vans);
//        database = FirebaseDatabase.getInstance().getReference("Sneakers/Vans");
//        rv.setHasFixedSize(true);
//        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//
//        List<Product> vans = new ArrayList<>();
//        ProductsAdapter adapter_vans = new ProductsAdapter(this, vans);
//        rv.setAdapter(adapter_vans);
//
//        database.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot vansSnapshot : snapshot.getChildren()) {
//                    Product product = vansSnapshot.getValue(Product.class);
//                    vans.add(product);
//                }
//                adapter_vans.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.w("Failed to read value.", error.toException());
//            }
//        });


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
//        rv= findViewById(R.id.recyclerview_converse);
//        List<Product> converse = new ArrayList<>();
//        converse.add(new Product("Converse Chuck Taylor All Star Construct",R.drawable.converse_1));
//        converse.add(new Product("Converse Converse Chuck 70 Patchwork Floral",R.drawable.converse_2));
//        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        ProductsAdapter adapter_converse = new ProductsAdapter(this, converse);
//        rv.setAdapter(adapter_converse);
//
//        rv= findViewById(R.id.recyclerview_vans);
//        List<Product> vans = new ArrayList<>();
//        vans.add(new Product("Vans Classic Authentic Shoes",R.drawable.vans_1));
//        vans.add(new Product("Vans Off The Wall Shoes",R.drawable.vans_2));
//        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        ProductsAdapter adapter_vans = new ProductsAdapter(this, vans);
//        rv.setAdapter(adapter_vans);


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