package com.groupe2cs.bizyhub.stock.application.usecase;
import com.groupe2cs.bizyhub.stock.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.stock.application.dto.*;
import com.groupe2cs.bizyhub.stock.domain.valueObject.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class StockMovementSyncApplicationService {

	private final StockMovementGate gateService;
	private final CommandGateway commandGateway;

	public void syncStockMovement(StockMovementSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateStockMovementCommand command = CreateStockMovementCommand.builder()
								.typeStockMovement(StockMovementTypeStockMovement.create(d.getTypeStockMovement()))
								.quantity(StockMovementQuantity.create(d.getQuantity()))
								.remoteId(StockMovementRemoteId.create(d.getRemoteId()))
								.localId(StockMovementLocalId.create(d.getLocalId()))
								.account(StockMovementAccount.create(d.getAccount()))
								.company(StockMovementCompany.create(d.getCompany()))
								.syncAt(StockMovementSyncAt.create(d.getSyncAt()))
								.productVariant(StockMovementProductVariant.create(d.getProductVariant()))
								.orderLineId(StockMovementOrderLineId.create(d.getOrderLineId()))
								.discriminator(StockMovementDiscriminator.create(d.getDiscriminator()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(StockMovementTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(StockMovementCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update StockMovement with id " + d.getId());
					}

					UpdateStockMovementCommand update = UpdateStockMovementCommand.builder()
							.id(StockMovementId.create(d.getId()))
							.typeStockMovement(StockMovementTypeStockMovement.create(d.getTypeStockMovement()))
							.quantity(StockMovementQuantity.create(d.getQuantity()))
							.remoteId(StockMovementRemoteId.create(d.getRemoteId()))
							.localId(StockMovementLocalId.create(d.getLocalId()))
							.account(StockMovementAccount.create(d.getAccount()))
							.company(StockMovementCompany.create(d.getCompany()))
							.syncAt(StockMovementSyncAt.create(d.getSyncAt()))
							.productVariant(StockMovementProductVariant.create(d.getProductVariant()))
							.orderLineId(StockMovementOrderLineId.create(d.getOrderLineId()))
							.discriminator(StockMovementDiscriminator.create(d.getDiscriminator()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete StockMovement with id " + d.getId());
					}

					DeleteStockMovementCommand delete = DeleteStockMovementCommand.builder()
						.id(StockMovementId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
