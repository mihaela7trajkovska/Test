package mk.ukim.finki.lab_1.bootstrap;


import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab_1.model.Event;
import mk.ukim.finki.lab_1.model.Location;
import mk.ukim.finki.lab_1.repository.JPA.EventRepository;
import mk.ukim.finki.lab_1.repository.JPA.LocationRepository;
import mk.ukim.finki.lab_1.repository.JPA.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = new ArrayList<>();
    public static List<Location> locations = new ArrayList<>();
    //public static List<User> users = new ArrayList<>();

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;
    //private final UserRepository userRepository;


    public DataHolder(EventRepository eventRepository, LocationRepository locationRepository/*UserRepository userRepository*/) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
        //this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        if (locationRepository.count() == 0) {
            Location location1 = (new Location("Ohrid Amphitheater", "Ohrid", "2000", "Outdoor amphitheater in Ohrid"));
            Location location2 = (new Location("Tikves Winery", "Kavadarci", "500", "Winery in Kavadarci"));
            Location location3 = (new Location("Strumica Carnival Square", "Strumica", "1500", "Main square in Strumica"));
            Location location4 = (new Location("Skopje Marathon Track", "Skopje", "5000", "Marathon route in Skopje"));
            Location location5 = (new Location("Dojran Beach", "Dojran", "3000", "Beach in Dojran for music festival"));

            locationRepository.save(location1);
            locationRepository.save(location2);
            locationRepository.save(location3);
            locationRepository.save(location4);
            locationRepository.save(location5);


            eventRepository.save(new Event("Ohridsko Leto", "Kulturn i muzicki festival vo Ohrid", 9.5, location1));
            eventRepository.save(new Event("Tikveski Grozdober", "Festival na vino i grozje vo Kavadarci", 8.8, location2));
            eventRepository.save(new Event("Strumicki Karneval", "Tradicionalen karneval so maski vo Strumica", 9.2, location3));
            eventRepository.save(new Event("Skopski Maraton", "Godishen sportski nastan vo Skopje", 8.0, location3));
            eventRepository.save(new Event("D Festival", "Muzicki festival na otvoreno vo Dojran", 9.0, location4));
            eventRepository.save(new Event("Folk Fest Valandovo", "Festival na narodna muzika vo Valandovo", 7.5, location1));
            eventRepository.save(new Event("Galichka Svadba", "Tradicionalna svadba vo Galichnik", 8.9, location2));
            eventRepository.save(new Event("Prilepski Pivofest", "Festival na pivo i muzika vo Prilep", 8.3, location3));
            eventRepository.save(new Event("Mladinski Kulturn Centar (MKC) Nastani", "Kulturni i muzicki nastani vo Skopje", 8.7, location4));
            eventRepository.save(new Event("Bela Nokj", "Noken kulturen nastan so umetnost i muzika vo Skopje", 8.6, location5));
        }


    }
}
