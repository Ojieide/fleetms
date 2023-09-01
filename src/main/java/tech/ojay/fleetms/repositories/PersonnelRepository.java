package tech.ojay.fleetms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.ojay.fleetms.models.Personnel;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {

}
