package tech.ojay.fleetms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.ojay.fleetms.models.CarType;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Integer> {

}
