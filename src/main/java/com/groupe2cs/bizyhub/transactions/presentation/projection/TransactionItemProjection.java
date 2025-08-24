package com.groupe2cs.bizyhub.transactions.presentation.projection;

	import com.groupe2cs.bizyhub.transactions.domain.event.*;
	import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
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
@ProcessingGroup("TransactionItem")
public class TransactionItemProjection {

private final TransactionItemRepository repository;


@EventHandler
public void on(TransactionItemCreatedEvent event) {
try {
TransactionItem entity = TransactionItem.builder()
		.id(event.getId() == null ? null : event.getId().value())
  		.transaction( event.getTransaction() == null ? null : new com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction(event.getTransaction().value()))
 		.product( event.getProduct() == null ? null : new com.groupe2cs.bizyhub.products.infrastructure.entity.Product(event.getProduct().value()))
		.label(event.getLabel() == null ? null : event.getLabel().value())
 		.quantity(event.getQuantity() == null ? null : event.getQuantity().value())
  		.unit( event.getUnit() == null ? null : new com.groupe2cs.bizyhub.units.infrastructure.entity.Unit(event.getUnit().value()))
		.remoteId(event.getRemoteId() == null ? null : event.getRemoteId().value())
 		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
 		.unitPrice(event.getUnitPrice() == null ? null : event.getUnitPrice().value())
 		.total(event.getTotal() == null ? null : event.getTotal().value())
 		.notes(event.getNotes() == null ? null : event.getNotes().value())
 .build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("TransactionItem inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving TransactionItem: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(TransactionItemUpdatedEvent event) {
try {
TransactionItem entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("TransactionItem not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }

     if(event.getTransaction() != null) {
		  entity.setTransaction(new com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction(event.getTransaction().value()));
	  }

     if(event.getProduct() != null) {
		  entity.setProduct(new com.groupe2cs.bizyhub.products.infrastructure.entity.Product(event.getProduct().value()));
	  }
	if(event.getLabel() != null) {
		entity.setLabel(event.getLabel().value());
    }
	if(event.getQuantity() != null) {
		entity.setQuantity(event.getQuantity().value());
    }

     if(event.getUnit() != null) {
		  entity.setUnit(new com.groupe2cs.bizyhub.units.infrastructure.entity.Unit(event.getUnit().value()));
	  }
	if(event.getRemoteId() != null) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }
	if(event.getUnitPrice() != null) {
		entity.setUnitPrice(event.getUnitPrice().value());
    }
	if(event.getTotal() != null) {
		entity.setTotal(event.getTotal().value());
    }
	if(event.getNotes() != null) {
		entity.setNotes(event.getNotes().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("TransactionItem updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating TransactionItem: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(TransactionItemDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("TransactionItem deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting TransactionItem: {}", e.getMessage(), e);
throw e;
}
}
}
