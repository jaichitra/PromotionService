package com.jaichitra.promotionservice.service;

import com.jaichitra.promotionservice.data.RetailSKUCartUnit;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.logging.Logger;

@Component
public class FixedPricePromotionForA implements PromotionStrategy {
    private static final Logger LOG = Logger.getLogger(FixedPricePromotionForA.class.getName());
    private static double promotionalPriceOfCombination = 130.00d;

    @Override
    public void applyPromotions(Set<RetailSKUCartUnit> cartUnits) {
        RetailSKUCartUnit cartUnitA = cartUnits.stream().filter(t -> t.getCartItem().getItemCode() == 'A').findFirst().orElse(null);

        if (cartUnitA == null || cartUnitA.getPromotionApplied()) return;

        LOG.info("Applying promotion : " + promotionType() + " cart items");

        int promotionalValue = cartUnitA.getItemQuantity() / 3;
        cartUnitA.setFinalPrice(promotionalValue * promotionalPriceOfCombination +
                (cartUnitA.getItemQuantity() % 3 * cartUnitA.getCartItem().getItemPrice()));

        LOG.info("Promotion Applied on " + cartUnitA.getCartItem().getItemName() + " and " + cartUnitA.getCartItem().getItemName()
                + " for " + promotionalValue + " sets");
        LOG.info("Updated final price for " + cartUnitA.getCartItem().getItemName() + " : " + cartUnitA.getFinalPrice());

        cartUnitA.setPromotionType(promotionType());
        cartUnitA.setPromotionApplied(true);
    }

    @Override
    public String promotionType() {
        return "FIXED_PRICE_FOR_SKU_A";
    }
}
