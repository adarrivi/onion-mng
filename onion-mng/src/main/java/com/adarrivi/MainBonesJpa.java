package com.adarrivi;

import com.adarrivi.core.GenericStructureApplication;
import com.adarrivi.external.jpa.JpaConfiguration;

public class MainBonesJpa extends GenericStructureApplication {

    public static void main(String[] args) {
        new MainBonesJpa().start();
    }

    @Override
    protected Class<?> getConfigurationClass() {
        return JpaConfiguration.class;
    }
}
