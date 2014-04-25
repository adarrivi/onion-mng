package com.adarrivi.norelational.adapter;

import org.codehaus.jackson.map.ObjectMapper;

public class ObjectMapperProvider {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

}
