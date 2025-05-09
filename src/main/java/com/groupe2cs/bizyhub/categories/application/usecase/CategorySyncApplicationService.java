package com.groupe2cs.bizyhub.categories.application.usecase;

import com.groupe2cs.bizyhub.categories.application.command.CreateCategoryCommand;
import com.groupe2cs.bizyhub.categories.application.command.DeleteCategoryCommand;
import com.groupe2cs.bizyhub.categories.application.command.UpdateCategoryCommand;
import com.groupe2cs.bizyhub.categories.application.dto.CategorySyncRequest;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategorySyncApplicationService {

	private final CommandGateway commandGateway;

	public void syncCategory(CategorySyncRequest request,
							 MetaRequest metaRequest

	) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {

					CreateCategoryCommand command = CreateCategoryCommand.builder()
							.name(CategoryName.create(d.getName()))
							.typeCategory(CategoryTypeCategory.create(d.getTypeCategory()))
							.parentId(CategoryParentId.create(d.getParentId()))
							.isDefault(CategoryIsDefault.create(d.getIsDefault()))
							.icon(CategoryIcon.create(d.getIcon()))
							.colorHex(CategoryColorHex.create(d.getColorHex()))
							.build();
					if (metaRequest.getTenantId() != null) {
						command.setTenant(CategoryTenant.create(metaRequest.getTenantId()));
					}
					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(CategoryCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(
							command
					);

				}
				case "UPDATE" -> {
					UpdateCategoryCommand update = UpdateCategoryCommand.builder()
							.id(CategoryId.create(d.getId()))
							.name(CategoryName.create(d.getName()))
							.typeCategory(CategoryTypeCategory.create(d.getTypeCategory()))
							.parentId(CategoryParentId.create(d.getParentId()))
							.isDefault(CategoryIsDefault.create(d.getIsDefault()))
							.icon(CategoryIcon.create(d.getIcon()))
							.colorHex(CategoryColorHex.create(d.getColorHex()))
							.build();

					if (metaRequest.getTenantId() != null) {
						//command.setTenant(CategoryTenant.create(metaRequest.getTenantId()));
					}
					if (metaRequest.getUserId() != null) {
						//command.setCreatedBy( CategoryCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(
							update
					);

				}
				case "DELETE" -> {
					DeleteCategoryCommand delete = DeleteCategoryCommand.builder()
							.id(CategoryId.create(d.getId()))
							.build();

					if (metaRequest.getTenantId() != null) {
						//delete.setTenant(CategoryTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						//delete.setCreatedBy( CategoryCreatedBy.create(metaRequest.getUserId()));
					}
					commandGateway.sendAndWait(
							delete
					);
				}
			}
		}
	}
}
