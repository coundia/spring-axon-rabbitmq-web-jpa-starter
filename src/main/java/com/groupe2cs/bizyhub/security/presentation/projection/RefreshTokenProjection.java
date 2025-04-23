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
@ProcessingGroup("RefreshToken")
public class RefreshTokenProjection {

private final RefreshTokenRepository repository;

public RefreshTokenProjection(RefreshTokenRepository repository) {
this.repository = repository;
}

@EventHandler
public void on(RefreshTokenCreatedEvent event) {
try {
RefreshToken entity = new RefreshToken(
		event.getId().value(),
		event.getToken().value(),
		event.getUsername().value(),
		event.getExpiration().value()
);
repository.save(entity);
log.info("RefreshToken inserted: {}", entity);
} catch (Exception e) {
log.error("Error saving RefreshToken: {}", e.getMessage(), e);

throw e;
}
}

@EventHandler
public void on(RefreshTokenUpdatedEvent event) {
try {
	RefreshToken entity = repository.findById(event.getId().value())
	.orElseThrow(() -> new RuntimeException("RefreshToken not found"));
	entity.setId(event.getId().value());
	entity.setToken(event.getToken().value());
	entity.setUsername(event.getUsername().value());
	entity.setExpiration(event.getExpiration().value());
	repository.save(entity);
	log.info("RefreshToken updated successfully: {}", event.getId().value());
	} catch (Exception e) {
	log.error("Error updating RefreshToken: {}", e.getMessage(), e);
	throw e;
	}
}

@EventHandler
public void on(RefreshTokenDeletedEvent event) {
try {
repository.deleteById(event.getId().value());
log.info("RefreshToken deleted successfully: {}", event.getId().value());
} catch (Exception e) {
	log.error("Error deleting RefreshToken: {}", e.getMessage(), e);
	throw e;
}
}
}
