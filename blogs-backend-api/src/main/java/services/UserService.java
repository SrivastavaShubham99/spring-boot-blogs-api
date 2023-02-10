package services;

import java.util.List;
import org.springframework.stereotype.Service;
import payloads.UserDTO;

@Service
public interface UserService {

	UserDTO createUser(UserDTO user);
	UserDTO updateUser(UserDTO user,Integer id);
	UserDTO getUserById(Integer user);
	List<UserDTO> getAllUser(UserDTO user);
	void deleteUser(Integer id);
}
