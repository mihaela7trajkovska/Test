package mk.ukim.finki.lab_1.service.impl;

import mk.ukim.finki.lab_1.model.Location;
import mk.ukim.finki.lab_1.repository.JPA.LocationRepository;
import mk.ukim.finki.lab_1.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRep;

    public LocationServiceImpl(LocationRepository locationRep) {
        this.locationRep = locationRep;
    }

    @Override
    public List<Location> findAll() {
        return locationRep.findAll();
    }
}
