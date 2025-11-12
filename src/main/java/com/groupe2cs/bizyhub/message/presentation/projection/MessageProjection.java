package com.groupe2cs.bizyhub.message.presentation.projection;

	import com.groupe2cs.bizyhub.message.domain.event.*;
	import com.groupe2cs.bizyhub.message.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.message.infrastructure.entity.*;
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
@ProcessingGroup("Message")
public class MessageProjection {

private final MessageRepository repository;


private static boolean hasId(Object s) {
    return s != null ;
}


@EventHandler
public void on(MessageCreatedEvent event) {
try {
Message entity = Message.builder().build();
		if(event.getId() !=null  && hasId(event.getId().value()) ) {
            entity.setId( event.getId().value());
        }
 		if(event.getCode() !=null  && hasId(event.getCode().value()) ) {
            entity.setCode( event.getCode().value());
        }
 		if(event.getEmail() !=null  && hasId(event.getEmail().value()) ) {
            entity.setEmail( event.getEmail().value());
        }
 		if(event.getPhone() !=null  && hasId(event.getPhone().value()) ) {
            entity.setPhone( event.getPhone().value());
        }
 		if(event.getContent() !=null  && hasId(event.getContent().value()) ) {
            entity.setContent( event.getContent().value());
        }
 		if(event.getPlateforme() !=null  && hasId(event.getPlateforme().value()) ) {
            entity.setPlateforme( event.getPlateforme().value());
        }
 		if(event.getSource() !=null  && hasId(event.getSource().value()) ) {
            entity.setSource( event.getSource().value());
        }
 		if(event.getAgent() !=null  && hasId(event.getAgent().value()) ) {
            entity.setAgent( event.getAgent().value());
        }
 		if(event.getStatus() !=null  && hasId(event.getStatus().value()) ) {
            entity.setStatus( event.getStatus().value());
        }
 		if(event.getDescription() !=null  && hasId(event.getDescription().value()) ) {
            entity.setDescription( event.getDescription().value());
        }
 		if(event.getIsActive() !=null  && hasId(event.getIsActive().value()) ) {
            entity.setIsActive( event.getIsActive().value());
        }
 		if(event.getIsDefault() !=null  && hasId(event.getIsDefault().value()) ) {
            entity.setIsDefault( event.getIsDefault().value());
        }
 		if(event.getRemoteId() !=null  && hasId(event.getRemoteId().value()) ) {
            entity.setRemoteId( event.getRemoteId().value());
        }
 		if(event.getLocalId() !=null  && hasId(event.getLocalId().value()) ) {
            entity.setLocalId( event.getLocalId().value());
        }
 		if(event.getDepotAt() !=null  && hasId(event.getDepotAt().value()) ) {
            entity.setDepotAt( event.getDepotAt().value());
        }
 		if(event.getSyncAt() !=null  && hasId(event.getSyncAt().value()) ) {
            entity.setSyncAt( event.getSyncAt().value());
        }
 

    entity.setId(event.getId().value());

    if(event.getCreatedBy() !=null){
        entity.setCreatedBy( new User(event.getCreatedBy().value()));
    }
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}

/*
	if(event.getRemoteId().value() == null) {
		entity.setRemoteId(event.getId().value());
	}
	*/

repository.save(entity);


log.info("Message inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving Message: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(MessageUpdatedEvent event) {
try {
Message entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("Message not found"));


	if(event.getId() != null  && hasId(event.getId().value())) {
		entity.setId(event.getId().value());
    }
	if(event.getCode() != null  && hasId(event.getCode().value())) {
		entity.setCode(event.getCode().value());
    }
	if(event.getEmail() != null  && hasId(event.getEmail().value())) {
		entity.setEmail(event.getEmail().value());
    }
	if(event.getPhone() != null  && hasId(event.getPhone().value())) {
		entity.setPhone(event.getPhone().value());
    }
	if(event.getContent() != null  && hasId(event.getContent().value())) {
		entity.setContent(event.getContent().value());
    }
	if(event.getPlateforme() != null  && hasId(event.getPlateforme().value())) {
		entity.setPlateforme(event.getPlateforme().value());
    }
	if(event.getSource() != null  && hasId(event.getSource().value())) {
		entity.setSource(event.getSource().value());
    }
	if(event.getAgent() != null  && hasId(event.getAgent().value())) {
		entity.setAgent(event.getAgent().value());
    }
	if(event.getStatus() != null  && hasId(event.getStatus().value())) {
		entity.setStatus(event.getStatus().value());
    }
	if(event.getDescription() != null  && hasId(event.getDescription().value())) {
		entity.setDescription(event.getDescription().value());
    }
	if(event.getIsActive() != null  && hasId(event.getIsActive().value())) {
		entity.setIsActive(event.getIsActive().value());
    }
	if(event.getIsDefault() != null  && hasId(event.getIsDefault().value())) {
		entity.setIsDefault(event.getIsDefault().value());
    }
	if(event.getRemoteId() != null  && hasId(event.getRemoteId().value())) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getLocalId() != null  && hasId(event.getLocalId().value())) {
		entity.setLocalId(event.getLocalId().value());
    }
	if(event.getDepotAt() != null  && hasId(event.getDepotAt().value())) {
		entity.setDepotAt(event.getDepotAt().value());
    }
	if(event.getSyncAt() != null  && hasId(event.getSyncAt().value())) {
		entity.setSyncAt(event.getSyncAt().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("Message updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Message: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(MessageDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("Message deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Message: {}", e.getMessage(), e);
throw e;
}
}
}
