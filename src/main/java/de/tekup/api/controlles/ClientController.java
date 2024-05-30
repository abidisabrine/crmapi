package de.tekup.api.controlles;

import java.util.List;

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

import de.tekup.api.models.Client;
import de.tekup.api.models.Role;
import de.tekup.api.services.ClientService;

@RestController
@RequestMapping(path="/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public ResponseEntity<List<Client>> getClients(){
		return new ResponseEntity(clientService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Client> addClient(@RequestBody Client client){
		return new ResponseEntity(clientService.saveClient(client),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteClient(@PathVariable Long id){
		clientService.deleteById(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id,@RequestBody Client updated){
		 Client client=clientService.findById(id).get();
		    if(client==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
		    client.setName(updated.getName());
		    clientService.saveClient(client);
		    return new ResponseEntity<Client>(client, HttpStatus.CREATED);
	}
	
	
	

}
