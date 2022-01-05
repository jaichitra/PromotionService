package com.jaichitra.promotionservice.service;

import com.jaichitra.promotionservice.data.RetailSKUCartUnit;

import java.util.Set;

public interface PromotionStrategy {

     void applyPromotions(Set<RetailSKUCartUnit> cartUnits);

     String promotionType();

}
