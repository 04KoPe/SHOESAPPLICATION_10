package com.example.shoesapplication;


// functional programming: stateless
// object oriented programming: stateful



public class Item {

    private int itemPhoto;
    private String itemName;
    private String itemSize;
    private String itemQuantity;
    private int delivery;

    public Item(int itemPhoto, String itemName, String itemSize, String itemQuantity, int delivery, String message) {
        this.itemPhoto = itemPhoto;
        this.itemName = itemName;
        this.itemSize = itemSize;
        this.itemQuantity = itemQuantity;
        this.delivery = delivery;
        this.message = message;
    }

    private String message;

    public String getMess() {
        return message  ;
    }

    public void setMess(String mess) {
        this.message = mess;
    }

    public int getItemPhoto() {
        return itemPhoto;
    }

    public void setItemPhoto(int itemPhoto) {
        this.itemPhoto = itemPhoto;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }




}
