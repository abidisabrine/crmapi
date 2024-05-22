package de.tekup.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.tekup.api.models.Role;

public interface RoleService {

	Role saveRole(Role role);

	Optional<Role> findById(Long id);

	List<Role> findAll();

	void deleteById(Long id);
}
