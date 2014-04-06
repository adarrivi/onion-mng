package com.adarrivi.core.entity;

import java.util.Collection;

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
    public String toString() {
        return "Muscle [name=" + name + ", relativePosition=" + relativePosition + ", anchors=" + anchors + "]";
    }

}
