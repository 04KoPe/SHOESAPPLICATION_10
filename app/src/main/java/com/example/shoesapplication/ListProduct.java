package com.example.shoesapplication;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListProduct {
    String brandName;
    List<Product> brandProducts;

    public ListProduct(String brandName, List<Product> brandProducts) {
        this.brandName = brandName;
        this.brandProducts = brandProducts;
    }

    public String getBrandName() {
        return brandName;
    }

    public List<Product> getBrandProducts() {
        return brandProducts;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setBrandProducts(List<Product> brandProducts) {
        this.brandProducts = brandProducts;
    }
}
