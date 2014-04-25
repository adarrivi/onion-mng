package com.adarrivi.core.adapter;

public interface EntityAdapter<F, T> {

    T convertFrom(F from);

    F convertTo(T to);
}
