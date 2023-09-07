package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.Invoice;
import tech.ojay.fleetms.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	//Fetch list of invoices
	public List<Invoice> fetchInvoices(){
		return invoiceRepository.findAll();
	}
	
	//Insert new invoice
	public void store(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	//Fetch invoice by id
	public Invoice fetchInvoiceDetailsById(int id) {
		return invoiceRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		invoiceRepository.deleteById(id);	
	}
}
