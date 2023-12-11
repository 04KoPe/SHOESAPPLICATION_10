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

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartHolder> {

    Context c;
    List<Cart> data;

    public CartAdapter(Context c, List<Cart> data) {
        this.c = c;
        this.data = data;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.cart_item, parent, false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        holder.txtName.setText(data.get(position).name);
        holder.txtPrice.setText(data.get(position).price);
        holder.txtSalePrice.setText(data.get(position).saleprice);
        holder.imgName.setImageResource(data.get(position).imgID);

        //chu gacg ngang
        String text = holder.txtPrice.getText().toString();
        SpannableString spannableString = new SpannableString(text);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString.setSpan(strikethroughSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.txtPrice.setText(spannableString);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
