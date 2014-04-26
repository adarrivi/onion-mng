package com.adarrivi.relational;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adarrivi.core.usercase.StructureUserCase;
import com.adarrivi.test.ShoulderCreationVerifier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RelationalConfiguration.class })
public class StructureUserCaseTest {

    @Inject
    private StructureUserCase structureUserCase;

    @Test
    public void verifyShoulderCreation() {
        ShoulderCreationVerifier verifier = new ShoulderCreationVerifier(structureUserCase);
        verifier.verify();
    }

}
