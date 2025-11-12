package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.application.command.DeleteProductCommand;
import com.groupe2cs.bizyhub.products.application.command.UpdateProductCommand;
import com.groupe2cs.bizyhub.products.application.dto.ProductSyncRequest;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.UserValidationService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductSyncApplicationService {

	private final ProductGate gateService;
	private final CommandGateway commandGateway;
	private final UserValidationService userValidationService;

	public void syncProduct(ProductSyncRequest request, MetaRequest metaRequest) {

		userValidationService.shouldBePremiumUser(metaRequest.getUserId());

		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateProductCommand command = CreateProductCommand.builder()
							.remoteId(ProductRemoteId.create(d.getRemoteId()))
							.localId(ProductLocalId.create(d.getLocalId()))
							.code(ProductCode.create(d.getCode()))
							.name(ProductName.create(d.getName()))
							.description(ProductDescription.create(d.getDescription()))
							.status(ProductStatus.create(d.getStatus()))
							.isPublic(ProductIsPublic.create(d.getIsPublic()))
							.hasSold(ProductHasSold.create(d.getHasSold()))
							.hasPrice(ProductHasPrice.create(d.getHasPrice()))
							.level(ProductLevel.create(d.getLevel()))
							.quantity(ProductQuantity.create(d.getQuantity()))
							.barcode(ProductBarcode.create(d.getBarcode()))
							.company(ProductCompany.create(d.getCompany()))
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
							.status(ProductStatus.create(d.getStatus()))
							.isPublic(ProductIsPublic.create(d.getIsPublic()))
							.hasSold(ProductHasSold.create(d.getHasSold()))
							.hasPrice(ProductHasPrice.create(d.getHasPrice()))
							.level(ProductLevel.create(d.getLevel()))
							.quantity(ProductQuantity.create(d.getQuantity()))
							.barcode(ProductBarcode.create(d.getBarcode()))
							.company(ProductCompany.create(d.getCompany()))
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
