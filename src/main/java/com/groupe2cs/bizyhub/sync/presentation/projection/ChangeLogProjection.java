package com.groupe2cs.bizyhub.sync.presentation.projection;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.sync.domain.event.ChangeLogCreatedEvent;
import com.groupe2cs.bizyhub.sync.domain.event.ChangeLogDeletedEvent;
import com.groupe2cs.bizyhub.sync.domain.event.ChangeLogUpdatedEvent;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.ChangeLog;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.ChangeLogRepository;
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
@ProcessingGroup("ChangeLog")
public class ChangeLogProjection {

	private final ChangeLogRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(ChangeLogCreatedEvent event) {
		try {
			ChangeLog entity = ChangeLog.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getEntityTable() != null && hasId(event.getEntityTable().value())) {
				entity.setEntityTable(event.getEntityTable().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getOperation() != null && hasId(event.getOperation().value())) {
				entity.setOperation(event.getOperation().value());
			}
			if (event.getPayload() != null && hasId(event.getPayload().value())) {
				entity.setPayload(event.getPayload().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getAttempts() != null && hasId(event.getAttempts().value())) {
				entity.setAttempts(event.getAttempts().value());
			}
			if (event.getError() != null && hasId(event.getError().value())) {
				entity.setError(event.getError().value());
			}


			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}


			repository.save(entity);


			log.info("ChangeLog inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving ChangeLog: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(ChangeLogUpdatedEvent event) {
		try {
			ChangeLog entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("ChangeLog not found"));


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getEntityTable() != null && hasId(event.getEntityTable().value())) {
				entity.setEntityTable(event.getEntityTable().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getOperation() != null && hasId(event.getOperation().value())) {
				entity.setOperation(event.getOperation().value());
			}
			if (event.getPayload() != null && hasId(event.getPayload().value())) {
				entity.setPayload(event.getPayload().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getAttempts() != null && hasId(event.getAttempts().value())) {
				entity.setAttempts(event.getAttempts().value());
			}
			if (event.getError() != null && hasId(event.getError().value())) {
				entity.setError(event.getError().value());
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


			log.info("ChangeLog updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating ChangeLog: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(ChangeLogDeletedEvent event) {
		try {


			repository.deleteById(event.getId().value());
			log.info("ChangeLog deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting ChangeLog: {}", e.getMessage(), e);
			throw e;
		}
	}
}
