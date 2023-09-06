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

import tech.ojay.fleetms.models.PersonnelType;
import tech.ojay.fleetms.services.PersonnelTypeService;

@Controller
public class PersonnelTypeController {
	@Autowired
	private PersonnelTypeService personnelTypeService;
	
	//Fetch All PersonnelTypes
	@GetMapping("/personneltypes")
	public String fetchPersonnelTypes(Model model){
		
		List<PersonnelType> personnelTypeList = personnelTypeService.fetchPersonnelTypes();
		model.addAttribute("personneltypes", personnelTypeList);
		
		return "personneltype";
	}
	
	@PostMapping("/personneltypes/insertNew")
	public String insertNew(PersonnelType personnelType) {
		personnelTypeService.store(personnelType);
		return "redirect:/personneltypes";
	}
	
	@RequestMapping("/personneltypes/fetchPersonnelTypeById/{id}")
	@ResponseBody
	public PersonnelType getById(@PathVariable int id) {
		return personnelTypeService.fetchPersonnelTypeDetailsById(id);
	}
	
	@RequestMapping(value="/personneltypes/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(PersonnelType personnelType) {
		personnelTypeService.store(personnelType);
		return "redirect:/personneltypes";
	}
	
	@RequestMapping(value="/personneltypes/deletePersonnelTypeById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		personnelTypeService.delete(id);
		return "redirect:/personneltypes";
	}
}
