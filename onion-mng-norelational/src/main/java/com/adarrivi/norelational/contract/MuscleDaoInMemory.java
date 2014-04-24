package com.adarrivi.norelational.contract;

import com.adarrivi.core.entity.Muscle;
import com.adarrivi.norelational.adapter.MuscleJsonAdapter;
import com.adarrivi.norelational.entity.MuscleJson;

public class MuscleDaoInMemory extends GenericInMemoryDao<Muscle, MuscleJson> {

    MuscleDaoInMemory(MuscleJsonAdapter muscleJsonAdapter) {
        super(muscleJsonAdapter);
    }

    @Override
    protected String getEntityKey(Muscle entity) {
        return getKeyPrefix() + entity.getName();
    }

    @Override
    protected String getKeyPrefix() {
        return "muscle::";
    }

}
