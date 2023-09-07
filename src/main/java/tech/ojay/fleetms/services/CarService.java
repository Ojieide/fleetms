package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.Car;
import tech.ojay.fleetms.repositories.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;

	public List<Car> fetchCars() {
		return carRepository.findAll();
	}

}
