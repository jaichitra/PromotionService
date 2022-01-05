package com.jaichitra.promotionservice.controllers;

import com.jaichitra.promotionservice.data.RetailSKUCartRequest;
import com.jaichitra.promotionservice.data.RetailSKUCartSummary;
import com.jaichitra.promotionservice.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PromotionServiceController {

    @Autowired
    private PromotionService promotionService;

    @PostMapping(value = "/promotionService",consumes = "application/json")
    public RetailSKUCartSummary getSiteDetails(@RequestBody RetailSKUCartRequest request) {
        return promotionService.execute(request);
    }

}
