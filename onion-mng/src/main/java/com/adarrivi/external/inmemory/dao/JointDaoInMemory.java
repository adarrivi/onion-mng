package com.adarrivi.external.inmemory.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.adarrivi.core.entity.Joint;
import com.adarrivi.external.inmemory.adapter.GenericNamedToEntryMapAdapter;

@Repository("jointDao")
public class JointDaoInMemory extends GenericDaoInMemory<Joint> {

    @Autowired
    public JointDaoInMemory(@Qualifier("jointToEntryMapAdapter") GenericNamedToEntryMapAdapter<Joint> entryMapAdapter) {
        super(entryMapAdapter);
    }

}
