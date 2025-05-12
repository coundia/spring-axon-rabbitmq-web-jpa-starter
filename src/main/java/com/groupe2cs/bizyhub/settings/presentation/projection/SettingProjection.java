package com.groupe2cs.bizyhub.settings.presentation.projection;

	import com.groupe2cs.bizyhub.settings.domain.event.*;
	import com.groupe2cs.bizyhub.settings.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.settings.infrastructure.entity.*;
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
@ProcessingGroup("Setting")
public class SettingProjection {

private final SettingRepository repository;


@EventHandler
public void on(SettingCreatedEvent event) {
try {
Setting entity = Setting.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.name(event.getName() == null ? null : event.getName().value())
 		.value(event.getValue() == null ? null : event.getValue().value())
 		.locale(event.getLocale() == null ? null : event.getLocale().value())
 		.details(event.getDetails() == null ? null : event.getDetails().value())
 		.isActive(event.getIsActive() == null ? null : event.getIsActive().value())
 		.updatedAt(event.getUpdatedAt() == null ? null : event.getUpdatedAt().value())
 		.reference(event.getReference() == null ? null : event.getReference().value())
 .build();

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("Setting inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving Setting: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(SettingUpdatedEvent event) {
try {
Setting entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("Setting not found"));


		entity.setId(event.getId().value());
		entity.setName(event.getName().value());
		entity.setValue(event.getValue().value());
		entity.setLocale(event.getLocale().value());
		entity.setDetails(event.getDetails().value());
		entity.setIsActive(event.getIsActive().value());
		entity.setUpdatedAt(event.getUpdatedAt().value());
		entity.setReference(event.getReference().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("Setting updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Setting: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(SettingDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("Setting deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Setting: {}", e.getMessage(), e);
throw e;
}
}
}
