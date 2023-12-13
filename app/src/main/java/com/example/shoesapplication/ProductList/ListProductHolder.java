package com.example.shoesapplication.ProductList;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapplication.R;

public class ListProductHolder extends RecyclerView.ViewHolder {
    TextView txtBrandName;
    RecyclerView rvShoes;
    public ListProductHolder(@NonNull View itemView) {
        super(itemView);
        txtBrandName = itemView.findViewById(R.id.txt_brand);
        rvShoes = itemView.findViewById(R.id.rv_shoes);
    }
}
