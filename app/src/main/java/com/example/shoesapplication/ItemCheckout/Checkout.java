package com.example.shoesapplication.ItemCheckout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoesapplication.CartPackage.Cart;
import com.example.shoesapplication.Item;
import com.example.shoesapplication.ItemAdapter;
import com.example.shoesapplication.MainPage.HomePage;
import com.example.shoesapplication.Message;
import com.example.shoesapplication.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

public class Checkout extends AppCompatActivity {
    ImageView chuyenMess;

    RecyclerView checkOutView;


    Button logInBtn;
    public List<Item> getListItem() {
        List<Item> shoesList = new ArrayList<>();
        shoesList.add(new Item(R.drawable.shoes_2,"Jordan 1 High Tactical Boots", "Size: 8.5","Quantity: 1",R.string.deliveryFedEx,"Message"));
        return shoesList;
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkOutView = findViewById(R.id.itemCheckOutView);
        Query query = FirebaseDatabase.getInstance().getReference().child("Cart").orderByKey();
        FirebaseRecyclerOptions<Cart> cartOption = new FirebaseRecyclerOptions.Builder<Cart>().setQuery(query, Cart.class).build();
        CheckoutAdapter adapter = new CheckoutAdapter(cartOption);
        checkOutView.setAdapter(adapter);
        adapter.startListening();


        chuyenMess = (ImageView) findViewById(R.id.chuyenmess);
        chuyenMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Checkout.this, Message.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });


        logInBtn = (Button) findViewById(R.id.logInBtn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Checkout.this, HomePage.class);
                //Khởi chạy Intent
                startActivity(intent);
                Toast toast = Toast.makeText(Checkout.this, "Đã thanh toán thành công", Toast.LENGTH_SHORT);

                // Hiển thị thông báo
                toast.show();
            }
        });


        TextView subtotalText = findViewById(R.id.subtotalText);
        TextView shippingText =findViewById(R.id.shippingText);
        TextView totalText = findViewById(R.id.orderTotalText);;
        Double subTotal = getIntent().getDoubleExtra("total_price", 0);

        adapter.setOnDataChangedListener(new Runnable() {
            @Override
            public void run() {
                subtotalText.setText("Subtotal: " + String.format("%.0f", adapter.getTotal()) + "đ");
                double SHIPPING_PRICE = 10000f;
                shippingText.setText("Shipping: " + String.format("%.0f", SHIPPING_PRICE) + "đ");
                totalText.setText("Order Total:" + String.format("%.0f",adapter.getTotal() + SHIPPING_PRICE) +"đ");
            }
        });
    }
}