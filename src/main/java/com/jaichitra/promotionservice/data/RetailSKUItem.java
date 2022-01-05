package com.jaichitra.promotionservice.data;

public class RetailSKUItem {
    private char itemCode;
    private String itemName;
    private double itemPrice;

    public RetailSKUItem() {
    }

    public RetailSKUItem(char itemCode, String itemName, double itemPrice) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public char getItemCode() {
        return itemCode;
    }

    public void setItemCode(char itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }



}

