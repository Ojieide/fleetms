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

import tech.ojay.fleetms.models.CarModel;
import tech.ojay.fleetms.services.CarModelService;

@Controller
public class CarModelController {
	@Autowired
	private CarModelService carModelService;
	
	//Fetch All CarModels
	@GetMapping("/carmodels")
	public String fetchCarModels(Model model){
		
		List<CarModel> carModelList = carModelService.fetchCarModels();
		model.addAttribute("carmodels", carModelList);
		
		return "carmodel";
	}
	
	@PostMapping("/carmodels/insertNew")
	public String insertNew(CarModel carModel) {
		carModelService.store(carModel);
		return "redirect:/carmodels";
	}
	
	@RequestMapping("/carmodels/fetchCarModelById/{id}")
	@ResponseBody
	public CarModel getById(@PathVariable int id) {
		return carModelService.fetchCarModelDetailsById(id);
	}
	
	@RequestMapping(value="/carmodels/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(CarModel carModel) {
		carModelService.store(carModel);
		return "redirect:/carmodels";
	}
	
	@RequestMapping(value="/carmodels/deleteCarModelById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		carModelService.delete(id);
		return "redirect:/carmodels";
	}
}
