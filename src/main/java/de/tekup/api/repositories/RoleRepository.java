package de.tekup.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryNameSpaceHandler;
import org.springframework.stereotype.Repository;

import de.tekup.api.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
