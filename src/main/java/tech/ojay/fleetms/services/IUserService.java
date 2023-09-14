package tech.ojay.fleetms.services;

import java.util.List;

import tech.ojay.fleetms.models.User;
import tech.ojay.fleetms.models.UserDto;

public interface IUserService {
    
	void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}