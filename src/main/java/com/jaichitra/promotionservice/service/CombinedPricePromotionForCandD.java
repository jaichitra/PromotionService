package com.jaichitra.promotionservice.service;

import com.jaichitra.promotionservice.data.RetailSKUCartUnit;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class CombinedPricePromotionForCandD implements PromotionStrategy {
    private static final Logger LOG = Logger.getLogger(CombinedPricePromotionForCandD.class.getName());
    private static final double combinedPriceOfCandD = 30.0;

    @Override
    public void applyPromotions(final Set<RetailSKUCartUnit> cartUnits) {
        RetailSKUCartUnit cartUnitForC = cartUnits.stream().filter(t -> t.getCartItem().getItemCode() == 'C').findFirst().orElse(null);
        RetailSKUCartUnit cartUnitForD = cartUnits.stream().filter(t -> t.getCartItem().getItemCode() == 'D').findFirst().orElse(null);

        if (cartUnitForC == null || cartUnitForD == null || cartUnitForC.getPromotionApplied()
                || cartUnitForD.getPromotionApplied())
            return;

        LOG.info("Applying promotion : " + promotionType() + " cart items");

        int promotionQuantity = Math.min(cartUnitForC.getItemQuantity(), cartUnitForD.getItemQuantity());
        cartUnitForC.setFinalPrice((cartUnitForC.getItemQuantity() - promotionQuantity) * cartUnitForC.getCartItem().getItemPrice());
        cartUnitForD.setFinalPrice(Double.sum(promotionQuantity * combinedPriceOfCandD, (cartUnitForD.getItemQuantity()
                - promotionQuantity) * cartUnitForD.getCartItem().getItemPrice()));

        LOG.info("Promotion Applied on " + cartUnitForC.getCartItem().getItemName() + " and " + cartUnitForD.getCartItem().getItemName()
                + " for " + promotionQuantity);
        LOG.info("Updated final price for "+ cartUnitForC.getCartItem().getItemName() + " : "+ cartUnitForC.getFinalPrice() );
        LOG.info("Updated final price for "+ cartUnitForD.getCartItem().getItemName() + " : "+ cartUnitForD.getFinalPrice() );

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
