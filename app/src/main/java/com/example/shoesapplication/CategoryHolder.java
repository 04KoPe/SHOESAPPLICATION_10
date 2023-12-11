package com.example.shoesapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryHolder extends RecyclerView.ViewHolder {
    TextView txt_typeName, txt_typeAmount;
    ImageView img_type;

    public CategoryHolder(@NonNull View itemView) {
        super(itemView);
        txt_typeName = itemView.findViewById(R.id.txt_typeName);
        txt_typeAmount = itemView.findViewById(R.id.txt_typeAmount);
        img_type = itemView.findViewById(R.id.img_type);
    }
}
