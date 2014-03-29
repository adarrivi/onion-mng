package com.adarrivi;

import com.adarrivi.core.GenericStructureApplication;
import com.adarrivi.external.inmemory.InMemoryConfiguration;

public class MainBonesInMemory extends GenericStructureApplication {

    public static void main(String[] args) {
        new MainBonesInMemory().start();
    }

    @Override
    protected Class<?> getConfigurationClass() {
        return InMemoryConfiguration.class;
    }
}
