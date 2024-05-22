package de.tekup.api.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.api.models.Role;
import de.tekup.api.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	
	@Autowired
	public AuthService authService;
	
	@GetMapping
	public ResponseEntity<String> login(@RequestParam String username,
			@RequestParam String password) {
		String token=authService.authenticate(username,password);
		if (token==null) return new ResponseEntity("bad credentials", HttpStatus.BAD_REQUEST);
		return new ResponseEntity(token, HttpStatus.OK);
	}


}
