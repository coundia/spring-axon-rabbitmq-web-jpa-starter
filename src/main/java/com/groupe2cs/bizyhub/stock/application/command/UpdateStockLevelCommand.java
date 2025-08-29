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
public class UpdateStockLevelCommand implements Serializable {
	@TargetAggregateIdentifier
	private StockLevelId id;
	private StockLevelRemoteId remoteId;
	private StockLevelLocalId localId;
	private StockLevelStockOnHand stockOnHand;
	private StockLevelStockAllocated stockAllocated;
	private StockLevelAccount account;
	private StockLevelProductVariant productVariant;
	private StockLevelSyncAt syncAt;
	private StockLevelCompany company;
	private StockLevelCreatedBy createdBy;
	private StockLevelTenant tenant;


}
