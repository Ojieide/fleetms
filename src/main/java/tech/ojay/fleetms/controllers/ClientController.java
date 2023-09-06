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

import tech.ojay.fleetms.models.Client;
import tech.ojay.fleetms.models.Country;
import tech.ojay.fleetms.models.State;
import tech.ojay.fleetms.services.ClientService;
import tech.ojay.fleetms.services.CountryService;
import tech.ojay.fleetms.services.StateService;

@Controller
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	//Fetch All Clients
	@GetMapping("/clients")
	public String fetchClients(Model model){
		
		List<Client> clientList = clientService.fetchClients();
		model.addAttribute("clients", clientList);
		
		List<Country> countryList = countryService.fetchCountries();
		model.addAttribute("countries", countryList);
		
		List<State> stateList = stateService.fetchStates();
		model.addAttribute("states", stateList);
		
		return "client";
	}
	
	@PostMapping("/clients/insertNew")
	public String insertNew(Client client) {
		clientService.store(client);
		return "redirect:/clients";
	}
	
	@RequestMapping("/clients/fetchClientById/{id}")
	@ResponseBody
	public Client getById(@PathVariable int id) {
		return clientService.fetchClientDetailsById(id);
	}
	
	@RequestMapping(value="/clients/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(Client client) {
		clientService.store(client);
		return "redirect:/clients";
	}
	
	@RequestMapping(value="/clients/deleteClientById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		clientService.delete(id);
		return "redirect:/clients";
	}
}
