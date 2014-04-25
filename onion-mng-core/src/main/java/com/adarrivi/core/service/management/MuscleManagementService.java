package com.adarrivi.core.service.management;

import javax.inject.Inject;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.entity.Muscle;

public class MuscleManagementService extends GenericManagementService<Muscle> {
    @Inject
    public MuscleManagementService(CrudContract<Muscle> crudDao) {
        super(crudDao);
    }

}
