package com.groupe2cs.bizyhub.tenant.presentation.projection;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.domain.event.TenantCreatedEvent;
import com.groupe2cs.bizyhub.tenant.domain.event.TenantDeletedEvent;
import com.groupe2cs.bizyhub.tenant.domain.event.TenantUpdatedEvent;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@AllowReplay(value = false)
@Slf4j
@Component
@ProcessingGroup("Tenant")
public class TenantProjection {

	private final TenantRepository repository;

	public TenantProjection(TenantRepository repository) {
		this.repository = repository;
	}

	@EventHandler
	public void on(TenantCreatedEvent event) {
		try {
			Tenant entity = Tenant.builder()
					.id(event.getId().value())
					.name(event.getName().value())
					.description(event.getDescription().value())
					.domain(event.getDomain().value())
					.language(event.getLanguage().value())
					.active(event.getActive().value())
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}

			repository.save(entity);
			log.info("Tenant inserted: {}", entity);
		} catch (Exception e) {
			log.error("Error saving Tenant: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(TenantUpdatedEvent event) {
		try {
			Tenant entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("Tenant not found"));

			entity.setId(event.getId().value());
			entity.setName(event.getName().value());
			entity.setDescription(event.getDescription().value());
			entity.setDomain(event.getDomain().value());
			entity.setLanguage(event.getLanguage().value());
			entity.setActive(event.getActive().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}


			repository.save(entity);
			log.info("Tenant updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating Tenant: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(TenantDeletedEvent event) {
		try {
			repository.deleteById(event.getId().value());
			log.info("Tenant deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting Tenant: {}", e.getMessage(), e);
			throw e;
		}
	}
}
