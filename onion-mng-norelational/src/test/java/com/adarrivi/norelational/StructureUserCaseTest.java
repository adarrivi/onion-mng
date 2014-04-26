package com.adarrivi.norelational;

import org.junit.Test;

import com.adarrivi.ConfigurationModule;
import com.adarrivi.core.usercase.StructureUserCase;
import com.adarrivi.test.ShoulderCreationVerifier;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class StructureUserCaseTest {

    @Test
    public void verifyShoulderCreation() {
        Injector injector = Guice.createInjector(new ConfigurationModule());
        StructureUserCase structureUserCase = injector.getInstance(StructureUserCase.class);
        ShoulderCreationVerifier verifier = new ShoulderCreationVerifier(structureUserCase);
        verifier.verify();
    }

}
