package com.groupe2cs.bizyhub.security.presentation.projection;

	import com.groupe2cs.bizyhub.security.domain.event.*;
	import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
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
@ProcessingGroup("Permission")
public class PermissionProjection {

private final PermissionRepository repository;

public PermissionProjection(PermissionRepository repository) {
this.repository = repository;
}

@EventHandler
public void on(PermissionCreatedEvent event) {
try {
Permission entity = Permission.builder()
		.id(event.getId().value())
 		.name(event.getName().value())
 .build();

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new CustomUser(event.getCreatedBy().value()));
}

repository.save(entity);
log.info("Permission inserted: {}", entity);
} catch (Exception e) {
log.error("Error saving Permission: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(PermissionUpdatedEvent event) {
try {
Permission entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("Permission not found"));

		entity.setId(event.getId().value());
		entity.setName(event.getName().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new CustomUser(event.getCreatedBy().value()));
}


repository.save(entity);
log.info("Permission updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Permission: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(PermissionDeletedEvent event) {
try {
repository.deleteById(event.getId().value());
log.info("Permission deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Permission: {}", e.getMessage(), e);
throw e;
}
}
}
