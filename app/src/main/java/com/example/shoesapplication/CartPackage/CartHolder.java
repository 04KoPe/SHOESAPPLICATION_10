package com.example.shoesapplication.CartPackage;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapplication.R;

public class CartHolder extends RecyclerView.ViewHolder {
    TextView txt_cartName, txtPrice, txtoldPrice, txtcartAmount;
    ImageView img_cartItem, imgplus, imgminus, imgdeleleItem;
    CheckBox itemCheck;

    public CartHolder(@NonNull View itemView) {
        super(itemView);
        txt_cartName = itemView.findViewById(R.id.txt_cartItemName);
        txtPrice = itemView.findViewById(R.id.txt_price);
        txtoldPrice = itemView.findViewById(R.id.txt_oldPrice);
        txtcartAmount = itemView.findViewById(R.id.txt_itemAmount);
        img_cartItem = itemView.findViewById(R.id.img_cartItem);

        imgminus = itemView.findViewById(R.id.btn_minus);
        imgplus = itemView.findViewById(R.id.btn_plus);
        imgdeleleItem = itemView.findViewById(R.id.img_deleteCartItem);

        itemCheck = itemView.findViewById(R.id.ck_checkItem);
    }
}
