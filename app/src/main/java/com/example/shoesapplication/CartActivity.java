package com.example.shoesapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    RecyclerView rv;
    ImageView imgmess;
    Button btncheckout;
    TextView txtamount;
    CheckBox checkAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        txtamount = findViewById(R.id.txt_cartAmount);
        loadData();

        //get amount in cart
        DatabaseReference amountDatabase = FirebaseDatabase.getInstance().getReference("Cart");
        amountDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int itemCount = (int) snapshot.getChildrenCount();
                txtamount.setText("(" + String.valueOf(itemCount) + ")");
                if(itemCount==0){
                    checkAll.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("Failed to read value.", error.toException());
            }
        });

        checkAll = findViewById(R.id.all_item);

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
        btncheckout = findViewById(R.id.btn_checkout);
        btncheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, Checkout.class);
                startActivity(intent);
            }
        });
    }

    public void loadData() {
        rv = findViewById(R.id.recyclerview_cart);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<Cart> cartList = new ArrayList<>();
        CartAdapter adapter_cart = new CartAdapter(this, cartList);
        rv.setAdapter(adapter_cart);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("Cart");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cartList.clear();
                for (DataSnapshot Snapshot : snapshot.getChildren()) {
                    Cart cart = Snapshot.getValue(Cart.class);
                    cart.setKey(Snapshot.getKey());
                    cartList.add(cart);
                }
                adapter_cart.notifyDataSetChanged();

                checkAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (checkAll.isChecked()) {
                            adapter_cart.selectAll();
                        } else {
                            adapter_cart.unSelectAll();
                        }
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("Failed to read value.", error.toException());
            }
        });
    }
}