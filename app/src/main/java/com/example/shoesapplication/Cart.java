package com.example.shoesapplication;

public class Cart {
    String name, price, saleprice;
    int imgID;

    public Cart(String name, String price, String saleprice, int imgID) {
        this.name = name;
        this.price = price;
        this.saleprice = saleprice;
        this.imgID = imgID;
    }
}
