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
import com.adarrivi.core.service.management.BoneManagementService;
import com.adarrivi.core.service.management.FasciaManagementService;
import com.adarrivi.core.service.management.JointManagementService;
import com.adarrivi.core.service.management.MuscleManagementService;

@Configuration
@ComponentScan("com.adarrivi")
@Import(DaoRelationalConfiguration.class)
public class RelationalConfiguration {

    @Bean
    public BoneManagementService boneManagementService(CrudContract<Bone> boneDaoJpa) {
        BoneManagementService boneManagementService = new BoneManagementService(boneDaoJpa);
        return boneManagementService;
    }

    @Bean
    public FasciaManagementService fasciaManagementService(CrudContract<Fascia> fasciaDaoJpa) {
        return new FasciaManagementService(fasciaDaoJpa);
    }

    @Bean
    public JointManagementService jointManagementService(CrudContract<Joint> jointDaoJpa) {
        return new JointManagementService(jointDaoJpa);
    }

    @Bean
    public MuscleManagementService muscleManagementService(CrudContract<Muscle> muscleDaoJpa) {
        return new MuscleManagementService(muscleDaoJpa);
    }
}
