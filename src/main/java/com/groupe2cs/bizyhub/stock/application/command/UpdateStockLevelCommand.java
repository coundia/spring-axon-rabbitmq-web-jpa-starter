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
public class UpdateStockLevelCommand implements Serializable {
@TargetAggregateIdentifier
	private StockLevelId id;
 	private StockLevelRemoteId remoteId;
 	private StockLevelLocalId localId;
 	private StockLevelStockOnHand stockOnHand;
 	private StockLevelStockAllocated stockAllocated;
 	private StockLevelProductVariant productVariant;
 	private StockLevelSyncAt syncAt;
 	private StockLevelCompany company;
 	private StockLevelCreatedBy createdBy;
 	private StockLevelTenant tenant;


}
