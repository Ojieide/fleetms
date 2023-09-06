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

import tech.ojay.fleetms.models.CarStatus;
import tech.ojay.fleetms.services.CarStatusService;

@Controller
public class CarStatusController {
	@Autowired
	private CarStatusService carStatusService;
	
	//Fetch All CarStatus
	@GetMapping("/carstatus")
	public String fetchCarStatus(Model model){
		
		List<CarStatus> carStatusList = carStatusService.fetchCarStatus();
		model.addAttribute("carstatus", carStatusList);
		
		return "carstatus";
	}
	
	@PostMapping("/carstatus/insertNew")
	public String insertNew(CarStatus carStatus) {
		carStatusService.store(carStatus);
		return "redirect:/carstatus";
	}
	
	@RequestMapping("/carstatus/fetchCarStatusById/{id}")
	@ResponseBody
	public CarStatus getById(@PathVariable int id) {
		return carStatusService.fetchCarStatusDetailsById(id);
	}
	
	@RequestMapping(value="/carstatus/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(CarStatus carStatus) {
		carStatusService.store(carStatus);
		return "redirect:/carstatus";
	}
	
	@RequestMapping(value="/carstatus/deleteCarStatusById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		carStatusService.delete(id);
		return "redirect:/carstatus";
	}
}
