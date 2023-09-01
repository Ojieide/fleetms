package tech.ojay.fleetms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.ojay.fleetms.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
