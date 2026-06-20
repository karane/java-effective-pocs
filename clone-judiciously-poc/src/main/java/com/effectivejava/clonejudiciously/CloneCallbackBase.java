package com.effectivejava.clonejudiciously;

import java.util.Arrays;

public class CloneCallbackBase implements Cloneable {

    protected Player[] players;

    public CloneCallbackBase(Player[] players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    @Override
    public CloneCallbackBase clone() {
        try {
            CloneCallbackBase result = (CloneCallbackBase) super.clone();
            result.players = Arrays.stream(players)
                    .map(Player::clone)
                    .toArray(Player[]::new);
            result.onCloned(); // overridable method
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    protected void onCloned() {
        // no-op hook for subclasses
    }
}
