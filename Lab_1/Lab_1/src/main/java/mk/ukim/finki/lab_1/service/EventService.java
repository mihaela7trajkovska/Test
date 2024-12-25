package mk.ukim.finki.lab_1.service;


import mk.ukim.finki.lab_1.model.Event;

import java.util.List;
import java.util.Optional;


public interface EventService {
    List<Event> listAll();

    Optional<Event> findById(Long id);

    Optional <Event> edit(Long id, String name, String description, double popularityScore, Long locationId);

    void delete(Long id);

    Optional<Event> save(String name, String description, double popularityScore, Long locationId);

    Event findEventById(Long id);

    void deleteEvent(Long id);
}
