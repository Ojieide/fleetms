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
	
	//Fetch list of cars
	public List<Car> fetchCars(){
		return carRepository.findAll();
	}
	
	//Insert new car
	public void store(Car car) {
		carRepository.save(car);
	}
	
	//Fetch car by id
	public Car fetchCarDetailsById(int id) {
		return carRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		carRepository.deleteById(id);	
	}

}
