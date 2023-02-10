package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import payloads.UserDTO;
import services.UserService;

@Controller
//@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/create")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto){
		System.out.print(userDto);
		UserDTO createUser=userService.createUser(userDto);
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public void getUers() {
		System.out.print("RUNNING");
	}
}
