package com.adarrivi.core;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adarrivi.core.entity.Bone;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.core.entity.Muscle;
import com.adarrivi.core.entity.RelativePosition;
import com.adarrivi.core.usercase.BoneManagementUserCase;
import com.adarrivi.core.usercase.JointManagementUserCase;
import com.adarrivi.core.usercase.MuscleManagementUserCase;

public abstract class CreateSomeElementsApplication {

    private static final Logger LOG = LoggerFactory.getLogger(CreateSomeElementsApplication.class);

    private BoneManagementUserCase boneManagementUserCase;
    private MuscleManagementUserCase muscleManagementUserCase;
    private JointManagementUserCase jointManagementUserCase;

    public void start() {

        Bone humerus = new Bone("humerus", RelativePosition.LEFT);
        Bone scapula = new Bone("scapula", RelativePosition.LEFT);
        Muscle deltoid = new Muscle("deltoid", RelativePosition.LEFT, Arrays.asList(humerus, scapula));
        Joint glenohumeral = new Joint("glenohumeral", RelativePosition.LEFT, humerus, scapula);

        boneManagementUserCase.create(humerus);
        boneManagementUserCase.create(scapula);
        muscleManagementUserCase.create(deltoid);
        jointManagementUserCase.create(glenohumeral);

        LOG.debug("Bone list: {}", boneManagementUserCase.findAll());
        LOG.debug("Muscle list: {}", muscleManagementUserCase.findAll());
        LOG.debug("Joint list: {}", jointManagementUserCase.findAll());
    }

    protected void setBoneManagementUserCase(BoneManagementUserCase boneManagementUserCase) {
        this.boneManagementUserCase = boneManagementUserCase;
    }

    protected void setMuscleManagementUserCase(MuscleManagementUserCase muscleManagementUserCase) {
        this.muscleManagementUserCase = muscleManagementUserCase;
    }

    protected void setJointManagementUserCase(JointManagementUserCase jointManagementUserCase) {
        this.jointManagementUserCase = jointManagementUserCase;
    }
}
