package com.adarrivi.norelational.contract;

import com.adarrivi.core.entity.Fascia;
import com.adarrivi.norelational.adapter.FasciaJsonAdapter;
import com.adarrivi.norelational.entity.FasciaJson;

public class FasciaDaoInMemory extends GenericInMemoryDao<Fascia, FasciaJson> {

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
