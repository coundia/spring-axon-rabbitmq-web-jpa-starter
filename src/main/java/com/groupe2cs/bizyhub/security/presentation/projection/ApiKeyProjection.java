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
@ProcessingGroup("ApiKey")
public class ApiKeyProjection {

private final ApiKeyRepository repository;


private static boolean hasId(Object s) {
    return s != null ;
}


@EventHandler
public void on(ApiKeyCreatedEvent event) {
try {
ApiKey entity = ApiKey.builder().build();
		if(event.getId() !=null  && hasId(event.getId().value()) ) {
            entity.setId( event.getId().value());
        }
 		if(event.getAppKey() !=null  && hasId(event.getAppKey().value()) ) {
            entity.setAppKey( event.getAppKey().value());
        }
 		if(event.getUsername() !=null  && hasId(event.getUsername().value()) ) {
            entity.setUsername( event.getUsername().value());
        }
 		if(event.getActive() !=null  && hasId(event.getActive().value()) ) {
            entity.setActive( event.getActive().value());
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


log.info("ApiKey inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving ApiKey: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(ApiKeyUpdatedEvent event) {
try {
ApiKey entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("ApiKey not found"));


	if(event.getId() != null  && hasId(event.getId().value())) {
		entity.setId(event.getId().value());
    }
	if(event.getAppKey() != null  && hasId(event.getAppKey().value())) {
		entity.setAppKey(event.getAppKey().value());
    }
	if(event.getUsername() != null  && hasId(event.getUsername().value())) {
		entity.setUsername(event.getUsername().value());
    }
	if(event.getActive() != null  && hasId(event.getActive().value())) {
		entity.setActive(event.getActive().value());
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


log.info("ApiKey updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating ApiKey: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(ApiKeyDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("ApiKey deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting ApiKey: {}", e.getMessage(), e);
throw e;
}
}
}
