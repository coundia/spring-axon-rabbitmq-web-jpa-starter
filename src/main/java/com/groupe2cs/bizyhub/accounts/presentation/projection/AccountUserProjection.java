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


private static boolean hasId(Object s) {
    return s != null ;
}


@EventHandler
public void on(AccountUserCreatedEvent event) {
try {
AccountUser entity = AccountUser.builder().build();
		if(event.getId() !=null  && hasId(event.getId().value()) ) {
            entity.setId( event.getId().value());
        }
 		if(event.getAccount() !=null  && hasId(event.getAccount().value()) ) {
            entity.setAccount( event.getAccount().value());
        }
 		if(event.getUser() !=null  && hasId(event.getUser().value()) ) {
            entity.setUser( event.getUser().value());
        }
 		if(event.getIdentity() !=null  && hasId(event.getIdentity().value()) ) {
            entity.setIdentity( event.getIdentity().value());
        }
 		if(event.getPhone() !=null  && hasId(event.getPhone().value()) ) {
            entity.setPhone( event.getPhone().value());
        }
 		if(event.getEmail() !=null  && hasId(event.getEmail().value()) ) {
            entity.setEmail( event.getEmail().value());
        }
 		if(event.getRole() !=null  && hasId(event.getRole().value()) ) {
            entity.setRole( event.getRole().value());
        }
 		if(event.getStatus() !=null  && hasId(event.getStatus().value()) ) {
            entity.setStatus( event.getStatus().value());
        }
 		if(event.getInvitedBy() !=null  && hasId(event.getInvitedBy().value()) ) {
            entity.setInvitedBy( event.getInvitedBy().value());
        }
 		if(event.getSyncAt() !=null  && hasId(event.getSyncAt().value()) ) {
            entity.setSyncAt( event.getSyncAt().value());
        }
 		if(event.getAcceptedAt() !=null  && hasId(event.getAcceptedAt().value()) ) {
            entity.setAcceptedAt( event.getAcceptedAt().value());
        }
 		if(event.getRevokedAt() !=null  && hasId(event.getRevokedAt().value()) ) {
            entity.setRevokedAt( event.getRevokedAt().value());
        }
 		if(event.getMessage() !=null  && hasId(event.getMessage().value()) ) {
            entity.setMessage( event.getMessage().value());
        }
 		if(event.getRemoteId() !=null  && hasId(event.getRemoteId().value()) ) {
            entity.setRemoteId( event.getRemoteId().value());
        }
 		if(event.getLocalId() !=null  && hasId(event.getLocalId().value()) ) {
            entity.setLocalId( event.getLocalId().value());
        }
 		if(event.getIsActive() !=null  && hasId(event.getIsActive().value()) ) {
            entity.setIsActive( event.getIsActive().value());
        }
 

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


	if(event.getId() != null  && hasId(event.getId().value())) {
		entity.setId(event.getId().value());
    }
	if(event.getAccount() != null  && hasId(event.getAccount().value())) {
		entity.setAccount(event.getAccount().value());
    }
	if(event.getUser() != null  && hasId(event.getUser().value())) {
		entity.setUser(event.getUser().value());
    }
	if(event.getIdentity() != null  && hasId(event.getIdentity().value())) {
		entity.setIdentity(event.getIdentity().value());
    }
	if(event.getPhone() != null  && hasId(event.getPhone().value())) {
		entity.setPhone(event.getPhone().value());
    }
	if(event.getEmail() != null  && hasId(event.getEmail().value())) {
		entity.setEmail(event.getEmail().value());
    }
	if(event.getRole() != null  && hasId(event.getRole().value())) {
		entity.setRole(event.getRole().value());
    }
	if(event.getStatus() != null  && hasId(event.getStatus().value())) {
		entity.setStatus(event.getStatus().value());
    }
	if(event.getInvitedBy() != null  && hasId(event.getInvitedBy().value())) {
		entity.setInvitedBy(event.getInvitedBy().value());
    }
	if(event.getSyncAt() != null  && hasId(event.getSyncAt().value())) {
		entity.setSyncAt(event.getSyncAt().value());
    }
	if(event.getAcceptedAt() != null  && hasId(event.getAcceptedAt().value())) {
		entity.setAcceptedAt(event.getAcceptedAt().value());
    }
	if(event.getRevokedAt() != null  && hasId(event.getRevokedAt().value())) {
		entity.setRevokedAt(event.getRevokedAt().value());
    }
	if(event.getMessage() != null  && hasId(event.getMessage().value())) {
		entity.setMessage(event.getMessage().value());
    }
	if(event.getRemoteId() != null  && hasId(event.getRemoteId().value())) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getLocalId() != null  && hasId(event.getLocalId().value())) {
		entity.setLocalId(event.getLocalId().value());
    }
	if(event.getIsActive() != null  && hasId(event.getIsActive().value())) {
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
