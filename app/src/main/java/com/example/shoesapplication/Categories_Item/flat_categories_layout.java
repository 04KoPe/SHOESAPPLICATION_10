package com.example.shoesapplication.Categories_Item;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.shoesapplication.R;

public class flat_categories_layout extends AppCompatActivity {

    private ImageView clickbackView, messView, cartView;

    public void ReceivedComponent(){
        clickbackView = findViewById(R.id.backtocategories_arrow_flat);
        messView = findViewById(R.id.boot_layout_message);
        cartView = findViewById(R.id.boot_layout_cart);
    }

    public void ClickListener(){
        clickbackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(flat_categories_layout.this, categories.class));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flat_categories_layout);

        ReceivedComponent();
        ClickListener();
    }
}