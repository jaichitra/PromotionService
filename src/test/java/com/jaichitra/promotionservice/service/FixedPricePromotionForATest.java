package com.jaichitra.promotionservice.service;

import com.google.common.collect.ImmutableSet;
import com.jaichitra.promotionservice.data.RetailSKUCartUnit;
import com.jaichitra.promotionservice.data.RetailSKUItem;
import com.jaichitra.promotionservice.util.CartTestUtil;
import org.junit.Assert;
import org.junit.Test;

public class FixedPricePromotionForATest {
    private FixedPricePromotionForA promotionStrategy = new FixedPricePromotionForA();

    @Test
    public void testScenarioA() {
        RetailSKUItem itemA = CartTestUtil.getSKU_A();
        RetailSKUCartUnit skuCartUnitA = new RetailSKUCartUnit(itemA, 1, 1 * itemA.getItemPrice());
        promotionStrategy.applyPromotions(ImmutableSet.of(skuCartUnitA));
        Assert.assertEquals(50.0d, skuCartUnitA.getFinalPrice(), 0.0);
    }

    @Test
    public void testScenarioB() {
        RetailSKUItem itemA = CartTestUtil.getSKU_A();
        RetailSKUCartUnit skuCartUnitA = new RetailSKUCartUnit(itemA, 6, 6 * itemA.getItemPrice());
        promotionStrategy.applyPromotions(ImmutableSet.of(skuCartUnitA));
        Assert.assertEquals(260.0d, skuCartUnitA.getFinalPrice(), 0.0);
    }

    @Test
    public void testScenarioC() {
        RetailSKUItem itemA = CartTestUtil.getSKU_A();
        RetailSKUCartUnit skuCartUnitA = new RetailSKUCartUnit(itemA, 4, 4 * itemA.getItemPrice());
        promotionStrategy.applyPromotions(ImmutableSet.of(skuCartUnitA));
        Assert.assertEquals(180.0d, skuCartUnitA.getFinalPrice(), 0.0);
    }

}
