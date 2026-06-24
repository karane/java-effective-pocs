package com.effectivejava.clonejudiciously;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class RosterSnapshotTest {

    @Test
    void copyFactoryProducesIndependentSnapshot() {
        Player alice = new Player("Alice", 10);
        RosterSnapshot original = new RosterSnapshot(new Player[] { alice });

        RosterSnapshot copy = RosterSnapshot.copyOf(original);
        copy.getPlayers()[0].setScore(99);

        assertNotSame(original.getPlayers()[0], copy.getPlayers()[0]);
        assertEquals(10, original.getPlayers()[0].getScore());
        assertEquals(99, copy.getPlayers()[0].getScore());
    }

    @Test
    void constructorDefensivelyCopiesInputArray() {
        Player alice = new Player("Alice", 10);
        Player[] source = new Player[] { alice };
        RosterSnapshot snapshot = new RosterSnapshot(source);

        source[0].setScore(50);

        assertEquals(10, snapshot.getPlayers()[0].getScore(),
                "constructor copies each Player, so later mutation of the source array's elements is invisible");
    }
}
