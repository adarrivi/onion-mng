package com.adarrivi.core.usercase;

import javax.inject.Inject;

import com.adarrivi.core.contract.BoneCrudContract;
import com.adarrivi.core.entity.Bone;

public class BoneManagementUserCase extends GenericManagementUseCase<Bone> {

    @Inject
    public BoneManagementUserCase(BoneCrudContract boneCrudContract) {
        super(boneCrudContract);
    }

}
