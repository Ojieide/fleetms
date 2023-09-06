package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.CarType;
import tech.ojay.fleetms.repositories.CarTypeRepository;

@Service
public class CarTypeService {
	@Autowired
	private CarTypeRepository carTypeRepository;
	
	//Fetch list of carTypes
	public List<CarType> fetchCarTypes(){
		return carTypeRepository.findAll();
	}
	
	//Insert new carType
	public void store(CarType carType) {
		carTypeRepository.save(carType);
	}
	
	//Fetch carType by id
	public CarType fetchCarTypeDetailsById(int id) {
		return carTypeRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		carTypeRepository.deleteById(id);	
	}
}
