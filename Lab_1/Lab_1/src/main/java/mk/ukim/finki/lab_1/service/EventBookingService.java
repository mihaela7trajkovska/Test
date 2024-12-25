package mk.ukim.finki.lab_1.service;
import mk.ukim.finki.lab_1.model.Event;
import mk.ukim.finki.lab_1.model.EventBooking;

public interface EventBookingService {
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);

    EventBooking bookEvent(Event event, String attendeeName, int numTickets);
}
