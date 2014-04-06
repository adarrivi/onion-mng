package com.adarrivi.core.entity;

abstract class GenericAnchor implements Anchor {
    private String name;
    private RelativePosition relativePosition;

    protected GenericAnchor(String name, RelativePosition relativePosition) {
        this.name = name;
        this.relativePosition = relativePosition;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public RelativePosition getRelativePosition() {
        return relativePosition;
    }

}
