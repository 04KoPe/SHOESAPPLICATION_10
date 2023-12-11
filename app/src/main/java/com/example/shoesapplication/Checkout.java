package com.example.shoesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Checkout extends AppCompatActivity {
    ImageView chuyenmess;
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





        chuyenmess = (ImageView) findViewById(R.id.chuyenmess);
        chuyenmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Checkout.this,Message.class);
                //Khởi chạy Intent
                startActivity(intent);
            }
        });


        logInBtn = (Button) findViewById(R.id.logInBtn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Checkout.this,HomePage.class);
                //Khởi chạy Intent
                startActivity(intent);
                Toast toast = Toast.makeText(Checkout.this, "Đã thanh toán thành công", Toast.LENGTH_SHORT);

                // Hiển thị thông báo
                toast.show();
            }
        });


        TextView subtotalText = findViewById(R.id.subtotalText);
        TextView shippingText =findViewById(R.id.shippingText);
        TextView totalText = findViewById(R.id.orderTotalText);
        ListView listview = findViewById(R.id.itemInfo);
        Double subTotal = getIntent().getDoubleExtra("total_price", 0);
        subtotalText.setText("Subtotal: " + String.format("%.0f", subTotal) + "đ");
        double SHIPPING_PRICE = 10000f;
        shippingText.setText("Shipping: " + String.format("%.0f", SHIPPING_PRICE) + "đ");
        totalText.setText("Order Total:" + String.format("%.0f",subTotal + SHIPPING_PRICE) +"đ");


        ItemAdapter adapter = new ItemAdapter(this, R.layout.item_checkout_information,R.layout.item_checkout_message,getListItem());
        listview.setAdapter(adapter);
    }
}