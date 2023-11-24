package com.example.shoesapplication;

public class Product {
    String image, name, price, oldPrice, key;

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getKey() {
        return key;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }
}
