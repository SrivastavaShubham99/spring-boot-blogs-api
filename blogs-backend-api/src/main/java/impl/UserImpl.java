package impl;

import java.util.List;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.User;
import exceptions.ResourceNotFoundException;
import payloads.UserDTO;
import repositories.UserRepository;
import services.UserService;

@Service
public class UserImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO createUser(UserDTO userDto) {
		User savedUser=userRepository.save(userToDto(userDto));
		return userDTOToUser(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto,Integer id) {
		User user=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setPassword(user.getPassword());
		user.setUserName(userDto.getUserName());
		User updatedUser=this.userRepository.save(user);
		return userDTOToUser(updatedUser);
		}

	@Override
	public UserDTO getUserById(Integer id) {
		User user=this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
		return userDTOToUser(user);
	}

	@Override
	public List<UserDTO> getAllUser(UserDTO user) {
		List<User> usersList=this.userRepository.findAll();
		List<UserDTO> userDtoList=usersList.stream().map(e ->this.userDTOToUser(e)).collect(Collectors.toList());
		return userDtoList;
	}

	@Override
	public void deleteUser(Integer id) {
		this.userRepository.deleteById(id);
	}

	private User userToDto(UserDTO userDto) {
		User user=new User();
		user.setId(userDto.getId());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setUserName(userDto.getUserName());
		return user;
	}
	
	private UserDTO userDTOToUser(User user) {
		UserDTO userDto=new UserDTO();
		userDto.setAbout(user.getAbout());
		userDto.setEmail(user.getEmail());
		userDto.setId(user.getId());
		userDto.setPassword(user.getPassword());
		userDto.setUserName(user.getUserName());
		return userDto;
	}
}
