package com.adarrivi.norelational.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adarrivi.core.contract.CrudContractName;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.norelational.adapter.JointJsonAdapter;
import com.adarrivi.norelational.entity.JointJson;

@Repository(CrudContractName.JOINT_CRUD)
public class JointDaoInMemory extends GenericInMemoryDao<Joint, JointJson> {

    @Autowired
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
