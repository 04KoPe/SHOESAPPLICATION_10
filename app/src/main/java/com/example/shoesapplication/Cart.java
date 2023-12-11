package com.example.shoesapplication;

public class Cart {
    String id, name, saleprice;
    double price, salePrice;
    int quantity;
    int imgID;

    public Cart(String id, String name, double price, double salePrice, int quantity, int imgID) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.salePrice = salePrice;
        this.imgID = imgID;
    }
}
