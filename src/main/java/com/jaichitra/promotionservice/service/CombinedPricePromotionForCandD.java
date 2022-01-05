package com.jaichitra.promotionservice.service;

import com.jaichitra.promotionservice.data.RetailSKUCartUnit;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;

public class CombinedPricePromotionForCandD implements PromotionStrategy {

    private static final double combinedPriceOfCandD = 30.0;

    @Override
    public void applyPromotions(Set<RetailSKUCartUnit> cartUnits) {
        RetailSKUCartUnit cartUnitForC = cartUnits.stream().filter(t -> t.getCartItem().getItemCode() == 'C').findFirst().orElse(null);
        RetailSKUCartUnit cartUnitForD = cartUnits.stream().filter(t -> t.getCartItem().getItemCode() == 'D').findFirst().orElse(null);

        if (cartUnitForC == null || cartUnitForD == null || cartUnitForC.getPromotionApplied()
                || cartUnitForD.getPromotionApplied())
            return;

        int promotionQuantity = Math.min(cartUnitForC.getItemQuantity(), cartUnitForD.getItemQuantity());
        cartUnitForC.setFinalPrice((cartUnitForC.getItemQuantity() - promotionQuantity) * cartUnitForC.getInitialPrice());
        cartUnitForD.setFinalPrice(Double.sum(promotionQuantity * combinedPriceOfCandD, (cartUnitForD.getItemQuantity()
                - promotionQuantity) * cartUnitForD.getInitialPrice()));

        setPromotionTypeAndConfirm(cartUnitForC, cartUnitForD);
    }

    private void setPromotionTypeAndConfirm(RetailSKUCartUnit... cartUnits) {
        Arrays.stream(cartUnits).forEach(t -> {
            t.setPromotionType(promotionType());
            t.setPromotionApplied(true);
        });
    }

    @Override
    public String promotionType() {
        return "COMBINED_PRICE_FOR_SKU_C_AND_D";
    }
}
