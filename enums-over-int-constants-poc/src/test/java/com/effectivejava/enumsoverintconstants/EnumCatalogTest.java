package com.effectivejava.enumsoverintconstants;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnumCatalogTest {

    @Test
    void describesAllAppleTypesByIteratingValues() {
        List<String> descriptions = EnumCatalog.describeAllApples();

        assertEquals(List.of("Fuji apple", "Pippin apple", "Granny Smith apple"), descriptions);
    }
}
