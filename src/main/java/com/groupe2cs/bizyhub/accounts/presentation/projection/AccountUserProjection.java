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
@ProcessingGroup("AccountUser")
public class AccountUserProjection {

private final AccountUserRepository repository;


@EventHandler
public void on(AccountUserCreatedEvent event) {
try {
AccountUser entity = AccountUser.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.name(event.getName() == null ? null : event.getName().value())
  		.account( event.getAccount() == null ? null : new com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account(event.getAccount().value()))
 		.user( event.getUser() == null ? null : new com.groupe2cs.bizyhub.security.infrastructure.entity.User(event.getUser().value()))
		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
 		.username(event.getUsername() == null ? null : event.getUsername().value())
 		.details(event.getDetails() == null ? null : event.getDetails().value())
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


log.info("AccountUser inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving AccountUser: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(AccountUserUpdatedEvent event) {
try {
AccountUser entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("AccountUser not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getName() != null) {
		entity.setName(event.getName().value());
    }

     if(event.getAccount() != null) {
		  entity.setAccount(new com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account(event.getAccount().value()));
	  }

     if(event.getUser() != null) {
		  entity.setUser(new com.groupe2cs.bizyhub.security.infrastructure.entity.User(event.getUser().value()));
	  }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }
	if(event.getUsername() != null) {
		entity.setUsername(event.getUsername().value());
    }
	if(event.getDetails() != null) {
		entity.setDetails(event.getDetails().value());
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


log.info("AccountUser updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating AccountUser: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(AccountUserDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("AccountUser deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting AccountUser: {}", e.getMessage(), e);
throw e;
}
}
}
