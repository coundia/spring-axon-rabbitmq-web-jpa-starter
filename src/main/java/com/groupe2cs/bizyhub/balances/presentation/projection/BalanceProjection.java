package com.groupe2cs.bizyhub.balances.presentation.projection;

import com.groupe2cs.bizyhub.balances.domain.event.BalanceCreatedEvent;
import com.groupe2cs.bizyhub.balances.domain.event.BalanceDeletedEvent;
import com.groupe2cs.bizyhub.balances.domain.event.BalanceUpdatedEvent;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.Balance;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.BalanceRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@AllowReplay(value = false)
@Slf4j
@Component
@ProcessingGroup("Balance")
public class BalanceProjection {

	private final BalanceRepository repository;

	public BalanceProjection(BalanceRepository repository) {
		this.repository = repository;
	}

	@EventHandler
	public void on(BalanceCreatedEvent event) {
		try {
			Balance entity = Balance.builder()
					.id(event.getId().value())
					.name(event.getName().value())
					.currency(event.getCurrency().value())
					.currentBalance(event.getCurrentBalance().value())
					.previousBalance(event.getPreviousBalance().value())
					.lastUpdated(event.getLastUpdated().value())
					.isDefault(event.getIsDefault().value())
					.ordre(event.getOrdre().value())
					.isArchived(event.getIsArchived().value())
					.isAllowDebit(event.getIsAllowDebit().value())
					.isAllowCredit(event.getIsAllowCredit().value())
					.isExcluTotal(event.getIsExcluTotal().value())
					.activateNotification(event.getActivateNotification().value())
					.syncedAt(event.getSyncedAt().value())
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}


			repository.save(entity);
			log.info("Balance inserted: {}", entity);
		} catch (Exception e) {
			log.error("Error saving Balance: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(BalanceUpdatedEvent event) {
		try {
			Balance entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("Balance not found"));

			entity.setId(event.getId().value());
			entity.setName(event.getName().value());
			entity.setCurrency(event.getCurrency().value());
			entity.setCurrentBalance(event.getCurrentBalance().value());
			entity.setPreviousBalance(event.getPreviousBalance().value());
			entity.setLastUpdated(event.getLastUpdated().value());
			entity.setIsDefault(event.getIsDefault().value());
			entity.setOrdre(event.getOrdre().value());
			entity.setIsArchived(event.getIsArchived().value());
			entity.setIsAllowDebit(event.getIsAllowDebit().value());
			entity.setIsAllowCredit(event.getIsAllowCredit().value());
			entity.setIsExcluTotal(event.getIsExcluTotal().value());
			entity.setActivateNotification(event.getActivateNotification().value());
			entity.setSyncedAt(event.getSyncedAt().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
			}

			if (entity.getTenant() == null && event.getTenant() != null) {
				log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}",
						event.getTenant().value());
				entity.setTenant(new Tenant(event.getTenant().value()));
			}

			repository.save(entity);
			log.info("Balance updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating Balance: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(BalanceDeletedEvent event) {
		try {
			repository.deleteById(event.getId().value());
			log.info("Balance deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting Balance: {}", e.getMessage(), e);
			throw e;
		}
	}
}
