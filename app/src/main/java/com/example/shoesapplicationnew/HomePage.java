package com.example.shoesapplicationnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomePage extends AppCompatActivity {

    private ViewPager jViewPager;
    private CircleIndicator jCirleIndicator;

    private List<PhotoSlider> jListPhoto;

    public List<PhotoSlider> getListPhoto(){
        List<PhotoSlider> list = new ArrayList<>();
        list.add(new PhotoSlider(R.drawable.instagram));
        list.add(new PhotoSlider(R.drawable.fb));
        list.add(new PhotoSlider(R.drawable.linkedin));

        return list;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        jViewPager = findViewById(R.id.shoesViewPager);
        jCirleIndicator = findViewById(R.id.shoesVPIndicator);

        jListPhoto = getListPhoto();

        SliderAdapter adapter = new SliderAdapter((jListPhoto));
        jViewPager.setAdapter(adapter);
        jCirleIndicator.setViewPager(jViewPager);



    }
}