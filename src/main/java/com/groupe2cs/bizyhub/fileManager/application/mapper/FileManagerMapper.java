package com.groupe2cs.bizyhub.fileManager.application.mapper;

import com.groupe2cs.bizyhub.fileManager.application.command.CreateFileManagerCommand;
import com.groupe2cs.bizyhub.fileManager.application.command.DeleteFileManagerCommand;
import com.groupe2cs.bizyhub.fileManager.application.command.UpdateFileManagerCommand;
import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerRequest;
import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerResponse;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;
import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.FileManager;

public class FileManagerMapper {

	public static FileManagerResponse toResponse(FileManager entity) {
		return FileManagerResponse.builder()
				.id(entity.getId())
				.name(entity.getName())
				.details(entity.getDetails())
				.objectId(entity.getObjectId())
				.objectName(entity.getObjectName())
				.originalName(entity.getOriginalName())
				.mimeType(entity.getMimeType())
				.size(entity.getSize())
				.path(entity.getPath())
				.uri(entity.getUri())
				.isPublic(entity.getIsPublic())
				.createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername() : null)
				.tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
				.build();
	}

	public static FileManagerResponse toResponse(CreateFileManagerCommand command) {
		return FileManagerResponse.builder()
				.id(command.getId().value())
				.name(command.getName().value())
				.details(command.getDetails().value())
				.objectId(command.getObjectId().value())
				.objectName(command.getObjectName().value())
				.originalName(command.getOriginalName().value())
				.mimeType(command.getMimeType().value())
				.size(command.getSize().value())
				.path(command.getPath().value())
				.uri(command.getUri().value())
				.isPublic(command.getIsPublic().value())
				.build();
	}

	public static FileManagerResponse toResponse(UpdateFileManagerCommand command) {
		return FileManagerResponse.builder()
				.id(command.getId().value())
				.name(command.getName().value())
				.details(command.getDetails().value())
				.objectId(command.getObjectId().value())
				.objectName(command.getObjectName().value())
				.originalName(command.getOriginalName().value())
				.mimeType(command.getMimeType().value())
				.size(command.getSize().value())
				.path(command.getPath().value())
				.uri(command.getUri().value())
				.isPublic(command.getIsPublic().value())
				.build();
	}

	public static CreateFileManagerCommand toCommand(
			FileManagerRequest request
	) {
		return CreateFileManagerCommand.builder()
				.name(FileManagerName.create(request.getName()))
				.details(FileManagerDetails.create(request.getDetails()))
				.objectId(FileManagerObjectId.create(request.getObjectId()))
				.objectName(FileManagerObjectName.create(request.getObjectName()))
				.originalName(FileManagerOriginalName.create(request.getOriginalName()))
				.mimeType(FileManagerMimeType.create(request.getMimeType()))
				.size(FileManagerSize.create(request.getSize()))
				.path(FileManagerPath.create(request.getPath()))
				.uri(FileManagerUri.create(request.getUri()))
				.isPublic(FileManagerIsPublic.create(request.getIsPublic()))
				.build();
	}

	public static UpdateFileManagerCommand toUpdateCommand(FileManagerId id, FileManagerRequest request) {
		return UpdateFileManagerCommand.builder()
				.id(id)
				.name(FileManagerName.create(request.getName()))
				.details(FileManagerDetails.create(request.getDetails()))
				.objectId(FileManagerObjectId.create(request.getObjectId()))
				.objectName(FileManagerObjectName.create(request.getObjectName()))
				.originalName(FileManagerOriginalName.create(request.getOriginalName()))
				.mimeType(FileManagerMimeType.create(request.getMimeType()))
				.size(FileManagerSize.create(request.getSize()))
				.path(FileManagerPath.create(request.getPath()))
				.uri(FileManagerUri.create(request.getUri()))
				.isPublic(FileManagerIsPublic.create(request.getIsPublic()))
				.build();
	}


	public static DeleteFileManagerCommand toDeleteCommand(FileManagerId id) {
		return DeleteFileManagerCommand.builder()
				.id(id)
				.build();
	}
}
