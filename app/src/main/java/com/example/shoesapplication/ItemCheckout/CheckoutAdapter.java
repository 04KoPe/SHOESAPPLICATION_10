package com.example.shoesapplication.ItemCheckout;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shoesapplication.CartPackage.Cart;
import com.example.shoesapplication.CartPackage.CartHolder;
import com.example.shoesapplication.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

public class CheckoutAdapter extends FirebaseRecyclerAdapter<Cart, CheckoutAdapter.CheckoutViewHolder> {

    private Runnable onDataChangedListener;
    public CheckoutAdapter(@NonNull FirebaseRecyclerOptions<Cart> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CheckoutViewHolder holder, int position, @NonNull Cart model) {
        holder.productName.setText(model.getName());
        Glide.with(holder.productImage).load(model.getImage()).into(holder.productImage);
        holder.priceTextView.setText(model.getPrice());
        holder.oldPriceTextView.setText(model.getOldPrice());
        holder.productQuantity.setText("Quantity: " + Integer.toString(model.getQuantity()));
    }

    @NonNull
    @Override
    public CheckoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_checkout_information, parent, false);
        return new CheckoutViewHolder(view);
    }

    @Override
    public void onDataChanged() {
        super.onDataChanged();
        if (onDataChangedListener != null)
            onDataChangedListener.run();
    }

    public void setOnDataChangedListener(Runnable listener) {
        onDataChangedListener = listener;
    }

    public float getTotal() {
        float total = 0;
        for (int i = 0; i < getItemCount(); ++i)
            total += getItem(i).getTotalPrice();
        return total;
    }


    class CheckoutViewHolder extends RecyclerView.ViewHolder{
        TextView productName;
        ImageView productImage;
        TextView oldPriceTextView;
        TextView priceTextView;
        TextView productQuantity;

        public CheckoutViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.shoesName);
            productImage = itemView.findViewById(R.id.shoesIMG);
            oldPriceTextView = itemView.findViewById(R.id.shoesOldPrice);
            priceTextView = itemView.findViewById(R.id.shoesNewPrice);
            productQuantity = itemView.findViewById(R.id.shoesQuantity);
        }
    }

}
