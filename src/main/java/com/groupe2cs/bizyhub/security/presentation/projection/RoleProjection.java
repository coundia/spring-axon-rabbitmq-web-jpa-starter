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
@ProcessingGroup("Role")
public class RoleProjection {

private final RoleRepository repository;


@EventHandler
public void on(RoleCreatedEvent event) {
try {
Role entity = Role.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.name(event.getName() == null ? null : event.getName().value())
 .build();

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("Role inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving Role: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(RoleUpdatedEvent event) {
try {
Role entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("Role not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getName() != null) {
		entity.setName(event.getName().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("Role updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Role: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(RoleDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("Role deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Role: {}", e.getMessage(), e);
throw e;
}
}
}
