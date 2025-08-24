package com.groupe2cs.bizyhub.sync.presentation.projection;

	import com.groupe2cs.bizyhub.sync.domain.event.*;
	import com.groupe2cs.bizyhub.sync.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.sync.infrastructure.entity.*;
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
@ProcessingGroup("ChangeLog")
public class ChangeLogProjection {

private final ChangeLogRepository repository;


@EventHandler
public void on(ChangeLogCreatedEvent event) {
try {
ChangeLog entity = ChangeLog.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.entityTable(event.getEntityTable() == null ? null : event.getEntityTable().value())
 		.entityId(event.getEntityId() == null ? null : event.getEntityId().value())
 		.remoteId(event.getRemoteId() == null ? null : event.getRemoteId().value())
 		.operation(event.getOperation() == null ? null : event.getOperation().value())
 		.payload(event.getPayload() == null ? null : event.getPayload().value())
 		.status(event.getStatus() == null ? null : event.getStatus().value())
 		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
 		.attempts(event.getAttempts() == null ? null : event.getAttempts().value())
 		.error(event.getError() == null ? null : event.getError().value())
 .build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("ChangeLog inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving ChangeLog: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(ChangeLogUpdatedEvent event) {
try {
ChangeLog entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("ChangeLog not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getEntityTable() != null) {
		entity.setEntityTable(event.getEntityTable().value());
    }
	if(event.getEntityId() != null) {
		entity.setEntityId(event.getEntityId().value());
    }
	if(event.getRemoteId() != null) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getOperation() != null) {
		entity.setOperation(event.getOperation().value());
    }
	if(event.getPayload() != null) {
		entity.setPayload(event.getPayload().value());
    }
	if(event.getStatus() != null) {
		entity.setStatus(event.getStatus().value());
    }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }
	if(event.getAttempts() != null) {
		entity.setAttempts(event.getAttempts().value());
    }
	if(event.getError() != null) {
		entity.setError(event.getError().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("ChangeLog updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating ChangeLog: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(ChangeLogDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("ChangeLog deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting ChangeLog: {}", e.getMessage(), e);
throw e;
}
}
}
