package com.groupe2cs.bizyhub.debts.presentation.projection;

	import com.groupe2cs.bizyhub.debts.domain.event.*;
	import com.groupe2cs.bizyhub.debts.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.debts.infrastructure.entity.*;
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
@ProcessingGroup("Debt")
public class DebtProjection {

private final DebtRepository repository;


@EventHandler
public void on(DebtCreatedEvent event) {
try {
Debt entity = Debt.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.remoteId(event.getRemoteId() == null ? null : event.getRemoteId().value())
 		.code(event.getCode() == null ? null : event.getCode().value())
 		.notes(event.getNotes() == null ? null : event.getNotes().value())
 		.balance(event.getBalance() == null ? null : event.getBalance().value())
 		.balanceDebt(event.getBalanceDebt() == null ? null : event.getBalanceDebt().value())
 		.dueDate(event.getDueDate() == null ? null : event.getDueDate().value())
 		.statuses(event.getStatuses() == null ? null : event.getStatuses().value())
 		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
  		.customer( event.getCustomer() == null ? null : new com.groupe2cs.bizyhub.customers.infrastructure.entity.Customer(event.getCustomer().value()))
		.isActive(event.getIsActive() == null ? null : event.getIsActive().value())
 .build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
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


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getRemoteId() != null) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getCode() != null) {
		entity.setCode(event.getCode().value());
    }
	if(event.getNotes() != null) {
		entity.setNotes(event.getNotes().value());
    }
	if(event.getBalance() != null) {
		entity.setBalance(event.getBalance().value());
    }
	if(event.getBalanceDebt() != null) {
		entity.setBalanceDebt(event.getBalanceDebt().value());
    }
	if(event.getDueDate() != null) {
		entity.setDueDate(event.getDueDate().value());
    }
	if(event.getStatuses() != null) {
		entity.setStatuses(event.getStatuses().value());
    }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }

     if(event.getCustomer() != null) {
		  entity.setCustomer(new com.groupe2cs.bizyhub.customers.infrastructure.entity.Customer(event.getCustomer().value()));
	  }
	if(event.getIsActive() != null) {
		entity.setIsActive(event.getIsActive().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
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
