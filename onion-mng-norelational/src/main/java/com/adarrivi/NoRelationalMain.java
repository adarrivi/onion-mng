package com.adarrivi;

import com.adarrivi.core.CreateSomeElementsApplication;
import com.adarrivi.core.usercase.BoneManagementUserCase;
import com.adarrivi.core.usercase.JointManagementUserCase;
import com.adarrivi.core.usercase.MuscleManagementUserCase;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class NoRelationalMain extends CreateSomeElementsApplication {

    public static void main(String[] args) {
        new NoRelationalMain().run();

    }

    private void run() {
        Injector injector = Guice.createInjector(new ConfigurationModule());
        setBoneManagementUserCase(injector.getInstance(BoneManagementUserCase.class));
        setMuscleManagementUserCase(injector.getInstance(MuscleManagementUserCase.class));
        setJointManagementUserCase(injector.getInstance(JointManagementUserCase.class));
        start();
    }

}
