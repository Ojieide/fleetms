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
import tech.ojay.fleetms.services.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	//Fetch All Countries
	@GetMapping("/countries")
	public String fetchCountries(Model model){
		
		List<Country> countryList = countryService.fetchCountries();
		
		model.addAttribute("countries", countryList);
		
		return "country";
	}
	
	@PostMapping("/countries/insertNew")
	public String insertNew(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}
	
	@RequestMapping("/countries/fetchCountryById/{id}")
	@ResponseBody
	public Country getById(@PathVariable int id) {
		return countryService.fetchCountryDetailsById(id);
	}
	
	@RequestMapping(value="/countries/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}

}
