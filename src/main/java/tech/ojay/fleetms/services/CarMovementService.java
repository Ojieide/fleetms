package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.CarMovement;
import tech.ojay.fleetms.repositories.CarMovementRepository;

@Service
public class CarMovementService {
	@Autowired
	private CarMovementRepository carMovementRepository;
	
	//Fetch list of CarMovement
	public List<CarMovement> fetchCarMovements(){
		return carMovementRepository.findAll();
	}
	
	//Insert new CarMovement
	public void store(CarMovement carMovement) {
		carMovementRepository.save(carMovement);
	}
	
	//Fetch CarMovement by id
	public CarMovement fetchCarMovementDetailsById(int id) {
		return carMovementRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		carMovementRepository.deleteById(id);	
	}
}
