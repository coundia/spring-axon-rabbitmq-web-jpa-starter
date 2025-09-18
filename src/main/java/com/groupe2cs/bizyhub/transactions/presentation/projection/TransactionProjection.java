package com.groupe2cs.bizyhub.transactions.presentation.projection;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionCreatedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionDeletedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionUpdatedEvent;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
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
@ProcessingGroup("Transaction")
public class TransactionProjection {

	private final TransactionRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(TransactionCreatedEvent event) {
		try {
			Transaction entity = Transaction.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getCode() != null && hasId(event.getCode().value())) {
				entity.setCode(event.getCode().value());
			}
			if (event.getDescription() != null && hasId(event.getDescription().value())) {
				entity.setDescription(event.getDescription().value());
			}
			if (event.getAmount() != null && hasId(event.getAmount().value())) {
				entity.setAmount(event.getAmount().value());
			}
			if (event.getTypeEntry() != null && hasId(event.getTypeEntry().value())) {
				entity.setTypeEntry(event.getTypeEntry().value());
			}
			if (event.getDateTransaction() != null && hasId(event.getDateTransaction().value())) {
				entity.setDateTransaction(event.getDateTransaction().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getEntityName() != null && hasId(event.getEntityName().value())) {
				entity.setEntityName(event.getEntityName().value());
			}
			if (event.getEntityId() != null && hasId(event.getEntityId().value())) {
				entity.setEntityId(event.getEntityId().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getCategory() != null && hasId(event.getCategory().value())) {
				entity.setCategory(event.getCategory().value());
			}
			if (event.getCompany() != null && hasId(event.getCompany().value())) {
				entity.setCompany(event.getCompany().value());
			}
			if (event.getCustomer() != null && hasId(event.getCustomer().value())) {
				entity.setCustomer(event.getCustomer().value());
			}
			if (event.getDebt() != null && hasId(event.getDebt().value())) {
				entity.setDebt(event.getDebt().value());
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


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getCode() != null && hasId(event.getCode().value())) {
				entity.setCode(event.getCode().value());
			}
			if (event.getDescription() != null && hasId(event.getDescription().value())) {
				entity.setDescription(event.getDescription().value());
			}
			if (event.getAmount() != null && hasId(event.getAmount().value())) {
				entity.setAmount(event.getAmount().value());
			}
			if (event.getTypeEntry() != null && hasId(event.getTypeEntry().value())) {
				entity.setTypeEntry(event.getTypeEntry().value());
			}
			if (event.getDateTransaction() != null && hasId(event.getDateTransaction().value())) {
				entity.setDateTransaction(event.getDateTransaction().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getEntityName() != null && hasId(event.getEntityName().value())) {
				entity.setEntityName(event.getEntityName().value());
			}
			if (event.getEntityId() != null && hasId(event.getEntityId().value())) {
				entity.setEntityId(event.getEntityId().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getCategory() != null && hasId(event.getCategory().value())) {
				entity.setCategory(event.getCategory().value());
			}
			if (event.getCompany() != null && hasId(event.getCompany().value())) {
				entity.setCompany(event.getCompany().value());
			}
			if (event.getCustomer() != null && hasId(event.getCustomer().value())) {
				entity.setCustomer(event.getCustomer().value());
			}
			if (event.getDebt() != null && hasId(event.getDebt().value())) {
				entity.setDebt(event.getDebt().value());
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
