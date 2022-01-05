package com.jaichitra.promotionservice.data;

import java.util.concurrent.atomic.AtomicBoolean;

public class RetailSKUCartUnit {
    
    private RetailSKUItem cartItem;
    
    private Integer itemQuantity;
    
    private Double initialPrice;
    
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

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public boolean getPromotionApplied() {
        return promotionApplied.get();
    }

    public void setPromotionApplied(boolean promotionApplied) {
        this.promotionApplied.set(promotionApplied);
    }

}
