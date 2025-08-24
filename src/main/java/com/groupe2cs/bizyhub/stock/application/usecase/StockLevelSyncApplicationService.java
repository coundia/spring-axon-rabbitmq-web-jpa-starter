package com.groupe2cs.bizyhub.stock.application.usecase;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.stock.application.command.*;
import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import com.groupe2cs.bizyhub.stock.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class StockLevelSyncApplicationService {

	private final StockLevelGate gateService;
	private final CommandGateway commandGateway;

	public void syncStockLevel(StockLevelSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateStockLevelCommand command = CreateStockLevelCommand.builder()
								.remoteId(StockLevelRemoteId.create(d.getRemoteId()))
								.localId(StockLevelLocalId.create(d.getLocalId()))
								.stockOnHand(StockLevelStockOnHand.create(d.getStockOnHand()))
								.stockAllocated(StockLevelStockAllocated.create(d.getStockAllocated()))
								.productVariant(StockLevelProductVariant.create(d.getProductVariant()))
								.syncAt(StockLevelSyncAt.create(d.getSyncAt()))
								.company(StockLevelCompany.create(d.getCompany()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(StockLevelTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(StockLevelCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update StockLevel with id " + d.getId());
					}

					UpdateStockLevelCommand update = UpdateStockLevelCommand.builder()
							.id(StockLevelId.create(d.getId()))
							.remoteId(StockLevelRemoteId.create(d.getRemoteId()))
							.localId(StockLevelLocalId.create(d.getLocalId()))
							.stockOnHand(StockLevelStockOnHand.create(d.getStockOnHand()))
							.stockAllocated(StockLevelStockAllocated.create(d.getStockAllocated()))
							.productVariant(StockLevelProductVariant.create(d.getProductVariant()))
							.syncAt(StockLevelSyncAt.create(d.getSyncAt()))
							.company(StockLevelCompany.create(d.getCompany()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete StockLevel with id " + d.getId());
					}

					DeleteStockLevelCommand delete = DeleteStockLevelCommand.builder()
						.id(StockLevelId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
