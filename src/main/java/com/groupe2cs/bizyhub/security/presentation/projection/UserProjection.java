package com.groupe2cs.bizyhub.security.presentation.projection;

import com.groupe2cs.bizyhub.security.domain.event.UserCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.UserDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.UserUpdatedEvent;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
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


			if (event.getId() != null) {
				entity.setId(event.getId().value());
			}
			if (event.getUsername() != null) {
				entity.setUsername(event.getUsername().value());
			}
			if (event.getPassword() != null) {
				entity.setPassword(event.getPassword().value());
			}

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}

			if (entity.getTenant() == null && event.getTenant() != null) {
				log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}",
						event.getTenant().value());
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
