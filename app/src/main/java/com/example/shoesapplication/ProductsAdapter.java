package com.example.shoesapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsHolder> {

    Context c;
    List<Product> data;

    public ProductsAdapter(Context c, List<Product> data) {
        this.c = c;
        this.data = data;
    }

    @NonNull
    @Override
    public ProductsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.products_item, parent, false);
        return new ProductsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsHolder holder, int position) {
        holder.txtName.setText(data.get(position).name);
        holder.imgName.setImageResource(data.get(position).imgID);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
