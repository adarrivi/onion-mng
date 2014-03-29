package com.adarrivi.external.inmemory.adapter;

import java.util.AbstractMap;
import java.util.Map.Entry;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.entity.Named;

public abstract class GenericNamedToEntryMapAdapter<F extends Named> implements EntityAdapter<F, Entry<String, F>> {

    @Override
    public Entry<String, F> convertFrom(F from) {
        return new AbstractMap.SimpleEntry<String, F>(from.getName(), from);
    }

    @Override
    public F convertTo(Entry<String, F> to) {
        return to.getValue();
    }

}
