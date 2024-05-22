package de.tekup.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import de.tekup.api.models.User;
import de.tekup.api.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public User addUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repository.save(user);
	}

	public List<User> findUsers(String query) {
		return repository.findByFullnameContains(query);
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
	
	public User findByUsername(String name) {
		
		return repository.findByUsername(name);
	}
}
