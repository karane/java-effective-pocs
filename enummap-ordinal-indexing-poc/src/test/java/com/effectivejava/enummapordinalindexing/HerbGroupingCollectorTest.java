package com.effectivejava.enummapordinalindexing;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class HerbGroupingCollectorTest {

    private static final Herb BASIL = new Herb("Basil", Herb.Type.ANNUAL);
    private static final Herb OREGANO = new Herb("Oregano", Herb.Type.PERENNIAL);

    @Test
    void groupsHerbsByTypeUsingAnEnumMapBackedCollector() {
        Map<Herb.Type, Set<Herb>> herbsByType = HerbGroupingCollector.groupByType(List.of(BASIL, OREGANO));

        assertEquals(Set.of(BASIL), herbsByType.get(Herb.Type.ANNUAL));
        assertEquals(Set.of(OREGANO), herbsByType.get(Herb.Type.PERENNIAL));
    }

    @Test
    void omitsTypesWithNoMatchingHerbsUnlikeThePreFilledEnumMap() {
        Map<Herb.Type, Set<Herb>> herbsByType = HerbGroupingCollector.groupByType(List.of(BASIL));

        assertFalse(herbsByType.containsKey(Herb.Type.BIENNIAL));
    }
}
