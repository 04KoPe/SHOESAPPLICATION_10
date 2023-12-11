package com.example.shoesapplication.Search;

import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Item {

    private int shoesIMG;

    private String shoesName;
    private String shoesQuantity;
    private String shoesSize;

    public int getShoesIMG() {
        return shoesIMG;
    }

    public void setShoesIMG(int shoesIMG) {
        this.shoesIMG = shoesIMG;
    }

    public String getShoesName() {
        return shoesName;
    }

    public void setShoesName(String shoesName) {
        this.shoesName = shoesName;
    }

    public String getShoesQuantity() {
        return shoesQuantity;
    }

    public void setShoesQuantity(String shoesQuantity) {
        this.shoesQuantity = shoesQuantity;
    }

    public String getShoesSize() {
        return shoesSize;
    }

    public void setShoesSize(String shoesSize) {
        this.shoesSize = shoesSize;
    }


    public Item(int shoesIMG, String shoesName, String shoesQuantity, String shoesSize) {
        this.shoesIMG = shoesIMG;
        this.shoesName = shoesName;
        this.shoesQuantity = shoesQuantity;
        this.shoesSize = shoesSize;
    }






}
