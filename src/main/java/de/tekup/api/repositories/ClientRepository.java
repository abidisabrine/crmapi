package de.tekup.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.tekup.api.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}
