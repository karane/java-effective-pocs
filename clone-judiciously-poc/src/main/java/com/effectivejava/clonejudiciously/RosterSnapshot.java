package com.effectivejava.clonejudiciously;

import java.util.Arrays;

// copyOf alternative to clone
public final class RosterSnapshot {

    private final Player[] players;

    public RosterSnapshot(Player[] players) {
        this.players = Arrays.stream(players)
                .map(Player::new)
                .toArray(Player[]::new);
    }

    public static RosterSnapshot copyOf(RosterSnapshot source) {
        return new RosterSnapshot(source.players);
    }

    public Player[] getPlayers() {
        return players;
    }
}
