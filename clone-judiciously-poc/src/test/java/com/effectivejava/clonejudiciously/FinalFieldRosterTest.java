package com.effectivejava.clonejudiciously;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinalFieldRosterTest {

    @Test
    void finalArrayFieldForcesSharedStateAcrossClones() {
        Player alice = new Player("Alice", 10);
        FinalFieldRoster original = new FinalFieldRoster(new Player[] { alice });

        FinalFieldRoster clone = original.clone();
        clone.getPlayers()[0].setScore(99);

        assertEquals(99, original.getPlayers()[0].getScore(),
                "the players field is final, so clone() cannot replace it with a "
                        + "deep copy and must live with the shared Player reference");
    }
}
