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


private static boolean hasId(Object s) {
    return s != null ;
}


@EventHandler
public void on(TransactionItemCreatedEvent event) {
try {
TransactionItem entity = TransactionItem.builder().build();
		if(event.getId() !=null  && hasId(event.getId().value()) ) {
            entity.setId( event.getId().value());
        }
 		if(event.getTransaction() !=null  && hasId(event.getTransaction().value()) ) {
            entity.setTransaction( event.getTransaction().value());
        }
 		if(event.getProduct() !=null  && hasId(event.getProduct().value()) ) {
            entity.setProduct( event.getProduct().value());
        }
 		if(event.getLabel() !=null  && hasId(event.getLabel().value()) ) {
            entity.setLabel( event.getLabel().value());
        }
 		if(event.getQuantity() !=null  && hasId(event.getQuantity().value()) ) {
            entity.setQuantity( event.getQuantity().value());
        }
 		if(event.getUnit() !=null  && hasId(event.getUnit().value()) ) {
            entity.setUnit( event.getUnit().value());
        }
 		if(event.getRemoteId() !=null  && hasId(event.getRemoteId().value()) ) {
            entity.setRemoteId( event.getRemoteId().value());
        }
 		if(event.getLocalId() !=null  && hasId(event.getLocalId().value()) ) {
            entity.setLocalId( event.getLocalId().value());
        }
 		if(event.getSyncAt() !=null  && hasId(event.getSyncAt().value()) ) {
            entity.setSyncAt( event.getSyncAt().value());
        }
 		if(event.getUnitPrice() !=null  && hasId(event.getUnitPrice().value()) ) {
            entity.setUnitPrice( event.getUnitPrice().value());
        }
 		if(event.getTotal() !=null  && hasId(event.getTotal().value()) ) {
            entity.setTotal( event.getTotal().value());
        }
 		if(event.getNotes() !=null  && hasId(event.getNotes().value()) ) {
            entity.setNotes( event.getNotes().value());
        }
 

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


	if(event.getId() != null  && hasId(event.getId().value())) {
		entity.setId(event.getId().value());
    }
	if(event.getTransaction() != null  && hasId(event.getTransaction().value())) {
		entity.setTransaction(event.getTransaction().value());
    }
	if(event.getProduct() != null  && hasId(event.getProduct().value())) {
		entity.setProduct(event.getProduct().value());
    }
	if(event.getLabel() != null  && hasId(event.getLabel().value())) {
		entity.setLabel(event.getLabel().value());
    }
	if(event.getQuantity() != null  && hasId(event.getQuantity().value())) {
		entity.setQuantity(event.getQuantity().value());
    }
	if(event.getUnit() != null  && hasId(event.getUnit().value())) {
		entity.setUnit(event.getUnit().value());
    }
	if(event.getRemoteId() != null  && hasId(event.getRemoteId().value())) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getLocalId() != null  && hasId(event.getLocalId().value())) {
		entity.setLocalId(event.getLocalId().value());
    }
	if(event.getSyncAt() != null  && hasId(event.getSyncAt().value())) {
		entity.setSyncAt(event.getSyncAt().value());
    }
	if(event.getUnitPrice() != null  && hasId(event.getUnitPrice().value())) {
		entity.setUnitPrice(event.getUnitPrice().value());
    }
	if(event.getTotal() != null  && hasId(event.getTotal().value())) {
		entity.setTotal(event.getTotal().value());
    }
	if(event.getNotes() != null  && hasId(event.getNotes().value())) {
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
