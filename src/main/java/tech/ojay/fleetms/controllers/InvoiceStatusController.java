package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceStatusController {
	//Display the invoice status page
	@GetMapping("/invoicestatus")
	public String fetchInvoiceStatus() {
		return "invoicestatus";
	}
}
