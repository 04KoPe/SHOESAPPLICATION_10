package com.example.shoesapplication.SearchPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapplication.MainPage.HomePage;
import com.example.shoesapplication.Notifications;
import com.example.shoesapplication.ProductPackage.Product;
import com.example.shoesapplication.R;
import com.example.shoesapplication.AccountPackage.account;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private BottomNavigationView btnavview;

    private EditText searchText;

    private RecyclerView shoesRecyclerView;

    private DatabaseReference database;

    private Toolbar toolbar;

    private AppCompatButton detailBtn;

    SearchAdapter adapter;
    ArrayList<Item> shoesList;

    public void getReference(){
        btnavview = findViewById(R.id.naviBtn);
        shoesRecyclerView = findViewById(R.id.searchItemRV);
        searchText = findViewById(R.id.searchTextBar);
        toolbar = findViewById(R.id.toolbar);
        detailBtn = findViewById(R.id.viewDetailBtn);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_item, menu);

        MenuItem item = menu.findItem(R.id.searchId);

        SearchView searchView =(SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newText) {
                MySearch(newText);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                MySearch(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void MySearch(String newText) {
        FirebaseRecyclerOptions<Product> options =
                new FirebaseRecyclerOptions.Builder<Product>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Shoes").
                                orderByChild("name").startAt(newText).endAt(newText+"\uf8ff"), Product.class)
                        .build();

        adapter = new SearchAdapter(options);
        adapter.startListening();
        shoesRecyclerView.setAdapter(adapter);
    }

    public void CreatingItemList(){
        shoesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Product> options =
                new FirebaseRecyclerOptions.Builder<Product>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Sneakers").child("Converse"), Product.class)
                        .build();

        adapter = new SearchAdapter(options);
        shoesRecyclerView.setAdapter(adapter);
    }


    public void BottomNavBar(){
        btnavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.accountNav:
                        startActivity(new Intent(getApplicationContext(), account.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.homeNav:
                        startActivity(new Intent(getApplicationContext(), HomePage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.searchNav:
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

    public void CreatingSearchBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        getReference();
        CreatingItemList();
        BottomNavBar();
        CreatingSearchBar();

    }
}