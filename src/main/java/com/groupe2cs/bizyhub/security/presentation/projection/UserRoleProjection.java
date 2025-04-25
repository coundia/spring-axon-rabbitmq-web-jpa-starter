package com.groupe2cs.bizyhub.security.presentation.projection;

import com.groupe2cs.bizyhub.security.domain.event.UserRoleCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.UserRoleDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.UserRoleUpdatedEvent;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@AllowReplay(value = false)
@Slf4j
@Component
@ProcessingGroup("UserRole")
public class UserRoleProjection {

	private final UserRoleRepository repository;

	public UserRoleProjection(UserRoleRepository repository) {
		this.repository = repository;
	}

	@EventHandler
	public void on(UserRoleCreatedEvent event) {
		try {
			UserRole entity = UserRole.builder()
					.id(event.getId().value())
					.user(new User(event.getUser().value()))
					.role(new Role(event.getRole().value()))
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}

			repository.save(entity);
			log.info("UserRole inserted: {}", entity);
		} catch (Exception e) {
			log.error("Error saving UserRole: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(UserRoleUpdatedEvent event) {
		try {
			UserRole entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("UserRole not found"));

			entity.setId(event.getId().value());
			entity.setUser(new User(event.getUser().value()));
			entity.setRole(new Role(event.getRole().value()));

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}


			repository.save(entity);
			log.info("UserRole updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating UserRole: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(UserRoleDeletedEvent event) {
		try {
			repository.deleteById(event.getId().value());
			log.info("UserRole deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting UserRole: {}", e.getMessage(), e);
			throw e;
		}
	}
}
