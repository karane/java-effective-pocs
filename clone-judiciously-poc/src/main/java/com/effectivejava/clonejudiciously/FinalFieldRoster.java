package com.effectivejava.clonejudiciously;

// final field that points to a mutable object case
public final class FinalFieldRoster implements Cloneable {

    private final Player[] players;

    public FinalFieldRoster(Player[] players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    @Override
    public FinalFieldRoster clone() {
        try {
            // result.players = Arrays.stream(players).map(Player::clone).toArray(Player[]::new);
            // ^ does not compile: cannot assign a value to final variable players
            return (FinalFieldRoster) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
