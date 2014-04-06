package com.adarrivi.core.entity;

public class Bone extends GenericAnchor {

    public Bone(String name, RelativePosition relativePosition) {
        super(name, relativePosition);
    }

    @Override
    public String toString() {
        return "Bone [name=" + getName() + ", relativePosition=" + getRelativePosition() + "]";
    }
}
