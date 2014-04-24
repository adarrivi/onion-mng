package com.adarrivi.norelational.contract;

import com.adarrivi.core.entity.Joint;
import com.adarrivi.norelational.adapter.JointJsonAdapter;
import com.adarrivi.norelational.entity.JointJson;

public class JointDaoInMemory extends GenericInMemoryDao<Joint, JointJson> {

    JointDaoInMemory(JointJsonAdapter jointJsonAdapter) {
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
