package com.adarrivi;

import com.adarrivi.core.CreateSomeElementsApplication;
import com.adarrivi.relational.RelationalConfiguration;

public class RelationalMain extends CreateSomeElementsApplication {

    public static void main(String[] args) {
        new RelationalMain().start();
    }

    @Override
    protected Class<?> getConfigurationClass() {
        return RelationalConfiguration.class;
    }
}
