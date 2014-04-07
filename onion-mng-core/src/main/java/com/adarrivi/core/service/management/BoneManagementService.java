package com.adarrivi.core.service.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.contract.CrudContractName;
import com.adarrivi.core.entity.Bone;

@Service
public class BoneManagementService extends GenericManagementService<Bone> {

    @Autowired
    public BoneManagementService(@Qualifier(CrudContractName.BONE_CRUD) CrudContract<Bone> crudDao) {
        super(crudDao);
    }

}
