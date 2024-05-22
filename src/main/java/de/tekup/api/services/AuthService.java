package de.tekup.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import de.tekup.api.config.JwtProvider;
import de.tekup.api.models.User;

@Service
public class AuthService {
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public String authenticate(String username, String password) {
		User user=userService.findByUsername(username);
		if (user==null) return null;
		if(!encoder.matches(password, user.getPassword())) return null;
		return jwtProvider.generateToken(user);
		// public User findByUsername(String name);
				// getuser byuser name 
				//if user not found return null
				//if password match password DB user.getpassword
				//return jwt.generateToken
				//else erreur: username or password incorrcete 
		
		
		
	}
	

}
