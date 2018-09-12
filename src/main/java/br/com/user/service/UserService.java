package br.com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.user.model.User;

@Component
public class UserService {
	
	@Autowired 
	private UserRepository userRepository;

	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	public User findUserById(Integer id) {
		
		return userRepository.findById(id).get();
	}

	public User addUser(User user) {
		
		return userRepository.save(user);
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

	public void deleteById(User user) {
		userRepository.delete(user);
	}
}