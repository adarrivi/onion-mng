package com.adarrivi.core.service.management;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.entity.Muscle;

public class MuscleManagementService extends GenericManagementService<Muscle> {

    public MuscleManagementService(CrudContract<Muscle> crudDao) {
        super(crudDao);
    }

}
