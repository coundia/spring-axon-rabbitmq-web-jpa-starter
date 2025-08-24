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
@ProcessingGroup("StockLevel")
public class StockLevelProjection {

private final StockLevelRepository repository;


@EventHandler
public void on(StockLevelCreatedEvent event) {
try {
StockLevel entity = StockLevel.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.remoteId(event.getRemoteId() == null ? null : event.getRemoteId().value())
 		.localId(event.getLocalId() == null ? null : event.getLocalId().value())
 		.stockOnHand(event.getStockOnHand() == null ? null : event.getStockOnHand().value())
 		.stockAllocated(event.getStockAllocated() == null ? null : event.getStockAllocated().value())
  		.productVariant( event.getProductVariant() == null ? null : new com.groupe2cs.bizyhub.products.infrastructure.entity.Product(event.getProductVariant().value()))
		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
  		.company( event.getCompany() == null ? null : new com.groupe2cs.bizyhub.companies.infrastructure.entity.Company(event.getCompany().value()))
.build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("StockLevel inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving StockLevel: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(StockLevelUpdatedEvent event) {
try {
StockLevel entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("StockLevel not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getRemoteId() != null) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getLocalId() != null) {
		entity.setLocalId(event.getLocalId().value());
    }
	if(event.getStockOnHand() != null) {
		entity.setStockOnHand(event.getStockOnHand().value());
    }
	if(event.getStockAllocated() != null) {
		entity.setStockAllocated(event.getStockAllocated().value());
    }

     if(event.getProductVariant() != null) {
		  entity.setProductVariant(new com.groupe2cs.bizyhub.products.infrastructure.entity.Product(event.getProductVariant().value()));
	  }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }

     if(event.getCompany() != null) {
		  entity.setCompany(new com.groupe2cs.bizyhub.companies.infrastructure.entity.Company(event.getCompany().value()));
	  }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("StockLevel updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating StockLevel: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(StockLevelDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("StockLevel deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting StockLevel: {}", e.getMessage(), e);
throw e;
}
}
}
