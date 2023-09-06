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

import tech.ojay.fleetms.models.InvoiceStatus;
import tech.ojay.fleetms.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	//Fetch All InvoiceStatuss
	@GetMapping("/invoicestatus")
	public String fetchInvoiceStatuss(Model model){
		
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.fetchInvoiceStatus();
		model.addAttribute("invoicestatus", invoiceStatusList);
		
		return "invoicestatus";
	}
	
	@PostMapping("/invoicestatus/insertNew")
	public String insertNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.store(invoiceStatus);
		return "redirect:/invoicestatus";
	}
	
	@RequestMapping("/invoicestatus/fetchInvoiceStatusById/{id}")
	@ResponseBody
	public InvoiceStatus getById(@PathVariable int id) {
		return invoiceStatusService.fetchInvoiceStatusDetailsById(id);
	}
	
	@RequestMapping(value="/invoicestatus/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.store(invoiceStatus);
		return "redirect:/invoicestatus";
	}
	
	@RequestMapping(value="/invoicestatus/deleteInvoiceStatusById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable int id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoicestatus";
	}
}
