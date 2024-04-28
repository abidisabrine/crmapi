package de.tekup.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.api.models.User;
import de.tekup.api.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired	
	private UserRepository repository;
	
	public User addUser(User user) { 
		return repository.save(user);
	}
	
	public List<User> findUsers() { 
		return repository.findAll();
	}
	
	public Optional<User> findUser(Long id) { 
		return repository.findById(id);
	}
	
	public User updateUser(User updated) { 
		return repository.save(updated);
	}
	
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}
}
