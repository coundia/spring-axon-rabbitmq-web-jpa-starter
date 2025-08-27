package com.groupe2cs.bizyhub.units.presentation.projection;

	import com.groupe2cs.bizyhub.units.domain.event.*;
	import com.groupe2cs.bizyhub.units.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.units.infrastructure.entity.*;
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
@ProcessingGroup("Unit")
public class UnitProjection {

private final UnitRepository repository;


private static boolean hasId(Object s) {
    return s != null ;
}


@EventHandler
public void on(UnitCreatedEvent event) {
try {
Unit entity = Unit.builder().build();
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
 		if(event.getSyncAt() !=null  && hasId(event.getSyncAt().value()) ) {
            entity.setSyncAt( event.getSyncAt().value());
        }
 		if(event.getDescription() !=null  && hasId(event.getDescription().value()) ) {
            entity.setDescription( event.getDescription().value());
        }
 

    entity.setId(event.getId().value());

    if(event.getCreatedBy() !=null){
        entity.setCreatedBy( new User(event.getCreatedBy().value()));
    }
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("Unit inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving Unit: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(UnitUpdatedEvent event) {
try {
Unit entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("Unit not found"));


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
	if(event.getSyncAt() != null  && hasId(event.getSyncAt().value())) {
		entity.setSyncAt(event.getSyncAt().value());
    }
	if(event.getDescription() != null  && hasId(event.getDescription().value())) {
		entity.setDescription(event.getDescription().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("Unit updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Unit: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(UnitDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("Unit deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Unit: {}", e.getMessage(), e);
throw e;
}
}
}
