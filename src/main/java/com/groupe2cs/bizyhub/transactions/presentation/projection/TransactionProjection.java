package com.groupe2cs.bizyhub.transactions.presentation.projection;

import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionCreatedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionDeletedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionUpdatedEvent;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@AllowReplay(value = false)
@Slf4j
@Component
@ProcessingGroup("Transaction")
public class TransactionProjection {

	private final TransactionRepository repository;

	public TransactionProjection(TransactionRepository repository) {
		this.repository = repository;
	}

	@EventHandler
	public void on(TransactionCreatedEvent event) {
		try {
			Transaction entity = Transaction.builder()
					.id(event.getId().value())
					.reference(event.getReference().value())
					.amount(event.getAmount().value())
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}


			repository.save(entity);
			log.info("Transaction inserted: {}", entity);
		} catch (Exception e) {
			log.error("Error saving Transaction: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(TransactionUpdatedEvent event) {
		try {
			Transaction entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("Transaction not found"));

			entity.setId(event.getId().value());
			entity.setReference(event.getReference().value());
			entity.setAmount(event.getAmount().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
			}

			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}

			repository.save(entity);
			log.info("Transaction updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating Transaction: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(TransactionDeletedEvent event) {
		try {
			repository.deleteById(event.getId().value());
			log.info("Transaction deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting Transaction: {}", e.getMessage(), e);
			throw e;
		}
	}
}
