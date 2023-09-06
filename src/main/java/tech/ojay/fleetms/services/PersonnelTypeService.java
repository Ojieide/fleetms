package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.PersonnelType;
import tech.ojay.fleetms.repositories.PersonnelTypeRepository;

@Service
public class PersonnelTypeService {
	@Autowired
	private PersonnelTypeRepository personnelTypeRepository;
	
	//Fetch list of personnelTypes
	public List<PersonnelType> fetchPersonnelTypes(){
		return personnelTypeRepository.findAll();
	}
	
	//Insert new personnelType
	public void store(PersonnelType personnelType) {
		personnelTypeRepository.save(personnelType);
	}
	
	//Fetch personnelType by id
	public PersonnelType fetchPersonnelTypeDetailsById(int id) {
		return personnelTypeRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		personnelTypeRepository.deleteById(id);	
	}
}
