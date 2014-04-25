package com.adarrivi.relational;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.entity.Bone;
import com.adarrivi.core.entity.Fascia;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.core.entity.Muscle;
import com.adarrivi.core.usercase.BoneManagementUserCase;
import com.adarrivi.core.usercase.FasciaManagementUserCase;
import com.adarrivi.core.usercase.JointManagementUserCase;
import com.adarrivi.core.usercase.MuscleManagementUserCase;

@Configuration
@ComponentScan("com.adarrivi")
@Import(DaoRelationalConfiguration.class)
public class RelationalConfiguration {

    @Bean
    public BoneManagementUserCase boneManagementUserCase(CrudContract<Bone> boneCrudContractJpa) {
        return new BoneManagementUserCase(boneCrudContractJpa);
    }

    @Bean
    public FasciaManagementUserCase fasciaManagementUserCase(CrudContract<Fascia> fasciaCrudContractJpa) {
        return new FasciaManagementUserCase(fasciaCrudContractJpa);
    }

    @Bean
    public JointManagementUserCase jointManagementUserCase(CrudContract<Joint> jointCrudContractJpa) {
        return new JointManagementUserCase(jointCrudContractJpa);
    }

    @Bean
    public MuscleManagementUserCase muscleManagementUserCase(CrudContract<Muscle> muscleCrudContractJpa) {
        return new MuscleManagementUserCase(muscleCrudContractJpa);
    }
}
