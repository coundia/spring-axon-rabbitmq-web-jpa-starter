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

@AllowReplay(value = false)
@Slf4j
@Component
@ProcessingGroup("RolePermission")
public class RolePermissionProjection {

private final RolePermissionRepository repository;

public RolePermissionProjection(RolePermissionRepository repository) {
this.repository = repository;
}

@EventHandler
public void on(RolePermissionCreatedEvent event) {
try {
RolePermission entity = RolePermission.builder()
		.id(event.getId().value())
  		.role(new Role(event.getRole().value()))
 		.permission(new Permission(event.getPermission().value()))
.build();

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);
log.info("RolePermission inserted: {}", entity);
} catch (Exception e) {
log.error("Error saving RolePermission: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(RolePermissionUpdatedEvent event) {
try {
RolePermission entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("RolePermission not found"));

		entity.setId(event.getId().value());
		entity.setRole(new Role(event.getRole().value()));
		entity.setPermission(new Permission(event.getPermission().value()));

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);
log.info("RolePermission updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating RolePermission: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(RolePermissionDeletedEvent event) {
try {
repository.deleteById(event.getId().value());
log.info("RolePermission deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting RolePermission: {}", e.getMessage(), e);
throw e;
}
}
}
