package com.adarrivi.core.usercase;

import javax.inject.Inject;

import com.adarrivi.core.contract.FasciaCrudContract;
import com.adarrivi.core.entity.Fascia;

public class FasciaManagementUserCase extends GenericManagementUseCase<Fascia> {
    @Inject
    public FasciaManagementUserCase(FasciaCrudContract fasciaCrudContract) {
        super(fasciaCrudContract);
    }

}
