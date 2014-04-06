package com.adarrivi.relational.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adarrivi.core.dao.CrudDao;
import com.adarrivi.core.entity.Fascia;
import com.adarrivi.relational.adapter.FasciaEntityAdapter;
import com.adarrivi.relational.dao.repository.FasciaJpaRepository;
import com.adarrivi.relational.entity.FasciaEntity;

@Repository("fasciaDao")
@Transactional(readOnly = true)
public class FasciaDaoJpa implements CrudDao<Fascia> {

    @Autowired
    private FasciaJpaRepository fasciaJpaRepository;
    @Autowired
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
