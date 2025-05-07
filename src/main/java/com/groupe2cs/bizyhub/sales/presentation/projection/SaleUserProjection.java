package com.groupe2cs.bizyhub.sales.presentation.projection;

	import com.groupe2cs.bizyhub.sales.domain.event.*;
	import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
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
@ProcessingGroup("SaleUser")
public class SaleUserProjection {

private final SaleUserRepository repository;

public SaleUserProjection(SaleUserRepository repository) {
this.repository = repository;
}

@EventHandler
public void on(SaleUserCreatedEvent event) {
try {
SaleUser entity = SaleUser.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.name(event.getName() == null ? null : event.getName().value())
  		.sales( event.getSales() == null ? null : new com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale(event.getSales().value()))
 		.users( event.getUsers() == null ? null : new com.groupe2cs.bizyhub.security.infrastructure.entity.User(event.getUsers().value()))
		.username(event.getUsername() == null ? null : event.getUsername().value())
 		.details(event.getDetails() == null ? null : event.getDetails().value())
 		.isActive(event.getIsActive() == null ? null : event.getIsActive().value())
 		.updatedAt(event.getUpdatedAt() == null ? null : event.getUpdatedAt().value())
 		.reference(event.getReference() == null ? null : event.getReference().value())
 .build();

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);
log.info("SaleUser inserted: {}", entity);
} catch (Exception e) {
log.error("Error saving SaleUser: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(SaleUserUpdatedEvent event) {
try {
SaleUser entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("SaleUser not found"));

		entity.setId(event.getId().value());
		entity.setName(event.getName().value());
		entity.setSales(new com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale(event.getSales().value()));
		entity.setUsers(new com.groupe2cs.bizyhub.security.infrastructure.entity.User(event.getUsers().value()));
		entity.setUsername(event.getUsername().value());
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
log.info("SaleUser updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating SaleUser: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(SaleUserDeletedEvent event) {
try {
repository.deleteById(event.getId().value());
log.info("SaleUser deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting SaleUser: {}", e.getMessage(), e);
throw e;
}
}
}
