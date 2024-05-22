package de.tekup.api.controlles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.api.models.User;
import de.tekup.api.repositories.UserRepository;
import de.tekup.api.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findUsers(@RequestParam("q") String q) {
		return new ResponseEntity(userService.findUsers(q), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody @Valid User user) {
		return new ResponseEntity(userService.addUser(user), HttpStatus.CREATED);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<User> findUser(@PathVariable("id") Long id) {
		Optional<User> user = userService.findUser(id);
		if (user.isEmpty())
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		return new ResponseEntity(user.get(), HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody @Valid User updated) {
		Optional<User> user = userService.findUser(id);
		if (user.isEmpty())
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		user.get().setFullname(updated.getFullname());
		// TODO : complete update logic
		userService.updateUser(user.get());
		return new ResponseEntity(user.get(), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
		if (userService.findUser(id) == null)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		userService.deleteUser(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
