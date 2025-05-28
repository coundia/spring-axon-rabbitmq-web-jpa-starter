package com.groupe2cs.bizyhub.tenant.presentation.projection;

	import com.groupe2cs.bizyhub.tenant.domain.event.*;
	import com.groupe2cs.bizyhub.tenant.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.*;
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
@ProcessingGroup("Tenant")
public class TenantProjection {

private final TenantRepository repository;


@EventHandler
public void on(TenantCreatedEvent event) {
try {
Tenant entity = Tenant.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.name(event.getName() == null ? null : event.getName().value())
 		.description(event.getDescription() == null ? null : event.getDescription().value())
 		.domain(event.getDomain() == null ? null : event.getDomain().value())
 		.language(event.getLanguage() == null ? null : event.getLanguage().value())
 		.active(event.getActive() == null ? null : event.getActive().value())
 .build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("Tenant inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving Tenant: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(TenantUpdatedEvent event) {
try {
Tenant entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("Tenant not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getName() != null) {
		entity.setName(event.getName().value());
    }
	if(event.getDescription() != null) {
		entity.setDescription(event.getDescription().value());
    }
	if(event.getDomain() != null) {
		entity.setDomain(event.getDomain().value());
    }
	if(event.getLanguage() != null) {
		entity.setLanguage(event.getLanguage().value());
    }
	if(event.getActive() != null) {
		entity.setActive(event.getActive().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("Tenant updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Tenant: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(TenantDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("Tenant deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Tenant: {}", e.getMessage(), e);
throw e;
}
}
}
