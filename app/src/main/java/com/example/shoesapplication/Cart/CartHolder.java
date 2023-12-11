package com.example.shoesapplication.Cart;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapplication.R;

public class CartHolder extends RecyclerView.ViewHolder{
    TextView txtName, txtPrice, txtSalePrice;
    ImageView imgName;

    public CartHolder(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.text_name);
        txtPrice = itemView.findViewById(R.id.price);
        txtSalePrice = itemView.findViewById(R.id.sale_price);
        imgName = itemView.findViewById(R.id.image_name);
    }
}
