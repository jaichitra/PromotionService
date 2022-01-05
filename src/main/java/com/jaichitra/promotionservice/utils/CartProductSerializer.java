package com.jaichitra.promotionservice.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jaichitra.promotionservice.data.RetailSKUItem;

import java.io.IOException;
import java.util.Map;

public class CartProductSerializer extends StdSerializer<Map<RetailSKUItem, Integer>> {

    public CartProductSerializer() {
        super((Class) null);
    }

    public CartProductSerializer(Class<Map<RetailSKUItem, Integer>> t) {
        super(t);
    }

    @Override
    public void serialize(Map<RetailSKUItem, Integer> retailSKUItemIntegerMap, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        retailSKUItemIntegerMap.entrySet().stream().forEach(t -> {
            try {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeObjectFieldStart("retailSKUItem");
                if (t.getKey().getItemName() != null) {
                    jsonGenerator.writeStringField("itemName", t.getKey().getItemName());
                }
                jsonGenerator.writeObjectField("itemCode", t.getKey().getItemName());
                jsonGenerator.writeNumberField("itemPrice", t.getKey().getItemPrice());
                jsonGenerator.writeEndObject();
                jsonGenerator.writeNumberField("quantity", t.getValue());
                jsonGenerator.writeEndObject();
            } catch (IOException e) {
             // On exception, the ser will write empty array object.
            }
        });
        jsonGenerator.writeEndArray();
    }
}