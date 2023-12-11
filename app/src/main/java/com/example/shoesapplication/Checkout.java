package com.example.shoesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Checkout extends AppCompatActivity {


    public List<Item> getListItem() {
        List<Item> shoesList = new ArrayList<>();
        shoesList.add(new Item(R.drawable.shoes_2,"Jordan 1 High Tactical Boots", "Size: 8.5","Quantity: 1",R.string.deliveryFedEx,"Message"));
        return shoesList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        ListView listview = findViewById(R.id.itemInfo);


        ItemAdapter adapter = new ItemAdapter(this, R.layout.item_checkout_information,R.layout.item_checkout_message,getListItem());
        listview.setAdapter(adapter);
    }
}