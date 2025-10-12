package com.groupe2cs.bizyhub.stock.application.command;

import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateStockMovementCommand implements Serializable {
	@TargetAggregateIdentifier
	private StockMovementId id;
	private StockMovementTypeStockMovement typeStockMovement;
	private StockMovementQuantity quantity;
	private StockMovementRemoteId remoteId;
	private StockMovementLocalId localId;
	private StockMovementAccount account;
	private StockMovementCompany company;
	private StockMovementSyncAt syncAt;
	private StockMovementProductVariant productVariant;
	private StockMovementOrderLineId orderLineId;
	private StockMovementDiscriminator discriminator;
	private StockMovementCreatedBy createdBy;
	private StockMovementTenant tenant;


}
