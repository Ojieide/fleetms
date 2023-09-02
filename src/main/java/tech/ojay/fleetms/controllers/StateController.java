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

import tech.ojay.fleetms.models.Country;
import tech.ojay.fleetms.models.State;
import tech.ojay.fleetms.services.CountryService;
import tech.ojay.fleetms.services.StateService;

@Controller
public class StateController {
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	//Fetch All States
	@GetMapping("/states")
	public String fetchStates(Model model){
		
		List<State> stateList = stateService.fetchStates();
		model.addAttribute("states", stateList);
		
		List<Country> countryList = countryService.fetchCountries();
		model.addAttribute("countries", countryList);
		
		return "state";
	}
	
	@PostMapping("/states/insertNew")
	public String insertNew(State state) {
		stateService.store(state);
		return "redirect:/states";
	}
	
	@RequestMapping("/states/fetchStateById/{id}")
	@ResponseBody
	public State getById(@PathVariable int id) {
		return stateService.fetchStateDetailsById(id);
	}
	
	@RequestMapping(value="/states/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(State state) {
		stateService.store(state);
		return "redirect:/states";
	}
	
	@RequestMapping(value="/states/deleteStateById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		stateService.delete(id);
		return "redirect:/states";
	}

}
