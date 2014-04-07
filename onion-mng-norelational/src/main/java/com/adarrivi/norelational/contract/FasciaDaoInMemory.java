package com.adarrivi.norelational.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adarrivi.core.contract.CrudContractName;
import com.adarrivi.core.entity.Fascia;
import com.adarrivi.norelational.adapter.FasciaJsonAdapter;
import com.adarrivi.norelational.entity.FasciaJson;

@Repository(CrudContractName.FASCIA_CRUD)
public class FasciaDaoInMemory extends GenericInMemoryDao<Fascia, FasciaJson> {

    @Autowired
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

    @Override
    protected Class<FasciaJson> getEntityClass() {
        return FasciaJson.class;
    }

}
