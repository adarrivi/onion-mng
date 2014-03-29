package com.adarrivi.core.service.management;

import java.util.Collection;

import com.adarrivi.core.dao.CrudDao;

abstract class GenericManagementService<K> {

    private CrudDao<K> crudDao;

    protected GenericManagementService(CrudDao<K> crudDao) {
        this.crudDao = crudDao;
    }

    public void create(K entity) {
        crudDao.create(entity);
    }

    public Collection<K> findAll() {
        return crudDao.findAll();
    }

}
