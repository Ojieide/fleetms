package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.CarStatus;
import tech.ojay.fleetms.repositories.CarStatusRepository;

@Service
public class CarStatusService {
	@Autowired
	private CarStatusRepository carStatusRepository;
	
	//Fetch list of carStatus
	public List<CarStatus> fetchCarStatus(){
		return carStatusRepository.findAll();
	}
	
	//Insert new carStatus
	public void store(CarStatus carStatus) {
		carStatusRepository.save(carStatus);
	}
	
	//Fetch carStatus by id
	public CarStatus fetchCarStatusDetailsById(int id) {
		return carStatusRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		carStatusRepository.deleteById(id);	
	}
}
