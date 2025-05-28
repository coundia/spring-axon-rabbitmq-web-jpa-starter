package com.groupe2cs.bizyhub.fileManager.application.usecase;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.fileManager.application.command.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;
import com.groupe2cs.bizyhub.fileManager.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class FileManagerSyncApplicationService {

	private final FileManagerGate gateService;
	private final CommandGateway commandGateway;

	public void syncFileManager(FileManagerSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateFileManagerCommand command = CreateFileManagerCommand.builder()
								.name(FileManagerName.create(d.getName()))
								.details(FileManagerDetails.create(d.getDetails()))
								.objectId(FileManagerObjectId.create(d.getObjectId()))
								.objectName(FileManagerObjectName.create(d.getObjectName()))
								.originalName(FileManagerOriginalName.create(d.getOriginalName()))
								.mimeType(FileManagerMimeType.create(d.getMimeType()))
								.size(FileManagerSize.create(d.getSize()))
								.path(FileManagerPath.create(d.getPath()))
								.uri(FileManagerUri.create(d.getUri()))
								.isPublic(FileManagerIsPublic.create(d.getIsPublic()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(FileManagerTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(FileManagerCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update FileManager with id " + d.getId());
					}

					UpdateFileManagerCommand update = UpdateFileManagerCommand.builder()
							.id(FileManagerId.create(d.getId()))
							.name(FileManagerName.create(d.getName()))
							.details(FileManagerDetails.create(d.getDetails()))
							.objectId(FileManagerObjectId.create(d.getObjectId()))
							.objectName(FileManagerObjectName.create(d.getObjectName()))
							.originalName(FileManagerOriginalName.create(d.getOriginalName()))
							.mimeType(FileManagerMimeType.create(d.getMimeType()))
							.size(FileManagerSize.create(d.getSize()))
							.path(FileManagerPath.create(d.getPath()))
							.uri(FileManagerUri.create(d.getUri()))
							.isPublic(FileManagerIsPublic.create(d.getIsPublic()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete FileManager with id " + d.getId());
					}

					DeleteFileManagerCommand delete = DeleteFileManagerCommand.builder()
						.id(FileManagerId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
