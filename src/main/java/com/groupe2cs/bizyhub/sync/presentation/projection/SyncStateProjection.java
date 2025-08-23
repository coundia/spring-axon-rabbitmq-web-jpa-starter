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
@ProcessingGroup("SyncState")
public class SyncStateProjection {

private final SyncStateRepository repository;


@EventHandler
public void on(SyncStateCreatedEvent event) {
try {
SyncState entity = SyncState.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.entityTable(event.getEntityTable() == null ? null : event.getEntityTable().value())
 		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
 		.lastSyncAt(event.getLastSyncAt() == null ? null : event.getLastSyncAt().value())
 		.lastCursor(event.getLastCursor() == null ? null : event.getLastCursor().value())
 .build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("SyncState inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving SyncState: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(SyncStateUpdatedEvent event) {
try {
SyncState entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("SyncState not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getEntityTable() != null) {
		entity.setEntityTable(event.getEntityTable().value());
    }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }
	if(event.getLastSyncAt() != null) {
		entity.setLastSyncAt(event.getLastSyncAt().value());
    }
	if(event.getLastCursor() != null) {
		entity.setLastCursor(event.getLastCursor().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("SyncState updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating SyncState: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(SyncStateDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("SyncState deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting SyncState: {}", e.getMessage(), e);
throw e;
}
}
}
