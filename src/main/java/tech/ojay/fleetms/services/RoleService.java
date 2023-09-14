package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.Role;
import tech.ojay.fleetms.repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	//Fetch list of roles
	public List<Role> fetchRoles(){
		return roleRepository.findAll();
	}
	
	//Insert new role
	public void store(Role role) {
		roleRepository.save(role);
	}
}
