package com.example.shoesapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rv = findViewById(R.id.recyclerview_cart);
        List<Cart> cart = new ArrayList<>();
        cart.add(new Cart("Nike Air Jordan 1 Low GS ‘White Gym Red’ 553560-118 Like Auth Shoes", "đ 900.000", "đ 880.000", R.drawable.nike_1));
        cart.add(new Cart("Nike Air Jordan 1 Low ‘True Blue Cement’ Like Auth Shoes", "đ 990.000", "đ 990.000", R.drawable.nike_3));
        cart.add(new Cart("Nike Air Jordan 1 Low ‘Ice Blue’ Like Auth Shoes", "đ 900.000", "đ 840.000", R.drawable.nike_4));
        cart.add(new Cart("Louis Vuitton Trainer Sneaker Pink Chalk Like Auth Shoes", "đ 800.000", "đ 720.000", R.drawable.nike_5));
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        CartAdapter adapter_cart = new CartAdapter(this, cart);
        rv.setAdapter(adapter_cart);
    }
}
