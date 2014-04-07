package com.adarrivi.norelational.entity;

import com.adarrivi.core.entity.RelativePosition;

public class JointJson {

    private String name;
    private RelativePosition relativePosition;
    private BoneJson bone1;
    private BoneJson bone2;

    JointJson() {
        // Constructor required for the json-pojo parser
    }

    public JointJson(String name, RelativePosition relativePosition, BoneJson bone1, BoneJson bone2) {
        this.name = name;
        this.relativePosition = relativePosition;
        this.bone1 = bone1;
        this.bone2 = bone2;
    }

    public String getName() {
        return name;
    }

    public RelativePosition getRelativePosition() {
        return relativePosition;
    }

    public BoneJson getBone1() {
        return bone1;
    }

    public BoneJson getBone2() {
        return bone2;
    }

}
