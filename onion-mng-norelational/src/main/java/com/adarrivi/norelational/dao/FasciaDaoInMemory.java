package com.adarrivi.norelational.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.adarrivi.core.entity.Fascia;
import com.adarrivi.norelational.adapter.GenericNamedToEntryMapAdapter;

@Repository("fasciaDao")
public class FasciaDaoInMemory extends GenericDaoInMemory<Fascia> {

    @Autowired
    public FasciaDaoInMemory(@Qualifier("fasciaToEntryMapAdapter") GenericNamedToEntryMapAdapter<Fascia> entryMapAdapter) {
        super(entryMapAdapter);
    }

}
