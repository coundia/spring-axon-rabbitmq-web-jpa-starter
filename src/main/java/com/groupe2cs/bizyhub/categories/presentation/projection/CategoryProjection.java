package com.groupe2cs.bizyhub.categories.presentation.projection;

	import com.groupe2cs.bizyhub.categories.domain.event.*;
	import com.groupe2cs.bizyhub.categories.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.categories.infrastructure.entity.*;
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
@ProcessingGroup("Category")
public class CategoryProjection {

private final CategoryRepository repository;

public CategoryProjection(CategoryRepository repository) {
this.repository = repository;
}

@EventHandler
public void on(CategoryCreatedEvent event) {
try {
Category entity = Category.builder()
		.id(event.getId().value())
 		.reference(event.getReference().value())
 		.name(event.getName().value())
 		.updatedAt(event.getUpdatedAt().value())
 		.typeCategory(event.getTypeCategory().value())
 		.parentId(event.getParentId().value())
 		.isDefault(event.getIsDefault().value())
 		.icon(event.getIcon().value())
 		.colorHex(event.getColorHex().value())
 .build();

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new CustomUser(event.getCreatedBy().value()));
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

		entity.setId(event.getId().value());
		entity.setReference(event.getReference().value());
		entity.setName(event.getName().value());
		entity.setUpdatedAt(event.getUpdatedAt().value());
		entity.setTypeCategory(event.getTypeCategory().value());
		entity.setParentId(event.getParentId().value());
		entity.setIsDefault(event.getIsDefault().value());
		entity.setIcon(event.getIcon().value());
		entity.setColorHex(event.getColorHex().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new CustomUser(event.getCreatedBy().value()));
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
