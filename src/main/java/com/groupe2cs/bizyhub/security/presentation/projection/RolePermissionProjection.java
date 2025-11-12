package com.groupe2cs.bizyhub.security.presentation.projection;

import com.groupe2cs.bizyhub.security.domain.event.RolePermissionCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.RolePermissionDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.RolePermissionUpdatedEvent;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
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
@ProcessingGroup("RolePermission")
public class RolePermissionProjection {

	private final RolePermissionRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(RolePermissionCreatedEvent event) {
		try {
			RolePermission entity = RolePermission.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getRole() != null && hasId(event.getRole().value())) {
				entity.setRole(new Role(event.getRole().value()));
			}

			if (event.getPermission() != null && hasId(event.getPermission().value())) {
				entity.setPermission(new Permission(event.getPermission().value()));
			}


			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}

/*
	if(event.getRemoteId().value() == null) {
		entity.setRemoteId(event.getId().value());
	}
	*/

			repository.save(entity);


			log.info("RolePermission inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving RolePermission: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(RolePermissionUpdatedEvent event) {
		try {
			RolePermission entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("RolePermission not found"));


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}

			if (event.getRole() != null && hasId(event.getRole().value())) {
				entity.setRole(new Role(event.getRole().value()));
			}

			if (event.getPermission() != null && hasId(event.getPermission().value())) {
				entity.setPermission(new Permission(event.getPermission().value()));
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


			log.info("RolePermission updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating RolePermission: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(RolePermissionDeletedEvent event) {
		try {


			repository.deleteById(event.getId().value());
			log.info("RolePermission deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting RolePermission: {}", e.getMessage(), e);
			throw e;
		}
	}
}
