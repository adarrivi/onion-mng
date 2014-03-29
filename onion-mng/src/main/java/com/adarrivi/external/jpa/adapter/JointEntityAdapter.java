package com.adarrivi.external.jpa.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.external.jpa.entity.JointEntity;

@Component("jointEntityAdapter")
public class JointEntityAdapter implements EntityAdapter<Joint, JointEntity> {

    @Autowired
    private BoneEntityAdapter boneEntityAdapter;

    @Override
    public JointEntity convertFrom(Joint from) {
        return new JointEntity(from.getName(), from.getRelativePosition(), boneEntityAdapter.convertFrom(from.getBone1()),
                boneEntityAdapter.convertFrom(from.getBone2()));
    }

    @Override
    public Joint convertTo(JointEntity to) {
        return new Joint(to.getName(), to.getRelativePosition(), boneEntityAdapter.convertTo(to.getBone1()), boneEntityAdapter.convertTo(to
                .getBone2()));
    }

}
