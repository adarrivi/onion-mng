package com.adarrivi.norelational.adapter;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperProvider {

    private final ObjectMapper objectMapper = new ObjectMapper();

    ObjectMapperProvider() {
        super();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

}
