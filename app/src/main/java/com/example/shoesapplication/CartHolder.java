package com.example.shoesapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartHolder extends RecyclerView.ViewHolder{
    TextView txt_cartName, txtPrice, txtoldPrice, txtcartAmount;
    ImageView img_cartItem, imgplus, imgminus;

    public CartHolder(@NonNull View itemView) {
        super(itemView);
        txt_cartName = itemView.findViewById(R.id.txt_cartItemName);
        txtPrice = itemView.findViewById(R.id.txt_price);
        txtoldPrice = itemView.findViewById(R.id.txt_oldPrice);
        txtcartAmount = itemView.findViewById(R.id.txt_itemAmount);
        img_cartItem = itemView.findViewById(R.id.img_cartItem);

        imgminus = itemView.findViewById(R.id.btn_minus);
        imgplus = itemView.findViewById(R.id.btn_plus);
    }
}
