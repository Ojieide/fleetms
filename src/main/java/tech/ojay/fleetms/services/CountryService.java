package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.Country;
import tech.ojay.fleetms.repositories.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	//Fetch list of countries
	public List<Country> fetchCountries(){
		return countryRepository.findAll();
	}
	
	//Insert new country
	public void store(Country country) {
		countryRepository.save(country);
	}
	
	//Fetch country by id
	public Country fetchCountryDetailsById(int id) {
		return countryRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		countryRepository.deleteById(id);	
	}
	
}
