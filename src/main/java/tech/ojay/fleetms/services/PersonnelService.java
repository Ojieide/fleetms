package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.Personnel;
import tech.ojay.fleetms.repositories.PersonnelRepository;

@Service
public class PersonnelService {
	@Autowired
	private PersonnelRepository personnelRepository;
	
	//Fetch list of personnel
	public List<Personnel> fetchPersonnel(){
		return personnelRepository.findAll();
	}
	
	//Insert new personnel
	public void store(Personnel personnel) {
		personnelRepository.save(personnel);
	}
	
	//Fetch personnel by id
	public Personnel fetchPersonnelDetailsById(int id) {
		return personnelRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		personnelRepository.deleteById(id);	
	}
}
