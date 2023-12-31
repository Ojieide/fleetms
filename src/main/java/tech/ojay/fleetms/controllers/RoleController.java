package tech.ojay.fleetms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tech.ojay.fleetms.models.Role;
import tech.ojay.fleetms.services.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	//Fetch All Roles
	@GetMapping("/roles")
	public String fetchRoles(Model model){
		
		List<Role> roleList = roleService.fetchRoles();
		model.addAttribute("roles", roleList);
		
		return "role";
	}
	
	@PostMapping("/roles/insertNew")
	public String insertNew(Role role) {
		roleService.store(role);
		return "redirect:/roles";
	}
	
	@RequestMapping(value="/roles/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(Role role) {
		roleService.store(role);
		return "redirect:/roles";
	}
}
