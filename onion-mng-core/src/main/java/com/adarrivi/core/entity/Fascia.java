package com.adarrivi.core.entity;

import java.util.Objects;

public class Fascia extends GenericAnchor {

    public Fascia(String name, RelativePosition relativePosition) {
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
        return obj instanceof Fascia;
    }

    @Override
    public String toString() {
        return "Fascia [name=" + getName() + ", relativePosition=" + getRelativePosition() + "]";
    }
}
