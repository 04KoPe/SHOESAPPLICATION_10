package com.example.shoesapplication.Search;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapplication.HomePage.HomePage;
import com.example.shoesapplication.Notifications;
import com.example.shoesapplication.R;
import com.example.shoesapplication.account;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class search extends AppCompatActivity {

    private BottomNavigationView btnavview;

    private EditText searchText;

    private RecyclerView shoesRecyclerView;

    private DatabaseReference database;

    private Toolbar toolbar;

    RAdapter adapterR;
    ArrayList<Item> shoesList;

    public void getReference(){
        btnavview = findViewById(R.id.naviBtn);
        shoesRecyclerView = findViewById(R.id.searchItemRV);
        searchText = findViewById(R.id.searchTextBar);
        toolbar = findViewById(R.id.toolbar);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapterR.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterR.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.search_menu, menu);

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
        FirebaseRecyclerOptions<Item> options =
                new FirebaseRecyclerOptions.Builder<Item>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Shoes").
                                orderByChild("name").startAt(newText).endAt(newText+"\uf8ff"), Item.class)
                        .build();

        adapterR = new RAdapter(options);
        adapterR.startListening();
        shoesRecyclerView.setAdapter(adapterR);
    }

    public void CreatingItemList(){
        shoesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Item> options =
                new FirebaseRecyclerOptions.Builder<Item>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Shoes"), Item.class)
                        .build();

        adapterR = new RAdapter(options);
        shoesRecyclerView.setAdapter(adapterR);
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