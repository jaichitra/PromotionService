package com.jaichitra.promotionservice.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class RetailSKUCartUnit {
    @JsonProperty
    private RetailSKUItem cartItem;
    @JsonProperty
    private Integer itemQuantity;
    @JsonProperty
    private Double initialPrice;
    @JsonProperty
    private Double finalPrice;

    private String promotionType;

    private AtomicBoolean promotionApplied;

    public RetailSKUCartUnit() {
        promotionApplied = new AtomicBoolean();
    }

    public RetailSKUCartUnit(RetailSKUItem cartItem, Integer itemQuantity, Double initialPrice) {
        this.cartItem = cartItem;
        this.itemQuantity = itemQuantity;
        this.initialPrice = initialPrice;
        this.finalPrice = initialPrice;
        this.promotionType = null;
        promotionApplied = new AtomicBoolean(false);
    }


    public RetailSKUItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(RetailSKUItem cartItem) {
        this.cartItem = cartItem;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    @JsonIgnore
    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    @JsonIgnore
    public boolean getPromotionApplied() {
        return promotionApplied.get();
    }

    public void setPromotionApplied(boolean promotionApplied) {
        this.promotionApplied.set(promotionApplied);
    }

    @Override
    @JsonIgnore
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RetailSKUCartUnit)) return false;
        RetailSKUCartUnit that = (RetailSKUCartUnit) o;
        return Objects.equals(getCartItem(), that.getCartItem());
    }

    @Override
    @JsonIgnore
    public int hashCode() {
        return Objects.hash(getCartItem());
    }
}
