package com.adarrivi.norelational.adapter;

import org.springframework.stereotype.Component;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.entity.Bone;
import com.adarrivi.norelational.entity.BoneJson;

@Component
public class BoneJsonAdapter implements EntityAdapter<Bone, BoneJson> {

    @Override
    public BoneJson convertFrom(Bone from) {
        return new BoneJson(from.getName(), from.getRelativePosition());
    }

    @Override
    public Bone convertTo(BoneJson to) {
        return new Bone(to.getName(), to.getRelativePosition());
    }

}
