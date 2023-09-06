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

import tech.ojay.fleetms.models.CarType;
import tech.ojay.fleetms.services.CarTypeService;

@Controller
public class CarTypeController {
	@Autowired
	private CarTypeService carTypeService;
	
	//Fetch All CarTypes
	@GetMapping("/cartypes")
	public String fetchCarTypes(Model model){
		
		List<CarType> carTypeList = carTypeService.fetchCarTypes();
		model.addAttribute("cartypes", carTypeList);
		
		return "cartype";
	}
	
	@PostMapping("/cartypes/insertNew")
	public String insertNew(CarType carType) {
		carTypeService.store(carType);
		return "redirect:/cartypes";
	}
	
	@RequestMapping("/cartypes/fetchCarTypeById/{id}")
	@ResponseBody
	public CarType getById(@PathVariable int id) {
		return carTypeService.fetchCarTypeDetailsById(id);
	}
	
	@RequestMapping(value="/cartypes/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(CarType carType) {
		carTypeService.store(carType);
		return "redirect:/cartypes";
	}
	
	@RequestMapping(value="/cartypes/deleteCarTypeById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		carTypeService.delete(id);
		return "redirect:/cartypes";
	}
}
