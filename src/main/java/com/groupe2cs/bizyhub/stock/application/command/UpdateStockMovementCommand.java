package com.groupe2cs.bizyhub.stock.application.command;

import com.groupe2cs.bizyhub.stock.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;


import java.time.*;
import java.util.*;

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
 	private StockMovementCompany company;
 	private StockMovementSyncAt syncAt;
 	private StockMovementProductVariant productVariant;
 	private StockMovementOrderLineId orderLineId;
 	private StockMovementDiscriminator discriminator;
 	private StockMovementCreatedBy createdBy;
 	private StockMovementTenant tenant;


}
