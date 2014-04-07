package com.adarrivi.core.service.management;

import java.util.Collection;

import com.adarrivi.core.contract.CrudContract;

abstract class GenericManagementService<K> {

    private CrudContract<K> crudContract;

    protected GenericManagementService(CrudContract<K> crudContract) {
        this.crudContract = crudContract;
    }

    public void create(K entity) {
        crudContract.create(entity);
    }

    public Collection<K> findAll() {
        return crudContract.findAll();
    }

}
