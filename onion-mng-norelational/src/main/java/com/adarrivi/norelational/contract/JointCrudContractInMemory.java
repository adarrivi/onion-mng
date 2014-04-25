package com.adarrivi.norelational.contract;

import javax.inject.Inject;

import com.adarrivi.core.entity.Joint;
import com.adarrivi.norelational.adapter.JointJsonAdapter;
import com.adarrivi.norelational.entity.JointJson;

public class JointCrudContractInMemory extends GenericCrudContractInMemory<Joint, JointJson> {
    @Inject
    JointCrudContractInMemory(JointJsonAdapter jointJsonAdapter) {
        super(jointJsonAdapter);
    }

    @Override
    protected String getEntityKey(Joint entity) {
        return getKeyPrefix() + entity.getName();
    }

    @Override
    protected String getKeyPrefix() {
        return "joint::";
    }

}
