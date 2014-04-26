package com.adarrivi.core.usercase;

import java.util.Arrays;

import javax.inject.Inject;

import com.adarrivi.core.contract.BoneCrudContract;
import com.adarrivi.core.contract.JointCrudContract;
import com.adarrivi.core.contract.MuscleCrudContract;
import com.adarrivi.core.entity.Bone;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.core.entity.Muscle;
import com.adarrivi.core.entity.RelativePosition;

public class StructureUserCase {

    @Inject
    private BoneCrudContract boneCrudContract;
    @Inject
    private MuscleCrudContract muscleCrudContract;
    @Inject
    private JointCrudContract jointCrudContract;

    public Joint createGlenoHumeralJoint() {
        Bone humerus = new Bone("humerus", RelativePosition.LEFT);
        boneCrudContract.create(humerus);
        Bone scapula = new Bone("scapula", RelativePosition.LEFT);
        boneCrudContract.create(scapula);
        Muscle deltoid = new Muscle("deltoid", RelativePosition.LEFT, Arrays.asList(humerus, scapula));
        muscleCrudContract.create(deltoid);
        Joint glenohumeral = new Joint("glenohumeral", RelativePosition.LEFT, humerus, scapula);
        jointCrudContract.create(glenohumeral);
        return glenohumeral;
    }

}
