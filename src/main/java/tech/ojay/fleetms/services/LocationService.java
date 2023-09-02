package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.Location;
import tech.ojay.fleetms.repositories.LocationRepository;

@Service
public class LocationService {
	@Autowired
	private LocationRepository locationRepository;
	
	//Fetch list of locations
	public List<Location> fetchLocations(){
		return locationRepository.findAll();
	}
	
	//Insert new location
	public void store(Location location) {
		locationRepository.save(location);
	}
	
	//Fetch location by id
	public Location fetchLocationDetailsById(int id) {
		return locationRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		locationRepository.deleteById(id);	
	}
	
}
