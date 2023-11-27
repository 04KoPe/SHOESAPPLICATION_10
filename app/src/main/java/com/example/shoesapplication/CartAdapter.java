package com.example.shoesapplication;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartHolder> {

    Context c;
    List<Cart> cartList;

    public CartAdapter(Context c, List<Cart> cartList) {
        this.c = c;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.cart_item, parent, false);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Handle long click event
                notifyDataSetChanged();
                return true;
            }
        });
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        Cart cart = cartList.get(position);
        holder.txt_cartName.setText(cart.getName());
        holder.txtPrice.setText(cart.getPrice());
        holder.txtoldPrice.setText(cart.getOldPrice());
//        holder.txttotalItemPrice.setText(String.valueOf(cart.getTotalPrice()));
        holder.txtcartAmount.setText(String.valueOf(cart.getQuantity()));
        Picasso.get().load(cart.getImage()).into(holder.img_cartItem);


        //btn delete item
        holder.imgdeleleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemId = cart.getKey();
                cartList.clear();
                FirebaseDatabase.getInstance().getReference("Cart").child(itemId).removeValue();
            }
        });

        //btn_plus
        holder.imgplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //chu gacg ngang
        String text = holder.txtoldPrice.getText().toString();
        SpannableString spannableString = new SpannableString(text);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString.setSpan(strikethroughSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.txtoldPrice.setText(spannableString);
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }
    public void updateData(List<Cart> newData) {
        this.cartList = newData;
        notifyDataSetChanged();

    }
}
