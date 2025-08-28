package com.groupe2cs.bizyhub.categories.application.usecase;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.categories.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

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
								.code(CategoryCode.create(d.getCode()))
								.name(CategoryName.create(d.getName()))
								.remoteId(CategoryRemoteId.create(d.getRemoteId()))
								.localId(CategoryLocalId.create(d.getLocalId()))
								.account(CategoryAccount.create(d.getAccount()))
								.description(CategoryDescription.create(d.getDescription()))
								.typeEntry(CategoryTypeEntry.create(d.getTypeEntry()))
								.version(CategoryVersion.create(d.getVersion()))
								.syncAt(CategorySyncAt.create(d.getSyncAt()))
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
							.code(CategoryCode.create(d.getCode()))
							.name(CategoryName.create(d.getName()))
							.remoteId(CategoryRemoteId.create(d.getRemoteId()))
							.localId(CategoryLocalId.create(d.getLocalId()))
							.account(CategoryAccount.create(d.getAccount()))
							.description(CategoryDescription.create(d.getDescription()))
							.typeEntry(CategoryTypeEntry.create(d.getTypeEntry()))
							.version(CategoryVersion.create(d.getVersion()))
							.syncAt(CategorySyncAt.create(d.getSyncAt()))
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
