package mk.ukim.finki.lab_1.repository.JPA;

import mk.ukim.finki.lab_1.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
