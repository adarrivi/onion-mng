package com.adarrivi.core.entity;

import java.util.Objects;

public class Joint implements Named, RelativePositioned {

    private String name;
    private RelativePosition relativePosition;
    private Bone bone1;
    private Bone bone2;

    public Joint(String name, RelativePosition relativePosition, Bone bone1, Bone bone2) {
        this.name = name;
        this.relativePosition = relativePosition;
        this.bone1 = bone1;
        this.bone2 = bone2;
    }

    @Override
    public String getName() {
        return name;
    }

    public Bone getBone1() {
        return bone1;
    }

    public Bone getBone2() {
        return bone2;
    }

    @Override
    public RelativePosition getRelativePosition() {
        return relativePosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, relativePosition, bone1, bone2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Joint)) {
            return false;
        }
        Joint other = (Joint) obj;
        return (name.equals(other.name) && relativePosition.equals(other.relativePosition) && bone1.equals(other.bone1) && bone2
                .equals(other.bone2));
    }

    @Override
    public String toString() {
        return "Joint [name=" + name + ", relativePosition=" + relativePosition + ", bone1=" + bone1 + ", bone2=" + bone2 + "]";
    }

}
