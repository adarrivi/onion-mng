package com.adarrivi.core;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adarrivi.core.entity.Bone;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.core.entity.Muscle;
import com.adarrivi.core.entity.RelativePosition;
import com.adarrivi.core.service.management.BoneManagementService;
import com.adarrivi.core.service.management.JointManagementService;
import com.adarrivi.core.service.management.MuscleManagementService;

public abstract class CreateSomeElementsApplication {

    private static final Logger LOG = LoggerFactory.getLogger(CreateSomeElementsApplication.class);

    private BoneManagementService boneManagementService;
    private MuscleManagementService muscleManagementService;
    private JointManagementService jointManagementService;

    public void start() {

        Bone humerus = new Bone("humerus", RelativePosition.LEFT);
        Bone scapula = new Bone("scapula", RelativePosition.LEFT);
        Muscle deltoid = new Muscle("deltoid", RelativePosition.LEFT, Arrays.asList(humerus, scapula));
        Joint glenohumeral = new Joint("glenohumeral", RelativePosition.LEFT, humerus, scapula);

        boneManagementService.create(humerus);
        boneManagementService.create(scapula);
        muscleManagementService.create(deltoid);
        jointManagementService.create(glenohumeral);

        LOG.debug("Bone list: {}", boneManagementService.findAll());
        LOG.debug("Muscle list: {}", muscleManagementService.findAll());
        LOG.debug("Joint list: {}", jointManagementService.findAll());
    }

    protected void setBoneManagementService(BoneManagementService boneManagementService) {
        this.boneManagementService = boneManagementService;
    }

    protected void setMuscleManagementService(MuscleManagementService muscleManagementService) {
        this.muscleManagementService = muscleManagementService;
    }

    protected void setJointManagementService(JointManagementService jointManagementService) {
        this.jointManagementService = jointManagementService;
    }
}
