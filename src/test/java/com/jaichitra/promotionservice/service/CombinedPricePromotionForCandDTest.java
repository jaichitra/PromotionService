package com.jaichitra.promotionservice.service;

import com.google.common.collect.ImmutableSet;
import com.jaichitra.promotionservice.data.RetailSKUCartUnit;
import com.jaichitra.promotionservice.data.RetailSKUItem;
import com.jaichitra.promotionservice.util.CartTestUtil;
import org.junit.Assert;
import org.junit.Test;


public class CombinedPricePromotionForCandDTest {

    private CombinedPricePromotionForCandD promotionStrategy = new CombinedPricePromotionForCandD();

    @Test
    public void testScenarioA() {
        RetailSKUItem itemC = CartTestUtil.getSKU_C();
        RetailSKUItem itemD = CartTestUtil.getSKU_D();
        RetailSKUCartUnit skuCartUnitC = new RetailSKUCartUnit(itemC, 1, 1 * itemC.getItemPrice());
        RetailSKUCartUnit skuCartUnitD = new RetailSKUCartUnit(itemD, 1, 1 * itemD.getItemPrice());
        promotionStrategy.applyPromotions(ImmutableSet.of(skuCartUnitC, skuCartUnitD));
        Assert.assertEquals(0.0d, skuCartUnitC.getFinalPrice(), 0.0);
        Assert.assertEquals(30.0d, skuCartUnitD.getFinalPrice(), 0.0);
    }

    @Test
    public void testScenarioB() {
        RetailSKUItem itemC = CartTestUtil.getSKU_C();
        RetailSKUCartUnit skuCartUnitC = new RetailSKUCartUnit(itemC, 1, 1 * itemC.getItemPrice());
        promotionStrategy.applyPromotions(ImmutableSet.of(skuCartUnitC));
        Assert.assertEquals(itemC.getItemPrice(), skuCartUnitC.getFinalPrice(), 0.0);
    }

    @Test
    public void testScenarioC() {
        RetailSKUItem itemC = CartTestUtil.getSKU_C();
        RetailSKUItem itemD = CartTestUtil.getSKU_D();
        RetailSKUCartUnit skuCartUnitC = new RetailSKUCartUnit(itemC, 4, 4 * itemC.getItemPrice());
        RetailSKUCartUnit skuCartUnitD = new RetailSKUCartUnit(itemD, 3, 3 * itemD.getItemPrice());
        promotionStrategy.applyPromotions(ImmutableSet.of(skuCartUnitC, skuCartUnitD));
        Assert.assertEquals(20.0d, skuCartUnitC.getFinalPrice(), 0.0);
        Assert.assertEquals(90.0d, skuCartUnitD.getFinalPrice(), 0.0);
    }

    @Test
    public void testScenarioD() {
        RetailSKUItem itemC = CartTestUtil.getSKU_C();
        RetailSKUItem itemD = CartTestUtil.getSKU_D();
        RetailSKUCartUnit skuCartUnitC = new RetailSKUCartUnit(itemC, 2, 4 * itemC.getItemPrice());
        RetailSKUCartUnit skuCartUnitD = new RetailSKUCartUnit(itemD, 3, 3 * itemD.getItemPrice());
        promotionStrategy.applyPromotions(ImmutableSet.of(skuCartUnitC, skuCartUnitD));
        Assert.assertEquals(0.0d, skuCartUnitC.getFinalPrice(), 0.0);
        Assert.assertEquals(75.0d, skuCartUnitD.getFinalPrice(), 0.0);
    }

}
