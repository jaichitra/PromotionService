package com.jaichitra.promotionservice.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.jaichitra.promotionservice.data.RetailSKUItem;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartProductDeserializer  extends StdDeserializer<Map<RetailSKUItem, Integer>> {

    public CartProductDeserializer() {
        super((Class) null);
    }

    public CartProductDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Map<RetailSKUItem, Integer> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final Map<RetailSKUItem, Integer> products = new HashMap<>();
        ArrayNode productNode = (ArrayNode) jsonParser.getCodec().readTree(jsonParser);
        productNode.forEach(t -> {
            JsonNode retailSKUItemNode = t.get("retailSKUItem");
            RetailSKUItem retailSKUItem = new RetailSKUItem(retailSKUItemNode.get("itemCode").toString().charAt(1), retailSKUItemNode.get("itemName").textValue(), retailSKUItemNode.get("itemPrice").doubleValue());
            int quantity = t.get("quantity").intValue();
            products.put(retailSKUItem, quantity);
        });

        return products;
    }
}