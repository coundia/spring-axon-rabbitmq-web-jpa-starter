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


	@EventHandler
	public void on(FileManagerCreatedEvent event) {
		try {
			FileManager entity = FileManager.builder()
					.id(event.getId() == null ? null : event.getId().value())
					.name(event.getName() == null ? null : event.getName().value())
					.details(event.getDetails() == null ? null : event.getDetails().value())
					.objectId(event.getObjectId() == null ? null : event.getObjectId().value())
					.objectName(event.getObjectName() == null ? null : event.getObjectName().value())
					.originalName(event.getOriginalName() == null ? null : event.getOriginalName().value())
					.mimeType(event.getMimeType() == null ? null : event.getMimeType().value())
					.size(event.getSize() == null ? null : event.getSize().value())
					.path(event.getPath() == null ? null : event.getPath().value())
					.uri(event.getUri() == null ? null : event.getUri().value())
					.isPublic(event.getIsPublic() == null ? null : event.getIsPublic().value())
					.build();

			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}


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


			if (event.getId() != null) {
				entity.setId(event.getId().value());
			}
			if (event.getName() != null) {
				entity.setName(event.getName().value());
			}
			if (event.getDetails() != null) {
				entity.setDetails(event.getDetails().value());
			}
			if (event.getObjectId() != null) {
				entity.setObjectId(event.getObjectId().value());
			}
			if (event.getObjectName() != null) {
				entity.setObjectName(event.getObjectName().value());
			}
			if (event.getOriginalName() != null) {
				entity.setOriginalName(event.getOriginalName().value());
			}
			if (event.getMimeType() != null) {
				entity.setMimeType(event.getMimeType().value());
			}
			if (event.getSize() != null) {
				entity.setSize(event.getSize().value());
			}
			if (event.getPath() != null) {
				entity.setPath(event.getPath().value());
			}
			if (event.getUri() != null) {
				entity.setUri(event.getUri().value());
			}
			if (event.getIsPublic() != null) {
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
