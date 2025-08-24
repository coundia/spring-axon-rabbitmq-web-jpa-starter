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
public class CreateStockLevelCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private StockLevelId id = StockLevelId.create(UUID.randomUUID().toString());
 	private StockLevelRemoteId remoteId;
 	private StockLevelLocalId localId;
 	private StockLevelStockOnHand stockOnHand;
 	private StockLevelStockAllocated stockAllocated;
 	private StockLevelProductVariant productVariant;
 	private StockLevelSyncAt syncAt;
 	private StockLevelCompany company;
 	private StockLevelCreatedBy createdBy;
 	private StockLevelTenant tenant;
	public CreateStockLevelCommand(
 
   StockLevelRemoteId remoteId , 
   StockLevelLocalId localId , 
   StockLevelStockOnHand stockOnHand , 
   StockLevelStockAllocated stockAllocated , 
   StockLevelProductVariant productVariant , 
   StockLevelSyncAt syncAt , 
   StockLevelCompany company , 
   StockLevelCreatedBy createdBy , 
   StockLevelTenant tenant  
		){
			this.id = StockLevelId.create(UUID.randomUUID().toString());
 
  this.remoteId = remoteId ; 
  this.localId = localId ; 
  this.stockOnHand = stockOnHand ; 
  this.stockAllocated = stockAllocated ; 
  this.productVariant = productVariant ; 
  this.syncAt = syncAt ; 
  this.company = company ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
