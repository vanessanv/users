package br.com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.user.model.User;
import br.com.user.service.UserService;

@Controller   
@RequestMapping(path="/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/find/{id}")
	public @ResponseBody User findUserById(@PathVariable Integer id) {
		return userService.findUserById(id);
	}
	
	@GetMapping("/all")
	public @ResponseBody List<User> findAllUsers() {
		return userService.findAllUsers();
	}
	
	@PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String insertUser(@RequestBody User user) {
		userService.addUser(user);
		return "New User Saved";
	}
	
	@PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return "User Updated:" + user.getName();
	}
	
	@DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteUser(@RequestBody User user) {
		userService.deleteById(user);
		return "User Deleted:" + user.getId();
	}
}