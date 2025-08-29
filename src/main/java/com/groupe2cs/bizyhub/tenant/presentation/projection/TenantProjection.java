package com.groupe2cs.bizyhub.tenant.presentation.projection;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.domain.event.TenantCreatedEvent;
import com.groupe2cs.bizyhub.tenant.domain.event.TenantDeletedEvent;
import com.groupe2cs.bizyhub.tenant.domain.event.TenantUpdatedEvent;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
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
@ProcessingGroup("Tenant")
public class TenantProjection {

	private final TenantRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(TenantCreatedEvent event) {
		try {
			Tenant entity = Tenant.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getName() != null && hasId(event.getName().value())) {
				entity.setName(event.getName().value());
			}
			if (event.getDescription() != null && hasId(event.getDescription().value())) {
				entity.setDescription(event.getDescription().value());
			}
			if (event.getDomain() != null && hasId(event.getDomain().value())) {
				entity.setDomain(event.getDomain().value());
			}
			if (event.getLanguage() != null && hasId(event.getLanguage().value())) {
				entity.setLanguage(event.getLanguage().value());
			}
			if (event.getActive() != null && hasId(event.getActive().value())) {
				entity.setActive(event.getActive().value());
			}


			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
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


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getName() != null && hasId(event.getName().value())) {
				entity.setName(event.getName().value());
			}
			if (event.getDescription() != null && hasId(event.getDescription().value())) {
				entity.setDescription(event.getDescription().value());
			}
			if (event.getDomain() != null && hasId(event.getDomain().value())) {
				entity.setDomain(event.getDomain().value());
			}
			if (event.getLanguage() != null && hasId(event.getLanguage().value())) {
				entity.setLanguage(event.getLanguage().value());
			}
			if (event.getActive() != null && hasId(event.getActive().value())) {
				entity.setActive(event.getActive().value());
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
