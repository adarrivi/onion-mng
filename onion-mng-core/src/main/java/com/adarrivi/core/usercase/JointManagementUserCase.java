package com.adarrivi.core.usercase;

import javax.inject.Inject;

import com.adarrivi.core.contract.JointCrudContract;
import com.adarrivi.core.entity.Joint;

public class JointManagementUserCase extends GenericManagementUseCase<Joint> {
    @Inject
    public JointManagementUserCase(JointCrudContract jointCrudContract) {
        super(jointCrudContract);
    }

}
