package com.effectivejava.documentthrownexceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketBookingServiceTest {

    @Test
    void registerShowRejectsNullId() {
        TicketBookingService service = new TicketBookingService();

        assertThrows(NullPointerException.class, () -> service.registerShow(null, 10));
    }

    @Test
    void registerShowRejectsNegativeSeatCount() {
        TicketBookingService service = new TicketBookingService();

        assertThrows(IllegalArgumentException.class, () -> service.registerShow("show-1", -1));
    }

    @Test
    void bookReducesAvailableSeats() throws SoldOutException {
        TicketBookingService service = new TicketBookingService();
        service.registerShow("show-1", 10);

        service.book("show-1", 4);

        assertEquals(6, service.availableSeats("show-1"));
    }

    @Test
    void bookRejectsNullShowId() {
        TicketBookingService service = new TicketBookingService();

        assertThrows(NullPointerException.class, () -> service.book(null, 1));
    }

    @Test
    void bookRejectsNonPositiveSeatCount() {
        TicketBookingService service = new TicketBookingService();
        service.registerShow("show-1", 10);

        assertThrows(IllegalArgumentException.class, () -> service.book("show-1", 0));
    }

    @Test
    void bookRejectsUnknownShowWithIllegalStateException() {
        TicketBookingService service = new TicketBookingService();

        assertThrows(IllegalStateException.class, () -> service.book("unknown", 1));
    }

    @Test
    void bookThrowsSoldOutExceptionCarryingRequestedAndAvailableSeats() {
        TicketBookingService service = new TicketBookingService();
        service.registerShow("show-1", 3);

        SoldOutException thrown = assertThrows(SoldOutException.class, () -> service.book("show-1", 5));

        assertEquals(5, thrown.requestedSeats());
        assertEquals(3, thrown.availableSeats());
    }

    @Test
    void callerCanRecoverFromSoldOutByRetryingWithAvailableSeats() throws SoldOutException {
        TicketBookingService service = new TicketBookingService();
        service.registerShow("show-1", 3);

        try {
            service.book("show-1", 5);
        } catch (SoldOutException e) {
            service.book("show-1", e.availableSeats());
        }

        assertEquals(0, service.availableSeats("show-1"));
    }

    @Test
    void availableSeatsRejectsUnknownShow() {
        TicketBookingService service = new TicketBookingService();

        assertThrows(IllegalStateException.class, () -> service.availableSeats("unknown"));
    }
}
