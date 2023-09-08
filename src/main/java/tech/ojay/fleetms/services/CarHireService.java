package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.CarHire;
import tech.ojay.fleetms.repositories.CarHireRepository;

@Service
public class CarHireService {
	@Autowired
	private CarHireRepository carHireRepository;
	
	//Fetch list of carHires
	public List<CarHire> fetchCarHires(){
		return carHireRepository.findAll();
	}
	
	//Insert new carHire
	public void store(CarHire carHire) {
		carHireRepository.save(carHire);
	}
	
	//Fetch carHire by id
	public CarHire fetchCarHireDetailsById(int id) {
		return carHireRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		carHireRepository.deleteById(id);	
	}
}
