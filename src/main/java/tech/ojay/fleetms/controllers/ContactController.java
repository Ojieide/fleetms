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

import tech.ojay.fleetms.models.Contact;
import tech.ojay.fleetms.models.Country;
import tech.ojay.fleetms.models.State;
import tech.ojay.fleetms.services.ContactService;
import tech.ojay.fleetms.services.CountryService;
import tech.ojay.fleetms.services.StateService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	//Fetch All Contacts
	@GetMapping("/contacts")
	public String fetchContacts(Model model){
		
		List<Contact> contactList = contactService.fetchContacts();
		model.addAttribute("contacts", contactList);
		
		List<Country> countryList = countryService.fetchCountries();
		model.addAttribute("countries", countryList);
		
		List<State> stateList = stateService.fetchStates();
		model.addAttribute("states", stateList);
		
		return "contact";
	}
	
	@PostMapping("/contacts/insertNew")
	public String insertNew(Contact contact) {
		contactService.store(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping("/contacts/fetchContactById/{id}")
	@ResponseBody
	public Contact getById(@PathVariable int id) {
		return contactService.fetchContactDetailsById(id);
	}
	
	@RequestMapping(value="/contacts/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(Contact contact) {
		contactService.store(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping(value="/contacts/deleteContactById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		contactService.delete(id);
		return "redirect:/contacts";
	}
}
