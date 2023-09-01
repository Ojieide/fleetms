package tech.ojay.fleetms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.ojay.fleetms.models.PersonnelType;

@Repository
public interface PersonnelTypeRepository extends JpaRepository<PersonnelType, Integer> {

}
