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
import tech.ojay.fleetms.models.Invoice;
import tech.ojay.fleetms.models.InvoiceStatus;
import tech.ojay.fleetms.services.ClientService;
import tech.ojay.fleetms.services.InvoiceService;
import tech.ojay.fleetms.services.InvoiceStatusService;

@Controller
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@Autowired
	private ClientService clientService;
	
	//Fetch All Invoices
	@GetMapping("/invoices")
	public String fetchInvoices(Model model){
		
		List<Invoice> invoiceList = invoiceService.fetchInvoices();
		model.addAttribute("invoices", invoiceList);
		
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.fetchInvoiceStatus();
		model.addAttribute("invoicestatus", invoiceStatusList);
		
		List<Client> clientList = clientService.fetchClients();
		model.addAttribute("clients", clientList);
		
		return "invoice";
	}
	
	@PostMapping("/invoices/insertNew")
	public String insertNew(Invoice invoice) {
		invoiceService.store(invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping("/invoices/fetchInvoiceById/{id}")
	@ResponseBody
	public Invoice getById(@PathVariable int id) {
		return invoiceService.fetchInvoiceDetailsById(id);
	}
	
	@RequestMapping(value="/invoices/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(Invoice invoice) {
		invoiceService.store(invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping(value="/invoices/deleteInvoiceById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		invoiceService.delete(id);
		return "redirect:/invoices";
	}
}
