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
@ProcessingGroup("Sale")
public class SaleProjection {

private final SaleRepository repository;

public SaleProjection(SaleRepository repository) {
this.repository = repository;
}

@EventHandler
public void on(SaleCreatedEvent event) {
try {
Sale entity = Sale.builder()
		.id(event.getId().value())
 		.name(event.getName().value())
 		.amount(event.getAmount().value())
 		.details(event.getDetails().value())
 		.isActive(event.getIsActive().value())
  		.product(new com.groupe2cs.bizyhub.products.infrastructure.entity.Product(event.getProduct().value()))
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
log.info("Sale inserted: {}", entity);
} catch (Exception e) {
log.error("Error saving Sale: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(SaleUpdatedEvent event) {
try {
Sale entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("Sale not found"));

		entity.setId(event.getId().value());
		entity.setName(event.getName().value());
		entity.setAmount(event.getAmount().value());
		entity.setDetails(event.getDetails().value());
		entity.setIsActive(event.getIsActive().value());
		entity.setProduct(new com.groupe2cs.bizyhub.products.infrastructure.entity.Product(event.getProduct().value()));
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
log.info("Sale updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Sale: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(SaleDeletedEvent event) {
try {
repository.deleteById(event.getId().value());
log.info("Sale deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Sale: {}", e.getMessage(), e);
throw e;
}
}
}
