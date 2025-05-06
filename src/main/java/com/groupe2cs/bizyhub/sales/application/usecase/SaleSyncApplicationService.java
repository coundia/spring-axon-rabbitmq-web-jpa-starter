package com.groupe2cs.bizyhub.sales.application.usecase;
import com.groupe2cs.bizyhub.sales.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;


@Service
@RequiredArgsConstructor
public class SaleSyncApplicationService {

	private final CommandGateway commandGateway;
	public void syncSale(SaleSyncRequest request,
MetaRequest metaRequest

) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {

CreateSaleCommand command = CreateSaleCommand.builder()
		.name(SaleName.create(d.getName()))
		.amount(SaleAmount.create(d.getAmount()))
		.details(SaleDetails.create(d.getDetails()))
		.isActive(SaleIsActive.create(d.getIsActive()))
		.updatedAt(SaleUpdatedAt.create(d.getUpdatedAt()))
		.reference(SaleReference.create(d.getReference()))
.build();
		if(metaRequest.getTenantId() != null) {
			command.setTenant(SaleTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			command.setCreatedBy( SaleCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
							command
				);

		}
				case "UPDATE" -> {
		UpdateSaleCommand update = UpdateSaleCommand.builder()
			.id(SaleId.create(d.getId()))
			.name(SaleName.create(d.getName()))
			.amount(SaleAmount.create(d.getAmount()))
			.details(SaleDetails.create(d.getDetails()))
			.isActive(SaleIsActive.create(d.getIsActive()))
			.updatedAt(SaleUpdatedAt.create(d.getUpdatedAt()))
			.reference(SaleReference.create(d.getReference()))
		.build();

		if(metaRequest.getTenantId() != null) {
			//update.setTenant(SaleTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			//update.setCreatedBy( SaleCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
		update
				);

		}
		case "DELETE" -> {
				DeleteSaleCommand delete = DeleteSaleCommand.builder()
					.id(SaleId.create(d.getId()) )
					.build();

				if(metaRequest.getTenantId() != null) {
					//delete.setTenant(SaleTenant.create(metaRequest.getTenantId()));
				}

				if(metaRequest.getUserId() != null) {
					//delete.setCreatedBy( SaleCreatedBy.create(metaRequest.getUserId()));
				}
				commandGateway.sendAndWait(
				delete
				 );
				}
			}
		}
	}
}
