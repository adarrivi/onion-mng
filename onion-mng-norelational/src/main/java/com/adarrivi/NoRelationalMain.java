package com.adarrivi;

import com.adarrivi.core.CreateSomeElementsApplication;
import com.adarrivi.core.service.management.BoneManagementService;
import com.adarrivi.core.service.management.JointManagementService;
import com.adarrivi.core.service.management.MuscleManagementService;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class NoRelationalMain extends CreateSomeElementsApplication {

    public static void main(String[] args) {
        new NoRelationalMain().run();
    }

    private void run() {
        Injector injector = Guice.createInjector(new ConfigurationModule());
        setBoneManagementService(injector.getInstance(BoneManagementService.class));
        setMuscleManagementService(injector.getInstance(MuscleManagementService.class));
        setJointManagementService(injector.getInstance(JointManagementService.class));
    }

}
