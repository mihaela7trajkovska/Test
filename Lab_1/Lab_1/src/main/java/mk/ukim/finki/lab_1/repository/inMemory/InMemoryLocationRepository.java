package mk.ukim.finki.lab_1.repository.inMemory;


import mk.ukim.finki.lab_1.model.Location;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import static mk.ukim.finki.lab_1.bootstrap.DataHolder.locations;

@Repository
public class InMemoryLocationRepository {


    private InMemoryLocationRepository eventRepository;

    public List<Location> findAll() {
        return locations;
    }

    public Optional<Location> findById(Long locationId) {
        return locations.stream()
                .filter(location -> location.getId().equals(locationId))
                .findFirst();
    }


    public void save(Location location) {
        locations.add(location);
    }


    public long count() {
        return eventRepository.count();
    }
}