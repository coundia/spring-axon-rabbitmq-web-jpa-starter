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


	@EventHandler
	public void on(TransactionUserCreatedEvent event) {
		try {
			TransactionUser entity = TransactionUser.builder()
					.id(event.getId() == null ? null : event.getId().value())
					.name(event.getName() == null ? null : event.getName().value())
					.transaction(event.getTransaction() == null ?
							null :
							new com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction(event.getTransaction()
									.value()))
					.user(event.getUser() == null ?
							null :
							new com.groupe2cs.bizyhub.security.infrastructure.entity.User(event.getUser().value()))
					.username(event.getUsername() == null ? null : event.getUsername().value())
					.details(event.getDetails() == null ? null : event.getDetails().value())
					.isActive(event.getIsActive() == null ? null : event.getIsActive().value())
					.build();

			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}


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


			if (event.getId() != null) {
				entity.setId(event.getId().value());
			}
			if (event.getName() != null) {
				entity.setName(event.getName().value());
			}

			if (event.getTransaction() != null) {
				entity.setTransaction(new com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction(event.getTransaction()
						.value()));
			}

			if (event.getUser() != null) {
				entity.setUser(new com.groupe2cs.bizyhub.security.infrastructure.entity.User(event.getUser().value()));
			}
			if (event.getUsername() != null) {
				entity.setUsername(event.getUsername().value());
			}
			if (event.getDetails() != null) {
				entity.setDetails(event.getDetails().value());
			}
			if (event.getIsActive() != null) {
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
