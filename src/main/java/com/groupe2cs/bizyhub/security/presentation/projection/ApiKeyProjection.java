package com.groupe2cs.bizyhub.security.presentation.projection;

import com.groupe2cs.bizyhub.security.domain.event.ApiKeyCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.ApiKeyDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.ApiKeyUpdatedEvent;
import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@AllowReplay(value = false)
@Slf4j
@Component
@ProcessingGroup("ApiKey")
public class ApiKeyProjection {

	private final ApiKeyRepository repository;

	public ApiKeyProjection(ApiKeyRepository repository) {
		this.repository = repository;
	}

	@EventHandler
	public void on(ApiKeyCreatedEvent event) {
		try {
			ApiKey entity = ApiKey.builder()
					.id(event.getId().value())
					.appKey(event.getAppKey().value())
					.username(event.getUsername().value())
					.createdAt(event.getCreatedAt().value())
					.expiration(event.getExpiration().value())
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
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

			entity.setId(event.getId().value());
			entity.setAppKey(event.getAppKey().value());
			entity.setUsername(event.getUsername().value());
			entity.setCreatedAt(event.getCreatedAt().value());
			entity.setExpiration(event.getExpiration().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
			}

			if (event.getTenant() != null) {
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
