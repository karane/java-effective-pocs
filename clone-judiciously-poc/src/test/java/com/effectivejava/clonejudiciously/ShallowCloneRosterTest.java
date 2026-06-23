package com.effectivejava.clonejudiciously;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

class ShallowCloneRosterTest {

    @Test
    void cloneSharesTheSameArrayElements() {
        Player alice = new Player("Alice", 10);
        ShallowCloneRoster original = new ShallowCloneRoster(new Player[] { alice });

        ShallowCloneRoster clone = original.clone();

        assertNotSame(original, clone);
        assertSame(original.getPlayers()[0], clone.getPlayers()[0]);
    }

    @Test
    void mutatingThroughCloneLeaksIntoOriginal() {
        Player alice = new Player("Alice", 10);
        ShallowCloneRoster original = new ShallowCloneRoster(new Player[] { alice });
        ShallowCloneRoster clone = original.clone();

        clone.getPlayers()[0].setScore(99);

        assertEquals(99, original.getPlayers()[0].getScore(),
                "shallow clone shares Player references, so mutation bleeds into the original");
    }
}
