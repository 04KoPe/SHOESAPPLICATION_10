package com.example.shoesapplication;

public class Cart {
    String name, price, saleprice, image;
    int quantity;
    double totalPrice;

    public Cart(String name, String price, String saleprice, String image, int quantity, double totalPrice) {
        this.name = name;
        this.price = price;
        this.saleprice = saleprice;
        this.image = image;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getSaleprice() {
        return saleprice;
    }

    public String getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSaleprice(String saleprice) {
        this.saleprice = saleprice;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
