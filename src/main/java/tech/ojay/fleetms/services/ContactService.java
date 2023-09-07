package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.Contact;
import tech.ojay.fleetms.repositories.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;
	
	//Fetch list of contacts
	public List<Contact> fetchContacts(){
		return contactRepository.findAll();
	}
	
	//Insert new contact
	public void store(Contact contact) {
		contactRepository.save(contact);
	}
	
	//Fetch contact by id
	public Contact fetchContactDetailsById(int id) {
		return contactRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		contactRepository.deleteById(id);	
	}
}
