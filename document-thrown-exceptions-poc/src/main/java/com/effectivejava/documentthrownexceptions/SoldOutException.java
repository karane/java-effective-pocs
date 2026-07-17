package com.effectivejava.documentthrownexceptions;

/**
 * Thrown when a show does not have enough remaining seats to satisfy a booking request.
 */
public class SoldOutException extends Exception {

    private final int requestedSeats;
    private final int availableSeats;

    public SoldOutException(int requestedSeats, int availableSeats) {
        super("Requested %d seats but only %d are available".formatted(requestedSeats, availableSeats));
        this.requestedSeats = requestedSeats;
        this.availableSeats = availableSeats;
    }

    public int requestedSeats() {
        return requestedSeats;
    }

    public int availableSeats() {
        return availableSeats;
    }
}
