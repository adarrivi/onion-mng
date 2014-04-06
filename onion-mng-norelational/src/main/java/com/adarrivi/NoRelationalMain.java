package com.adarrivi;

import com.adarrivi.core.CreateSomeElementsApplication;
import com.adarrivi.norelational.NoRelationalConfiguration;

public class NoRelationalMain extends CreateSomeElementsApplication {

    public static void main(String[] args) {
        new NoRelationalMain().start();
    }

    @Override
    protected Class<?> getConfigurationClass() {
        return NoRelationalConfiguration.class;
    }
}
