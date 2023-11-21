package com.example.shoesapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductHolder> {

    public OnItemClickListener listener;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    Context c;
    List<ListProduct> listProducts;

    public ListProductAdapter(Context c, List<ListProduct> listProducts) {
        this.c = c;
        this.listProducts = listProducts;
    }

    @NonNull
    @Override
    public ListProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.listproduct_item, parent, false);
        return new ListProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListProductHolder holder, int position) {
        ListProduct listProduct = listProducts.get(position);
        holder.txtBrandName.setText(listProduct.getBrandName());
        List<Product> products = listProduct.getBrandProducts();

        ProductsAdapter adapter = new ProductsAdapter(c, products);
        holder.rvShoes.setHasFixedSize(true);
        holder.rvShoes.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.HORIZONTAL, false));
        holder.rvShoes.setAdapter(adapter);

        adapter.setOnItemClickListener(new ProductsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product product) {
                // Open another activity
                Intent intent = new Intent(c, detailproduct.class);
                // Pass the product information to the detail activity if needed
                //intent.putExtra("product", product);
                c.startActivity(intent);
            }
        });

//        DatabaseReference database = FirebaseDatabase.getInstance().getReference("Sneakers/" + listProduct.getBrandName());
//        database.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot productSnapshot : snapshot.getChildren()) {
//                    Product product = productSnapshot.getValue(Product.class);
//                    products.add(product);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.w("Failed to read value.", error.toException());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }

    public interface OnItemClickListener {
        void onItemClick(ListProduct listProduct);
    }
}
