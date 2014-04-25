package com.adarrivi.norelational.contract;

import javax.inject.Inject;

import com.adarrivi.core.entity.Fascia;
import com.adarrivi.norelational.adapter.FasciaJsonAdapter;
import com.adarrivi.norelational.entity.FasciaJson;

public class FasciaDaoInMemory extends GenericInMemoryDao<Fascia, FasciaJson> {
    @Inject
    FasciaDaoInMemory(FasciaJsonAdapter fasciaJsonAdapter) {
        super(fasciaJsonAdapter);
    }

    @Override
    protected String getEntityKey(Fascia entity) {
        return getKeyPrefix() + entity.getName();
    }

    @Override
    protected String getKeyPrefix() {
        return "fascia::";
    }

}
