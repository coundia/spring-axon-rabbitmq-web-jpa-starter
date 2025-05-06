package com.groupe2cs.bizyhub.products.presentation.projection;

	import com.groupe2cs.bizyhub.products.domain.event.*;
	import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
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
@ProcessingGroup("Product")
public class ProductProjection {

private final ProductRepository repository;

public ProductProjection(ProductRepository repository) {
this.repository = repository;
}

@EventHandler
public void on(ProductCreatedEvent event) {
try {
Product entity = Product.builder()
		.id(event.getId().value())
 		.name(event.getName().value())
 		.price(event.getPrice().value())
 		.details(event.getDetails().value())
 		.isActive(event.getIsActive().value())
 		.updatedAt(event.getUpdatedAt().value())
 		.reference(event.getReference().value())
 .build();

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);
log.info("Product inserted: {}", entity);
} catch (Exception e) {
log.error("Error saving Product: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(ProductUpdatedEvent event) {
try {
Product entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("Product not found"));

		entity.setId(event.getId().value());
		entity.setName(event.getName().value());
		entity.setPrice(event.getPrice().value());
		entity.setDetails(event.getDetails().value());
		entity.setIsActive(event.getIsActive().value());
		entity.setUpdatedAt(event.getUpdatedAt().value());
		entity.setReference(event.getReference().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);
log.info("Product updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Product: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(ProductDeletedEvent event) {
try {
repository.deleteById(event.getId().value());
log.info("Product deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Product: {}", e.getMessage(), e);
throw e;
}
}
}
