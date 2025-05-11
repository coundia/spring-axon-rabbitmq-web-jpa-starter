package com.groupe2cs.bizyhub.balances.presentation.projection;

	import com.groupe2cs.bizyhub.balances.domain.event.*;
	import com.groupe2cs.bizyhub.balances.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.balances.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
	import org.axonframework.eventhandling.EventHandler;

import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.config.ProcessingGroup;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@AllowReplay(value = false)
@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
@ProcessingGroup("Balance")
public class BalanceProjection {

private final BalanceRepository repository;


@EventHandler
public void on(BalanceCreatedEvent event) {
try {
Balance entity = Balance.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.name(event.getName() == null ? null : event.getName().value())
 		.currency(event.getCurrency() == null ? null : event.getCurrency().value())
 		.currentBalance(event.getCurrentBalance() == null ? null : event.getCurrentBalance().value())
 		.previousBalance(event.getPreviousBalance() == null ? null : event.getPreviousBalance().value())
 		.lastUpdated(event.getLastUpdated() == null ? null : event.getLastUpdated().value())
 		.isDefault(event.getIsDefault() == null ? null : event.getIsDefault().value())
 		.ordre(event.getOrdre() == null ? null : event.getOrdre().value())
 		.isArchived(event.getIsArchived() == null ? null : event.getIsArchived().value())
 		.isAllowDebit(event.getIsAllowDebit() == null ? null : event.getIsAllowDebit().value())
 		.isAllowCredit(event.getIsAllowCredit() == null ? null : event.getIsAllowCredit().value())
 		.isExcluTotal(event.getIsExcluTotal() == null ? null : event.getIsExcluTotal().value())
 		.activateNotification(event.getActivateNotification() == null ? null : event.getActivateNotification().value())
 		.syncedAt(event.getSyncedAt() == null ? null : event.getSyncedAt().value())
 		.updatedAt(event.getUpdatedAt() == null ? null : event.getUpdatedAt().value())
 		.reference(event.getReference() == null ? null : event.getReference().value())
 .build();

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
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
		entity.setUpdatedAt(event.getUpdatedAt().value());
		entity.setReference(event.getReference().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
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
