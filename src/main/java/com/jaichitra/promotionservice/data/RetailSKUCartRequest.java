package com.jaichitra.promotionservice.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jaichitra.promotionservice.utils.CartProductDeserializer;
import com.jaichitra.promotionservice.utils.CartProductSerializer;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetailSKUCartRequest {
    @JsonProperty
    @JsonSerialize(using = CartProductSerializer.class)
    @JsonDeserialize(using = CartProductDeserializer.class)
    private Map<RetailSKUItem, Integer> products;

    @JsonProperty
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
