package mk.ukim.finki.lab_1.service.impl;

import mk.ukim.finki.lab_1.model.Event;
import mk.ukim.finki.lab_1.model.Location;
import mk.ukim.finki.lab_1.repository.JPA.EventRepository;
import mk.ukim.finki.lab_1.repository.JPA.LocationRepository;
import mk.ukim.finki.lab_1.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

//    @PostConstruct
//    public void initData() {
//        if (locationRepository.count() == 0) {
//            Location location1 = new Location(1L, "Partizanska", "Partizanska Street, Gostivar", "200", "Main location");
//            Location location2 = new Location(2L,"Ljubljanska", "Skopska Street, Gostivar", "150", "Popular area");
//            Location location3 = (new Location(3L, "Teodosij Gologanov", "Teodosij Gologanov, Gostivar", "500", "Large medical complex"));
//            Location location4 = (new Location( 4L,"Bukova", "Bukova Street, Gostivar", "100", "Quiet neighborhood spot"));
//            Location location5 = (new Location(5L, "Shopping Center", "Shopping Center, Gostivar", "300", "Shopping and entertainment area"));
//
//            locationRepository.save(location1);
//            locationRepository.save(location2);
//            locationRepository.save(location3);
//            locationRepository.save(location4);
//            locationRepository.save(location5);
//
//            eventRepository.save(new Event("Concert", "Live music concert", 4.5, location1));
//            eventRepository.save(new Event("Art Exhibition", "Modern art showcase", 4.0, location2));
//            eventRepository.save(new Event("Tech Conference", "Technology trends and insights", 4.8, location1));
//            eventRepository.save(new Event("Film Festival", "Showcasing independent films", 4.2, location2));
//            eventRepository.save(new Event("Food Fair", "Taste of various cuisines", 4.6, location1));
//            eventRepository.save(new Event("Charity Run", "Running for a good cause", 4.3, location2));
//            eventRepository.save(new Event("Book Signing", "Meet your favorite authors", 4.4, location1));
//            eventRepository.save(new Event("Theater Play", "Classic drama performance", 4.7, location2));
//            eventRepository.save(new Event("Stand-up Comedy", "A night of laughter", 4.1, location1));
//            eventRepository.save(new Event("Dance Party", "Join us for a night of dancing", 4.5, location2));
//
//        }
//    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public Optional<Event> save(String name, String description, double popularityScore, Long locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid location ID"));
        Event event = new Event(name, description, popularityScore, location);
        eventRepository.save(event);
        return null;
    }

    @Override
    public Event findEventById(Long id) {
        return null;
    }

    @Override
    public void deleteEvent(Long id) {

    }

    @Override
    public Optional<Event> edit(Long id, String name, String description, double popularityScore, Long locationId) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        Optional<Location> locationOptional = locationRepository.findById(locationId);

        if (eventOptional.isPresent() && locationOptional.isPresent()) {
            Event event = eventOptional.get();
            event.setName(name);
            event.setDescription(description);
            event.setPopularityScore(popularityScore);
            event.setLocation(locationOptional.get());

            return Optional.of(eventRepository.save(event));
        }

        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
