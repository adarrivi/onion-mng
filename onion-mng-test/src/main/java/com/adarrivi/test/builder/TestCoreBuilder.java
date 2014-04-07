package com.adarrivi.test.builder;

import com.adarrivi.core.entity.Bone;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.core.entity.RelativePosition;

public class TestCoreBuilder {

    private TestCoreBuilder() {
        // This class is not intended to be instantiated
    }

    public static Bone createBone() {
        return new Bone("humerus", RelativePosition.LEFT);
    }

    public static Joint createJoint() {
        return new Joint("glenohumeral", RelativePosition.LEFT, createBone(), createBone());
    }

}
