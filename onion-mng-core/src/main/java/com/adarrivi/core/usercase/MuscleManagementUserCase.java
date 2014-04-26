package com.adarrivi.core.usercase;

import javax.inject.Inject;

import com.adarrivi.core.contract.MuscleCrudContract;
import com.adarrivi.core.entity.Muscle;

public class MuscleManagementUserCase extends GenericManagementUseCase<Muscle> {
    @Inject
    public MuscleManagementUserCase(MuscleCrudContract muscleCrudContract) {
        super(muscleCrudContract);
    }

}
