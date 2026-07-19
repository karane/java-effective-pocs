package com.effectivejava.rawtypes;

import java.util.ArrayList;
import java.util.List;

public final class LegacyProductStore {

    @SuppressWarnings("rawtypes")
    private final List products = new ArrayList();

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void add(Object product) {
        products.add(product);
    }

    @SuppressWarnings("rawtypes")
    public List getAll() {
        return products;
    }

    public int size() {
        return products.size();
    }
}
