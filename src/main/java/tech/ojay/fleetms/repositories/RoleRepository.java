package tech.ojay.fleetms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.ojay.fleetms.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
