package tech.ojay.fleetms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.ojay.fleetms.models.CarMaintenance;

@Repository
public interface CarMaintenanceRepository extends JpaRepository<CarMaintenance, Integer> {

}
