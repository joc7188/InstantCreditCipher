package com.instantcredit.service;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

public class JsonSerializer {
    private static final Logger LOG = Logger.getLogger(JsonSerializer.class.getName());
    public static final String ERROR_JSON_SERIALIZATION = "An error occurred while JSON serialization";

    public static String serializeString(String property_name, String text) {
        String output = null;
        try {
            output = mapString(property_name, text);
        } catch (Exception e) {
            LOG.warning(ERROR_JSON_SERIALIZATION + e);
        }
        return output;
    }

    private static String mapString(String property_name, String text) throws IOException {
        HashMap<String, String> output_map = new HashMap<>();
        String output;
        output_map.put(property_name, text);
        ObjectMapper mapper = new ObjectMapper();
        output = mapper.writeValueAsString(output_map);
        return output;
    }
}
