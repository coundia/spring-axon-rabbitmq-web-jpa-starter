package com.groupe2cs.bizyhub.categories.application.usecase;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.categories.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;


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
		.typeCategoryRaw(CategoryTypeCategoryRaw.create(d.getTypeCategoryRaw()))
		.details(CategoryDetails.create(d.getDetails()))
		.isActive(CategoryIsActive.create(d.getIsActive()))
		.updatedAt(CategoryUpdatedAt.create(d.getUpdatedAt()))
		.reference(CategoryReference.create(d.getReference()))
.build();
		if(metaRequest.getTenantId() != null) {
			command.setTenant(CategoryTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			command.setCreatedBy( CategoryCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
							command
				);

		}
				case "UPDATE" -> {
		UpdateCategoryCommand update = UpdateCategoryCommand.builder()
			.id(CategoryId.create(d.getId()))
			.name(CategoryName.create(d.getName()))
			.typeCategoryRaw(CategoryTypeCategoryRaw.create(d.getTypeCategoryRaw()))
			.details(CategoryDetails.create(d.getDetails()))
			.isActive(CategoryIsActive.create(d.getIsActive()))
			.updatedAt(CategoryUpdatedAt.create(d.getUpdatedAt()))
			.reference(CategoryReference.create(d.getReference()))
		.build();

		if(metaRequest.getTenantId() != null) {
			//update.setTenant(CategoryTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			//update.setCreatedBy( CategoryCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
		update
				);

		}
		case "DELETE" -> {
				DeleteCategoryCommand delete = DeleteCategoryCommand.builder()
					.id(CategoryId.create(d.getId()) )
					.build();

				if(metaRequest.getTenantId() != null) {
					//delete.setTenant(CategoryTenant.create(metaRequest.getTenantId()));
				}

				if(metaRequest.getUserId() != null) {
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
