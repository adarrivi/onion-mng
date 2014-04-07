package com.adarrivi.norelational.entity;

import java.util.Collection;

import com.adarrivi.core.entity.RelativePosition;

public class MuscleJson {

    private String name;
    private RelativePosition relativePosition;
    private Collection<? extends AnchorJson> anchors;

    MuscleJson() {
        // Constructor required for the json-pojo parser
    }

    public MuscleJson(String name, RelativePosition relativePosition, Collection<? extends AnchorJson> anchors) {
        this.name = name;
        this.relativePosition = relativePosition;
        this.anchors = anchors;
    }

    public String getName() {
        return name;
    }

    public RelativePosition getRelativePosition() {
        return relativePosition;
    }

    public Collection<? extends AnchorJson> getAnchors() {
        return anchors;
    }

}
