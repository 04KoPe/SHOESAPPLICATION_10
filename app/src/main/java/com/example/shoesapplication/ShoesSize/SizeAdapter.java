package com.example.shoesapplication.ShoesSize;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapplication.R;

import java.util.List;

public class SizeAdapter extends RecyclerView.Adapter<SizeHolder> {
    Context c;
    List<Size> sizeList;
    private boolean isRed = false;

    public SizeAdapter(Context c, List<Size> sizeList) {
        this.c = c;
        this.sizeList = sizeList;
    }

    @NonNull
    @Override
    public SizeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.size_item, parent, false);
        return new SizeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SizeHolder holder, int position) { 
        Size size = sizeList.get(position);
        holder.txtSize.setText(size.getSize());
        holder.txtSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;
                if (isRed) {
                    holder.txtSize.setBackgroundColor(ContextCompat.getColor(c, R.color.red));
                } else {
                    holder.txtSize.setBackgroundColor(ContextCompat.getColor(c, R.color.gray));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sizeList.size();
    }
}
