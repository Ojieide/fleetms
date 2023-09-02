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
import tech.ojay.fleetms.models.Location;
import tech.ojay.fleetms.models.State;
import tech.ojay.fleetms.services.CountryService;
import tech.ojay.fleetms.services.LocationService;
import tech.ojay.fleetms.services.StateService;

@Controller
public class LocationController {
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private LocationService locationService;
	
	//Fetch All Locations
	@GetMapping("/locations")
	public String fetchLocations(Model model){
		
		List<State> stateList = stateService.fetchStates();
		model.addAttribute("states", stateList);
		
		List<Country> countryList = countryService.fetchCountries();
		model.addAttribute("countries", countryList);
		
		List<Location> locationList = locationService.fetchLocations();
		model.addAttribute("locations", locationList);
		
		return "location";
	}
	
	@PostMapping("/locations/insertNew")
	public String insertNew(Location location) {
		locationService.store(location);
		return "redirect:/locations";
	}
	
	@RequestMapping("/locations/fetchLocationById/{id}")
	@ResponseBody
	public Location getById(@PathVariable int id) {
		return locationService.fetchLocationDetailsById(id);
	}
	
	@RequestMapping(value="/locations/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(Location location) {
		locationService.store(location);
		return "redirect:/locations";
	}
	
	@RequestMapping(value="/locations/deleteLocationById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		locationService.delete(id);
		return "redirect:/locations";
	}

}
