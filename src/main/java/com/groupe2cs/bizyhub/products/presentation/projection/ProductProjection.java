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
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@AllowReplay(value = false)
@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
@ProcessingGroup("Product")
public class ProductProjection {

private final ProductRepository repository;


@EventHandler
public void on(ProductCreatedEvent event) {
try {
Product entity = Product.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.remoteId(event.getRemoteId() == null ? null : event.getRemoteId().value())
 		.localId(event.getLocalId() == null ? null : event.getLocalId().value())
 		.code(event.getCode() == null ? null : event.getCode().value())
 		.name(event.getName() == null ? null : event.getName().value())
 		.description(event.getDescription() == null ? null : event.getDescription().value())
 		.barcode(event.getBarcode() == null ? null : event.getBarcode().value())
  		.unit( event.getUnit() == null ? null : new com.groupe2cs.bizyhub.units.infrastructure.entity.Unit(event.getUnit().value()))
		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
  		.category( event.getCategory() == null ? null : new com.groupe2cs.bizyhub.categories.infrastructure.entity.Category(event.getCategory().value()))
		.defaultPrice(event.getDefaultPrice() == null ? null : event.getDefaultPrice().value())
 		.statuses(event.getStatuses() == null ? null : event.getStatuses().value())
 		.purchasePrice(event.getPurchasePrice() == null ? null : event.getPurchasePrice().value())
 .build();

entity.setId(event.getId().value());

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


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getRemoteId() != null) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getLocalId() != null) {
		entity.setLocalId(event.getLocalId().value());
    }
	if(event.getCode() != null) {
		entity.setCode(event.getCode().value());
    }
	if(event.getName() != null) {
		entity.setName(event.getName().value());
    }
	if(event.getDescription() != null) {
		entity.setDescription(event.getDescription().value());
    }
	if(event.getBarcode() != null) {
		entity.setBarcode(event.getBarcode().value());
    }

     if(event.getUnit() != null) {
		  entity.setUnit(new com.groupe2cs.bizyhub.units.infrastructure.entity.Unit(event.getUnit().value()));
	  }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }

     if(event.getCategory() != null) {
		  entity.setCategory(new com.groupe2cs.bizyhub.categories.infrastructure.entity.Category(event.getCategory().value()));
	  }
	if(event.getDefaultPrice() != null) {
		entity.setDefaultPrice(event.getDefaultPrice().value());
    }
	if(event.getStatuses() != null) {
		entity.setStatuses(event.getStatuses().value());
    }
	if(event.getPurchasePrice() != null) {
		entity.setPurchasePrice(event.getPurchasePrice().value());
    }

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
