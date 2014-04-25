package com.adarrivi;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.entity.Bone;
import com.adarrivi.core.entity.Fascia;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.core.entity.Muscle;
import com.adarrivi.core.service.management.BoneManagementService;
import com.adarrivi.core.service.management.FasciaManagementService;
import com.adarrivi.core.service.management.JointManagementService;
import com.adarrivi.core.service.management.MuscleManagementService;
import com.adarrivi.norelational.adapter.BoneJsonAdapter;
import com.adarrivi.norelational.adapter.FasciaJsonAdapter;
import com.adarrivi.norelational.adapter.JointJsonAdapter;
import com.adarrivi.norelational.adapter.JsonParserComponent;
import com.adarrivi.norelational.adapter.MuscleJsonAdapter;
import com.adarrivi.norelational.adapter.ObjectMapperProvider;
import com.adarrivi.norelational.contract.BoneDaoInMemory;
import com.adarrivi.norelational.contract.FasciaDaoInMemory;
import com.adarrivi.norelational.contract.InMemoryMap;
import com.adarrivi.norelational.contract.JointDaoInMemory;
import com.adarrivi.norelational.contract.MuscleDaoInMemory;
import com.adarrivi.norelational.entity.BoneJson;
import com.adarrivi.norelational.entity.FasciaJson;
import com.adarrivi.norelational.entity.JointJson;
import com.adarrivi.norelational.entity.MuscleJson;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class ConfigurationModule extends AbstractModule {

    @Override
    protected void configure() {
        bindUtils();
        bindAdapters();
        bindContracts();
        bindServices();
    }

    private void bindAdapters() {
        bind(new TypeLiteral<EntityAdapter<Bone, BoneJson>>() {
        }).to(BoneJsonAdapter.class);
        bind(new TypeLiteral<EntityAdapter<Fascia, FasciaJson>>() {
        }).to(FasciaJsonAdapter.class);
        bind(new TypeLiteral<EntityAdapter<Muscle, MuscleJson>>() {
        }).to(MuscleJsonAdapter.class);
        bind(new TypeLiteral<EntityAdapter<Joint, JointJson>>() {
        }).to(JointJsonAdapter.class);
    }

    private void bindUtils() {
        bind(ObjectMapperProvider.class);
        bind(JsonParserComponent.class);
        bind(InMemoryMap.class);
    }

    private void bindContracts() {
        bind(new TypeLiteral<CrudContract<Bone>>() {
        }).to(BoneDaoInMemory.class);
        bind(new TypeLiteral<CrudContract<Fascia>>() {
        }).to(FasciaDaoInMemory.class);
        bind(new TypeLiteral<CrudContract<Joint>>() {
        }).to(JointDaoInMemory.class);
        bind(new TypeLiteral<CrudContract<Muscle>>() {
        }).to(MuscleDaoInMemory.class);
    }

    private void bindServices() {
        bind(BoneManagementService.class);
        bind(FasciaManagementService.class);
        bind(JointManagementService.class);
        bind(MuscleManagementService.class);
    }

}
