package com.groupe2cs.bizyhub.security.presentation.projection;

import com.groupe2cs.bizyhub.security.domain.event.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import org.axonframework.eventhandling.EventHandler;

import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.config.ProcessingGroup;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@AllowReplay(value = false)
@Slf4j
@Component
@ProcessingGroup("User")
public class UserProjection {

private final UserRepository repository;

public UserProjection(UserRepository repository) {
this.repository = repository;
}

@EventHandler
public void on(UserCreatedEvent event) {
try {
User entity = new User(
		event.getId().value(),
		event.getUsername().value(),
		event.getPassword().value(),
		null
);
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
	entity.setId(event.getId().value());
	entity.setUsername(event.getUsername().value());
	entity.setPassword(event.getPassword().value());
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
