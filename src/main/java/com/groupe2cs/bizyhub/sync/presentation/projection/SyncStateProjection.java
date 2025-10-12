package com.groupe2cs.bizyhub.sync.presentation.projection;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.sync.domain.event.SyncStateCreatedEvent;
import com.groupe2cs.bizyhub.sync.domain.event.SyncStateDeletedEvent;
import com.groupe2cs.bizyhub.sync.domain.event.SyncStateUpdatedEvent;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.SyncState;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.SyncStateRepository;
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
@ProcessingGroup("SyncState")
public class SyncStateProjection {

	private final SyncStateRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(SyncStateCreatedEvent event) {
		try {
			SyncState entity = SyncState.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getEntityTable() != null && hasId(event.getEntityTable().value())) {
				entity.setEntityTable(event.getEntityTable().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getLastSyncAt() != null && hasId(event.getLastSyncAt().value())) {
				entity.setLastSyncAt(event.getLastSyncAt().value());
			}
			if (event.getLastCursor() != null && hasId(event.getLastCursor().value())) {
				entity.setLastCursor(event.getLastCursor().value());
			}


			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}
			if (event.getRemoteId().value() == null) {
				entity.setRemoteId(event.getId().value());
			}


			repository.save(entity);


			log.info("SyncState inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving SyncState: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(SyncStateUpdatedEvent event) {
		try {
			SyncState entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("SyncState not found"));


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getEntityTable() != null && hasId(event.getEntityTable().value())) {
				entity.setEntityTable(event.getEntityTable().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getLastSyncAt() != null && hasId(event.getLastSyncAt().value())) {
				entity.setLastSyncAt(event.getLastSyncAt().value());
			}
			if (event.getLastCursor() != null && hasId(event.getLastCursor().value())) {
				entity.setLastCursor(event.getLastCursor().value());
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


			log.info("SyncState updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating SyncState: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(SyncStateDeletedEvent event) {
		try {


			repository.deleteById(event.getId().value());
			log.info("SyncState deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting SyncState: {}", e.getMessage(), e);
			throw e;
		}
	}
}
