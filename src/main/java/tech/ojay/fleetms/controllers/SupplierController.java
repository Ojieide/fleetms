package tech.ojay.fleetms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplierController {
	//Display the supplier page
	@GetMapping("/suppliers")
	public String fetchSupplier() {
		return "supplier";
	}
}
