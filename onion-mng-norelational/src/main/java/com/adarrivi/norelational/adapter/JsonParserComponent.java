package com.adarrivi.norelational.adapter;

import java.io.IOException;

import javax.inject.Inject;

import com.adarrivi.norelational.exception.InvalidEntityException;

public class JsonParserComponent {

    @Inject
    private ObjectMapperProvider objectMapperProvider;

    JsonParserComponent() {
    }

    public String toJsonString(Object entity) {
        asserValidEntity(entity);
        try {
            return objectMapperProvider.getObjectMapper().writeValueAsString(entity);
        } catch (IOException e) {
            throw new InvalidEntityException("Could not parse the entity: ", e);
        }
    }

    private void asserValidEntity(Object entity) {
        if (entity == null) {
            throw new InvalidEntityException("Cannot convert into json a null entity");
        }
    }

    public <T> T toJsonEntity(String jsonString, Class<T> entityClass) {
        assertValidJsonSTring(jsonString);
        try {
            return objectMapperProvider.getObjectMapper().readValue(jsonString, entityClass);
        } catch (IOException e) {
            throw new InvalidEntityException("Could not parse the jsonString: ", e);
        }
    }

    private void assertValidJsonSTring(String jsonString) {
        if (jsonString == null || jsonString.isEmpty()) {
            throw new InvalidEntityException("Cannot convert an empty string");
        }
    }

}
