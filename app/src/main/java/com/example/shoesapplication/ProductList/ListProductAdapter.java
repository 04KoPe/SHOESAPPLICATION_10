package com.example.shoesapplication.ProductList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapplication.ProductPackage.Product;
import com.example.shoesapplication.ProductPackage.ProductsAdapter;
import com.example.shoesapplication.ProductPackage.detailproduct;
import com.example.shoesapplication.R;

import java.util.List;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductHolder> {
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
                intent.putExtra("name", product.getName());
                intent.putExtra("image", product.getImage());
                intent.putExtra("price", product.getPrice());
                intent.putExtra("oldPrice", product.getOldPrice());
                intent.putExtra("id", product.getKey());
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }

    public interface OnItemClickListener {
        void onItemClick(ListProduct listProduct);
    }
}
