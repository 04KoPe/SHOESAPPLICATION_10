package com.example.shoesapplication.ProductPackage;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.example.shoesapplication.AccountPackage.AccountDDNActivity;
import com.example.shoesapplication.CartPackage.Cart;
import com.example.shoesapplication.ItemCheckout.Checkout;
import com.example.shoesapplication.MainPage.HomePage;
import com.example.shoesapplication.Notifications;
import com.example.shoesapplication.R;
import com.example.shoesapplication.SearchPackage.SearchActivity;
import com.example.shoesapplication.ShoesSize.Size;
import com.example.shoesapplication.ShoesSize.SizeAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class detailproduct extends AppCompatActivity {
    BottomNavigationView btnavview;
    TextView txt_shoePrice, txt_shoeName, txtnumOrder, txt_shoeID, txt_shoeOldPrice;
    ImageView img_shoe, img_backToProduct;
    Button btnaddtocart, btnoder;
    ImageView btnminus, btnplus;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detaiproduct);

        img_backToProduct = findViewById(R.id.img_backtoProduct);
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

        img_backToProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rv = findViewById(R.id.rv_size);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<Size> list = new ArrayList<>();
        list.add(new Size("36"));
        list.add(new Size("37"));
        list.add(new Size("38"));
        list.add(new Size("39"));
        list.add(new Size("40"));
        list.add(new Size("41"));
        list.add(new Size("42"));
        SizeAdapter sizeAdapter = new SizeAdapter(this, list);
        rv.setAdapter(sizeAdapter);


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
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
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

//        Gạch ngang giá tiền
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
