package com.adarrivi.core.service.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.contract.CrudContractName;
import com.adarrivi.core.entity.Muscle;

@Service
public class MuscleManagementService extends GenericManagementService<Muscle> {

    @Autowired
    public MuscleManagementService(@Qualifier(CrudContractName.MUSCLE_CRUD) CrudContract<Muscle> crudDao) {
        super(crudDao);
    }

}
