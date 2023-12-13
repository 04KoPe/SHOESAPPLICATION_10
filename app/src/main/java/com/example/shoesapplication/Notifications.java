package com.example.shoesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.shoesapplication.AccountPackage.AccountDDNActivity;
import com.example.shoesapplication.CartPackage.CartActivity;
import com.example.shoesapplication.MainPage.HomePage;
import com.example.shoesapplication.SearchPackage.SearchActivity;

public class Notifications extends AppCompatActivity {
    private ImageView imgcart, imgmess, imghome, imgacc, imgsearsh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notications);


        imgcart = (ImageView) findViewById(R.id.img_cart);

        imgcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển đổi activity để khi nhấn vào imageview nó chuyển qua layout khác
                Intent intent = new Intent(Notifications.this, CartActivity.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });
        imgmess = (ImageView) findViewById(R.id.img_message);

        imgmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển đổi activity để khi nhấn vào imageview nó chuyển qua layout khác
                Intent intent = new Intent(Notifications.this,Message.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });


        imgsearsh = (ImageView) findViewById(R.id.imgsearch);

        imgsearsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển đổi activity để khi nhấn vào imageview nó chuyển qua layout khác
                Intent intent = new Intent(Notifications.this, SearchActivity.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });
        imghome = (ImageView) findViewById(R.id.imghome);

        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển đổi activity để khi nhấn vào imageview nó chuyển qua layout khác
                Intent intent = new Intent(Notifications.this, HomePage.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });
        imgacc = (ImageView) findViewById(R.id.imgacc);

        imgacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển đổi activity để khi nhấn vào imageview nó chuyển qua layout khác
                Intent intent = new Intent(Notifications.this, AccountDDNActivity.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });

    }
}