package com.adarrivi.core.contract;

import java.util.Collection;

public interface CrudContract<K> {

    void create(K entity);

    Collection<K> findAll();

}
