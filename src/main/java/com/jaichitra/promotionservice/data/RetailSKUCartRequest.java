package com.jaichitra.promotionservice.data;

import java.util.List;
import java.util.Map;

public class RetailSKUCartRequest {
    private Map<RetailSKUItem, Integer> products;

    private List<String> activePromotions;

    public RetailSKUCartRequest() {
    }

    public Map<RetailSKUItem, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<RetailSKUItem, Integer> products) {
        this.products = products;
    }

    public List<String> getActivePromotions() {
        return activePromotions;
    }

    public void setActivePromotions(List<String> activePromotions) {
        this.activePromotions = activePromotions;
    }
}
