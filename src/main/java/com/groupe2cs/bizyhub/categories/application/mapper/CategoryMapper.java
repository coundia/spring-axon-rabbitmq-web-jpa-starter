package com.groupe2cs.bizyhub.categories.application.mapper;

	import com.groupe2cs.bizyhub.categories.application.dto.*;
	import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
	import com.groupe2cs.bizyhub.categories.domain.*;
	import com.groupe2cs.bizyhub.categories.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.categories.application.command.*;

public class CategoryMapper {

public static CategoryResponse toResponse(Category entity) {
return CategoryResponse.builder()
		.id(entity.getId())
		.reference(entity.getReference())
		.name(entity.getName())
		.updatedAt(entity.getUpdatedAt())
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
	.reference(command.getReference().value())
	.name(command.getName().value())
	.updatedAt(command.getUpdatedAt().value())
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
	.reference(command.getReference().value())
	.name(command.getName().value())
	.updatedAt(command.getUpdatedAt().value())
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
	.reference(CategoryReference.create(request.getReference()))
	.name(CategoryName.create(request.getName()))
	.updatedAt(CategoryUpdatedAt.create(request.getUpdatedAt()))
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
		.reference(CategoryReference.create(request.getReference()))
		.name(CategoryName.create(request.getName()))
		.updatedAt(CategoryUpdatedAt.create(request.getUpdatedAt()))
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
