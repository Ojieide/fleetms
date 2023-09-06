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

import tech.ojay.fleetms.models.CarBrand;
import tech.ojay.fleetms.services.CarBrandService;

@Controller
public class CarBrandController {
	@Autowired
	private CarBrandService carBrandService;
	
	//Fetch All CarBrands
	@GetMapping("/carbrands")
	public String fetchCarBrands(Model model){
		
		List<CarBrand> carBrandList = carBrandService.fetchCarBrands();
		model.addAttribute("carbrands", carBrandList);
		
		return "carbrand";
	}
	
	@PostMapping("/carbrands/insertNew")
	public String insertNew(CarBrand carBrand) {
		carBrandService.store(carBrand);
		return "redirect:/carbrands";
	}
	
	@RequestMapping("/carbrands/fetchCarBrandById/{id}")
	@ResponseBody
	public CarBrand getById(@PathVariable int id) {
		return carBrandService.fetchCarBrandDetailsById(id);
	}
	
	@RequestMapping(value="/carbrands/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(CarBrand carBrand) {
		carBrandService.store(carBrand);
		return "redirect:/carbrands";
	}
	
	@RequestMapping(value="/carbrands/deleteCarBrandById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		carBrandService.delete(id);
		return "redirect:/carbrands";
	}
}
