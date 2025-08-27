package com.groupe2cs.bizyhub.security.presentation.projection;

	import com.groupe2cs.bizyhub.security.domain.event.*;
	import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
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
@ProcessingGroup("PasswordReset")
public class PasswordResetProjection {

private final PasswordResetRepository repository;


private static boolean hasId(Object s) {
    return s != null ;
}


@EventHandler
public void on(PasswordResetCreatedEvent event) {
try {
PasswordReset entity = PasswordReset.builder().build();
		if(event.getId() !=null  && hasId(event.getId().value()) ) {
            entity.setId( event.getId().value());
        }
 		if(event.getToken() !=null  && hasId(event.getToken().value()) ) {
            entity.setToken( event.getToken().value());
        }
 		if(event.getUsername() !=null  && hasId(event.getUsername().value()) ) {
            entity.setUsername( event.getUsername().value());
        }
 		if(event.getExpiration() !=null  && hasId(event.getExpiration().value()) ) {
            entity.setExpiration( event.getExpiration().value());
        }
 

    entity.setId(event.getId().value());

    if(event.getCreatedBy() !=null){
        entity.setCreatedBy( new User(event.getCreatedBy().value()));
    }
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("PasswordReset inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving PasswordReset: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(PasswordResetUpdatedEvent event) {
try {
PasswordReset entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("PasswordReset not found"));


	if(event.getId() != null  && hasId(event.getId().value())) {
		entity.setId(event.getId().value());
    }
	if(event.getToken() != null  && hasId(event.getToken().value())) {
		entity.setToken(event.getToken().value());
    }
	if(event.getUsername() != null  && hasId(event.getUsername().value())) {
		entity.setUsername(event.getUsername().value());
    }
	if(event.getExpiration() != null  && hasId(event.getExpiration().value())) {
		entity.setExpiration(event.getExpiration().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("PasswordReset updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating PasswordReset: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(PasswordResetDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("PasswordReset deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting PasswordReset: {}", e.getMessage(), e);
throw e;
}
}
}
