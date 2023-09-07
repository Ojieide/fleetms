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

import tech.ojay.fleetms.models.Supplier;
import tech.ojay.fleetms.models.Country;
import tech.ojay.fleetms.models.State;
import tech.ojay.fleetms.services.SupplierService;
import tech.ojay.fleetms.services.CountryService;
import tech.ojay.fleetms.services.StateService;

@Controller
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	//Fetch All Suppliers
	@GetMapping("/suppliers")
	public String fetchSuppliers(Model model){
		
		List<Supplier> supplierList = supplierService.fetchSuppliers();
		model.addAttribute("suppliers", supplierList);
		
		List<Country> countryList = countryService.fetchCountries();
		model.addAttribute("countries", countryList);
		
		List<State> stateList = stateService.fetchStates();
		model.addAttribute("states", stateList);
		
		return "supplier";
	}
	
	@PostMapping("/suppliers/insertNew")
	public String insertNew(Supplier supplier) {
		supplierService.store(supplier);
		return "redirect:/suppliers";
	}
	
	@RequestMapping("/suppliers/fetchSupplierById/{id}")
	@ResponseBody
	public Supplier getById(@PathVariable int id) {
		return supplierService.fetchSupplierDetailsById(id);
	}
	
	@RequestMapping(value="/suppliers/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(Supplier supplier) {
		supplierService.store(supplier);
		return "redirect:/suppliers";
	}
	
	@RequestMapping(value="/suppliers/deleteSupplierById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		supplierService.delete(id);
		return "redirect:/suppliers";
	}
}
