package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.CarBrand;
import tech.ojay.fleetms.repositories.CarBrandRepository;

@Service
public class CarBrandService {
	@Autowired
	private CarBrandRepository carBrandRepository;
	
	//Fetch list of carBrands
	public List<CarBrand> fetchCarBrands(){
		return carBrandRepository.findAll();
	}
	
	//Insert new carBrand
	public void store(CarBrand carBrand) {
		carBrandRepository.save(carBrand);
	}
	
	//Fetch carBrand by id
	public CarBrand fetchCarBrandDetailsById(int id) {
		return carBrandRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		carBrandRepository.deleteById(id);	
	}
}
