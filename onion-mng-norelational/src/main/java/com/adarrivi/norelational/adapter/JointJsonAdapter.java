package com.adarrivi.norelational.adapter;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.norelational.entity.JointJson;

public class JointJsonAdapter implements EntityAdapter<Joint, JointJson> {

    private BoneJsonAdapter boneJsonAdapter;

    @Override
    public JointJson convertFrom(Joint from) {
        return new JointJson(from.getName(), from.getRelativePosition(), boneJsonAdapter.convertFrom(from.getBone1()),
                boneJsonAdapter.convertFrom(from.getBone2()));
    }

    @Override
    public Joint convertTo(JointJson to) {
        return new Joint(to.getName(), to.getRelativePosition(), boneJsonAdapter.convertTo(to.getBone1()), boneJsonAdapter.convertTo(to
                .getBone2()));
    }

}
