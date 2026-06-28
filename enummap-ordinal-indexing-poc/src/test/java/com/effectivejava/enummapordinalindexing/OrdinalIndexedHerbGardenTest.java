package com.effectivejava.enummapordinalindexing;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrdinalIndexedHerbGardenTest {

    private static final Herb BASIL = new Herb("Basil", Herb.Type.ANNUAL);
    private static final Herb PARSLEY = new Herb("Parsley", Herb.Type.BIENNIAL);
    private static final Herb MINT = new Herb("Mint", Herb.Type.PERENNIAL);

    @Test
    void groupsHerbsIntoTheArraySlotMatchingTheirOrdinal() {
        Set<Herb>[] herbsByType = OrdinalIndexedHerbGarden.groupByType(List.of(BASIL, PARSLEY, MINT));

        assertEquals(Set.of(BASIL), herbsByType[Herb.Type.ANNUAL.ordinal()]);
        assertEquals(Set.of(MINT), herbsByType[Herb.Type.PERENNIAL.ordinal()]);
        assertEquals(Set.of(PARSLEY), herbsByType[Herb.Type.BIENNIAL.ordinal()]);
    }

    @Test
    void theArrayCarriesNoLabelOfWhichTypeEachSlotRepresents() {
        Set<Herb>[] herbsByType = OrdinalIndexedHerbGarden.groupByType(List.of(BASIL));

        assertTrue(herbsByType[0].contains(BASIL));
        // The only way to know slot 0 means ANNUAL is to read Herb.Type's declaration
        // order; the array itself carries no such label.
    }
}
