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
@ProcessingGroup("PasswordReset")
public class PasswordResetProjection {

private final PasswordResetRepository repository;

public PasswordResetProjection(PasswordResetRepository repository) {
this.repository = repository;
}

@EventHandler
public void on(PasswordResetCreatedEvent event) {
try {
PasswordReset entity = new PasswordReset(
		event.getId().value(),
		event.getToken().value(),
		event.getUsername().value(),
		event.getExpiration().value()
);
repository.save(entity);
log.info("PasswordReset inserted: {}", entity);
} catch (Exception e) {
log.error("Error saving PasswordReset: {}", e.getMessage(), e);

throw e;
}
}

@EventHandler
public void on(PasswordResetUpdatedEvent event) {
try {
	PasswordReset entity = repository.findById(event.getId().value())
	.orElseThrow(() -> new RuntimeException("PasswordReset not found"));
	entity.setId(event.getId().value());
	entity.setToken(event.getToken().value());
	entity.setUsername(event.getUsername().value());
	entity.setExpiration(event.getExpiration().value());
	repository.save(entity);
	log.info("PasswordReset updated successfully: {}", event.getId().value());
	} catch (Exception e) {
	log.error("Error updating PasswordReset: {}", e.getMessage(), e);
	throw e;
	}
}

@EventHandler
public void on(PasswordResetDeletedEvent event) {
try {
repository.deleteById(event.getId().value());
log.info("PasswordReset deleted successfully: {}", event.getId().value());
} catch (Exception e) {
	log.error("Error deleting PasswordReset: {}", e.getMessage(), e);
	throw e;
}
}
}
