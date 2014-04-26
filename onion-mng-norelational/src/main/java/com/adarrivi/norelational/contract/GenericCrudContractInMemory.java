package com.adarrivi.norelational.contract;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import javax.inject.Inject;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.norelational.adapter.JsonParserComponent;

abstract class GenericCrudContractInMemory<K, T> {

    @Inject
    private JsonParserComponent jsonParserComponent;
    @Inject
    private InMemoryMap inMemoryMap;

    private Class<T> jsonClass;

    private EntityAdapter<K, T> entityAdapter;

    protected GenericCrudContractInMemory(EntityAdapter<K, T> entityAdapter) {
        this.entityAdapter = entityAdapter;
        setJsonClassFromGeneric();
    }

    @SuppressWarnings("unchecked")
    private void setJsonClassFromGeneric() {
        this.jsonClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public void create(K entity) {
        T entityJson = entityAdapter.convertFrom(entity);
        String jsonString = jsonParserComponent.toJsonString(entityJson);
        inMemoryMap.getMap().put(getEntityKey(entity), jsonString);
    }

    public Collection<K> findAll() {
        List<K> allEntities = new ArrayList<>();
        for (Entry<String, String> entry : inMemoryMap.getMap().entrySet()) {
            if (entry.getKey().startsWith(getKeyPrefix())) {
                T jsonEntity = jsonParserComponent.toJsonEntity(entry.getValue(), jsonClass);
                allEntities.add(entityAdapter.convertTo(jsonEntity));
            }
        }
        return allEntities;
    }

    protected abstract String getEntityKey(K entity);

    protected abstract String getKeyPrefix();

}
