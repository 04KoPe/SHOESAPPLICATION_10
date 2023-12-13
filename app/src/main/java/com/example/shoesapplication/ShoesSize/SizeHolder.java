package com.example.shoesapplication.ShoesSize;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapplication.R;

public class SizeHolder extends RecyclerView.ViewHolder{
    TextView txtSize;
    public SizeHolder(@NonNull View itemView) {
        super(itemView);
        txtSize=itemView.findViewById(R.id.btn_size);
    }
}
