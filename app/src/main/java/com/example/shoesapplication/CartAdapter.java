package com.example.shoesapplication;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

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
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        Cart cart = cartList.get(position);
        holder.txt_cartName.setText(cart.getName());
        holder.txtPrice.setText(cart.getPrice());
        holder.txtoldPrice.setText(cart.getOldPrice());
        holder.txtcartAmount.setText(String.valueOf(cart.getQuantity()));
        Picasso.get().load(cart.getImage()).into(holder.img_cartItem);

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

    //btn_plus
    public void plusNumber(List<Cart> cartList, int position) {

    }


    @Override
    public int getItemCount() {
        return cartList.size();
    }
}
