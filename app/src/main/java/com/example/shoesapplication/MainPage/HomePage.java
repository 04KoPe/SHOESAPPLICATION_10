package com.example.shoesapplication.MainPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.shoesapplication.AccountPackage.account;
import com.example.shoesapplication.Notifications;
import com.example.shoesapplication.R;
import com.example.shoesapplication.SearchPackage.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import me.relex.circleindicator.CircleIndicator;

public class HomePage extends AppCompatActivity {
    BottomNavigationView btnavview;

    private ViewPager jViewPager;
    private CircleIndicator jCircleIndicator;

    private AppCompatButton productBtn, cateBtn;

    private List<PhotoSlider> jListPhoto;

    public List<PhotoSlider> getListPhoto(){
        List<PhotoSlider> list = new ArrayList<>();
        list.add(new PhotoSlider(R.drawable.all_about_shoes_best_ppt_templates_259395));
        list.add(new PhotoSlider(R.drawable.fb));
        list.add(new PhotoSlider(R.drawable.linkedin));

        return list;

    }

    public void ReceivedComponent(){
        jViewPager = findViewById(R.id.shoesViewPager);
        jCircleIndicator = findViewById(R.id.shoesVPIndicator);
        btnavview = findViewById(R.id.naviBtn);
        btnavview.setSelectedItemId(R.id.homeNav);
        productBtn = findViewById(R.id.productsScrollable);
        cateBtn = findViewById(R.id.categoriesScrollable);
    }

    public void SetAdapter(){
        SliderAdapter adapter = new SliderAdapter((jListPhoto));
        jViewPager.setAdapter(adapter);
        jCircleIndicator.setViewPager(jViewPager);
    }

    public void ScrollableViewOnClick(){
       productBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomePage.this, com.example.shoesapplication.ProductPackage.Product.class));
           }
       });

        cateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, com.example.shoesapplication.CategoryPackage.categories.class));
            }
        });
    }

    public void DirectedActivity(){
        btnavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.accountNav:
                        startActivity(new Intent(getApplicationContext(), com.example.shoesapplication.AccountPackage.AccountDDNActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.homeNav:
                        return true;
                    case R.id.searchNav:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        jListPhoto = getListPhoto();

        ReceivedComponent();
        SetAdapter();
        DirectedActivity();
        ScrollableViewOnClick();

    }
}