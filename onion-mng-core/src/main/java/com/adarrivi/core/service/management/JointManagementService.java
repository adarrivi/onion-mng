package com.adarrivi.core.service.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.contract.CrudContractName;
import com.adarrivi.core.entity.Joint;

@Service
public class JointManagementService extends GenericManagementService<Joint> {

    @Autowired
    public JointManagementService(@Qualifier(CrudContractName.JOINT_CRUD) CrudContract<Joint> crudDao) {
        super(crudDao);
    }

}
