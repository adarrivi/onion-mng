package com.adarrivi.external.jpa.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adarrivi.core.dao.CrudDao;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.external.jpa.adapter.JointEntityAdapter;
import com.adarrivi.external.jpa.dao.repository.BoneJpaRepository;
import com.adarrivi.external.jpa.dao.repository.JointJpaRepository;
import com.adarrivi.external.jpa.entity.BoneEntity;
import com.adarrivi.external.jpa.entity.JointEntity;

@Repository("jointDao")
@Transactional(readOnly = true)
public class JointDaoJpa implements CrudDao<Joint> {

    @Autowired
    private JointJpaRepository jointJpaRepository;
    @Autowired
    private JointEntityAdapter jointEntityAdapter;
    @Autowired
    private BoneJpaRepository boneJpaRepository;

    @Override
    @Transactional
    public void create(Joint entity) {
        BoneEntity boneEntity = boneJpaRepository.findAll().get(0);
        JointEntity jointEntity = new JointEntity(entity.getName(), entity.getRelativePosition(), boneEntity, boneEntity);
        jointJpaRepository.saveAndFlush(jointEntity);
    }

    @Override
    public Collection<Joint> findAll() {
        List<Joint> bones = new ArrayList<>();
        for (JointEntity jointEntity : jointJpaRepository.findAll()) {
            bones.add(jointEntityAdapter.convertTo(jointEntity));
        }
        return bones;
    }

}
