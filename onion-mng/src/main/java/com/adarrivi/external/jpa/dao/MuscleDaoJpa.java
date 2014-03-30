package com.adarrivi.external.jpa.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adarrivi.core.dao.CrudDao;
import com.adarrivi.core.entity.Muscle;
import com.adarrivi.external.jpa.adapter.MuscleEntityAdapter;
import com.adarrivi.external.jpa.dao.repository.BoneJpaRepository;
import com.adarrivi.external.jpa.dao.repository.MuscleJpaRepository;
import com.adarrivi.external.jpa.entity.BoneEntity;
import com.adarrivi.external.jpa.entity.MuscleEntity;

@Repository("muscleDao")
@Transactional(readOnly = true)
public class MuscleDaoJpa implements CrudDao<Muscle> {

    @Autowired
    private MuscleJpaRepository muscleJpaRepository;
    @Autowired
    private MuscleEntityAdapter muscleEntityAdapter;
    @Autowired
    private BoneJpaRepository boneJpaRepository;

    @Override
    @Transactional
    public void create(Muscle entity) {
        BoneEntity boneEntity = boneJpaRepository.findAll().get(0);
        MuscleEntity muscleEntity = new MuscleEntity(entity.getName(), entity.getRelativePosition(), Collections.singletonList(boneEntity));
        muscleJpaRepository.saveAndFlush(muscleEntity);
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
