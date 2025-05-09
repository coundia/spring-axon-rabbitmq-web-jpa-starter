package com.groupe2cs.bizyhub.security.presentation.projection;

import com.groupe2cs.bizyhub.security.domain.event.RefreshTokenCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.RefreshTokenDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.RefreshTokenUpdatedEvent;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RefreshToken;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RefreshTokenRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

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
			RefreshToken entity = RefreshToken.builder()
					.id(event.getId().value())
					.token(event.getToken().value())
					.username(event.getUsername().value())
					.expiration(event.getExpiration().value())
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}


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

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new CustomUser(event.getCreatedBy().value()));
			}

			if (entity.getTenant() == null && event.getTenant() != null) {
				log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}",
						event.getTenant().value());
				entity.setTenant(new Tenant(event.getTenant().value()));
			}

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
