package com.adarrivi.relational.adapter;

import org.springframework.stereotype.Component;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.entity.Bone;
import com.adarrivi.relational.entity.BoneEntity;

@Component
public class BoneEntityAdapter implements EntityAdapter<Bone, BoneEntity> {

    @Override
    public BoneEntity convertFrom(Bone from) {
        return new BoneEntity(from.getName(), from.getRelativePosition());
    }

    @Override
    public Bone convertTo(BoneEntity to) {
        return new Bone(to.getName(), to.getRelativePosition());
    }

}
