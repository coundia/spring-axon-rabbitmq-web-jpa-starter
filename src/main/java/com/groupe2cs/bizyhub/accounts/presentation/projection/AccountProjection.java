package com.groupe2cs.bizyhub.accounts.presentation.projection;

import com.groupe2cs.bizyhub.accounts.domain.event.AccountCreatedEvent;
import com.groupe2cs.bizyhub.accounts.domain.event.AccountDeletedEvent;
import com.groupe2cs.bizyhub.accounts.domain.event.AccountUpdatedEvent;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
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
@ProcessingGroup("Account")
public class AccountProjection {

	private final AccountRepository repository;


	@EventHandler
	public void on(AccountCreatedEvent event) {
		try {
			Account entity = Account.builder()
					.id(event.getId() == null ? null : event.getId().value())
					.name(event.getName() == null ? null : event.getName().value())
					.currency(event.getCurrency() == null ? null : event.getCurrency().value())
					.currentBalance(event.getCurrentBalance() == null ? null : event.getCurrentBalance().value())
					.previousBalance(event.getPreviousBalance() == null ? null : event.getPreviousBalance().value())
					.details(event.getDetails() == null ? null : event.getDetails().value())
					.isActive(event.getIsActive() == null ? null : event.getIsActive().value())
					.updatedAt(event.getUpdatedAt() == null ? null : event.getUpdatedAt().value())
					.reference(event.getReference() == null ? null : event.getReference().value())
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}


			repository.save(entity);


			log.info("Account inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving Account: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(AccountUpdatedEvent event) {
		try {
			Account entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("Account not found"));


			entity.setId(event.getId().value());
			entity.setName(event.getName().value());
			entity.setCurrency(event.getCurrency().value());
			entity.setCurrentBalance(event.getCurrentBalance().value());
			entity.setPreviousBalance(event.getPreviousBalance().value());
			entity.setDetails(event.getDetails().value());
			entity.setIsActive(event.getIsActive().value());
			entity.setUpdatedAt(event.getUpdatedAt().value());
			entity.setReference(event.getReference().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}

			if (entity.getTenant() == null && event.getTenant() != null) {
				log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}",
						event.getTenant().value());
				entity.setTenant(new Tenant(event.getTenant().value()));
			}

			repository.save(entity);


			log.info("Account updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating Account: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(AccountDeletedEvent event) {
		try {


			repository.deleteById(event.getId().value());
			log.info("Account deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting Account: {}", e.getMessage(), e);
			throw e;
		}
	}
}
