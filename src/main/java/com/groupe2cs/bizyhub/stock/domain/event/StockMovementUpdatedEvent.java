package com.groupe2cs.bizyhub.stock.domain.event;

import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockMovementUpdatedEvent implements Serializable {

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
