package com.adarrivi.core.entity;

public class Joint implements Named, RelativePositioned {

    private String name;
    private RelativePosition relativePosition;
    private Bone bone1;
    private Bone bone2;

    public Joint(String name, RelativePosition relativePosition, Bone bone1, Bone bone2) {
        super();
        this.name = name;
        this.relativePosition = relativePosition;
        this.bone1 = bone1;
        this.bone2 = bone2;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * @return the bone1
     */
    public Bone getBone1() {
        return bone1;
    }

    /**
     * @return the bone2
     */
    public Bone getBone2() {
        return bone2;
    }

    @Override
    public RelativePosition getRelativePosition() {
        return relativePosition;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Joint [name=" + name + ", relativePosition=" + relativePosition + ", bone1=" + bone1 + ", bone2=" + bone2 + "]";
    }

}
