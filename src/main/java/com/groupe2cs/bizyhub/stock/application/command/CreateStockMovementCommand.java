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
public class CreateStockMovementCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private StockMovementId id = StockMovementId.create(UUID.randomUUID().toString());
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
	public CreateStockMovementCommand(
 
   StockMovementTypeStockMovement typeStockMovement , 
   StockMovementQuantity quantity , 
   StockMovementRemoteId remoteId , 
   StockMovementLocalId localId , 
   StockMovementAccount account , 
   StockMovementCompany company , 
   StockMovementSyncAt syncAt , 
   StockMovementProductVariant productVariant , 
   StockMovementOrderLineId orderLineId , 
   StockMovementDiscriminator discriminator , 
   StockMovementCreatedBy createdBy , 
   StockMovementTenant tenant  
		){
			this.id = StockMovementId.create(UUID.randomUUID().toString());
 
  this.typeStockMovement = typeStockMovement ; 
  this.quantity = quantity ; 
  this.remoteId = remoteId ; 
  this.localId = localId ; 
  this.account = account ; 
  this.company = company ; 
  this.syncAt = syncAt ; 
  this.productVariant = productVariant ; 
  this.orderLineId = orderLineId ; 
  this.discriminator = discriminator ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
