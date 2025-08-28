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

	private final ProductGate gateService;
	private final CommandGateway commandGateway;

	public void syncProduct(ProductSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateProductCommand command = CreateProductCommand.builder()
								.remoteId(ProductRemoteId.create(d.getRemoteId()))
								.localId(ProductLocalId.create(d.getLocalId()))
								.code(ProductCode.create(d.getCode()))
								.name(ProductName.create(d.getName()))
								.description(ProductDescription.create(d.getDescription()))
								.barcode(ProductBarcode.create(d.getBarcode()))
								.unit(ProductUnit.create(d.getUnit()))
								.syncAt(ProductSyncAt.create(d.getSyncAt()))
								.category(ProductCategory.create(d.getCategory()))
								.account(ProductAccount.create(d.getAccount()))
								.defaultPrice(ProductDefaultPrice.create(d.getDefaultPrice()))
								.statuses(ProductStatuses.create(d.getStatuses()))
								.purchasePrice(ProductPurchasePrice.create(d.getPurchasePrice()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(ProductTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(ProductCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update Product with id " + d.getId());
					}

					UpdateProductCommand update = UpdateProductCommand.builder()
							.id(ProductId.create(d.getId()))
							.remoteId(ProductRemoteId.create(d.getRemoteId()))
							.localId(ProductLocalId.create(d.getLocalId()))
							.code(ProductCode.create(d.getCode()))
							.name(ProductName.create(d.getName()))
							.description(ProductDescription.create(d.getDescription()))
							.barcode(ProductBarcode.create(d.getBarcode()))
							.unit(ProductUnit.create(d.getUnit()))
							.syncAt(ProductSyncAt.create(d.getSyncAt()))
							.category(ProductCategory.create(d.getCategory()))
							.account(ProductAccount.create(d.getAccount()))
							.defaultPrice(ProductDefaultPrice.create(d.getDefaultPrice()))
							.statuses(ProductStatuses.create(d.getStatuses()))
							.purchasePrice(ProductPurchasePrice.create(d.getPurchasePrice()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete Product with id " + d.getId());
					}

					DeleteProductCommand delete = DeleteProductCommand.builder()
						.id(ProductId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
