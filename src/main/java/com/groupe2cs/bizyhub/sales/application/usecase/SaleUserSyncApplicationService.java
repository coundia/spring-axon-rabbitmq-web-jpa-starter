package com.groupe2cs.bizyhub.sales.application.usecase;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class SaleUserSyncApplicationService {

	private final CommandGateway commandGateway;

	public void syncSaleUser(SaleUserSyncRequest request,
MetaRequest metaRequest

) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {

CreateSaleUserCommand command = CreateSaleUserCommand.builder()
		.sales(SaleUserSales.create(d.getSales()))
		.users(SaleUserUsers.create(d.getUsers()))
		.details(SaleUserDetails.create(d.getDetails()))
		.isActive(SaleUserIsActive.create(d.getIsActive()))
		.updatedAt(SaleUserUpdatedAt.create(d.getUpdatedAt()))
		.reference(SaleUserReference.create(d.getReference()))
.build();
		if(metaRequest.getTenantId() != null) {
			command.setTenant(SaleUserTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			command.setCreatedBy( SaleUserCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
							command
				);

		}
				case "UPDATE" -> {
		UpdateSaleUserCommand update = UpdateSaleUserCommand.builder()
			.id(SaleUserId.create(d.getId()))
			.sales(SaleUserSales.create(d.getSales()))
			.users(SaleUserUsers.create(d.getUsers()))
			.details(SaleUserDetails.create(d.getDetails()))
			.isActive(SaleUserIsActive.create(d.getIsActive()))
			.updatedAt(SaleUserUpdatedAt.create(d.getUpdatedAt()))
			.reference(SaleUserReference.create(d.getReference()))
		.build();

		if(metaRequest.getTenantId() != null) {
			//command.setTenant(SaleUserTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			//command.setCreatedBy( SaleUserCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
		update
				);

		}
		case "DELETE" -> {
				DeleteSaleUserCommand delete = DeleteSaleUserCommand.builder()
					.id(SaleUserId.create(d.getId()) )
					.build();

				if(metaRequest.getTenantId() != null) {
					//delete.setTenant(SaleUserTenant.create(metaRequest.getTenantId()));
				}

				if(metaRequest.getUserId() != null) {
					//delete.setCreatedBy( SaleUserCreatedBy.create(metaRequest.getUserId()));
				}
				commandGateway.sendAndWait(
				delete
				 );
				}
			}
		}
	}
}
