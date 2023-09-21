package tech.ojay.fleetms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tech.ojay.fleetms.models.User;
import tech.ojay.fleetms.repositories.UserRepository;
import tech.ojay.fleetms.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/users/insertNew")
	public String insertNew(User user) {
		userService.store(user);
		return "redirect:/users";
	}
	
	@RequestMapping("/users/fetchUserById/{id}")
	@ResponseBody
	public User getById(@PathVariable Long id) {
		return userService.fetchUserDetailsById(id);
	}
	
	@RequestMapping(value="/users/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(User user) {
		userService.store(user);
		return "redirect:/users";
	}
	
	@RequestMapping(value="/users/deleteUserById/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Long id) {
		userService.delete(id);
		return "redirect:/users";
	}
	
	@RequestMapping("/users/{email}")
    public String dashboardPageList(Model model, @AuthenticationPrincipal UserDetails currentUser ) {
    User user = (User) userRepository.findByEmail(currentUser.getUsername());
        model.addAttribute("users", user);

        return "users";
    }
}
