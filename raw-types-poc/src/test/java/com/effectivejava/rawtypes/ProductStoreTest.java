package com.effectivejava.rawtypes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductStoreTest {

    @Test
    void addAndGetSingleProduct() {
        ProductStore<String> store = new ProductStore<>();
        store.add("Laptop");
        assertEquals("Laptop", store.get(0));
    }

    @Test
    void sizeTracksAddedProducts() {
        ProductStore<Integer> store = new ProductStore<>();
        store.add(10);
        store.add(20);
        assertEquals(2, store.size());
    }

    @Test
    void getAllReturnsUnmodifiableCopy() {
        ProductStore<String> store = new ProductStore<>();
        store.add("Phone");
        store.add("Tablet");
        List<String> all = store.getAll();
        assertEquals(List.of("Phone", "Tablet"), all);
        assertThrows(UnsupportedOperationException.class, () -> all.add("Camera"));
    }

    @Test
    void parameterizedStoreEnforcesTypeSafety() {
        ProductStore<String> stringStore = new ProductStore<>();
        stringStore.add("Keyboard");
        String product = stringStore.get(0);
        assertEquals("Keyboard", product);
    }

    @Test
    void integerStoreWorksIndependentlyFromStringStore() {
        ProductStore<Integer> intStore = new ProductStore<>();
        intStore.add(999);
        assertEquals(999, intStore.get(0));
    }
}
