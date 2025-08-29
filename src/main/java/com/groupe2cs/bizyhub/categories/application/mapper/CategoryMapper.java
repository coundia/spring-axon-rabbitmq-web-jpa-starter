package com.groupe2cs.bizyhub.categories.application.mapper;

import com.groupe2cs.bizyhub.categories.application.command.CreateCategoryCommand;
import com.groupe2cs.bizyhub.categories.application.command.DeleteCategoryCommand;
import com.groupe2cs.bizyhub.categories.application.command.UpdateCategoryCommand;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryRequest;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryResponse;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;

public class CategoryMapper {

	public static CategoryResponse toResponse(Category entity) {
		return CategoryResponse.builder()
				.id(entity.getId())
				.code(entity.getCode())
				.name(entity.getName())
				.remoteId(entity.getRemoteId())
				.localId(entity.getLocalId())
				.account(entity.getAccount())
				.description(entity.getDescription())
				.typeEntry(entity.getTypeEntry())
				.version(entity.getVersion())
				.syncAt(entity.getSyncAt())
				.createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername() : null)
				.tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
				.build();
	}

	public static CategoryResponse toResponse(CreateCategoryCommand command) {
		return CategoryResponse.builder()
				.id(command.getId().value())
				.code(command.getCode().value())
				.name(command.getName().value())
				.remoteId(command.getRemoteId().value())
				.localId(command.getLocalId().value())
				.account(command.getAccount().value())
				.description(command.getDescription().value())
				.typeEntry(command.getTypeEntry().value())
				.version(command.getVersion().value())
				.syncAt(command.getSyncAt().value())
				.build();
	}

	public static CategoryResponse toResponse(UpdateCategoryCommand command) {
		return CategoryResponse.builder()
				.id(command.getId().value())
				.code(command.getCode().value())
				.name(command.getName().value())
				.remoteId(command.getRemoteId().value())
				.localId(command.getLocalId().value())
				.account(command.getAccount().value())
				.description(command.getDescription().value())
				.typeEntry(command.getTypeEntry().value())
				.version(command.getVersion().value())
				.syncAt(command.getSyncAt().value())
				.build();
	}

	public static CreateCategoryCommand toCommand(
			CategoryRequest request
	) {
		return CreateCategoryCommand.builder()
				.code(CategoryCode.create(request.getCode()))
				.name(CategoryName.create(request.getName()))
				.remoteId(CategoryRemoteId.create(request.getRemoteId()))
				.localId(CategoryLocalId.create(request.getLocalId()))
				.account(CategoryAccount.create(request.getAccount()))
				.description(CategoryDescription.create(request.getDescription()))
				.typeEntry(CategoryTypeEntry.create(request.getTypeEntry()))
				.version(CategoryVersion.create(request.getVersion()))
				.syncAt(CategorySyncAt.create(request.getSyncAt()))
				.build();
	}

	public static UpdateCategoryCommand toUpdateCommand(CategoryId id, CategoryRequest request) {
		return UpdateCategoryCommand.builder()
				.id(id)
				.code(CategoryCode.create(request.getCode()))
				.name(CategoryName.create(request.getName()))
				.remoteId(CategoryRemoteId.create(request.getRemoteId()))
				.localId(CategoryLocalId.create(request.getLocalId()))
				.account(CategoryAccount.create(request.getAccount()))
				.description(CategoryDescription.create(request.getDescription()))
				.typeEntry(CategoryTypeEntry.create(request.getTypeEntry()))
				.version(CategoryVersion.create(request.getVersion()))
				.syncAt(CategorySyncAt.create(request.getSyncAt()))
				.build();
	}


	public static DeleteCategoryCommand toDeleteCommand(CategoryId id) {
		return DeleteCategoryCommand.builder()
				.id(id)
				.build();
	}
}
