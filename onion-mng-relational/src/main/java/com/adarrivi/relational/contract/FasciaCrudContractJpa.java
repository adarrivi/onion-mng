package com.adarrivi.relational.contract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adarrivi.core.contract.CrudContract;
import com.adarrivi.core.entity.Fascia;
import com.adarrivi.relational.adapter.FasciaEntityAdapter;
import com.adarrivi.relational.contract.repository.FasciaJpaRepository;
import com.adarrivi.relational.entity.FasciaEntity;

@Repository
@Transactional(readOnly = true)
public class FasciaCrudContractJpa implements CrudContract<Fascia> {

    @Inject
    private FasciaJpaRepository fasciaJpaRepository;
    @Inject
    private FasciaEntityAdapter fasciaEntityAdapter;

    @Override
    @Transactional
    public void create(Fascia entity) {
        fasciaJpaRepository.saveAndFlush(fasciaEntityAdapter.convertFrom(entity));
    }

    @Override
    public Collection<Fascia> findAll() {
        List<Fascia> bones = new ArrayList<>();
        for (FasciaEntity fasciaEntity : fasciaJpaRepository.findAll()) {
            bones.add(fasciaEntityAdapter.convertTo(fasciaEntity));
        }
        return bones;
    }

}
