package com.groupe2cs.bizyhub.stock.domain.event;

	import com.groupe2cs.bizyhub.stock.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockLevelCreatedEvent implements Serializable {

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
