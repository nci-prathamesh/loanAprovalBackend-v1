package com.cloud.loanApproval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.loanApproval.exception.UserNotFoundException;
import com.cloud.loanApproval.model.User;
import com.cloud.loanApproval.repository.UserRepository;

@RestController
@RequestMapping(value = {"/user"})
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/user")
	User newUser(@RequestBody User newUser) {
	//	System.out.println(newUser);
		return userRepository.save(newUser);
	}

	@GetMapping("/users")
	List<User> getAllUsers() {
		return userRepository.findAll();

	}
	
	@GetMapping("/demo")
	String getDemo() {
		return "hiiii";

	}

	@GetMapping("/login/{userId}/{password}")
	User getUserLogin(@PathVariable String userId, @PathVariable String password) {
		System.out.println("id : "+userId+"  pw : "+password);
		System.out.println(userRepository.findByUserIdAndPassword(userId,password).getUserFirstName());
		return userRepository.findByUserIdAndPassword(userId,password);
	}

	@GetMapping("/useridExist/{userId}")
	User getUserByUserId(@PathVariable String userId) {
		System.out.println(userId);
//		 System.out.println( "eeeeeeeee  "+userRepository.findByUserId(userid).getUserId());
		 return userRepository.findByUserId(userId);
	}
	
	@GetMapping("/user/{id}")
	User getUserById(@PathVariable Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@PutMapping("/user/{id}")
	User updateUser(@RequestBody User newUser, @PathVariable Long id) {
		return userRepository.findById(id).map(user -> {
			user.setUserFirstName(newUser.getUserFirstName());
			user.setUserMiddleName(newUser.getUserMiddleName());
			user.setUserLastName(newUser.getUserLastName());
			user.setUserName(newUser.getUserName());
			user.setPassword(newUser.getPassword());
			return userRepository.save(user);
		}).orElseThrow(() -> new UserNotFoundException(id));
	}

	@DeleteMapping("/user/{id}")
	String deleteUserById(@PathVariable Long id) {
		if (!userRepository.existsById(id)) {
			throw new UserNotFoundException(id);
		}

		userRepository.deleteById(id);
		return "User with id " + id + " has been deleted";
	}
}
