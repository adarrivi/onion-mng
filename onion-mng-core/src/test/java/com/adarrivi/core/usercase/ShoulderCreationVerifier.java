package com.adarrivi.core.usercase;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adarrivi.core.entity.Bone;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.core.entity.RelativePosition;

public abstract class ShoulderCreationVerifier {

    private static final Logger LOG = LoggerFactory.getLogger(ShoulderCreationVerifier.class);

    private StructureUserCase structureUserCase;

    public ShoulderCreationVerifier(StructureUserCase structureUserCase) {
        this.structureUserCase = structureUserCase;
    }

    public void verify() {
        Joint expectedGlenohumeral = getExpectedGlenohumeral();
        Assert.assertEquals(expectedGlenohumeral, structureUserCase.createGlenoHumeralJoint());
        LOG.debug("Shoulder joint: {}", expectedGlenohumeral);
    }

    private Joint getExpectedGlenohumeral() {
        Bone humerus = new Bone("humerus", RelativePosition.LEFT);
        Bone scapula = new Bone("scapula", RelativePosition.LEFT);
        return new Joint("glenohumeral", RelativePosition.LEFT, humerus, scapula);
    }

}
