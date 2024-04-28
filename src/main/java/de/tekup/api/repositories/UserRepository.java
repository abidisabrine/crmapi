package de.tekup.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.tekup.api.models.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>  {

}
