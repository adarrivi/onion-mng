package com.adarrivi.norelational.contract;

import javax.inject.Inject;

import com.adarrivi.core.entity.Bone;
import com.adarrivi.norelational.adapter.BoneJsonAdapter;
import com.adarrivi.norelational.entity.BoneJson;

public class BoneDaoInMemory extends GenericInMemoryDao<Bone, BoneJson> {

    @Inject
    BoneDaoInMemory(BoneJsonAdapter boneJsonAdapter) {
        super(boneJsonAdapter);
    }

    @Override
    protected String getEntityKey(Bone entity) {
        return getKeyPrefix() + entity.getName();
    }

    @Override
    protected String getKeyPrefix() {
        return "bone::";
    }

}
