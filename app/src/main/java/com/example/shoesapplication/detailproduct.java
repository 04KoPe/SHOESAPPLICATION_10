package com.example.shoesapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class detailproduct extends AppCompatActivity {
    BottomNavigationView btnavview;
    private boolean isRed = false;
    TextView txt_shoePrice, txt_shoeName, txtnumOrder, txt_shoeID, txt_shoeOldPrice;
    ImageView img_shoe;
    Button btnaddtocart, btnoder;
    ImageView btnminus, btnplus;
    private Button button36, button37, button38, button39, button40, button41, button42;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detaiproduct);

        txt_shoePrice = findViewById(R.id.txt_shoesPrice);
        txt_shoeOldPrice = findViewById(R.id.textgiacu);
        txt_shoeName = findViewById(R.id.txt_shoesName);
        txt_shoeID = findViewById(R.id.txt_prID);
        img_shoe = findViewById(R.id.img_shoes);

        String shoeName = getIntent().getExtras().getString("name");
        String shoeImage = getIntent().getExtras().getString("image");
        String shoePrice = getIntent().getExtras().getString("price");
        String shoeOldPrice = getIntent().getExtras().getString("oldPrice");
        String shoeID = getIntent().getExtras().getString("id");

        txt_shoeName.setText(shoeName);
        txt_shoePrice.setText("đ " + shoePrice);
        txt_shoeOldPrice.setText("đ " + shoeOldPrice);
        txt_shoeID.setText(shoeID);
        Picasso.get().load(shoeImage).into(img_shoe);

        //button minus, button plus
        txtnumOrder = findViewById(R.id.txt_numberOrder);
        btnminus = findViewById(R.id.btn_productMinus);
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(txtnumOrder.getText().toString());
                if (number > 1) {
                    number = number - 1;
                }
                txtnumOrder.setText(String.valueOf(number));
            }
        });

        btnplus = findViewById(R.id.btn_productPlus);
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(txtnumOrder.getText().toString());
                number = number + 1;
                txtnumOrder.setText(String.valueOf(number));
            }
        });


        button36 = findViewById(R.id.btn36);
        button37 = findViewById(R.id.btn37);
        button38 = findViewById(R.id.btn38);
        button39 = findViewById(R.id.btn39);
        button40 = findViewById(R.id.btn39);
        button41 = findViewById(R.id.btn41);
        button42 = findViewById(R.id.btn42);
        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button36.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button36.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });
        button37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button37.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button37.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });
        button38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button38.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button38.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });
        button39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button39.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button39.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });
        button40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button40.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button40.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });
        button41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button41.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button41.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });
        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button42.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button42.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });

        btnavview = findViewById(R.id.naviBtn);

        //dieu huong den cac trang
        btnavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.homeNav:
                        startActivity(new Intent(getApplicationContext(), HomePage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.accountNav:
                        startActivity(new Intent(getApplicationContext(), AccountDDNActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.searchNav:
                        startActivity(new Intent(getApplicationContext(), search.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.notificationNav:
                        startActivity(new Intent(getApplicationContext(), Notifications.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

//        Gạch ngang giá tiên
        TextView txtgiacu = findViewById(R.id.textgiacu);
        String text = txtgiacu.getText().toString();
        SpannableString spannableString = new SpannableString(text);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString.setSpan(strikethroughSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtgiacu.setText(spannableString);

        //open pay
        btnoder = findViewById(R.id.btn_odernow);
        btnoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detailproduct.this, Checkout.class);
                startActivity(intent);
            }
        });
        //add to cart
        btnaddtocart = findViewById(R.id.btn_addtocart);
        btnaddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cartID = txt_shoeID.getText().toString();
                DatabaseReference database = FirebaseDatabase.getInstance().getReference("Cart");
                database.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int quantity = Integer.parseInt(txtnumOrder.getText().toString());
                        if (snapshot.hasChild(cartID)) // Check if the cart item exists
                        {
                            Cart existingItem = snapshot.child(cartID).getValue(Cart.class);
                            if (existingItem != null) {
                                int newqtt = existingItem.getQuantity() + quantity;
                                float newttPrice = Float.parseFloat(shoePrice) * newqtt;
                                existingItem.setQuantity(newqtt);
                                existingItem.setTotalPrice(newttPrice);
                                database.child(cartID).setValue(existingItem);
                            }
                        } else {
                            Cart newCartItem = new Cart();
                            newCartItem.setName(shoeName);
                            newCartItem.setImage(shoeImage);
                            newCartItem.setPrice(shoePrice);
                            newCartItem.setOldPrice(shoeOldPrice);
                            newCartItem.setQuantity(quantity);
                            newCartItem.setTotalPrice(Float.parseFloat(shoePrice) * quantity);
                            database.child(cartID).setValue(newCartItem);
                        }
                        Toast.makeText(detailproduct.this, "Đã thêm sản phẩm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w("Failed to read value.", error.toException());
                    }
                });
            }
        });
    }
}
