package com.adarrivi.external.inmemory.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.adarrivi.core.entity.Fascia;
import com.adarrivi.external.inmemory.adapter.GenericNamedToEntryMapAdapter;

@Repository("fasciaDao")
public class FasciaDaoInMemory extends GenericDaoInMemory<Fascia> {

    @Autowired
    public FasciaDaoInMemory(@Qualifier("fasciaToEntryMapAdapter") GenericNamedToEntryMapAdapter<Fascia> entryMapAdapter) {
        super(entryMapAdapter);
    }

}
