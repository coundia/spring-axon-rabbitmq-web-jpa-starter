package com.groupe2cs.bizyhub.security.presentation.projection;

import com.groupe2cs.bizyhub.security.domain.event.PermissionCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.PermissionDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.PermissionUpdatedEvent;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@AllowReplay(value = false)
@Slf4j
@Component
@ProcessingGroup("Permission")
public class PermissionProjection {

	private final PermissionRepository repository;

	public PermissionProjection(PermissionRepository repository) {
		this.repository = repository;
	}

	@EventHandler
	public void on(PermissionCreatedEvent event) {
		try {
			Permission entity = Permission.builder()
					.id(event.getId().value())
					.name(event.getName().value())
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}


			repository.save(entity);
			log.info("Permission inserted: {}", entity);
		} catch (Exception e) {
			log.error("Error saving Permission: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(PermissionUpdatedEvent event) {
		try {
			Permission entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("Permission not found"));

			entity.setId(event.getId().value());
			entity.setName(event.getName().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
			}

			if (entity.getTenant() == null && event.getTenant() != null) {
				log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}",
						event.getTenant().value());
				entity.setTenant(new Tenant(event.getTenant().value()));
			}

			repository.save(entity);
			log.info("Permission updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating Permission: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(PermissionDeletedEvent event) {
		try {
			repository.deleteById(event.getId().value());
			log.info("Permission deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting Permission: {}", e.getMessage(), e);
			throw e;
		}
	}
}
