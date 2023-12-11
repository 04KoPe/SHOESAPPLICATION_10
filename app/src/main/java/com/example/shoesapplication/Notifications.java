package com.example.shoesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Notifications extends AppCompatActivity {
    private ImageView imgcart, imgmess, imghome, imgacc, imgsearsh;
    Button btnShowNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notications);









        imgcart = (ImageView) findViewById(R.id.img_cart);

        imgcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển đổi activity để khi nhấn vào imageview nó chuyển qua layout khác
                Intent intent = new Intent(Notifications.this,CartActivity.class);
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


        btnShowNow = (Button) findViewById(R.id.btnShowNow);
        btnShowNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Notifications.this,HomePage.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });



        imgsearsh = (ImageView) findViewById(R.id.imgsearch);

        imgsearsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển đổi activity để khi nhấn vào imageview nó chuyển qua layout khác
                Intent intent = new Intent(Notifications.this,search.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });
        imghome = (ImageView) findViewById(R.id.imghome);

        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển đổi activity để khi nhấn vào imageview nó chuyển qua layout khác
                Intent intent = new Intent(Notifications.this,HomePage.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });
        imgacc = (ImageView) findViewById(R.id.imgacc);

        imgacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển đổi activity để khi nhấn vào imageview nó chuyển qua layout khác
                Intent intent = new Intent(Notifications.this,AccountDDNActivity.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });

    }
}