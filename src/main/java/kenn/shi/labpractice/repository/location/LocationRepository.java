package kenn.shi.labpractice.repository.location;

import kenn.shi.labpractice.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location , Long> {
    Location getByName(String name);
}
