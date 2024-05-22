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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.api.models.Role;
import de.tekup.api.models.User;
import de.tekup.api.services.RoleService;


@RestController
@RequestMapping(path="/roles")
public class RoleController {
	
	@Autowired
	private RoleService service;
	
	@GetMapping
	public ResponseEntity<List<Role>> getRoles() {
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Role> addRole(@RequestBody Role role) {
		return new ResponseEntity(service.saveRole(role), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletRole(@PathVariable Long id) {
		service.deleteById(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role updated){
	    Role role=service.findById(id).get();
	    if(role==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
	    role.setName(updated.getName());
	    service.saveRole(role);
	    return new ResponseEntity<Role>(role, HttpStatus.CREATED);
	}
	


}
