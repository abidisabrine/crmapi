package de.tekup.api.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import de.tekup.api.models.Client;
import de.tekup.api.repositories.ClientRepository;
@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepo;

	public Client saveClient(Client client) {
	
		return clientRepo.save(client);
	}
	
	
	public List<Client> findAll(){
		return clientRepo.findAll();
	}


	public void deleteById(Long id) {
		clientRepo.deleteById(id);
	}


	public Optional<Client> findById(Long id) {
		return clientRepo.findById(id);
	}

	

}
