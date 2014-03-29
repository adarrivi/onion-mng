package com.adarrivi.core.entity;

public class Fascia extends GenericAnchor {

    public Fascia(String name, RelativePosition relativePosition) {
        super(name, relativePosition);
    }

    @Override
    public String toString() {
        return "Fascia [name=" + getName() + ", relativePosition=" + getRelativePosition() + "]";
    }
}
