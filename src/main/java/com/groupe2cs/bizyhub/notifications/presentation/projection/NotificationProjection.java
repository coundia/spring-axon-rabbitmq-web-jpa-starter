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


@EventHandler
public void on(NotificationCreatedEvent event) {
try {
Notification entity = Notification.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.deviceToken(event.getDeviceToken() == null ? null : event.getDeviceToken().value())
 		.title(event.getTitle() == null ? null : event.getTitle().value())
 		.message(event.getMessage() == null ? null : event.getMessage().value())
 		.status(event.getStatus() == null ? null : event.getStatus().value())
 		.reserved(event.getReserved() == null ? null : event.getReserved().value())
 		.errorMessage(event.getErrorMessage() == null ? null : event.getErrorMessage().value())
 .build();

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


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getDeviceToken() != null) {
		entity.setDeviceToken(event.getDeviceToken().value());
    }
	if(event.getTitle() != null) {
		entity.setTitle(event.getTitle().value());
    }
	if(event.getMessage() != null) {
		entity.setMessage(event.getMessage().value());
    }
	if(event.getStatus() != null) {
		entity.setStatus(event.getStatus().value());
    }
	if(event.getReserved() != null) {
		entity.setReserved(event.getReserved().value());
    }
	if(event.getErrorMessage() != null) {
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
