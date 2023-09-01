package tech.ojay.fleetms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.ojay.fleetms.models.CarBrand;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Integer> {

}
