package com.jaichitra.promotionservice.service;

import com.google.common.collect.ImmutableSet;
import com.jaichitra.promotionservice.data.RetailSKUCartUnit;
import com.jaichitra.promotionservice.data.RetailSKUItem;
import com.jaichitra.promotionservice.util.CartTestUtil;
import org.junit.Assert;
import org.junit.Test;

public class FixedPricePromotionForBTest {
    private FixedPricePromotionForA promotionStrategy = new FixedPricePromotionForA();

    @Test
    public void testScenarioA() {
        RetailSKUItem itemB = CartTestUtil.getSKU_B();
        RetailSKUCartUnit skuCartUnitB = new RetailSKUCartUnit(itemB, 1, 1 * itemB.getItemPrice());
        promotionStrategy.applyPromotions(ImmutableSet.of(skuCartUnitB));
        Assert.assertEquals(30.0d, skuCartUnitB.getFinalPrice(), 0.0);
    }

    @Test
    public void testScenarioB() {
        RetailSKUItem itemB = CartTestUtil.getSKU_B();
        RetailSKUCartUnit skuCartUnitB = new RetailSKUCartUnit(itemB, 4, 4 * itemB.getItemPrice());
        promotionStrategy.applyPromotions(ImmutableSet.of(skuCartUnitB));
        Assert.assertEquals(120.0d, skuCartUnitB.getFinalPrice(), 0.0);
    }

    @Test
    public void testScenarioC() {
        RetailSKUItem itemB = CartTestUtil.getSKU_B();
        RetailSKUCartUnit skuCartUnitB = new RetailSKUCartUnit(itemB, 3, 3 * itemB.getItemPrice());
        promotionStrategy.applyPromotions(ImmutableSet.of(skuCartUnitB));
        Assert.assertEquals(90.0d, skuCartUnitB.getFinalPrice(), 0.0);
    }

}
