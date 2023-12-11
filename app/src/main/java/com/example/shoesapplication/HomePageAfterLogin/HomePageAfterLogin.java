package com.example.shoesapplication.HomePageAfterLogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.shoesapplication.Log.LogInActivity;
import com.example.shoesapplication.Notifications;
import com.example.shoesapplication.R;
import com.example.shoesapplication.Search.search;
import com.example.shoesapplication.account;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomePageAfterLogin extends AppCompatActivity {

    BottomNavigationView btnavview;

    private ViewPager jViewPager;
    private CircleIndicator jCirleIndicator;
    private List<PhotoSlider_1> jListPhoto;
    private TextView welcome;

    public void ReceivedComponent(){
        jViewPager = findViewById(R.id.shoesViewPager);
        jCirleIndicator = findViewById(R.id.shoesVPIndicator);
        btnavview = findViewById(R.id.naviBtn);
        btnavview.setSelectedItemId(R.id.homeNav);
        welcome = findViewById(R.id.welcomeText);
    }

    public List<PhotoSlider_1> getListPhoto(){
        List<PhotoSlider_1> list = new ArrayList<>();
        list.add(new PhotoSlider_1(R.drawable.all_about_shoes_best_ppt_templates_259395));
        list.add(new PhotoSlider_1(R.drawable.fb));
        list.add(new PhotoSlider_1(R.drawable.linkedin));

        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_after_login);

        ReceivedComponent();

        jListPhoto = getListPhoto();

        SliderAdapter_1 adapter = new SliderAdapter_1((jListPhoto));
        jViewPager.setAdapter(adapter);
        jCirleIndicator.setViewPager(jViewPager);

        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageAfterLogin.this, LogInActivity.class));
            }
        });

        //dieu huong den cac trang
        btnavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.accountNav:
                        startActivity(new Intent(getApplicationContext(), account.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.homeNav:
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