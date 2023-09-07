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
import tech.ojay.fleetms.models.CarMaintenance;
import tech.ojay.fleetms.models.Supplier;
import tech.ojay.fleetms.services.CarMaintenanceService;
import tech.ojay.fleetms.services.CarService;
import tech.ojay.fleetms.services.SupplierService;

@Controller
public class CarMaintenanceController {
	@Autowired
	private CarMaintenanceService carMaintenanceService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private SupplierService supplierService;
	
	//Fetch All CarMaintenance
	@GetMapping("/carmaintenance")
	public String fetchCarMaintenance(Model model){
		
		List<CarMaintenance> carMaintenanceList = carMaintenanceService.fetchCarMaintenance();
		model.addAttribute("carmaintenance", carMaintenanceList);
		
		List<Car> carList = carService.fetchCars();
		model.addAttribute("cars", carList);
		
		List<Supplier> supplierList = supplierService.fetchSuppliers();
		model.addAttribute("suppliers", supplierList);
		
		return "carmaintenance";
	}
	
	@PostMapping("/carmaintenance/insertNew")
	public String insertNew(CarMaintenance carMaintenance) {
		carMaintenanceService.store(carMaintenance);
		return "redirect:/carmaintenance";
	}
	
	@RequestMapping("/carmaintenance/fetchCarMaintenanceById/{id}")
	@ResponseBody
	public CarMaintenance getById(@PathVariable int id) {
		return carMaintenanceService.fetchCarMaintenanceDetailsById(id);
	}
	
	@RequestMapping(value="/carmaintenance/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(CarMaintenance carMaintenance) {
		carMaintenanceService.store(carMaintenance);
		return "redirect:/carmaintenance";
	}
	
	@RequestMapping(value="/carmaintenance/deleteCarMaintenanceById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		carMaintenanceService.delete(id);
		return "redirect:/carmaintenance";
	}
}
