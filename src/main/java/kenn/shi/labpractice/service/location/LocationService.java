package kenn.shi.labpractice.service.location;

import kenn.shi.labpractice.model.entity.Location;

public interface LocationService {
    void save(Location location);
    Location findByName(String name);
}
