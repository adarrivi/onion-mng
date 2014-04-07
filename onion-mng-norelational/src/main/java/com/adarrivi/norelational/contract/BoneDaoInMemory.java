package com.adarrivi.norelational.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adarrivi.core.contract.CrudContractName;
import com.adarrivi.core.entity.Bone;
import com.adarrivi.norelational.adapter.BoneJsonAdapter;
import com.adarrivi.norelational.entity.BoneJson;

@Repository(CrudContractName.BONE_CRUD)
public class BoneDaoInMemory extends GenericInMemoryDao<Bone, BoneJson> {

    @Autowired
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

    @Override
    protected Class<BoneJson> getEntityClass() {
        return BoneJson.class;
    }

}
