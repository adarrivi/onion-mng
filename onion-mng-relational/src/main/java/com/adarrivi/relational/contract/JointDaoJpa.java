package com.adarrivi.relational.contract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.entity.Joint;
import com.adarrivi.relational.adapter.JointEntityAdapter;
import com.adarrivi.relational.contract.repository.JointJpaRepository;
import com.adarrivi.relational.entity.JointEntity;

@Repository
@Transactional(readOnly = true)
public class JointDaoJpa implements CrudContract<Joint> {

    @Autowired
    private JointJpaRepository jointJpaRepository;
    @Autowired
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
