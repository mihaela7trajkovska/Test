package mk.ukim.finki.lab_1.web.controller;


import mk.ukim.finki.lab_1.model.Event;
import mk.ukim.finki.lab_1.model.EventBooking;
import mk.ukim.finki.lab_1.service.EventBookingService;
import mk.ukim.finki.lab_1.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class EventBookingController {

    private final EventBookingService eventBookingService;
    private final EventService eventService;

    public EventBookingController(EventBookingService eventBookingService, EventService eventService) {
        this.eventBookingService = eventBookingService;
        this.eventService = eventService;
    }

    @GetMapping("/book/{eventId}")
    public String showBookingForm(@PathVariable Long eventId, Model model) {
        Event event = eventService.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Invalid event ID"));
        model.addAttribute("event", event);
        return "booking-form";
    }

    @PostMapping("/book/{eventId}")
    public String bookEvent(@PathVariable Long eventId,
                            @RequestParam String attendeeName,
                            @RequestParam int numTickets,
                            Model model) {
        Event event = eventService.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Invalid event ID"));

        eventBookingService.bookEvent(event, attendeeName, numTickets);

        model.addAttribute("attendeeName", attendeeName);
        model.addAttribute("eventName", event.getName());
        model.addAttribute("numTickets", numTickets);

        return "booking-confirmation";
    }
}
