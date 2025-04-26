package com.groupe2cs.bizyhub.security.presentation.projection;

import com.groupe2cs.bizyhub.security.domain.event.PasswordResetCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.PasswordResetDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.PasswordResetUpdatedEvent;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PasswordResetRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

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
			PasswordReset entity = PasswordReset.builder()
					.id(event.getId().value())
					.token(event.getToken().value())
					.username(event.getUsername().value())
					.expiration(event.getExpiration().value())
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
			}

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

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
			}


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
