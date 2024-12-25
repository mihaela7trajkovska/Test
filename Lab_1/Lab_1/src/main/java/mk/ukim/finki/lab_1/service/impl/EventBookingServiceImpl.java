package mk.ukim.finki.lab_1.service.impl;


import mk.ukim.finki.lab_1.model.Event;
import mk.ukim.finki.lab_1.model.EventBooking;
import mk.ukim.finki.lab_1.service.EventBookingService;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numTickets) {
        return new EventBooking(eventName, attendeeName, attendeeAddress, (long) numTickets);
    }

    @Override
    public EventBooking bookEvent(Event event, String attendeeName, int numTickets) {

        EventBooking booking = new EventBooking(event.getName(), attendeeName, "", (long) numTickets);
        event.addBooking(booking);
        return booking;
    }
}
