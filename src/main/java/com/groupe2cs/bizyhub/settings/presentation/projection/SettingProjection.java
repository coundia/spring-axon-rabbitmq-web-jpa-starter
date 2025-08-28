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


private static boolean hasId(Object s) {
    return s != null ;
}


@EventHandler
public void on(SettingCreatedEvent event) {
try {
Setting entity = Setting.builder().build();
		if(event.getId() !=null  && hasId(event.getId().value()) ) {
            entity.setId( event.getId().value());
        }
 		if(event.getName() !=null  && hasId(event.getName().value()) ) {
            entity.setName( event.getName().value());
        }
 		if(event.getValue() !=null  && hasId(event.getValue().value()) ) {
            entity.setValue( event.getValue().value());
        }
 		if(event.getLocale() !=null  && hasId(event.getLocale().value()) ) {
            entity.setLocale( event.getLocale().value());
        }
 		if(event.getRemoteId() !=null  && hasId(event.getRemoteId().value()) ) {
            entity.setRemoteId( event.getRemoteId().value());
        }
 		if(event.getLocalId() !=null  && hasId(event.getLocalId().value()) ) {
            entity.setLocalId( event.getLocalId().value());
        }
 		if(event.getAccount() !=null  && hasId(event.getAccount().value()) ) {
            entity.setAccount( event.getAccount().value());
        }
 		if(event.getDetails() !=null  && hasId(event.getDetails().value()) ) {
            entity.setDetails( event.getDetails().value());
        }
 		if(event.getSyncAt() !=null  && hasId(event.getSyncAt().value()) ) {
            entity.setSyncAt( event.getSyncAt().value());
        }
 		if(event.getIsActive() !=null  && hasId(event.getIsActive().value()) ) {
            entity.setIsActive( event.getIsActive().value());
        }
 

    entity.setId(event.getId().value());

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


	if(event.getId() != null  && hasId(event.getId().value())) {
		entity.setId(event.getId().value());
    }
	if(event.getName() != null  && hasId(event.getName().value())) {
		entity.setName(event.getName().value());
    }
	if(event.getValue() != null  && hasId(event.getValue().value())) {
		entity.setValue(event.getValue().value());
    }
	if(event.getLocale() != null  && hasId(event.getLocale().value())) {
		entity.setLocale(event.getLocale().value());
    }
	if(event.getRemoteId() != null  && hasId(event.getRemoteId().value())) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getLocalId() != null  && hasId(event.getLocalId().value())) {
		entity.setLocalId(event.getLocalId().value());
    }
	if(event.getAccount() != null  && hasId(event.getAccount().value())) {
		entity.setAccount(event.getAccount().value());
    }
	if(event.getDetails() != null  && hasId(event.getDetails().value())) {
		entity.setDetails(event.getDetails().value());
    }
	if(event.getSyncAt() != null  && hasId(event.getSyncAt().value())) {
		entity.setSyncAt(event.getSyncAt().value());
    }
	if(event.getIsActive() != null  && hasId(event.getIsActive().value())) {
		entity.setIsActive(event.getIsActive().value());
    }

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
