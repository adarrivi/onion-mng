package com.adarrivi.core.service.management;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.entity.Fascia;

public class FasciaManagementService extends GenericManagementService<Fascia> {

    public FasciaManagementService(CrudContract<Fascia> fasciaDao) {
        super(fasciaDao);
    }

}
