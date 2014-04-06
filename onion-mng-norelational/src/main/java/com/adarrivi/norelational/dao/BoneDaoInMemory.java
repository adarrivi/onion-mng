package com.adarrivi.norelational.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.adarrivi.core.entity.Bone;
import com.adarrivi.norelational.adapter.GenericNamedToEntryMapAdapter;

@Repository("boneDao")
public class BoneDaoInMemory extends GenericDaoInMemory<Bone> {

    @Autowired
    public BoneDaoInMemory(@Qualifier("boneToEntryMapAdapter") GenericNamedToEntryMapAdapter<Bone> entryMapAdapter) {
        super(entryMapAdapter);
    }

}
