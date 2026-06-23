package com.effectivejava.clonejudiciously;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class DeepCloneRosterTest {

    @Test
    void cloneHasIndependentArrayElements() {
        Player alice = new Player("Alice", 10);
        DeepCloneRoster original = new DeepCloneRoster(new Player[] { alice });

        DeepCloneRoster clone = original.clone();

        assertNotSame(original.getPlayers()[0], clone.getPlayers()[0]);
    }

    @Test
    void mutatingThroughCloneDoesNotAffectOriginal() {
        Player alice = new Player("Alice", 10);
        DeepCloneRoster original = new DeepCloneRoster(new Player[] { alice });
        DeepCloneRoster clone = original.clone();

        clone.getPlayers()[0].setScore(99);

        assertEquals(10, original.getPlayers()[0].getScore());
        assertEquals(99, clone.getPlayers()[0].getScore());
    }
}
