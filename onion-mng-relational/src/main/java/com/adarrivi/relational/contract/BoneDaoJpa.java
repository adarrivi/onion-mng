package com.adarrivi.relational.contract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.contract.CrudContractName;
import com.adarrivi.core.entity.Bone;
import com.adarrivi.relational.adapter.BoneEntityAdapter;
import com.adarrivi.relational.contract.repository.BoneJpaRepository;
import com.adarrivi.relational.entity.BoneEntity;

@Repository(CrudContractName.BONE_CRUD)
@Transactional(readOnly = true)
public class BoneDaoJpa implements CrudContract<Bone> {

    @Autowired
    private BoneJpaRepository boneJpaRepository;
    @Autowired
    private BoneEntityAdapter boneEntityAdapter;

    @Override
    @Transactional
    public void create(Bone entity) {
        boneJpaRepository.saveAndFlush(boneEntityAdapter.convertFrom(entity));
    }

    @Override
    public Collection<Bone> findAll() {
        List<Bone> bones = new ArrayList<>();
        for (BoneEntity boneEntity : boneJpaRepository.findAll()) {
            bones.add(boneEntityAdapter.convertTo(boneEntity));
        }
        return bones;
    }

}