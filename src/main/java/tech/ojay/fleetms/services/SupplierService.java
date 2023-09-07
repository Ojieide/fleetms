package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.Supplier;
import tech.ojay.fleetms.repositories.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;
	
	//Fetch list of suppliers
	public List<Supplier> fetchSuppliers(){
		return supplierRepository.findAll();
	}
	
	//Insert new supplier
	public void store(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	//Fetch supplier by id
	public Supplier fetchSupplierDetailsById(int id) {
		return supplierRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		supplierRepository.deleteById(id);	
	}
}
