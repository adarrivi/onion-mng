package com.adarrivi.core.entity;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(name, relativePosition);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof GenericAnchor)) {
            return false;
        }
        GenericAnchor other = (GenericAnchor) obj;
        return (name.equals(other.name) && relativePosition.equals(other.relativePosition));
    }
}
