package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.Client;
import tech.ojay.fleetms.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	//Fetch list of clients
	public List<Client> fetchClients(){
		return clientRepository.findAll();
	}
	
	//Insert new client
	public void store(Client client) {
		clientRepository.save(client);
	}
	
	//Fetch client by id
	public Client fetchClientDetailsById(int id) {
		return clientRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		clientRepository.deleteById(id);	
	}
}
