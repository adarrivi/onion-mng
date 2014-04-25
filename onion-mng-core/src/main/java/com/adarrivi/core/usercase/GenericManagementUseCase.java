package com.adarrivi.core.usercase;

import java.util.Collection;

import com.adarrivi.core.contract.CrudContract;

abstract class GenericManagementUseCase<K> {

    private CrudContract<K> crudContract;

    protected GenericManagementUseCase(CrudContract<K> crudContract) {
        this.crudContract = crudContract;
    }

    public void create(K entity) {
        // more logic could be added here, like check it it already exists
        crudContract.create(entity);
    }

    public Collection<K> findAll() {
        // and also here, like filtering...
        return crudContract.findAll();
    }

}
