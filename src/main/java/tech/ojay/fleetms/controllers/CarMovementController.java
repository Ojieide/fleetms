package tech.ojay.fleetms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tech.ojay.fleetms.models.CarMovement;
import tech.ojay.fleetms.models.Car;
import tech.ojay.fleetms.models.Location;
import tech.ojay.fleetms.services.CarMovementService;
import tech.ojay.fleetms.services.CarService;
import tech.ojay.fleetms.services.LocationService;

@Controller
public class CarMovementController {
	@Autowired
	private CarMovementService carMovementService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private LocationService locationService;
	
	//Fetch All CarMovements
	@GetMapping("/carmovements")
	public String fetchCarMovements(Model model){
		
		List<CarMovement> carMovementList = carMovementService.fetchCarMovements();
		model.addAttribute("carmovements", carMovementList);
		
		List<Car> carList = carService.fetchCars();
		model.addAttribute("cars", carList);
		
		List<Location> locationList = locationService.fetchLocations();
		model.addAttribute("locations", locationList);
		
		return "carmovement";
	}
	
	@PostMapping("/carmovements/insertNew")
	public String insertNew(CarMovement carMovement) {
		carMovementService.store(carMovement);
		return "redirect:/carmovements";
	}
	
	@RequestMapping("/carmovements/fetchCarMovementById/{id}")
	@ResponseBody
	public CarMovement getById(@PathVariable int id) {
		return carMovementService.fetchCarMovementDetailsById(id);
	}
	
	@RequestMapping(value="/carmovements/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(CarMovement carMovement) {
		carMovementService.store(carMovement);
		return "redirect:/carmovements";
	}
	
	@RequestMapping(value="/carmovements/deleteCarMovementById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		carMovementService.delete(id);
		return "redirect:/carmovements";
	}
}
