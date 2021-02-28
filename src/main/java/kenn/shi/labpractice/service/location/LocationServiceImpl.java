package kenn.shi.labpractice.service.location;

import kenn.shi.labpractice.model.entity.Location;
import kenn.shi.labpractice.repository.location.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void save(Location location) {
        locationRepository.save(location);
    }

    @Override
    public Location findByName(String name) {
        Location location = locationRepository.getByName(name);
        return location;
    }


}
