package com.adarrivi.relational;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.adarrivi.core.contract.BoneCrudContract;
import com.adarrivi.core.contract.FasciaCrudContract;
import com.adarrivi.core.contract.JointCrudContract;
import com.adarrivi.core.contract.MuscleCrudContract;
import com.adarrivi.core.usercase.BoneManagementUserCase;
import com.adarrivi.core.usercase.FasciaManagementUserCase;
import com.adarrivi.core.usercase.JointManagementUserCase;
import com.adarrivi.core.usercase.MuscleManagementUserCase;
import com.adarrivi.core.usercase.StructureUserCase;

@Configuration
@ComponentScan("com.adarrivi")
@Import(DaoRelationalConfiguration.class)
public class RelationalConfiguration {

    @Bean
    public BoneManagementUserCase boneManagementUserCase(BoneCrudContract boneCrudContractJpa) {
        return new BoneManagementUserCase(boneCrudContractJpa);
    }

    @Bean
    public FasciaManagementUserCase fasciaManagementUserCase(FasciaCrudContract fasciaCrudContractJpa) {
        return new FasciaManagementUserCase(fasciaCrudContractJpa);
    }

    @Bean
    public JointManagementUserCase jointManagementUserCase(JointCrudContract jointCrudContractJpa) {
        return new JointManagementUserCase(jointCrudContractJpa);
    }

    @Bean
    public MuscleManagementUserCase muscleManagementUserCase(MuscleCrudContract muscleCrudContractJpa) {
        return new MuscleManagementUserCase(muscleCrudContractJpa);
    }

    @Bean
    public StructureUserCase structureUserCase() {
        return new StructureUserCase();
    }
}
