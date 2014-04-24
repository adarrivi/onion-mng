package com.adarrivi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adarrivi.core.CreateSomeElementsApplication;
import com.adarrivi.core.service.management.BoneManagementService;
import com.adarrivi.core.service.management.JointManagementService;
import com.adarrivi.core.service.management.MuscleManagementService;
import com.adarrivi.relational.RelationalConfiguration;

public class RelationalMain extends CreateSomeElementsApplication {

    public static void main(String[] args) {
        new RelationalMain().run();
    }

    @SuppressWarnings("resource")
    private void run() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RelationalConfiguration.class);
        applicationContext.registerShutdownHook();

        setBoneManagementService(applicationContext.getBean(BoneManagementService.class));
        setMuscleManagementService(applicationContext.getBean(MuscleManagementService.class));
        setJointManagementService(applicationContext.getBean(JointManagementService.class));

        start();

    }
}
