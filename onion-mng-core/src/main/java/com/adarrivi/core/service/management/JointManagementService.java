package com.adarrivi.core.service.management;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.entity.Joint;

public class JointManagementService extends GenericManagementService<Joint> {

    public JointManagementService(CrudContract<Joint> crudDao) {
        super(crudDao);
    }

}
