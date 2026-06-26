package com.effectivejava.enummapordinalindexing;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EnumMapHerbGardenTest {

    private static final Herb BASIL = new Herb("Basil", Herb.Type.ANNUAL);
    private static final Herb PARSLEY = new Herb("Parsley", Herb.Type.BIENNIAL);
    private static final Herb MINT = new Herb("Mint", Herb.Type.PERENNIAL);

    @Test
    void groupsHerbsByTypeWithTheTypeAsTheMapKey() {
        Map<Herb.Type, Set<Herb>> herbsByType = EnumMapHerbGarden.groupByType(List.of(BASIL, PARSLEY, MINT));

        assertEquals(Set.of(BASIL), herbsByType.get(Herb.Type.ANNUAL));
        assertEquals(Set.of(MINT), herbsByType.get(Herb.Type.PERENNIAL));
        assertEquals(Set.of(PARSLEY), herbsByType.get(Herb.Type.BIENNIAL));
    }

    @Test
    void includesEveryTypeEvenWithNoMatchingHerbs() {
        Map<Herb.Type, Set<Herb>> herbsByType = EnumMapHerbGarden.groupByType(List.of(BASIL));

        assertTrue(herbsByType.containsKey(Herb.Type.PERENNIAL));
        assertTrue(herbsByType.get(Herb.Type.PERENNIAL).isEmpty());
    }

    @Test
    void iterationOrderFollowsTheEnumsDeclarationOrderRegardlessOfInsertionOrder() {
        Map<Herb.Type, Set<Herb>> herbsByType = EnumMapHerbGarden.groupByType(List.of(PARSLEY, BASIL, MINT));

        assertEquals(List.of(Herb.Type.ANNUAL, Herb.Type.PERENNIAL, Herb.Type.BIENNIAL),
                List.copyOf(herbsByType.keySet()));
    }
}
