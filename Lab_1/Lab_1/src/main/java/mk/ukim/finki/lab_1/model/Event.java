package mk.ukim.finki.lab_1.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double popularityScore;
    @ManyToOne
    private Location location;

    public Event(String name, String description, double popularityScore,Location location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location=location;
    }


    @OneToMany(mappedBy = "event")
    private List<EventBooking> bookings = new ArrayList<>();


    public void addBooking(EventBooking booking) {
        this.bookings.add(booking);
    }
}
