package com.groupe2cs.bizyhub.categories.presentation.projection;

	import com.groupe2cs.bizyhub.categories.domain.event.*;
	import com.groupe2cs.bizyhub.categories.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.categories.infrastructure.entity.*;
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
@ProcessingGroup("Category")
public class CategoryProjection {

private final CategoryRepository repository;


@EventHandler
public void on(CategoryCreatedEvent event) {
try {
Category entity = Category.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.code(event.getCode() == null ? null : event.getCode().value())
 		.name(event.getName() == null ? null : event.getName().value())
 		.remoteId(event.getRemoteId() == null ? null : event.getRemoteId().value())
 		.localId(event.getLocalId() == null ? null : event.getLocalId().value())
 		.description(event.getDescription() == null ? null : event.getDescription().value())
 		.typeEntry(event.getTypeEntry() == null ? null : event.getTypeEntry().value())
 		.version(event.getVersion() == null ? null : event.getVersion().value())
 		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
 .build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("Category inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving Category: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(CategoryUpdatedEvent event) {
try {
Category entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("Category not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getCode() != null) {
		entity.setCode(event.getCode().value());
    }
	if(event.getName() != null) {
		entity.setName(event.getName().value());
    }
	if(event.getRemoteId() != null) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getLocalId() != null) {
		entity.setLocalId(event.getLocalId().value());
    }
	if(event.getDescription() != null) {
		entity.setDescription(event.getDescription().value());
    }
	if(event.getTypeEntry() != null) {
		entity.setTypeEntry(event.getTypeEntry().value());
    }
	if(event.getVersion() != null) {
		entity.setVersion(event.getVersion().value());
    }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("Category updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Category: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(CategoryDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("Category deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Category: {}", e.getMessage(), e);
throw e;
}
}
}
