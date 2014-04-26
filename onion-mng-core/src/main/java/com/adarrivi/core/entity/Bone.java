package com.adarrivi.core.entity;

import java.util.Objects;

public class Bone extends GenericAnchor {

    public Bone(String name, RelativePosition relativePosition) {
        super(name, relativePosition);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass()) + super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        return obj instanceof Bone;
    }

    @Override
    public String toString() {
        return "Bone [name=" + getName() + ", relativePosition=" + getRelativePosition() + "]";
    }
}
