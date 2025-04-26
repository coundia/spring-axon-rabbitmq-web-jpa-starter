package com.groupe2cs.bizyhub.security.presentation.projection;

import com.groupe2cs.bizyhub.security.domain.event.UserCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.UserDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.UserUpdatedEvent;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

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
			CustomUser entity = CustomUser.builder()
					.id(event.getId().value())
					.username(event.getUsername().value())
					.password(event.getPassword().value())
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
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
			CustomUser entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("User not found"));

			entity.setId(event.getId().value());
			entity.setUsername(event.getUsername().value());
			entity.setPassword(event.getPassword().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
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
