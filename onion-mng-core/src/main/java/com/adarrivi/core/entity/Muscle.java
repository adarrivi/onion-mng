package com.adarrivi.core.entity;

import java.util.Collection;
import java.util.Objects;

public class Muscle implements Named, RelativePositioned {

    private String name;
    private RelativePosition relativePosition;
    private Collection<? extends Anchor> anchors;

    public Muscle(String name, RelativePosition relativePosition, Collection<? extends Anchor> anchors) {
        this.name = name;
        this.relativePosition = relativePosition;
        this.anchors = anchors;
    }

    @Override
    public String getName() {
        return name;
    }

    public Collection<? extends Anchor> getAnchors() {
        return anchors;
    }

    @Override
    public RelativePosition getRelativePosition() {
        return relativePosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, relativePosition, anchors);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Muscle)) {
            return false;
        }
        Muscle other = (Muscle) obj;
        return name.equals(other.name) && relativePosition.equals(other.relativePosition) && Objects.equals(anchors, other.anchors);
    }

    @Override
    public String toString() {
        return "Muscle [name=" + name + ", relativePosition=" + relativePosition + ", anchors=" + anchors + "]";
    }

}
