package de.tekup.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import de.tekup.api.models.Subscription;
import de.tekup.api.models.User;
import de.tekup.api.repositories.SubsRepo;

@Service
public class SubsService {

	@Autowired
	private SubsRepo subsRepo;

	public List<Subscription> getAllSubscriptions() {
		return subsRepo.findAll();
	}

	public Optional<Subscription> getSubscriptionById(Long id) {
		return subsRepo.findById(id);
	}

	public Subscription createSubscription(Subscription subscription) {
		return subsRepo.save(subscription);
	}

	public Subscription updateSubscription(Long id, Subscription subscription) {
		if (subsRepo.existsById(id)) {
			subscription.setId(id);
			return subsRepo.save(subscription);
		} else {
			throw new RuntimeException("Subscription not found with id: " + id);
		}
	}

	public void deleteSubscription(Long id) {
		subsRepo.deleteById(id);
	}

}