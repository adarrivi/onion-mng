package com.adarrivi.external.jpa.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adarrivi.core.dao.CrudDao;
import com.adarrivi.core.entity.Muscle;
import com.adarrivi.external.jpa.adapter.MuscleEntityAdapter;
import com.adarrivi.external.jpa.dao.repository.MuscleJpaRepository;
import com.adarrivi.external.jpa.entity.MuscleEntity;

@Repository("muscleDao")
@Transactional(readOnly = true)
public class MuscleDaoJpa implements CrudDao<Muscle> {

    @Autowired
    private MuscleJpaRepository muscleJpaRepository;
    @Autowired
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
