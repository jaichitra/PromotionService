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
    private static final Logger LOG = Logger.getLogger(PromotionServiceController.class.getName());

    @Autowired
    private PromotionService promotionService;

    @PostMapping(value = "/promotionService",consumes = "application/json")
    public RetailSKUCartSummary getSiteDetails(@RequestBody RetailSKUCartRequest request) {
        LOG.info("Controller request received for RetailSKUCartRequest");
        return promotionService.execute(request);
    }

}
