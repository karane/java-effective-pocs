package com.effectivejava.documentthrownexceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Books seats against a fixed pool of shows, each starting with a configured seat count.
 */
public final class TicketBookingService {

    private final Map<String, Integer> availableSeatsByShow = new HashMap<>();

    /**
     * Registers a show with the given number of available seats.
     *
     * @param showId unique identifier for the show; must not be {@code null}
     * @param seatCount total number of seats available for the show
     * @throws NullPointerException if {@code showId} is {@code null}
     * @throws IllegalArgumentException if {@code seatCount} is negative
     */
    public void registerShow(String showId, int seatCount) {
        Objects.requireNonNull(showId, "showId must not be null");
        if (seatCount < 0) {
            throw new IllegalArgumentException("seatCount must be >= 0: " + seatCount);
        }
        availableSeatsByShow.put(showId, seatCount);
    }

    /**
     * Books the requested number of seats for the given show.
     *
     * <p>This is a recoverable business condition: callers that receive a
     * {@link SoldOutException} can inspect {@link SoldOutException#availableSeats()}
     * and retry with a smaller request.
     *
     * @param showId identifier of a previously registered show
     * @param seatCount number of seats to book; must be positive
     * @throws NullPointerException if {@code showId} is {@code null}
     * @throws IllegalArgumentException if {@code seatCount} is not positive
     * @throws IllegalStateException if {@code showId} was never registered
     * @throws SoldOutException if fewer than {@code seatCount} seats remain for the show
     */
    public void book(String showId, int seatCount) throws SoldOutException {
        Objects.requireNonNull(showId, "showId must not be null");
        if (seatCount <= 0) {
            throw new IllegalArgumentException("seatCount must be > 0: " + seatCount);
        }
        Integer available = availableSeatsByShow.get(showId);
        if (available == null) {
            throw new IllegalStateException("Unknown show: " + showId);
        }
        if (seatCount > available) {
            throw new SoldOutException(seatCount, available);
        }
        availableSeatsByShow.put(showId, available - seatCount);
    }

    /**
     * Returns the number of seats still available for the given show.
     *
     * @param showId identifier of a previously registered show
     * @return remaining seat count
     * @throws NullPointerException if {@code showId} is {@code null}
     * @throws IllegalStateException if {@code showId} was never registered
     */
    public int availableSeats(String showId) {
        Objects.requireNonNull(showId, "showId must not be null");
        Integer available = availableSeatsByShow.get(showId);
        if (available == null) {
            throw new IllegalStateException("Unknown show: " + showId);
        }
        return available;
    }
}
