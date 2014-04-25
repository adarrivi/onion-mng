package com.adarrivi.core.usercase;

import javax.inject.Inject;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.entity.Joint;

public class JointManagementUserCase extends GenericManagementUseCase<Joint> {
    @Inject
    public JointManagementUserCase(CrudContract<Joint> crudDao) {
        super(crudDao);
    }

}
