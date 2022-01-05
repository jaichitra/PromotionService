package com.jaichitra.promotionservice.service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.jaichitra.promotionservice.data.RetailSKUCartRequest;
import com.jaichitra.promotionservice.data.RetailSKUCartSummary;
import com.jaichitra.promotionservice.util.CartTestUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class PromotionServiceTest {

    private PromotionService promotionService;

    @Before
    public void init() {
        promotionService = new PromotionService(ImmutableList.of(new CombinedPricePromotionForCandD(), new FixedPricePromotionForA(),
                new FixedPricePromotionForB()));
    }

    @Test
    public void testScenario1() {
        RetailSKUCartRequest initialCart = new RetailSKUCartRequest();
        initialCart.setProducts(ImmutableMap.of(CartTestUtil.getSKU_A(), 1, CartTestUtil.getSKU_B(), 1, CartTestUtil.getSKU_C(), 1));
        initialCart.setActivePromotions(Arrays.asList("FIXED_PRICE_FOR_SKU_A", "FIXED_PRICE_FOR_SKU_B", "COMBINED_PRICE_FOR_SKU_C_AND_D"));
        RetailSKUCartSummary cartSummary = promotionService.execute(initialCart);
        Assert.assertEquals(100.00, cartSummary.getTotalFinalPrice(), 0.0);
    }

    @Test
    public void testScenario2() {
        RetailSKUCartRequest initialCart = new RetailSKUCartRequest();
        initialCart.setProducts(ImmutableMap.of(CartTestUtil.getSKU_A(), 5, CartTestUtil.getSKU_B(), 5, CartTestUtil.getSKU_C(), 1));
        initialCart.setActivePromotions(Arrays.asList("FIXED_PRICE_FOR_SKU_A", "FIXED_PRICE_FOR_SKU_B", "COMBINED_PRICE_FOR_SKU_C_AND_D"));
        RetailSKUCartSummary cartSummary = promotionService.execute(initialCart);
        Assert.assertEquals(370.00, cartSummary.getTotalFinalPrice(), 0.0);
    }

    @Test
    public void testScenario3() throws Exception {
        RetailSKUCartRequest initialCart = new RetailSKUCartRequest();
        initialCart.setProducts(ImmutableMap.of(CartTestUtil.getSKU_A(), 3, CartTestUtil.getSKU_B(), 5, CartTestUtil.getSKU_C(), 1, CartTestUtil.getSKU_D(), 1));
        initialCart.setActivePromotions(Arrays.asList("FIXED_PRICE_FOR_SKU_A", "FIXED_PRICE_FOR_SKU_B", "COMBINED_PRICE_FOR_SKU_C_AND_D"));
        RetailSKUCartSummary cartSummary = promotionService.execute(initialCart);
        Assert.assertEquals(280.00, cartSummary.getTotalFinalPrice(), 0.0);
    }

    @Test
    public void testScenario4() {
        RetailSKUCartRequest initialCart = new RetailSKUCartRequest();
        initialCart.setProducts(ImmutableMap.of(CartTestUtil.getSKU_A(), 5, CartTestUtil.getSKU_B(), 5, CartTestUtil.getSKU_C(), 1));
        RetailSKUCartSummary cartSummary = promotionService.execute(initialCart);
        Assert.assertEquals(420.00, cartSummary.getTotalFinalPrice(), 0.0);
    }

    @Test
    public void testScenario5() {
        RetailSKUCartRequest initialCart = new RetailSKUCartRequest();
        initialCart.setProducts(ImmutableMap.of(CartTestUtil.getSKU_A(), 3, CartTestUtil.getSKU_B(), 5, CartTestUtil.getSKU_C(), 1, CartTestUtil.getSKU_D(), 1));
        RetailSKUCartSummary cartSummary = promotionService.execute(initialCart);
        Assert.assertEquals(335.00, cartSummary.getTotalFinalPrice(), 0.0);
    }


}

