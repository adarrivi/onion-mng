package com.adarrivi.core.service.management;

import javax.inject.Inject;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.entity.Bone;

public class BoneManagementService extends GenericManagementService<Bone> {

    @Inject
    public BoneManagementService(CrudContract<Bone> crudContract) {
        super(crudContract);
    }

}
