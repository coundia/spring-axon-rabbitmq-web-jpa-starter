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


private static boolean hasId(Object s) {
    return s != null ;
}


@EventHandler
public void on(ProductCreatedEvent event) {
try {
Product entity = Product.builder().build();
		if(event.getId() !=null  && hasId(event.getId().value()) ) {
            entity.setId( event.getId().value());
        }
 		if(event.getRemoteId() !=null  && hasId(event.getRemoteId().value()) ) {
            entity.setRemoteId( event.getRemoteId().value());
        }
 		if(event.getLocalId() !=null  && hasId(event.getLocalId().value()) ) {
            entity.setLocalId( event.getLocalId().value());
        }
 		if(event.getCode() !=null  && hasId(event.getCode().value()) ) {
            entity.setCode( event.getCode().value());
        }
 		if(event.getName() !=null  && hasId(event.getName().value()) ) {
            entity.setName( event.getName().value());
        }
 		if(event.getDescription() !=null  && hasId(event.getDescription().value()) ) {
            entity.setDescription( event.getDescription().value());
        }
 		if(event.getBarcode() !=null  && hasId(event.getBarcode().value()) ) {
            entity.setBarcode( event.getBarcode().value());
        }
 		if(event.getUnit() !=null  && hasId(event.getUnit().value()) ) {
            entity.setUnit( event.getUnit().value());
        }
 		if(event.getSyncAt() !=null  && hasId(event.getSyncAt().value()) ) {
            entity.setSyncAt( event.getSyncAt().value());
        }
 		if(event.getCategory() !=null  && hasId(event.getCategory().value()) ) {
            entity.setCategory( event.getCategory().value());
        }
 		if(event.getDefaultPrice() !=null  && hasId(event.getDefaultPrice().value()) ) {
            entity.setDefaultPrice( event.getDefaultPrice().value());
        }
 		if(event.getStatuses() !=null  && hasId(event.getStatuses().value()) ) {
            entity.setStatuses( event.getStatuses().value());
        }
 		if(event.getPurchasePrice() !=null  && hasId(event.getPurchasePrice().value()) ) {
            entity.setPurchasePrice( event.getPurchasePrice().value());
        }
 

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


	if(event.getId() != null  && hasId(event.getId().value())) {
		entity.setId(event.getId().value());
    }
	if(event.getRemoteId() != null  && hasId(event.getRemoteId().value())) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getLocalId() != null  && hasId(event.getLocalId().value())) {
		entity.setLocalId(event.getLocalId().value());
    }
	if(event.getCode() != null  && hasId(event.getCode().value())) {
		entity.setCode(event.getCode().value());
    }
	if(event.getName() != null  && hasId(event.getName().value())) {
		entity.setName(event.getName().value());
    }
	if(event.getDescription() != null  && hasId(event.getDescription().value())) {
		entity.setDescription(event.getDescription().value());
    }
	if(event.getBarcode() != null  && hasId(event.getBarcode().value())) {
		entity.setBarcode(event.getBarcode().value());
    }
	if(event.getUnit() != null  && hasId(event.getUnit().value())) {
		entity.setUnit(event.getUnit().value());
    }
	if(event.getSyncAt() != null  && hasId(event.getSyncAt().value())) {
		entity.setSyncAt(event.getSyncAt().value());
    }
	if(event.getCategory() != null  && hasId(event.getCategory().value())) {
		entity.setCategory(event.getCategory().value());
    }
	if(event.getDefaultPrice() != null  && hasId(event.getDefaultPrice().value())) {
		entity.setDefaultPrice(event.getDefaultPrice().value());
    }
	if(event.getStatuses() != null  && hasId(event.getStatuses().value())) {
		entity.setStatuses(event.getStatuses().value());
    }
	if(event.getPurchasePrice() != null  && hasId(event.getPurchasePrice().value())) {
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
