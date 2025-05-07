package com.groupe2cs.bizyhub.products.application.usecase;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.products.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;


@Service
@RequiredArgsConstructor
public class ProductSyncApplicationService {

	private final CommandGateway commandGateway;
	public void syncProduct(ProductSyncRequest request,
MetaRequest metaRequest

) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {

CreateProductCommand command = CreateProductCommand.builder()
		.name(ProductName.create(d.getName()))
		.price(ProductPrice.create(d.getPrice()))
		.details(ProductDetails.create(d.getDetails()))
		.isActive(ProductIsActive.create(d.getIsActive()))
		.updatedAt(ProductUpdatedAt.create(d.getUpdatedAt()))
		.reference(ProductReference.create(d.getReference()))
.build();
		if(metaRequest.getTenantId() != null) {
			command.setTenant(ProductTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			command.setCreatedBy( ProductCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
							command
				);

		}
				case "UPDATE" -> {
		UpdateProductCommand update = UpdateProductCommand.builder()
			.id(ProductId.create(d.getId()))
			.name(ProductName.create(d.getName()))
			.price(ProductPrice.create(d.getPrice()))
			.details(ProductDetails.create(d.getDetails()))
			.isActive(ProductIsActive.create(d.getIsActive()))
			.updatedAt(ProductUpdatedAt.create(d.getUpdatedAt()))
			.reference(ProductReference.create(d.getReference()))
		.build();

		if(metaRequest.getTenantId() != null) {
			//update.setTenant(ProductTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			//update.setCreatedBy( ProductCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
		update
				);

		}
		case "DELETE" -> {
				DeleteProductCommand delete = DeleteProductCommand.builder()
					.id(ProductId.create(d.getId()) )
					.build();

				if(metaRequest.getTenantId() != null) {
					//delete.setTenant(ProductTenant.create(metaRequest.getTenantId()));
				}

				if(metaRequest.getUserId() != null) {
					//delete.setCreatedBy( ProductCreatedBy.create(metaRequest.getUserId()));
				}
				commandGateway.sendAndWait(
				delete
				 );
				}
			}
		}
	}
}
