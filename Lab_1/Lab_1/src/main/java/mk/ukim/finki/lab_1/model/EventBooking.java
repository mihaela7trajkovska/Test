package mk.ukim.finki.lab_1.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity

@Data
@NoArgsConstructor
public class EventBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String eventName;
    private String attendeeName;
    private String attendeeAddress;
    private Long numberOfTickets;

    @ManyToOne
    private Event event;

    public EventBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        this.eventName = eventName;
        this.attendeeName = attendeeName;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
    }



    public String getEventName() {
        return eventName;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public String getAttendeeAddress() {
        return attendeeAddress;
    }

    public Long getNumberOfTickets() {
        return numberOfTickets;
    }
}
