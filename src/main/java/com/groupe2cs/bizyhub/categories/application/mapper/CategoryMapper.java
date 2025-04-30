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
				.name(entity.getName())
				.typeCategory(entity.getTypeCategory())
				.parentId(entity.getParentId())
				.isDefault(entity.getIsDefault())
				.icon(entity.getIcon())
				.colorHex(entity.getColorHex())
				.build();
	}

	public static CategoryResponse toResponse(CreateCategoryCommand command) {
		return CategoryResponse.builder()
				.id(command.getId().value())
				.name(command.getName().value())
				.typeCategory(command.getTypeCategory().value())
				.parentId(command.getParentId().value())
				.isDefault(command.getIsDefault().value())
				.icon(command.getIcon().value())
				.colorHex(command.getColorHex().value())
				.build();
	}

	public static CategoryResponse toResponse(UpdateCategoryCommand command) {
		return CategoryResponse.builder()
				.id(command.getId().value())
				.name(command.getName().value())
				.typeCategory(command.getTypeCategory().value())
				.parentId(command.getParentId().value())
				.isDefault(command.getIsDefault().value())
				.icon(command.getIcon().value())
				.colorHex(command.getColorHex().value())
				.build();
	}

	public static CreateCategoryCommand toCommand(
			CategoryRequest request
	) {
		return CreateCategoryCommand.builder()
				.name(CategoryName.create(request.getName()))
				.typeCategory(CategoryTypeCategory.create(request.getTypeCategory()))
				.parentId(CategoryParentId.create(request.getParentId()))
				.isDefault(CategoryIsDefault.create(request.getIsDefault()))
				.icon(CategoryIcon.create(request.getIcon()))
				.colorHex(CategoryColorHex.create(request.getColorHex()))
				.build();
	}

	public static UpdateCategoryCommand toUpdateCommand(CategoryId id, CategoryRequest request) {
		return UpdateCategoryCommand.builder()
				.id(id)
				.name(CategoryName.create(request.getName()))
				.typeCategory(CategoryTypeCategory.create(request.getTypeCategory()))
				.parentId(CategoryParentId.create(request.getParentId()))
				.isDefault(CategoryIsDefault.create(request.getIsDefault()))
				.icon(CategoryIcon.create(request.getIcon()))
				.colorHex(CategoryColorHex.create(request.getColorHex()))
				.build();
	}


	public static DeleteCategoryCommand toDeleteCommand(CategoryId id) {
		return DeleteCategoryCommand.builder()
				.id(id)
				.build();
	}
}
