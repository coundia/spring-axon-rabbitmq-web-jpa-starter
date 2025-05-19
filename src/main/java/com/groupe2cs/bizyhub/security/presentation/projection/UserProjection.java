package com.groupe2cs.bizyhub.security.presentation.projection;

	import com.groupe2cs.bizyhub.security.domain.event.*;
	import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
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
@ProcessingGroup("User")
public class UserProjection {

private final UserRepository repository;


@EventHandler
public void on(UserCreatedEvent event) {
try {
User entity = User.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.username(event.getUsername() == null ? null : event.getUsername().value())
 		.password(event.getPassword() == null ? null : event.getPassword().value())
 		.firstName(event.getFirstName() == null ? null : event.getFirstName().value())
 		.lastName(event.getLastName() == null ? null : event.getLastName().value())
 		.email(event.getEmail() == null ? null : event.getEmail().value())
 		.telephone(event.getTelephone() == null ? null : event.getTelephone().value())
 		.limitPerDay(event.getLimitPerDay() == null ? null : event.getLimitPerDay().value())
 		.isPremium(event.getIsPremium() == null ? null : event.getIsPremium().value())
 		.enabled(event.getEnabled() == null ? null : event.getEnabled().value())
 		.isBan(event.getIsBan() == null ? null : event.getIsBan().value())
 .build();

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("User inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving User: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(UserUpdatedEvent event) {
try {
User entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("User not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getUsername() != null) {
		entity.setUsername(event.getUsername().value());
    }
	if(event.getPassword() != null) {
		entity.setPassword(event.getPassword().value());
    }
	if(event.getFirstName() != null) {
		entity.setFirstName(event.getFirstName().value());
    }
	if(event.getLastName() != null) {
		entity.setLastName(event.getLastName().value());
    }
	if(event.getEmail() != null) {
		entity.setEmail(event.getEmail().value());
    }
	if(event.getTelephone() != null) {
		entity.setTelephone(event.getTelephone().value());
    }
	if(event.getLimitPerDay() != null) {
		entity.setLimitPerDay(event.getLimitPerDay().value());
    }
	if(event.getIsPremium() != null) {
		entity.setIsPremium(event.getIsPremium().value());
    }
	if(event.getEnabled() != null) {
		entity.setEnabled(event.getEnabled().value());
    }
	if(event.getIsBan() != null) {
		entity.setIsBan(event.getIsBan().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("User updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating User: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(UserDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("User deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting User: {}", e.getMessage(), e);
throw e;
}
}
}
