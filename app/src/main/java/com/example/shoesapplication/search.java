package com.example.shoesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class search extends AppCompatActivity {
    private ImageView imgnoti, imghome, imgacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        imgnoti = (ImageView) findViewById(R.id.imgnoti);

        imgnoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển đổi activity để khi nhấn vào imageview nó chuyển qua layout khác
                Intent intent = new Intent(search.this,Notifications.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });
        imghome = (ImageView) findViewById(R.id.imghome);

        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển đổi activity để khi nhấn vào imageview nó chuyển qua layout khác
                Intent intent = new Intent(search.this,HomePage.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });
        imgacc = (ImageView) findViewById(R.id.imgacc);

        imgacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển đổi activity để khi nhấn vào imageview nó chuyển qua layout khác
                Intent intent = new Intent(search.this,AccountDDNActivity.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });
    }
}