package com.adarrivi.norelational.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adarrivi.core.contract.CrudContractName;
import com.adarrivi.core.entity.Muscle;
import com.adarrivi.norelational.adapter.MuscleJsonAdapter;
import com.adarrivi.norelational.entity.MuscleJson;

@Repository(CrudContractName.MUSCLE_CRUD)
public class MuscleDaoInMemory extends GenericInMemoryDao<Muscle, MuscleJson> {

    @Autowired
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

    @Override
    protected Class<MuscleJson> getEntityClass() {
        return MuscleJson.class;
    }

}
