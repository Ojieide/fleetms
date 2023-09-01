package tech.ojay.fleetms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.ojay.fleetms.models.CarMovement;

@Repository
public interface CarMovementRepository extends JpaRepository<CarMovement, Integer> {

}
