package com.jaichitra.promotionservice.service;


import com.jaichitra.promotionservice.data.RetailSKUCartRequest;
import com.jaichitra.promotionservice.data.RetailSKUCartSummary;
import com.jaichitra.promotionservice.data.RetailSKUCartUnit;
import com.jaichitra.promotionservice.data.RetailSKUItem;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PromotionService {

    private final List<PromotionStrategy> promotionStrategies;

    @Autowired
    public PromotionService(final List<PromotionStrategy> promotionStrategies) {
        this.promotionStrategies = promotionStrategies;
    }

    /**
     * Method generates the RetailSKUCartSummary based on the provided active promotions.
     * This method accepts initialSKUCart object and expects the item price and quantity is provided as input.
     *
     * @param cartRequest
     * @return
     */
    public RetailSKUCartSummary execute(final RetailSKUCartRequest cartRequest) {
        final RetailSKUCartSummary cartSummary = new RetailSKUCartSummary();
        final List<String> activePromotions = cartRequest.getActivePromotions();

        final Set<RetailSKUCartUnit> cartUnits = transformInitialCart(cartRequest.getProducts());

        if (!CollectionUtils.isEmpty(activePromotions))
            // Applying promotional strategies.
            promotionStrategies.stream().filter(t -> activePromotions.contains(t.promotionType()))
                    .forEach(t -> t.applyPromotions(cartUnits));

        cartUnits.forEach(t -> cartSummary.addToCart(t));
        return cartSummary;
    }

    private Set<RetailSKUCartUnit> transformInitialCart(final Map<RetailSKUItem, Integer> products) {
        return products.entrySet().stream().map(t -> new RetailSKUCartUnit(t.getKey(), t.getValue(),
                t.getKey().getItemPrice() * t.getValue()))
                .collect(Collectors.toSet());
    }
}