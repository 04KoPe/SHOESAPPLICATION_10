package com.example.shoesapplication.Search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shoesapplication.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class RAdapter extends FirebaseRecyclerAdapter<Item, RAdapter.viewHolder> {


    public RAdapter(@NonNull FirebaseRecyclerOptions<Item> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull Item model) {
        holder.itemName.setText(model.getName());
        holder.itemOldPrice.setText("Old Price: " + model.getOldPrice());
        holder.itemNewPrice.setText("New Price: " + model.getPrice());

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

        public viewHolder(@NonNull View itemView){
            super(itemView);

            itemIMG = itemView.findViewById(R.id.shoesIMG);
            itemName = itemView.findViewById(R.id.shoesName);
            itemOldPrice = itemView.findViewById(R.id.shoesOldPrice);
            itemNewPrice = itemView.findViewById(R.id.shoesNewPrice);

        }

    }
}
