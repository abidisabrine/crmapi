package de.tekup.api.controlles;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.api.models.Subscription;
import de.tekup.api.models.User;
import de.tekup.api.services.SubsService;

@RestController
@RequestMapping(path = "/subs")
public class SubscriptionController {

	@Autowired
	private SubsService subsService;

	@GetMapping
	public List<Subscription> getAllSubscriptions() {
		return subsService.getAllSubscriptions();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Long id) {
		Optional<Subscription> subscription = subsService.getSubscriptionById(id);
		return subscription.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
		Subscription createdSubscription = subsService.createSubscription(subscription);
		return new ResponseEntity<>(createdSubscription, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Subscription> updateSubscription(@PathVariable Long id,
			@RequestBody Subscription subscription) {
		Subscription updatedSubscription = subsService.updateSubscription(id, subscription);
		return new ResponseEntity<>(updatedSubscription, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
		subsService.deleteSubscription(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}