package com.adarrivi.relational.contract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adarrivi.core.contract.JointCrudContract;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.relational.adapter.JointEntityAdapter;
import com.adarrivi.relational.contract.repository.JointJpaRepository;
import com.adarrivi.relational.entity.JointEntity;

@Repository
@Transactional(readOnly = true)
public class JointCrudContractJpa implements JointCrudContract {

    @Inject
    private JointJpaRepository jointJpaRepository;
    @Inject
    private JointEntityAdapter jointEntityAdapter;

    @Override
    @Transactional
    public void create(Joint entity) {
        jointJpaRepository.saveAndFlush(jointEntityAdapter.convertFrom(entity));
    }

    @Override
    public Collection<Joint> findAll() {
        List<Joint> bones = new ArrayList<>();
        for (JointEntity jointEntity : jointJpaRepository.findAll()) {
            bones.add(jointEntityAdapter.convertTo(jointEntity));
        }
        return bones;
    }

}
