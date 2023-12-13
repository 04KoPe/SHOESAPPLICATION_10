package com.example.shoesapplication.SearchPackage;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shoesapplication.ProductPackage.Product;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shoesapplication.ProductPackage.detailproduct;
import com.example.shoesapplication.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchAdapter extends FirebaseRecyclerAdapter<Product, SearchAdapter.viewHolder> {


    public SearchAdapter(@NonNull FirebaseRecyclerOptions<Product> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull Product model) {
        holder.itemName.setText(model.getName());
        holder.itemOldPrice.setText("Old Price: " + model.getOldPrice());
        holder.itemNewPrice.setText("New Price: " + model.getPrice());
        holder.model = model;
        Glide.with(holder.itemIMG.getContext())
                .load(model.getImage())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.itemIMG);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shoes_search_model,parent, false);
        return new viewHolder(view);
    }

    static class viewHolder extends RecyclerView.ViewHolder{
        CircleImageView itemIMG;
        TextView itemName, itemOldPrice, itemNewPrice;
        Product model;

        public viewHolder(@NonNull View itemView){
            super(itemView);
            itemView.setOnClickListener(v -> {
                Context context = v.getContext();
                Intent intent = new Intent(context, detailproduct.class);
                intent.putExtra("name", model.getName());
                intent.putExtra("image", model.getImage());
                intent.putExtra("price", model.getPrice());
                intent.putExtra("oldPrice", model.getOldPrice());
                intent.putExtra("id", model.getKey());
                context.startActivity(intent);
            });
            itemIMG = itemView.findViewById(R.id.shoesIMG);
            itemName = itemView.findViewById(R.id.shoesName);
            itemOldPrice = itemView.findViewById(R.id.shoesOldPrice);
            itemNewPrice = itemView.findViewById(R.id.shoesNewPrice);

        }

    }
}
