package de.tekup.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.api.models.Role;
import de.tekup.api.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Optional<Role> findById(Long id) {

		return roleRepository.findById(id);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}
	
	@Override
	public void deleteById(Long id) {
		roleRepository.deleteById(id);

	}
}
