package com.groupe2cs.bizyhub.fileManager.presentation.projection;

import com.groupe2cs.bizyhub.fileManager.domain.event.FileManagerCreatedEvent;
import com.groupe2cs.bizyhub.fileManager.domain.event.FileManagerDeletedEvent;
import com.groupe2cs.bizyhub.fileManager.domain.event.FileManagerUpdatedEvent;
import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.FileManager;
import com.groupe2cs.bizyhub.fileManager.infrastructure.repository.FileManagerRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
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
@ProcessingGroup("FileManager")
public class FileManagerProjection {

	private final FileManagerRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(FileManagerCreatedEvent event) {
		try {
			FileManager entity = FileManager.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getName() != null && hasId(event.getName().value())) {
				entity.setName(event.getName().value());
			}
			if (event.getDetails() != null && hasId(event.getDetails().value())) {
				entity.setDetails(event.getDetails().value());
			}
			if (event.getObjectId() != null && hasId(event.getObjectId().value())) {
				entity.setObjectId(event.getObjectId().value());
			}
			if (event.getObjectName() != null && hasId(event.getObjectName().value())) {
				entity.setObjectName(event.getObjectName().value());
			}
			if (event.getOriginalName() != null && hasId(event.getOriginalName().value())) {
				entity.setOriginalName(event.getOriginalName().value());
			}
			if (event.getMimeType() != null && hasId(event.getMimeType().value())) {
				entity.setMimeType(event.getMimeType().value());
			}
			if (event.getSize() != null && hasId(event.getSize().value())) {
				entity.setSize(event.getSize().value());
			}
			if (event.getPath() != null && hasId(event.getPath().value())) {
				entity.setPath(event.getPath().value());
			}
			if (event.getUri() != null && hasId(event.getUri().value())) {
				entity.setUri(event.getUri().value());
			}
			if (event.getIsPublic() != null && hasId(event.getIsPublic().value())) {
				entity.setIsPublic(event.getIsPublic().value());
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


			log.info("FileManager inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving FileManager: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(FileManagerUpdatedEvent event) {
		try {
			FileManager entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("FileManager not found"));


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getName() != null && hasId(event.getName().value())) {
				entity.setName(event.getName().value());
			}
			if (event.getDetails() != null && hasId(event.getDetails().value())) {
				entity.setDetails(event.getDetails().value());
			}
			if (event.getObjectId() != null && hasId(event.getObjectId().value())) {
				entity.setObjectId(event.getObjectId().value());
			}
			if (event.getObjectName() != null && hasId(event.getObjectName().value())) {
				entity.setObjectName(event.getObjectName().value());
			}
			if (event.getOriginalName() != null && hasId(event.getOriginalName().value())) {
				entity.setOriginalName(event.getOriginalName().value());
			}
			if (event.getMimeType() != null && hasId(event.getMimeType().value())) {
				entity.setMimeType(event.getMimeType().value());
			}
			if (event.getSize() != null && hasId(event.getSize().value())) {
				entity.setSize(event.getSize().value());
			}
			if (event.getPath() != null && hasId(event.getPath().value())) {
				entity.setPath(event.getPath().value());
			}
			if (event.getUri() != null && hasId(event.getUri().value())) {
				entity.setUri(event.getUri().value());
			}
			if (event.getIsPublic() != null && hasId(event.getIsPublic().value())) {
				entity.setIsPublic(event.getIsPublic().value());
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


			log.info("FileManager updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating FileManager: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(FileManagerDeletedEvent event) {
		try {


			repository.deleteById(event.getId().value());
			log.info("FileManager deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting FileManager: {}", e.getMessage(), e);
			throw e;
		}
	}
}
