package com.example.shoesapplication.CategoryPackage;

public class CategoryItem {
    String shoesType, typeAmount;
    int typeImg;

    public CategoryItem(String shoesType, int typeImg) {
        this.shoesType = shoesType;
        this.typeImg = typeImg;
    }

    public String getShoesType() {
        return shoesType;
    }

    public void setShoesType(String shoesType) {
        this.shoesType = shoesType;
    }

    public void setTypeAmount(String typeAmount) {
        this.typeAmount = typeAmount;
    }

    public void setTypeImg(int typeImg) {
        this.typeImg = typeImg;
    }

    public String getTypeAmount() {
        return typeAmount;
    }

    public int getTypeImg() {
        return typeImg;
    }
}
