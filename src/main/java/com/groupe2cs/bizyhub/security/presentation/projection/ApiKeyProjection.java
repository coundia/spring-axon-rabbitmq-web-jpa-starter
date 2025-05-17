package com.groupe2cs.bizyhub.security.presentation.projection;

import com.groupe2cs.bizyhub.security.domain.event.ApiKeyCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.ApiKeyDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.ApiKeyUpdatedEvent;
import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
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
@ProcessingGroup("ApiKey")
public class ApiKeyProjection {

	private final ApiKeyRepository repository;


	@EventHandler
	public void on(ApiKeyCreatedEvent event) {
		try {
			ApiKey entity = ApiKey.builder()
					.id(event.getId() == null ? null : event.getId().value())
					.appKey(event.getAppKey() == null ? null : event.getAppKey().value())
					.username(event.getUsername() == null ? null : event.getUsername().value())
					.active(event.getActive() == null ? null : event.getActive().value())
					.createdAt(event.getCreatedAt() == null ? null : event.getCreatedAt().value())
					.expiration(event.getExpiration() == null ? null : event.getExpiration().value())
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}


			repository.save(entity);


			log.info("ApiKey inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving ApiKey: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(ApiKeyUpdatedEvent event) {
		try {
			ApiKey entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("ApiKey not found"));


			if (event.getId() != null) {
				entity.setId(event.getId().value());
			}
			if (event.getAppKey() != null) {
				entity.setAppKey(event.getAppKey().value());
			}
			if (event.getUsername() != null) {
				entity.setUsername(event.getUsername().value());
			}
			if (event.getActive() != null) {
				entity.setActive(event.getActive().value());
			}
			if (event.getCreatedAt() != null) {
				entity.setCreatedAt(event.getCreatedAt().value());
			}
			if (event.getExpiration() != null) {
				entity.setExpiration(event.getExpiration().value());
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


			log.info("ApiKey updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating ApiKey: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(ApiKeyDeletedEvent event) {
		try {


			repository.deleteById(event.getId().value());
			log.info("ApiKey deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting ApiKey: {}", e.getMessage(), e);
			throw e;
		}
	}
}
