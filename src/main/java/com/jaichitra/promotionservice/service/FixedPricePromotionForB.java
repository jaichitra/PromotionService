package com.jaichitra.promotionservice.service;

import com.jaichitra.promotionservice.data.RetailSKUCartUnit;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.logging.Logger;

@Component
public class FixedPricePromotionForB implements PromotionStrategy{
    private static final Logger LOG = Logger.getLogger(FixedPricePromotionForB.class.getName());
    private static double promotionalPriceOfCombination = 45.00d;

    @Override
    public void applyPromotions(Set<RetailSKUCartUnit> cartUnits){
        RetailSKUCartUnit cartUnitB = cartUnits.stream().filter(t -> t.getCartItem().getItemCode() == 'B').findFirst().orElse(null);

        LOG.info("Applying promotion : " + promotionType() + " cart items");

        if (cartUnitB == null || cartUnitB.getPromotionApplied()) return;

        int promotionalValue = cartUnitB.getItemQuantity() / 2;
        cartUnitB.setFinalPrice(promotionalValue * promotionalPriceOfCombination +
                (cartUnitB.getItemQuantity() % 2 * cartUnitB.getCartItem().getItemPrice()));

        LOG.info("Promotion Applied on " + cartUnitB.getCartItem().getItemName() + " and " + cartUnitB.getCartItem().getItemName()
                + " for " + promotionalValue + " sets");
        LOG.info("Updated final price for " + cartUnitB.getCartItem().getItemName() + " : " + cartUnitB.getFinalPrice());

        cartUnitB.setPromotionType(promotionType());
        cartUnitB.setPromotionApplied(true);
    }

    @Override
    public String promotionType() {
        return "FIXED_PRICE_FOR_SKU_B";
    }
}
