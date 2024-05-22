package de.tekup.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.tekup.api.models.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>  {
	
	public List<User> findByFullnameContains(String q);
	public User findByUsername(String name);
	
	//public List<User> findByFullnameContainsAndEntrepriseEqual(String q ,Entreprise e );

}
