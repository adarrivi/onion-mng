package com.adarrivi.relational.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.relational.dao.repository.BoneJpaRepository;
import com.adarrivi.relational.entity.BoneEntity;
import com.adarrivi.relational.entity.JointEntity;

@Component("jointEntityAdapter")
public class JointEntityAdapter implements EntityAdapter<Joint, JointEntity> {

    @Autowired
    private BoneEntityAdapter boneEntityAdapter;
    @Autowired
    private BoneJpaRepository boneJpaRepository;

    @Override
    public JointEntity convertFrom(Joint from) {
        BoneEntity boneEntity1 = boneJpaRepository.findByName(from.getBone1().getName());
        BoneEntity boneEntity2 = boneJpaRepository.findByName(from.getBone2().getName());
        return new JointEntity(from.getName(), from.getRelativePosition(), boneEntity1, boneEntity2);
    }

    @Override
    public Joint convertTo(JointEntity to) {
        return new Joint(to.getName(), to.getRelativePosition(), boneEntityAdapter.convertTo(to.getBone1()), boneEntityAdapter.convertTo(to
                .getBone2()));
    }

}
