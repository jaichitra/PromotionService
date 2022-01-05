package com.jaichitra.promotionservice.data;

import java.util.ArrayList;
import java.util.List;

public class RetailSKUCartSummary {
    private List<RetailSKUCartUnit> cartUnits;
    private double totalFinalPrice;

    public RetailSKUCartSummary() {
        this.cartUnits = new ArrayList<>();
    }

    public void addToCart(RetailSKUCartUnit retailSKUCartUnit) {
        cartUnits.add(retailSKUCartUnit);
        calculateFinalPrice(retailSKUCartUnit);
    }

    private void calculateFinalPrice(RetailSKUCartUnit retailSKUCartUnit) {
        totalFinalPrice = Double.sum(totalFinalPrice, retailSKUCartUnit.getFinalPrice());
    }

    public double getTotalFinalPrice() {
        return this.totalFinalPrice;
    }

}
