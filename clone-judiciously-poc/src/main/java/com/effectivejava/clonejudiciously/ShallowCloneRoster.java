package com.effectivejava.clonejudiciously;

public final class ShallowCloneRoster implements Cloneable {

    private Player[] players;

    public ShallowCloneRoster(Player[] players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    @Override
    public ShallowCloneRoster clone() {
        try {
            return (ShallowCloneRoster) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
