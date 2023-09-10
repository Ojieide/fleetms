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

import tech.ojay.fleetms.models.Personnel;
import tech.ojay.fleetms.models.PersonnelType;
import tech.ojay.fleetms.models.Role;
import tech.ojay.fleetms.models.Country;
import tech.ojay.fleetms.models.State;
import tech.ojay.fleetms.services.PersonnelService;
import tech.ojay.fleetms.services.PersonnelTypeService;
import tech.ojay.fleetms.services.RoleService;
import tech.ojay.fleetms.services.CountryService;
import tech.ojay.fleetms.services.StateService;

@Controller
public class PersonnelController {
	@Autowired
	private PersonnelService personnelService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PersonnelTypeService personnelTypeService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	//Fetch All Personnel
	@GetMapping("/personnel")
	public String fetchPersonnel(Model model){
		
		List<Personnel> personnelList = personnelService.fetchPersonnel();
		model.addAttribute("personnel", personnelList);
		
		List<Country> countryList = countryService.fetchCountries();
		model.addAttribute("countries", countryList);
		
		List<State> stateList = stateService.fetchStates();
		model.addAttribute("states", stateList);
		
		List<Role> roleList = roleService.fetchRoles();
		model.addAttribute("roles", roleList);
		
		List<PersonnelType> personnelTypeList = personnelTypeService.fetchPersonnelTypes();
		model.addAttribute("personneltypes", personnelTypeList);
		
		return "personnel";
	}
	
	@PostMapping("/personnel/insertNew")
	public String insertNew(Personnel personnel) {
		personnelService.store(personnel);
		return "redirect:/personnel";
	}
	
	@RequestMapping("/personnel/fetchPersonnelById/{id}")
	@ResponseBody
	public Personnel getById(@PathVariable int id) {
		return personnelService.fetchPersonnelDetailsById(id);
	}
	
	@RequestMapping(value="/personnel/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(Personnel personnel) {
		personnelService.store(personnel);
		return "redirect:/personnel";
	}
	
	@RequestMapping(value="/personnel/deletePersonnelById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		personnelService.delete(id);
		return "redirect:/personnel";
	}
}
