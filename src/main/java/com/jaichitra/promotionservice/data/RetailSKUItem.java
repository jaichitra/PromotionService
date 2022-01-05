package com.jaichitra.promotionservice.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetailSKUItem {
    @JsonProperty
    private char itemCode;
    @JsonProperty
    private String itemName;
    @JsonProperty
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

    @Override
    @JsonIgnore
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RetailSKUItem)) return false;
        RetailSKUItem that = (RetailSKUItem) o;
        return getItemCode() == that.getItemCode();
    }

    @Override
    @JsonIgnore
    public int hashCode() {
        return Objects.hash(getItemCode());
    }

}

