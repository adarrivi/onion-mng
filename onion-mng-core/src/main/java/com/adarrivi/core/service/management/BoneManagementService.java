package com.adarrivi.core.service.management;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.entity.Bone;

public class BoneManagementService extends GenericManagementService<Bone> {

    public BoneManagementService(CrudContract<Bone> crudContract) {
        super(crudContract);
    }

}
