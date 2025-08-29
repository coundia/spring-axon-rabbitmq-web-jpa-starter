package com.groupe2cs.bizyhub.debts.presentation.projection;

import com.groupe2cs.bizyhub.debts.domain.event.DebtCreatedEvent;
import com.groupe2cs.bizyhub.debts.domain.event.DebtDeletedEvent;
import com.groupe2cs.bizyhub.debts.domain.event.DebtUpdatedEvent;
import com.groupe2cs.bizyhub.debts.infrastructure.entity.Debt;
import com.groupe2cs.bizyhub.debts.infrastructure.repository.DebtRepository;
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
@ProcessingGroup("Debt")
public class DebtProjection {

	private final DebtRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(DebtCreatedEvent event) {
		try {
			Debt entity = Debt.builder().build();
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
			if (event.getNotes() != null && hasId(event.getNotes().value())) {
				entity.setNotes(event.getNotes().value());
			}
			if (event.getBalance() != null && hasId(event.getBalance().value())) {
				entity.setBalance(event.getBalance().value());
			}
			if (event.getBalanceDebt() != null && hasId(event.getBalanceDebt().value())) {
				entity.setBalanceDebt(event.getBalanceDebt().value());
			}
			if (event.getDueDate() != null && hasId(event.getDueDate().value())) {
				entity.setDueDate(event.getDueDate().value());
			}
			if (event.getStatuses() != null && hasId(event.getStatuses().value())) {
				entity.setStatuses(event.getStatuses().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getCustomer() != null && hasId(event.getCustomer().value())) {
				entity.setCustomer(event.getCustomer().value());
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


			repository.save(entity);


			log.info("Debt inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving Debt: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(DebtUpdatedEvent event) {
		try {
			Debt entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("Debt not found"));


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
			if (event.getNotes() != null && hasId(event.getNotes().value())) {
				entity.setNotes(event.getNotes().value());
			}
			if (event.getBalance() != null && hasId(event.getBalance().value())) {
				entity.setBalance(event.getBalance().value());
			}
			if (event.getBalanceDebt() != null && hasId(event.getBalanceDebt().value())) {
				entity.setBalanceDebt(event.getBalanceDebt().value());
			}
			if (event.getDueDate() != null && hasId(event.getDueDate().value())) {
				entity.setDueDate(event.getDueDate().value());
			}
			if (event.getStatuses() != null && hasId(event.getStatuses().value())) {
				entity.setStatuses(event.getStatuses().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getCustomer() != null && hasId(event.getCustomer().value())) {
				entity.setCustomer(event.getCustomer().value());
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


			log.info("Debt updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating Debt: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(DebtDeletedEvent event) {
		try {


			repository.deleteById(event.getId().value());
			log.info("Debt deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting Debt: {}", e.getMessage(), e);
			throw e;
		}
	}
}
