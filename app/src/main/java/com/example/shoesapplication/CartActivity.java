package com.example.shoesapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    RecyclerView rv;
    ImageView imgmess;
    Button btncheckout;
    private ArrayList<String> productIds;
    private List<Cart> cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rv = findViewById(R.id.recyclerview_cart);
        productIds = new ArrayList<>();
        cart = new ArrayList<>();
        cart.add(new Cart("1","Nike Air Jordan 1 Low GS ‘White Gym Red’ 553560-118 Like Auth Shoes", 900000, 880000, 1, R.drawable.nike_1));
        cart.add(new Cart("2","Nike Air Jordan 1 Low ‘True Blue Cement’ Like Auth Shoes", 990000, 790000, 2, R.drawable.nike_3));
        cart.add(new Cart("3", "Nike Air Jordan 1 Low ‘Ice Blue’ Like Auth Shoes", 900000, 840000,1, R.drawable.nike_4));
        cart.add(new Cart("4", "Louis Vuitton Trainer Sneaker Pink Chalk Like Auth Shoes", 900000, 720000,1, R.drawable.nike_5));
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        CartAdapter adapter_cart = new CartAdapter(this, cart);
        adapter_cart.setOnCheckListener((isChecked, id) -> {
            if(isChecked) {
                productIds.add(id);
            } else {
                productIds.remove(id);
            }
        });
        rv.setAdapter(adapter_cart);


        //open message
        imgmess = findViewById(R.id.img_message);
        imgmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, Message.class);
                startActivity(intent);
            }
        });

        //open pay
        btncheckout=findViewById(R.id.btn_checkout);
        btncheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double totalPrice = 0f;
                for(Cart item : cart) {
                    if(productIds.contains(item.id)) {
                        totalPrice += item.salePrice * item.quantity;
                    }
                }
                Intent intent = new Intent(CartActivity.this, Checkout.class);
                intent.putExtra("total_price", totalPrice);
                startActivity(intent);
            }
        });
    }
}