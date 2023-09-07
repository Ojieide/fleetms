package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.CarMaintenance;
import tech.ojay.fleetms.repositories.CarMaintenanceRepository;

@Service
public class CarMaintenanceService {
	@Autowired
	private CarMaintenanceRepository carMaintenanceRepository;
	
	//Fetch list of carMaintenance
	public List<CarMaintenance> fetchCarMaintenance(){
		return carMaintenanceRepository.findAll();
	}
	
	//Insert new carMaintenance
	public void store(CarMaintenance carMaintenance) {
		carMaintenanceRepository.save(carMaintenance);
	}
	
	//Fetch carMaintenance by id
	public CarMaintenance fetchCarMaintenanceDetailsById(int id) {
		return carMaintenanceRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		carMaintenanceRepository.deleteById(id);	
	}
}
