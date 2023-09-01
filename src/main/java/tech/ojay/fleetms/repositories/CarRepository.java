package tech.ojay.fleetms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.ojay.fleetms.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
