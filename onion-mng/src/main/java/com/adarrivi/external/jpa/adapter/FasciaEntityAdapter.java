package com.adarrivi.external.jpa.adapter;

import org.springframework.stereotype.Component;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.entity.Fascia;
import com.adarrivi.external.jpa.entity.FasciaEntity;

@Component("fasciaEntityAdapter")
public class FasciaEntityAdapter implements EntityAdapter<Fascia, FasciaEntity> {

    @Override
    public FasciaEntity convertFrom(Fascia from) {
        return new FasciaEntity(from.getName(), from.getRelativePosition());
    }

    @Override
    public Fascia convertTo(FasciaEntity to) {
        return new Fascia(to.getName(), to.getRelativePosition());
    }

}
