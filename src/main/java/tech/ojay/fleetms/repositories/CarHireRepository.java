package tech.ojay.fleetms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.ojay.fleetms.models.CarHire;

@Repository
public interface CarHireRepository extends JpaRepository<CarHire, Integer> {

}
