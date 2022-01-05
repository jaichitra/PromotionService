package com.jaichitra.promotionservice.service;

import com.jaichitra.promotionservice.data.RetailSKUCartUnit;
import org.springframework.stereotype.Component;

import java.util.Set;

public class FixedPricePromotionForB implements PromotionStrategy{
    private static double promotionalPriceOfCombination = 45.00d;

    @Override
    public void applyPromotions(Set<RetailSKUCartUnit> cartUnits){
        RetailSKUCartUnit cartUnitB = cartUnits.stream().filter(t -> t.getCartItem().getItemCode() == 'B').findFirst().orElse(null);

        if (cartUnitB == null || cartUnitB.getPromotionApplied()) return;

        int promotionalValue = cartUnitB.getItemQuantity() / 3;
        cartUnitB.setFinalPrice(promotionalValue * promotionalPriceOfCombination +
                (cartUnitB.getItemQuantity() % 3 * cartUnitB.getCartItem().getItemPrice()));

        cartUnitB.setPromotionType(promotionType());
        cartUnitB.setPromotionApplied(true);
    }

    @Override
    public String promotionType() {
        return "FIXED_PRICE_FOR_SKU_B";
    }
}
