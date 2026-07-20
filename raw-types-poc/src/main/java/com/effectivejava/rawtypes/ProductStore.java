package com.effectivejava.rawtypes;

import java.util.ArrayList;
import java.util.List;

public final class ProductStore<T> {

    private final List<T> products = new ArrayList<>();

    public void add(T product) {
        products.add(product);
    }

    public T get(int index) {
        return products.get(index);
    }

    public List<T> getAll() {
        return List.copyOf(products);
    }

    public int size() {
        return products.size();
    }
}
