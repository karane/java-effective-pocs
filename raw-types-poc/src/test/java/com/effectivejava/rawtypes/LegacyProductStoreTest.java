package com.effectivejava.rawtypes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LegacyProductStoreTest {

    @Test
    void addsItemsWithoutTypeCheck() {
        LegacyProductStore store = new LegacyProductStore();
        store.add("Widget");
        store.add(42);
        assertEquals(2, store.size());
    }

    @Test
    @SuppressWarnings({"rawtypes", "unchecked"})
    void rawListAllowsMixedTypesLeadingToClassCastException() {
        LegacyProductStore store = new LegacyProductStore();
        store.add("Gadget");
        store.add(100);

        List raw = store.getAll();
        String first = (String) raw.get(0);
        assertEquals("Gadget", first);

        assertThrows(ClassCastException.class, () -> {
            String wrongCast = (String) raw.get(1);
        });
    }

    @Test
    void sizeReflectsAllAddedItems() {
        LegacyProductStore store = new LegacyProductStore();
        store.add("A");
        store.add("B");
        store.add("C");
        assertEquals(3, store.size());
    }
}
