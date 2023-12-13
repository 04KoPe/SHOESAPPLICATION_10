package com.example.shoesapplication.CategoryPackage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapplication.ProductPackage.ProductsActivity;
import com.example.shoesapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder> {
    Context c;
    List<CategoryItem> categoryList;

    public CategoryAdapter(Context c, List<CategoryItem> categoryList) {
        this.c = c;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.category_item, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        CategoryItem category = categoryList.get(position);
        holder.img_type.setImageResource(category.getTypeImg());
        holder.txt_typeName.setText(category.getShoesType());
        holder.txt_typeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, ProductsActivity.class);
                intent.putExtra("Product", holder.txt_typeName.getText());
                c.startActivity(intent);
            }
        });

        DatabaseReference prdAmount = FirebaseDatabase.getInstance().getReference(holder.txt_typeName.getText().toString());
        prdAmount.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int itemCount = 0;
                for (DataSnapshot Snapshot : snapshot.getChildren()) {
                    itemCount += (int) Snapshot.getChildrenCount();
                }
                holder.txt_typeAmount.setText("(" + String.valueOf(itemCount) + ")");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("Failed to read value.", error.toException());
            }
        });
        holder.txt_typeAmount.setText(category.getTypeAmount());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
