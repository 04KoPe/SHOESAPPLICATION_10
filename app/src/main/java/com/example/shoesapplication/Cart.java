package com.example.shoesapplication;

public class Cart {
    String name, price, oldPrice, image;
    int quantity;
    float totalPrice;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public String getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
