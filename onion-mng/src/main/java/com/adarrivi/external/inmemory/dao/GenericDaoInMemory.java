package com.adarrivi.external.inmemory.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.adarrivi.core.dao.CrudDao;
import com.adarrivi.core.entity.Named;
import com.adarrivi.external.inmemory.adapter.GenericNamedToEntryMapAdapter;

abstract class GenericDaoInMemory<K extends Named> implements CrudDao<K> {

    private GenericNamedToEntryMapAdapter<K> entryMapAdapter;

    private Map<String, K> entityContainer = new HashMap<>();

    public GenericDaoInMemory(GenericNamedToEntryMapAdapter<K> entryMapAdapter) {
        this.entryMapAdapter = entryMapAdapter;
    }

    @Override
    public void create(K entity) {
        Entry<String, K> entry = entryMapAdapter.convertFrom(entity);
        entityContainer.put(entry.getKey(), entry.getValue());
    }

    @Override
    public Collection<K> findAll() {
        List<K> allEntities = new ArrayList<>();
        for (Entry<String, K> userEntry : entityContainer.entrySet()) {
            allEntities.add(entryMapAdapter.convertTo(userEntry));
        }
        return allEntities;
    }

}
