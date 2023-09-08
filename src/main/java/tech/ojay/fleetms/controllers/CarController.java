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

import tech.ojay.fleetms.models.Car;
import tech.ojay.fleetms.models.CarBrand;
import tech.ojay.fleetms.models.CarModel;
import tech.ojay.fleetms.models.CarStatus;
import tech.ojay.fleetms.models.CarType;
import tech.ojay.fleetms.models.Location;
import tech.ojay.fleetms.models.Personnel;
import tech.ojay.fleetms.services.CarBrandService;
import tech.ojay.fleetms.services.CarModelService;
import tech.ojay.fleetms.services.CarService;
import tech.ojay.fleetms.services.CarStatusService;
import tech.ojay.fleetms.services.CarTypeService;
import tech.ojay.fleetms.services.LocationService;
import tech.ojay.fleetms.services.PersonnelService;

@Controller
public class CarController {
	@Autowired
	private CarService carService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private PersonnelService personnelService;
	
	@Autowired
	private CarBrandService carBrandService;
	
	@Autowired
	private CarTypeService carTypeService;
	
	@Autowired
	private CarStatusService carStatusService;
	
	@Autowired
	private CarModelService carModelService;
	
	//Fetch All Cars
	@GetMapping("/cars")
	public String fetchCars(Model model){
		
		List<Car> carList = carService.fetchCars();
		model.addAttribute("cars", carList);
		
		List<Location> locationList = locationService.fetchLocations();
		model.addAttribute("locations", locationList);
		
		List<Personnel> personnelList = personnelService.fetchPersonnel();
		model.addAttribute("personnel", personnelList);
		
		List<CarBrand> carBrandList = carBrandService.fetchCarBrands();
		model.addAttribute("carbrands", carBrandList);
		
		List<CarType> carTypeList = carTypeService.fetchCarTypes();
		model.addAttribute("cartypes", carTypeList);
		
		List<CarStatus> carStatusList = carStatusService.fetchCarStatus();
		model.addAttribute("carstatus", carStatusList);
		
		List<CarModel> carModelList = carModelService.fetchCarModels();
		model.addAttribute("carmodels", carModelList);
		
		return "car";
	}
	
	@PostMapping("/cars/insertNew")
	public String insertNew(Car car) {
		carService.store(car);
		return "redirect:/cars";
	}
	
	@RequestMapping("/cars/fetchCarById/{id}")
	@ResponseBody
	public Car getById(@PathVariable int id) {
		return carService.fetchCarDetailsById(id);
	}
	
	@RequestMapping(value="/cars/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(Car car) {
		carService.store(car);
		return "redirect:/cars";
	}
	
	@RequestMapping(value="/cars/deleteCarById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		carService.delete(id);
		return "redirect:/cars";
	}
}
