package de.tekup.api.repositories;

import java.util.List;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.tekup.api.models.Subscription;
@Repository

public interface SubsRepo extends JpaRepository<Subscription, Long>{

	
	 

}
