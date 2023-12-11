package com.example.shoesapplication.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapplication.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.SViewHolder> {

    Context searchActivity;

    ArrayList<Item> shoesList;


    @NonNull
    @Override
    public SViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View shoesView = LayoutInflater.from(searchActivity).inflate(R.layout.shoes_search_model, parent, false);
        return new SViewHolder(shoesView);
    }

    @Override
    public void onBindViewHolder(@NonNull SViewHolder holder, int position) {

        Item shoes = shoesList.get(position);
        holder.itemIMG.setImageResource(shoes.getShoesIMG());
        holder.itemName.setText(shoes.getShoesName());
        holder.itemSize.setText(shoes.getShoesSize());
        holder.itemQuantity.setText(shoes.getShoesQuantity());

    }

    @Override
    public int getItemCount() {
        return shoesList.size();
    }

    public static class SViewHolder extends RecyclerView.ViewHolder {

        TextView itemName, itemQuantity, itemSize;
        ImageView itemIMG;

        public SViewHolder(View shoesView){
            super(shoesView);

            itemIMG = shoesView.findViewById(R.id.shoesIMG);

            itemName = shoesView.findViewById(R.id.shoesName);

            itemQuantity = shoesView.findViewById(R.id.shoesQuantity);

            itemSize = shoesView.findViewById(R.id.shoesSize);

        }

    }
}
