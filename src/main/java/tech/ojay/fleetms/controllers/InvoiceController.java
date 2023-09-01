package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceController {
	//Display the invoice page
	@GetMapping("/invoices")
	public String fetchInvoices() {
		return "invoice";
	}
}
