package com.adarrivi;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.contract.BoneCrudContract;
import com.adarrivi.core.contract.FasciaCrudContract;
import com.adarrivi.core.contract.JointCrudContract;
import com.adarrivi.core.contract.MuscleCrudContract;
import com.adarrivi.core.entity.Bone;
import com.adarrivi.core.entity.Fascia;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.core.entity.Muscle;
import com.adarrivi.norelational.adapter.BoneJsonAdapter;
import com.adarrivi.norelational.adapter.FasciaJsonAdapter;
import com.adarrivi.norelational.adapter.JointJsonAdapter;
import com.adarrivi.norelational.adapter.JsonParserComponent;
import com.adarrivi.norelational.adapter.MuscleJsonAdapter;
import com.adarrivi.norelational.adapter.ObjectMapperProvider;
import com.adarrivi.norelational.contract.BoneCrudContractInMemory;
import com.adarrivi.norelational.contract.FasciaCrudContractInMemory;
import com.adarrivi.norelational.contract.InMemoryMap;
import com.adarrivi.norelational.contract.JointCrudContractInMemory;
import com.adarrivi.norelational.contract.MuscleCrudContractInMemory;
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
        bind(BoneCrudContract.class).to(BoneCrudContractInMemory.class);
        bind(FasciaCrudContract.class).to(FasciaCrudContractInMemory.class);
        bind(JointCrudContract.class).to(JointCrudContractInMemory.class);
        bind(MuscleCrudContract.class).to(MuscleCrudContractInMemory.class);
    }

}
