package com.adarrivi.external.inmemory.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.adarrivi.core.entity.Muscle;
import com.adarrivi.external.inmemory.adapter.GenericNamedToEntryMapAdapter;

@Repository("muscleDao")
public class MuscleDaoInMemory extends GenericDaoInMemory<Muscle> {

    @Autowired
    public MuscleDaoInMemory(@Qualifier("muscleToEntryMapAdapter") GenericNamedToEntryMapAdapter<Muscle> entryMapAdapter) {
        super(entryMapAdapter);
    }

}
