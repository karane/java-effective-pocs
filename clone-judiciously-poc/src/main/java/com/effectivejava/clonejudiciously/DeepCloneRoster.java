package com.effectivejava.clonejudiciously;

import java.util.Arrays;

public final class DeepCloneRoster implements Cloneable {

    private Player[] players;

    public DeepCloneRoster(Player[] players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    @Override
    public DeepCloneRoster clone() {
        try {
            DeepCloneRoster result = (DeepCloneRoster) super.clone();
            result.players = Arrays.stream(players)
                    .map(Player::clone)
                    .toArray(Player[]::new);
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
