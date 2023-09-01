package tech.ojay.fleetms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.ojay.fleetms.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
