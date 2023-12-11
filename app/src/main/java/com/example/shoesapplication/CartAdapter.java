package com.example.shoesapplication;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {

    Context c;
    List<Cart> data;
    private IOnCheck callback;

    public CartAdapter(Context c, List<Cart> data) {
        this.c = c;
        this.data = data;
    }

    public void setOnCheckListener(IOnCheck callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.cart_item, parent, false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        holder.txtName.setText(data.get(position).name);
        holder.txtPrice.setText(String.valueOf(data.get(position).price));
        holder.txtSalePrice.setText(String.valueOf(data.get(position).salePrice));
        holder.imgName.setImageResource(data.get(position).imgID);

        //chu gacg ngang
        String text = holder.txtPrice.getText().toString();
        SpannableString spannableString = new SpannableString(text);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString.setSpan(strikethroughSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.txtPrice.setText(spannableString);

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(callback != null) callback.execute(isChecked, data.get(position).id  );
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class CartHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtPrice, txtSalePrice;
        ImageView imgName;
        CheckBox checkBox;

        public CartHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.text_name);
            txtPrice = itemView.findViewById(R.id.price);
            txtSalePrice = itemView.findViewById(R.id.sale_price);
            imgName = itemView.findViewById(R.id.image_name);
            checkBox = itemView.findViewById(R.id.checkbox);
        }
    }

    public interface IOnCheck{
        void execute(boolean isChecked, String id);
    }
}
