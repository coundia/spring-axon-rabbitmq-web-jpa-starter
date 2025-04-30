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
					.amount(event.getAmount().value())
					.dateOperation(event.getDateOperation().value())
					.description(event.getDescription().value())
					.reference(event.getReference().value())
					.isRecurring(event.getIsRecurring().value())
					.isExcluToRapport(event.getIsExcluToRapport().value())
					.status(event.getStatus().value())
					.balance(new com.groupe2cs.bizyhub.balances.infrastructure.entity.Balance(event.getBalance()
							.value()))
					.category(new com.groupe2cs.bizyhub.categories.infrastructure.entity.Category(event.getCategory()
							.value()))
					.updatedAt(event.getUpdatedAt().value())
					.createdAt(event.getCreatedAt().value())
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
			entity.setAmount(event.getAmount().value());
			entity.setDateOperation(event.getDateOperation().value());
			entity.setDescription(event.getDescription().value());
			entity.setReference(event.getReference().value());
			entity.setIsRecurring(event.getIsRecurring().value());
			entity.setIsExcluToRapport(event.getIsExcluToRapport().value());
			entity.setStatus(event.getStatus().value());
			entity.setBalance(new com.groupe2cs.bizyhub.balances.infrastructure.entity.Balance(event.getBalance()
					.value()));
			entity.setCategory(new com.groupe2cs.bizyhub.categories.infrastructure.entity.Category(event.getCategory()
					.value()));
			entity.setUpdatedAt(event.getUpdatedAt().value());
			entity.setCreatedAt(event.getCreatedAt().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
			}

			if (entity.getTenant() == null && event.getTenant() != null) {
				log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}",
						event.getTenant().value());
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
