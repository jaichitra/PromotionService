package com.jaichitra.promotionservice.service;

import com.google.common.collect.ImmutableMap;
import com.jaichitra.promotionservice.data.RetailSKUCartRequest;
import com.jaichitra.promotionservice.data.RetailSKUCartSummary;
import com.jaichitra.promotionservice.data.RetailSKUItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class PromotionServiceTest {

    private PromotionService promotionService;

    @Before
    public void init() {
        promotionService = new PromotionService();
    }

    @Test
    public void testScenario1() {
        RetailSKUCartRequest initialCart = new RetailSKUCartRequest();
        initialCart.setProducts(ImmutableMap.of(getSKU_A(), 1, getSKU_B(), 1, getSKU_C(), 1));
        initialCart.setActivePromotions(Arrays.asList("FIXED_PRICE_FOR_SKU_A", "FIXED_PRICE_FOR_SKU_B", "COMBINED_PRICE_FOR_SKU_C_AND_D"));
        RetailSKUCartSummary cartSummary = promotionService.execute(initialCart);
        Assert.assertEquals(100.00, cartSummary.getTotalFinalPrice(), 0.0);
    }

    @Test
    public void testScenario2() {
        RetailSKUCartRequest initialCart = new RetailSKUCartRequest();
        initialCart.setProducts(ImmutableMap.of(getSKU_A(), 5, getSKU_B(), 5, getSKU_C(), 1));
        initialCart.setActivePromotions(Arrays.asList("FIXED_PRICE_FOR_SKU_A", "FIXED_PRICE_FOR_SKU_B", "COMBINED_PRICE_FOR_SKU_C_AND_D"));
        RetailSKUCartSummary cartSummary = promotionService.execute(initialCart);
        Assert.assertEquals(370.00, cartSummary.getTotalFinalPrice(), 0.0);
    }

    @Test
    public void testScenario3() throws Exception {
        RetailSKUCartRequest initialCart = new RetailSKUCartRequest();
        initialCart.setProducts(ImmutableMap.of(getSKU_A(), 3, getSKU_B(), 5, getSKU_C(), 1, getSKU_D(), 1));
        initialCart.setActivePromotions(Arrays.asList("FIXED_PRICE_FOR_SKU_A", "FIXED_PRICE_FOR_SKU_B", "COMBINED_PRICE_FOR_SKU_C_AND_D"));
        RetailSKUCartSummary cartSummary = promotionService.execute(initialCart);
        Assert.assertEquals(280.00, cartSummary.getTotalFinalPrice(), 0.0);
    }

    @Test
    public void testScenario4() {
        RetailSKUCartRequest initialCart = new RetailSKUCartRequest();
        initialCart.setProducts(ImmutableMap.of(getSKU_A(), 5, getSKU_B(), 5, getSKU_C(), 1));
        RetailSKUCartSummary cartSummary = promotionService.execute(initialCart);
        Assert.assertEquals(420.00, cartSummary.getTotalFinalPrice(), 0.0);
    }

    @Test
    public void testScenario5() {
        RetailSKUCartRequest initialCart = new RetailSKUCartRequest();
        initialCart.setProducts(ImmutableMap.of(getSKU_A(), 3, getSKU_B(), 5, getSKU_C(), 1, getSKU_D(), 1));
        RetailSKUCartSummary cartSummary = promotionService.execute(initialCart);
        Assert.assertEquals(335.00, cartSummary.getTotalFinalPrice(), 0.0);
    }

    private RetailSKUItem getSKU_A() {
        return new RetailSKUItem('A', "A", 50);
    }


    private RetailSKUItem getSKU_B() {
        return new RetailSKUItem('B', "B", 30);
    }


    private RetailSKUItem getSKU_C() {
        return new RetailSKUItem('C', "C", 20);
    }

    private RetailSKUItem getSKU_D() {
        return new RetailSKUItem('D', "D", 15);
    }

}

