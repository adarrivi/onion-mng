package com.adarrivi.core.dao;

import java.util.Collection;

public interface CrudDao<K> {

    void create(K entity);

    Collection<K> findAll();

}
