package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.InvoiceStatus;
import tech.ojay.fleetms.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {
	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	//Fetch list of InvoiceStatus
	public List<InvoiceStatus> fetchInvoiceStatus(){
		return invoiceStatusRepository.findAll();
	}
	
	//Insert new InvoiceStatus
	public void store(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}
	
	//Fetch InvoiceStatus by id
	public InvoiceStatus fetchInvoiceStatusDetailsById(int id) {
		return invoiceStatusRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		invoiceStatusRepository.deleteById(id);	
	}
}
