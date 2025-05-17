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

	private final CategoryGate gateService;
	private final CommandGateway commandGateway;

	public void syncCategory(CategorySyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateCategoryCommand command = CreateCategoryCommand.builder()
							.name(CategoryName.create(d.getName()))
							.typeCategoryRaw(CategoryTypeCategoryRaw.create(d.getTypeCategoryRaw()))
							.details(CategoryDetails.create(d.getDetails()))
							.isActive(CategoryIsActive.create(d.getIsActive()))
							.updatedAt(CategoryUpdatedAt.create(d.getUpdatedAt()))
							.reference(CategoryReference.create(d.getReference()))
							.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(CategoryTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(CategoryCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update Category with id " + d.getId());
					}

					UpdateCategoryCommand update = UpdateCategoryCommand.builder()
							.id(CategoryId.create(d.getId()))
							.name(CategoryName.create(d.getName()))
							.typeCategoryRaw(CategoryTypeCategoryRaw.create(d.getTypeCategoryRaw()))
							.details(CategoryDetails.create(d.getDetails()))
							.isActive(CategoryIsActive.create(d.getIsActive()))
							.updatedAt(CategoryUpdatedAt.create(d.getUpdatedAt()))
							.reference(CategoryReference.create(d.getReference()))
							.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete Category with id " + d.getId());
					}

					DeleteCategoryCommand delete = DeleteCategoryCommand.builder()
							.id(CategoryId.create(d.getId()))
							.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
