package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.User;
import tech.ojay.fleetms.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	//Fetch list of users
	public List<User> fetchUsers(){
		return userRepository.findAll();
	}
	
	//Insert new user
	public void store(User user) {
		userRepository.save(user);
	}
}
