package com.effectivejava.enumsoverintconstants;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntConstantCatalogTest {

    @Test
    void describesAllAppleTypesUpToTheHardcodedCount() {
        List<String> descriptions = IntConstantCatalog.describeAllApples();

        assertEquals(List.of("Fuji apple", "Pippin apple", "Granny Smith apple"), descriptions);
    }

    @Test
    void addingAnAppleConstantWithoutUpdatingTheCountSilentlyDropsIt() {
        assertEquals(3, IntConstantCatalog.NUMBER_OF_APPLE_TYPES);
        assertEquals(3, IntConstantCatalog.describeAllApples().size());
    }
}
