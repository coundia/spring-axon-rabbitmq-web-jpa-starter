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
 		.name(event.getName() == null ? null : event.getName().value())
 		.typeCategoryRaw(event.getTypeCategoryRaw() == null ? null : event.getTypeCategoryRaw().value())
 		.details(event.getDetails() == null ? null : event.getDetails().value())
 		.isActive(event.getIsActive() == null ? null : event.getIsActive().value())
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
	if(event.getName() != null) {
		entity.setName(event.getName().value());
    }
	if(event.getTypeCategoryRaw() != null) {
		entity.setTypeCategoryRaw(event.getTypeCategoryRaw().value());
    }
	if(event.getDetails() != null) {
		entity.setDetails(event.getDetails().value());
    }
	if(event.getIsActive() != null) {
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
