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
import tech.ojay.fleetms.models.CarHire;
import tech.ojay.fleetms.models.Client;
import tech.ojay.fleetms.models.Location;
import tech.ojay.fleetms.services.CarHireService;
import tech.ojay.fleetms.services.CarService;
import tech.ojay.fleetms.services.ClientService;
import tech.ojay.fleetms.services.LocationService;

@Controller
public class CarHireController {
	@Autowired
	private CarHireService carHireService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private ClientService clientService;
	
	//Fetch All CarHires
	@GetMapping("/carhires")
	public String fetchCarHires(Model model){
		
		List<CarHire> carHireList = carHireService.fetchCarHires();
		model.addAttribute("carhires", carHireList);
		
		List<Car> carList = carService.fetchCars();
		model.addAttribute("cars", carList);
		
		List<Location> locationList = locationService.fetchLocations();
		model.addAttribute("locations", locationList);
		
		List<Client> clientList = clientService.fetchClients();
		model.addAttribute("clients", clientList);
		
		return "carhire";
	}
	
	@PostMapping("/carhires/insertNew")
	public String insertNew(CarHire carHire) {
		carHireService.store(carHire);
		return "redirect:/carhires";
	}
	
	@RequestMapping("/carhires/fetchCarHireById/{id}")
	@ResponseBody
	public CarHire getById(@PathVariable int id) {
		return carHireService.fetchCarHireDetailsById(id);
	}
	
	@RequestMapping(value="/carhires/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(CarHire carHire) {
		carHireService.store(carHire);
		return "redirect:/carhires";
	}
	
	@RequestMapping(value="/carhires/deleteCarHireById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		carHireService.delete(id);
		return "redirect:/carhires";
	}
}
