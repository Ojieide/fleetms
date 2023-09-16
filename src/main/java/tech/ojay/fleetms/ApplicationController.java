package tech.ojay.fleetms;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import tech.ojay.fleetms.models.User;
import tech.ojay.fleetms.models.UserDto;
import tech.ojay.fleetms.services.IUserService;

@Controller
public class ApplicationController {
	
    private IUserService userService;

    public ApplicationController(IUserService userService) {
        this.userService = userService;
    }
	
	//handler method to handle index page
	@GetMapping("/index")
	public String fetchIndex() {
		return "index";
	}
	
    // handler method to handle registration and login page request
    @GetMapping("/index2")
    public String home(){
        return "index2";
    }
    
    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }
    
    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
    
    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    
    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
