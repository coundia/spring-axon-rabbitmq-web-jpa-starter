package com.groupe2cs.bizyhub.stock.presentation.projection;

	import com.groupe2cs.bizyhub.stock.domain.event.*;
	import com.groupe2cs.bizyhub.stock.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.stock.infrastructure.entity.*;
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
@ProcessingGroup("StockMovement")
public class StockMovementProjection {

private final StockMovementRepository repository;


@EventHandler
public void on(StockMovementCreatedEvent event) {
try {
StockMovement entity = StockMovement.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.typeStockMovement(event.getTypeStockMovement() == null ? null : event.getTypeStockMovement().value())
 		.quantity(event.getQuantity() == null ? null : event.getQuantity().value())
 		.remoteId(event.getRemoteId() == null ? null : event.getRemoteId().value())
 		.localId(event.getLocalId() == null ? null : event.getLocalId().value())
  		.company( event.getCompany() == null ? null : new com.groupe2cs.bizyhub.companies.infrastructure.entity.Company(event.getCompany().value()))
		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
  		.productVariant( event.getProductVariant() == null ? null : new com.groupe2cs.bizyhub.products.infrastructure.entity.Product(event.getProductVariant().value()))
		.orderLineId(event.getOrderLineId() == null ? null : event.getOrderLineId().value())
 		.discriminator(event.getDiscriminator() == null ? null : event.getDiscriminator().value())
 .build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("StockMovement inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving StockMovement: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(StockMovementUpdatedEvent event) {
try {
StockMovement entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("StockMovement not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getTypeStockMovement() != null) {
		entity.setTypeStockMovement(event.getTypeStockMovement().value());
    }
	if(event.getQuantity() != null) {
		entity.setQuantity(event.getQuantity().value());
    }
	if(event.getRemoteId() != null) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getLocalId() != null) {
		entity.setLocalId(event.getLocalId().value());
    }

     if(event.getCompany() != null) {
		  entity.setCompany(new com.groupe2cs.bizyhub.companies.infrastructure.entity.Company(event.getCompany().value()));
	  }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }

     if(event.getProductVariant() != null) {
		  entity.setProductVariant(new com.groupe2cs.bizyhub.products.infrastructure.entity.Product(event.getProductVariant().value()));
	  }
	if(event.getOrderLineId() != null) {
		entity.setOrderLineId(event.getOrderLineId().value());
    }
	if(event.getDiscriminator() != null) {
		entity.setDiscriminator(event.getDiscriminator().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("StockMovement updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating StockMovement: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(StockMovementDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("StockMovement deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting StockMovement: {}", e.getMessage(), e);
throw e;
}
}
}
