package com.adarrivi.norelational.adapter;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.entity.Fascia;
import com.adarrivi.norelational.entity.FasciaJson;

public class FasciaJsonAdapter implements EntityAdapter<Fascia, FasciaJson> {

    @Override
    public FasciaJson convertFrom(Fascia from) {
        return new FasciaJson(from.getName(), from.getRelativePosition());
    }

    @Override
    public Fascia convertTo(FasciaJson to) {
        return new Fascia(to.getName(), to.getRelativePosition());
    }

}
