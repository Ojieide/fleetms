package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.CarModel;
import tech.ojay.fleetms.repositories.CarModelRepository;

@Service
public class CarModelService {
	@Autowired
	private CarModelRepository carModelRepository;
	
	//Fetch list of carModels
	public List<CarModel> fetchCarModels(){
		return carModelRepository.findAll();
	}
	
	//Insert new carModel
	public void store(CarModel carModel) {
		carModelRepository.save(carModel);
	}
	
	//Fetch carModel by id
	public CarModel fetchCarModelDetailsById(int id) {
		return carModelRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		carModelRepository.deleteById(id);	
	}
}
