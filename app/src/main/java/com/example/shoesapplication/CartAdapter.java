package com.example.shoesapplication;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartHolder> {

    Context c;
    List<Cart> cartList;
    public boolean isAllChecked = false;
    List<Integer> selected = new ArrayList<>();
    float total = 0;

    public CartAdapter(Context c, List<Cart> cartList) {
        this.c = c;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.cart_item, parent, false);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Handle long click event
                notifyDataSetChanged();
                return true;
            }
        });
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        Cart cart = cartList.get(position);
        holder.txt_cartName.setText(cart.getName());
        holder.txtPrice.setText("đ " + cart.getPrice());
        holder.txtoldPrice.setText("đ " + cart.getOldPrice());
        holder.txtcartAmount.setText(String.valueOf(cart.getQuantity()));
        Picasso.get().load(cart.getImage()).into(holder.img_cartItem);

        int index = holder.getAdapterPosition();

        //btn delete item
        holder.imgdeleleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemId = cart.getKey();
                cartList.clear();
                FirebaseDatabase.getInstance().getReference("Cart").child(itemId).removeValue();
                if (holder.itemCheck.isChecked()) {
                    total -= cart.getTotalPrice();
                    grandTotal(total);
                }
            }
        });

        //btn_plus
        holder.imgplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.setQuantity(cart.getQuantity() + 1);
                float newttPrice = Float.parseFloat(cart.getPrice()) * cart.getQuantity();
                cart.setTotalPrice(newttPrice);
                String itemId = cart.getKey();
                FirebaseDatabase.getInstance().getReference("Cart").child(itemId).setValue(cart);
                if (holder.itemCheck.isChecked()) {
                    total += Float.parseFloat(cart.getPrice());
                    grandTotal(total);
                }
            }
        });


        //btn_plus
        holder.imgminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cart.getQuantity() > 1) {
                    cart.setQuantity(cart.getQuantity() - 1);
                    float newttPrice = Float.parseFloat(cart.getPrice()) * cart.getQuantity();
                    cart.setTotalPrice(newttPrice);
                    String itemId = cart.getKey();
                    FirebaseDatabase.getInstance().getReference("Cart").child(itemId).setValue(cart);
                    if (holder.itemCheck.isChecked()) {
                        total -= Float.parseFloat(cart.getPrice());
                        grandTotal(total);
                    }
                }
            }
        });

        //check to buy product
        holder.itemCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    total += cart.getTotalPrice();
                    if (!selected.contains(index))
                        selected.add(index);
                } else {
                    total -= cart.getTotalPrice();
                    CheckBox checkAll = ((CartActivity) c).findViewById(R.id.all_item);
                    checkAll.setChecked(false);
                    if (selected.contains(index))
                        selected.remove(Integer.valueOf(index));
                }
                grandTotal(total);
            }
        });


        //check item
        if (selected.contains(index)) {
            holder.itemCheck.setChecked(true);
        } else holder.itemCheck.setChecked(false);

        //chu gacg ngang
        String text = holder.txtoldPrice.getText().toString();
        SpannableString spannableString = new SpannableString(text);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString.setSpan(strikethroughSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.txtoldPrice.setText(spannableString);
    }

    public void grandTotal(float total) {
        TextView txtcartTotal = ((CartActivity) c).findViewById(R.id.txt_total);
        DecimalFormat df = new DecimalFormat("###,###,###,000");
        String formattedNumber = df.format(total * 1000);
        txtcartTotal.setText("đ " + formattedNumber);
    }

    public void selectAll() {
        for (int i = 0; i < cartList.size(); i++) {
            selected.add(i);
        }
        notifyDataSetChanged();
    }

    public void unSelectAll() {
        selected.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }
}
