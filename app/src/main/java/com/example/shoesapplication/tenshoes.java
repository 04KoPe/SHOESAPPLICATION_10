package com.example.shoesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class tenshoes extends AppCompatActivity {
    TextView txttenshoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tenshoes_main);

        //open pay
        txttenshoes=findViewById(R.id.txt_tenshoes);
        txttenshoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tenshoes.this, HomePage.class);
                startActivity(intent);
            }
        });
    }
}