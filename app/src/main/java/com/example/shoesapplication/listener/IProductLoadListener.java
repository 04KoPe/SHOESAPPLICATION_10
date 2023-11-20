package com.example.shoesapplication.listener;

import com.example.shoesapplication.Product;

import java.util.List;

public interface IProductLoadListener {
    void onProductLoadSuccess(List<Product> productList);
    void onProductLoadFailed(String message);
}
