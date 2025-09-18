package com.groupe2cs.bizyhub.transactions.presentation.projection;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionUserCreatedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionUserDeletedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionUserUpdatedEvent;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionUser;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AllowReplay(value = false)
@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
@ProcessingGroup("TransactionUser")
public class TransactionUserProjection {

	private final TransactionUserRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(TransactionUserCreatedEvent event) {
		try {
			TransactionUser entity = TransactionUser.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getName() != null && hasId(event.getName().value())) {
				entity.setName(event.getName().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getTransaction() != null && hasId(event.getTransaction().value())) {
				entity.setTransaction(event.getTransaction().value());
			}
			if (event.getUser() != null && hasId(event.getUser().value())) {
				entity.setUser(event.getUser().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getUsername() != null && hasId(event.getUsername().value())) {
				entity.setUsername(event.getUsername().value());
			}
			if (event.getDetails() != null && hasId(event.getDetails().value())) {
				entity.setDetails(event.getDetails().value());
			}
			if (event.getIsActive() != null && hasId(event.getIsActive().value())) {
				entity.setIsActive(event.getIsActive().value());
			}


			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}

				entity.setRemoteId(event.getId().value());



			repository.save(entity);


			log.info("TransactionUser inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving TransactionUser: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(TransactionUserUpdatedEvent event) {
		try {
			TransactionUser entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("TransactionUser not found"));


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getName() != null && hasId(event.getName().value())) {
				entity.setName(event.getName().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getTransaction() != null && hasId(event.getTransaction().value())) {
				entity.setTransaction(event.getTransaction().value());
			}
			if (event.getUser() != null && hasId(event.getUser().value())) {
				entity.setUser(event.getUser().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getUsername() != null && hasId(event.getUsername().value())) {
				entity.setUsername(event.getUsername().value());
			}
			if (event.getDetails() != null && hasId(event.getDetails().value())) {
				entity.setDetails(event.getDetails().value());
			}
			if (event.getIsActive() != null && hasId(event.getIsActive().value())) {
				entity.setIsActive(event.getIsActive().value());
			}

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}

			if (entity.getTenant() == null && event.getTenant() != null) {
				log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}",
						event.getTenant().value());
				entity.setTenant(new Tenant(event.getTenant().value()));
			}

			repository.save(entity);


			log.info("TransactionUser updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating TransactionUser: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(TransactionUserDeletedEvent event) {
		try {


			repository.deleteById(event.getId().value());
			log.info("TransactionUser deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting TransactionUser: {}", e.getMessage(), e);
			throw e;
		}
	}
}
