package com.adarrivi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adarrivi.core.CreateSomeElementsApplication;
import com.adarrivi.core.usercase.BoneManagementUserCase;
import com.adarrivi.core.usercase.JointManagementUserCase;
import com.adarrivi.core.usercase.MuscleManagementUserCase;
import com.adarrivi.relational.RelationalConfiguration;

public class RelationalMain extends CreateSomeElementsApplication {

    public static void main(String[] args) {
        new RelationalMain().run();
    }

    @SuppressWarnings("resource")
    private void run() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RelationalConfiguration.class);
        applicationContext.registerShutdownHook();

        setBoneManagementUserCase(applicationContext.getBean(BoneManagementUserCase.class));
        setMuscleManagementUserCase(applicationContext.getBean(MuscleManagementUserCase.class));
        setJointManagementUserCase(applicationContext.getBean(JointManagementUserCase.class));

        start();

    }
}
