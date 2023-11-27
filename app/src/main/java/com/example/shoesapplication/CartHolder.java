package com.example.shoesapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartHolder extends RecyclerView.ViewHolder{
    TextView txt_cartName, txtPrice, txtoldPrice, txtcartAmount, txttotalItemPrice;
    ImageView img_cartItem, imgplus, imgminus, imgdeleleItem;

    public CartHolder(@NonNull View itemView) {
        super(itemView);
        txt_cartName = itemView.findViewById(R.id.txt_cartItemName);
        txtPrice = itemView.findViewById(R.id.txt_price);
        txtoldPrice = itemView.findViewById(R.id.txt_oldPrice);
        txtcartAmount = itemView.findViewById(R.id.txt_itemAmount);
        img_cartItem = itemView.findViewById(R.id.img_cartItem);
//        txttotalItemPrice = itemView.findViewById(R.id.txt_totalItemPrice);

        imgminus = itemView.findViewById(R.id.btn_minus);
        imgplus = itemView.findViewById(R.id.btn_plus);
        imgdeleleItem = itemView.findViewById(R.id.img_deleteCartItem);
    }
}
