package com.jaichitra.promotionservice.util;

import com.jaichitra.promotionservice.data.RetailSKUItem;

public class CartTestUtil {

    public static RetailSKUItem getSKU_A() {
        return new RetailSKUItem('A', "A", 50);
    }


    public static RetailSKUItem getSKU_B() {
        return new RetailSKUItem('B', "B", 30);
    }


    public static RetailSKUItem getSKU_C() {
        return new RetailSKUItem('C', "C", 20);
    }

    public static RetailSKUItem getSKU_D() {
        return new RetailSKUItem('D', "D", 15);
    }

}
