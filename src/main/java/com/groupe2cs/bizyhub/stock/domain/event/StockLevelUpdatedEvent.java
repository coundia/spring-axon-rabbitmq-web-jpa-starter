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
public class StockLevelUpdatedEvent implements Serializable {

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
