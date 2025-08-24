package com.groupe2cs.bizyhub.accounts.presentation.projection;

	import com.groupe2cs.bizyhub.accounts.domain.event.*;
	import com.groupe2cs.bizyhub.accounts.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
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
@ProcessingGroup("Account")
public class AccountProjection {

private final AccountRepository repository;


@EventHandler
public void on(AccountCreatedEvent event) {
try {
Account entity = Account.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.code(event.getCode() == null ? null : event.getCode().value())
 		.name(event.getName() == null ? null : event.getName().value())
 		.status(event.getStatus() == null ? null : event.getStatus().value())
 		.currency(event.getCurrency() == null ? null : event.getCurrency().value())
 		.typeAccount(event.getTypeAccount() == null ? null : event.getTypeAccount().value())
 		.balance(event.getBalance() == null ? null : event.getBalance().value())
 		.balancePrev(event.getBalancePrev() == null ? null : event.getBalancePrev().value())
 		.balanceBlocked(event.getBalanceBlocked() == null ? null : event.getBalanceBlocked().value())
 		.balanceInit(event.getBalanceInit() == null ? null : event.getBalanceInit().value())
 		.balanceGoal(event.getBalanceGoal() == null ? null : event.getBalanceGoal().value())
 		.balanceLimit(event.getBalanceLimit() == null ? null : event.getBalanceLimit().value())
 		.description(event.getDescription() == null ? null : event.getDescription().value())
 		.isActive(event.getIsActive() == null ? null : event.getIsActive().value())
 		.isDefault(event.getIsDefault() == null ? null : event.getIsDefault().value())
 		.remoteId(event.getRemoteId() == null ? null : event.getRemoteId().value())
 		.localId(event.getLocalId() == null ? null : event.getLocalId().value())
 		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
 .build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
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


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getCode() != null) {
		entity.setCode(event.getCode().value());
    }
	if(event.getName() != null) {
		entity.setName(event.getName().value());
    }
	if(event.getStatus() != null) {
		entity.setStatus(event.getStatus().value());
    }
	if(event.getCurrency() != null) {
		entity.setCurrency(event.getCurrency().value());
    }
	if(event.getTypeAccount() != null) {
		entity.setTypeAccount(event.getTypeAccount().value());
    }
	if(event.getBalance() != null) {
		entity.setBalance(event.getBalance().value());
    }
	if(event.getBalancePrev() != null) {
		entity.setBalancePrev(event.getBalancePrev().value());
    }
	if(event.getBalanceBlocked() != null) {
		entity.setBalanceBlocked(event.getBalanceBlocked().value());
    }
	if(event.getBalanceInit() != null) {
		entity.setBalanceInit(event.getBalanceInit().value());
    }
	if(event.getBalanceGoal() != null) {
		entity.setBalanceGoal(event.getBalanceGoal().value());
    }
	if(event.getBalanceLimit() != null) {
		entity.setBalanceLimit(event.getBalanceLimit().value());
    }
	if(event.getDescription() != null) {
		entity.setDescription(event.getDescription().value());
    }
	if(event.getIsActive() != null) {
		entity.setIsActive(event.getIsActive().value());
    }
	if(event.getIsDefault() != null) {
		entity.setIsDefault(event.getIsDefault().value());
    }
	if(event.getRemoteId() != null) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getLocalId() != null) {
		entity.setLocalId(event.getLocalId().value());
    }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
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
