package de.tekup.api.controlles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.api.models.User;
import de.tekup.api.repositories.UserRepository;


@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping 
	public ResponseEntity<List<User>> findUsers() {
		return new ResponseEntity(repository.findAll(), HttpStatus.OK) ;
	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity(repository.save(user), HttpStatus.CREATED) ;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> findUser(@PathVariable("id") Long id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty()) return new ResponseEntity(HttpStatus.NOT_FOUND);
		return new ResponseEntity(user.get(), HttpStatus.OK) ;
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id,
			@RequestBody User updated) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty()) return new ResponseEntity(HttpStatus.NOT_FOUND);
		user.get().setFirstname(updated.getFirstname());
		// TODO : complete update logic 
		repository.save(user.get());
		return new ResponseEntity(user.get(), HttpStatus.OK) ;
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
		if (!repository.existsById(id))
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		repository.deleteById(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);	
	}
	
}
