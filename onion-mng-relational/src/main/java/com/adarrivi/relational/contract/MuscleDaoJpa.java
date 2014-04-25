package com.adarrivi.relational.contract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.entity.Muscle;
import com.adarrivi.relational.adapter.MuscleEntityAdapter;
import com.adarrivi.relational.contract.repository.MuscleJpaRepository;
import com.adarrivi.relational.entity.MuscleEntity;

@Repository
@Transactional(readOnly = true)
public class MuscleDaoJpa implements CrudContract<Muscle> {

    @Inject
    private MuscleJpaRepository muscleJpaRepository;
    @Inject
    private MuscleEntityAdapter muscleEntityAdapter;

    @Override
    @Transactional
    public void create(Muscle entity) {
        muscleJpaRepository.saveAndFlush(muscleEntityAdapter.convertFrom(entity));
    }

    @Override
    public Collection<Muscle> findAll() {
        List<Muscle> bones = new ArrayList<>();
        for (MuscleEntity muscleEntity : muscleJpaRepository.findAll()) {
            bones.add(muscleEntityAdapter.convertTo(muscleEntity));
        }
        return bones;
    }

}
