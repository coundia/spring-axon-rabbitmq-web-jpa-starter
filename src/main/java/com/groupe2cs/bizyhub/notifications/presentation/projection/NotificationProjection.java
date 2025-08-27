package com.groupe2cs.bizyhub.notifications.presentation.projection;

	import com.groupe2cs.bizyhub.notifications.domain.event.*;
	import com.groupe2cs.bizyhub.notifications.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.notifications.infrastructure.entity.*;
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
@ProcessingGroup("Notification")
public class NotificationProjection {

private final NotificationRepository repository;


private static boolean hasId(Object s) {
    return s != null ;
}


@EventHandler
public void on(NotificationCreatedEvent event) {
try {
Notification entity = Notification.builder().build();
		if(event.getId() !=null  && hasId(event.getId().value()) ) {
            entity.setId( event.getId().value());
        }
 		if(event.getDeviceToken() !=null  && hasId(event.getDeviceToken().value()) ) {
            entity.setDeviceToken( event.getDeviceToken().value());
        }
 		if(event.getTitle() !=null  && hasId(event.getTitle().value()) ) {
            entity.setTitle( event.getTitle().value());
        }
 		if(event.getMessage() !=null  && hasId(event.getMessage().value()) ) {
            entity.setMessage( event.getMessage().value());
        }
 		if(event.getStatus() !=null  && hasId(event.getStatus().value()) ) {
            entity.setStatus( event.getStatus().value());
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
 		if(event.getReserved() !=null  && hasId(event.getReserved().value()) ) {
            entity.setReserved( event.getReserved().value());
        }
 		if(event.getErrorMessage() !=null  && hasId(event.getErrorMessage().value()) ) {
            entity.setErrorMessage( event.getErrorMessage().value());
        }
 

    entity.setId(event.getId().value());

    if(event.getCreatedBy() !=null){
        entity.setCreatedBy( new User(event.getCreatedBy().value()));
    }
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("Notification inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving Notification: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(NotificationUpdatedEvent event) {
try {
Notification entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("Notification not found"));


	if(event.getId() != null  && hasId(event.getId().value())) {
		entity.setId(event.getId().value());
    }
	if(event.getDeviceToken() != null  && hasId(event.getDeviceToken().value())) {
		entity.setDeviceToken(event.getDeviceToken().value());
    }
	if(event.getTitle() != null  && hasId(event.getTitle().value())) {
		entity.setTitle(event.getTitle().value());
    }
	if(event.getMessage() != null  && hasId(event.getMessage().value())) {
		entity.setMessage(event.getMessage().value());
    }
	if(event.getStatus() != null  && hasId(event.getStatus().value())) {
		entity.setStatus(event.getStatus().value());
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
	if(event.getReserved() != null  && hasId(event.getReserved().value())) {
		entity.setReserved(event.getReserved().value());
    }
	if(event.getErrorMessage() != null  && hasId(event.getErrorMessage().value())) {
		entity.setErrorMessage(event.getErrorMessage().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("Notification updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Notification: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(NotificationDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("Notification deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Notification: {}", e.getMessage(), e);
throw e;
}
}
}
